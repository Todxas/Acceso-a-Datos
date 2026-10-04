package Ejerciciosficherosbinarios;

import java.io.*;
import java.util.Scanner;

public class EjercicioPDF6 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Número de personas: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/datospersonas.dat"));
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nPERSONA " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = teclado.nextLine();
            System.out.print("Edad: ");
            int edad = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Teléfono: ");
            String telefono = teclado.nextLine();
            System.out.print("Email: ");
            String email = teclado.nextLine();
            System.out.print("Ciudad: ");
            String ciudad = teclado.nextLine();
            System.out.print("Nacionalidad: ");
            String nacionalidad = teclado.nextLine();
            System.out.print("Profesión: ");
            String profesion = teclado.nextLine();
            escribir.writeUTF(nombre);
            escribir.writeUTF(apellidos);
            escribir.writeInt(edad);
            escribir.writeUTF(telefono);
            escribir.writeUTF(email);
            escribir.writeUTF(ciudad);
            escribir.writeUTF(nacionalidad);
            escribir.writeUTF(profesion);
        }
        escribir.close();
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/datospersonas.dat"));
        System.out.println("\nPERSONAS:");
        try {
            while (true) {
                String nombre = leer.readUTF();
                String apellidos = leer.readUTF();
                int edad = leer.readInt();
                String telefono = leer.readUTF();
                String email = leer.readUTF();
                String ciudad = leer.readUTF();
                String nacionalidad = leer.readUTF();
                String profesion = leer.readUTF();
                System.out.println("Nombre: "+ nombre + " Apellidos: " + apellidos + " Edad: " + edad + " años " + " Telefono: " + telefono + " Email: " + email + " Ciudad: " + ciudad
                        + " Nacionalidad: " + nacionalidad + " Profesion: " + profesion);
            }
        } catch (EOFException e) {
        }
        leer.close();
    }
}
