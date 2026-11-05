package JDBC;
import java.sql.*;
import java.util.Scanner;
public class Ejercicio1_2 {
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "3306";
    private static final String BASE_DATOS = "tienda1";
    private static final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + BASE_DATOS;

    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            {
                int opcion = 0;
                while (opcion != 5) {
                    System.out.println("\n--- MENU TIENDA ---");
                    System.out.println("1. Listar articulos por precio");
                    System.out.println("2. Agregar fabricante");
                    System.out.println("3. Modificar precio");
                    System.out.println("4. Eliminar articulo");
                    System.out.println("5. Salir");
                    System.out.print("Elige una opcion: ");
                    opcion = sc.nextInt();
                    if (opcion == 1) {
                        System.out.println("introduce un precio");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        String op1 = "SELECT * FROM articulos WHERE precio < ?";

                        PreparedStatement ps1 = conexion.prepareStatement(op1);
                        ps1.setDouble(1, precio);
                        ResultSet rs = ps1.executeQuery();
                        while (rs.next()) {
                            String precio1 = rs.getString("nombre")+ " - " + rs.getString("precio") + " €";
                        }
                    }
                    if (opcion == 2) {
                        System.out.println("Nombre del fabricante: ");
                        String nombre = sc.nextLine();
                        String op2 = "INSERT INTO fabricantes (codigo, nombre) " +
                                "SELECT COALESCE (MAX(codigo), 0) + 1, ? FROM fabricantes";
                        PreparedStatement ps2 = conexion.prepareStatement(op2);
                        ps2.setString(1, nombre);
                        ps2.executeUpdate();
                        System.out.println("Fabricante agregado");
                    }
                    if (opcion == 3) {
                        System.out.println("Introduce el porcentaje para reducir el precio de Disco Duro 300Gb: ");
                        double porcentaje = sc.nextDouble();
                        sc.nextLine();
                        String op3 = "UPDATE articulos SET precio = precio - (precio * ? / 100) "+
                                "WHERE nombre = 'Disco Duro 300Gb'";

                        PreparedStatement ps3 = conexion.prepareStatement(op3);
                        ps3.setDouble(1, porcentaje);
                        int modificacion = ps3.executeUpdate();
                        System.out.println("El precio nuevo es: " + modificacion);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

