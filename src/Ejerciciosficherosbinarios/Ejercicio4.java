package Ejerciciosficherosbinarios;

import java.io.*;

public class Ejercicio4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream escribir = new ObjectOutputStream(
                new FileOutputStream("src/Ejerciciosficherosbinarios/productos.dat"));
        escribir.writeObject(new Producto("Teclado", 25.5, 10));
        escribir.writeObject(new Producto("Ratón", 15.5, 20));
        escribir.writeObject(new Producto("Monitor", 150, 5));
        escribir.close();
        ObjectInputStream leer = new ObjectInputStream(
                new FileInputStream("src/Ejerciciosficherosbinarios/productos.dat"));
        for (int i = 0; i < 3; i++) {
            Producto p = (Producto) leer.readObject();
            System.out.println(p);
        }
        leer.close();
    }
}
