package Ejerciciosficherosbinarios;

import java.io.*;
import java.util.Scanner;

public class EjercicioPDF4 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Número de becarios: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();
        DataOutputStream escribir = new DataOutputStream(
                new FileOutputStream("src/Ejerciciosficherosbinarios/datosbeca.bin", true));
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nBECARIO " + (i + 1));
            System.out.print("Nombre y apellido: ");
            String nombre = teclado.nextLine();
            System.out.print("Sexo (H-M): ");
            String sexo = teclado.nextLine();
            System.out.print("Edad: ");
            int edad = teclado.nextInt();
            System.out.print("Número de suspensos: ");
            int suspensos = teclado.nextInt();
            teclado.nextLine();
            System.out.print("¿Residencia familiar? (SI-NO): ");
            String residencia = teclado.nextLine();
            System.out.print("Ingresos anuales: ");
            double ingresos = teclado.nextDouble();
            teclado.nextLine();
            System.out.print("¿Tiene beca? (SI-NO): ");
            String beca = teclado.nextLine();
            escribir.writeUTF(nombre);
            escribir.writeUTF(sexo);
            escribir.writeInt(edad);
            escribir.writeInt(suspensos);
            escribir.writeUTF(residencia);
            escribir.writeDouble(ingresos);
            escribir.writeUTF(beca);
        }
        escribir.close();
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/datosbeca.bin"));
        System.out.println("\nDATOS:");
        try {
            while (true) {
                String nombre = leer.readUTF();
                String sexo = leer.readUTF();
                int edad = leer.readInt();
                int suspensos = leer.readInt();
                String residencia = leer.readUTF();
                double ingresos = leer.readDouble();
                String beca = leer.readUTF();
                System.out.println(nombre + " | " + sexo
                        + " | " + edad + " años"
                        + " | Suspensos: " + suspensos
                        + " | Residencia: " + residencia
                        + " | Ingresos: " + ingresos
                        + " | Beca: " + beca);
            }
        } catch (EOFException e) {
        }

        leer.close();
    }
}
