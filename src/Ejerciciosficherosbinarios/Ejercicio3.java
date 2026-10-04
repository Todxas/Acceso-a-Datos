package Ejerciciosficherosbinarios;

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Producto producto = new Producto("Teclado", 25.5, 10);
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/producto.dat"));
        escribir.writeObject(producto);
        escribir.close();
        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/producto.dat"));
        Producto p = (Producto) leer.readObject();
        System.out.println(p);
        leer.close();
    }
}
