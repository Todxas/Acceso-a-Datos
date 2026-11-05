package JDBC;

import java.sql.*;

public class Ejercicio1_1 {
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "3306";
    private static final String BASE_DATOS = "tienda1";
    private static final String URL = "jdbc:mysql://" + SERVIDOR + ":" + PUERTO + "/" + BASE_DATOS;

    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    public static void main(String[] args) {
        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)){
            System.out.println("Bienvenido");
            Statement st = conexion.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS ArtFab");

            String codigo = "CREATE TABLE ArtFab AS " +
                    "SELECT a.nombre AS articulo, " +
                    "   f.nombre AS fabricante, " +
                    "   a.precio, " +
                    "   CASE " +
                    "       WHEN a.precio < 200 THEN a.precio * 0.10 " +
                    "       WHEN a.precio < 500 THEN a.precio * 0.08 " +
                    "       WHEN a.precio < 700 THEN a.precio * 0.06 " +
                    "       ELSE a.precio " +
                    "   END AS iva " +
                    "FROM articulos a " +
                    "JOIN fabricantes f " +
                    "ON a.CLFAB = f.CLFAB ";
            st.executeUpdate(codigo);
            ResultSet rs = st.executeQuery("SELECT * FROM ArtFab");
            while (rs.next()) {
                System.out.println(
                        rs.getString("articulo") + " | " +
                                rs.getString("fabricante") + " | " +
                                rs.getDouble("precio") + " | " +
                                rs.getDouble("iva")
                );
            }
            conexion.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
