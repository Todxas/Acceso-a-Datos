package Ejerciciosficherosbinarios;

import java.io.*;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/alumnos.dat"));
        escribir.writeUTF("Juan");
        escribir.writeDouble(7.5);
        escribir.writeUTF("Ana");
        escribir.writeDouble(8.2);
        escribir.writeUTF("Pedro");
        escribir.writeDouble(6.5);
        escribir.writeUTF("Laura");
        escribir.writeDouble(9.1);
        escribir.writeUTF("Carlos");
        escribir.writeDouble(5.8);
        escribir.close();
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/alumnos.dat"));
        for (int i = 0; i < 5; i++) {
            String nombre = leer.readUTF();
            double nota = leer.readDouble();
            System.out.println(nombre + " - " + nota);
        }
        leer.close();
    }
}
