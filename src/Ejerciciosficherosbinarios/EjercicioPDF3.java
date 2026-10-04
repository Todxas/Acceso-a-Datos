package Ejerciciosficherosbinarios;

import java.io.*;
import java.util.Scanner;

public class EjercicioPDF3 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
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
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/datosbeca.bin"));
        escribir.writeUTF(nombre);
        escribir.writeUTF(sexo);
        escribir.writeInt(edad);
        escribir.writeInt(suspensos);
        escribir.writeUTF(residencia);
        escribir.writeDouble(ingresos);
        escribir.writeUTF(beca);
        escribir.close();
        System.out.println("Datos guardados.");
    }
}