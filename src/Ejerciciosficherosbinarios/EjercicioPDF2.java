package Ejerciciosficherosbinarios;

import java.io.*;
import java.util.Scanner;

public class EjercicioPDF2 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Cuantos vehículos? ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/vehiculos.bin", true));
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Matrícula: ");
            String matricula = teclado.nextLine();
            System.out.print("Marca: ");
            String marca = teclado.nextLine();
            System.out.print("Deposito: ");
            double deposito = teclado.nextDouble();
            teclado.nextLine();
            System.out.print("Modelo: ");
            String modelo = teclado.nextLine();
            escribir.writeUTF(matricula);
            escribir.writeUTF(marca);
            escribir.writeDouble(deposito);
            escribir.writeUTF(modelo);
        }
        escribir.close();

        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/vehiculos.bin"));
        System.out.println("\nVEHÍCULOS:");
        try {
            while (true) {
                String matricula = leer.readUTF();
                String marca = leer.readUTF();
                double deposito = leer.readDouble();
                String modelo = leer.readUTF();
                System.out.println("matricula: "+matricula + "marca: " + marca + "deposito: " + deposito + "Modelo: " + modelo);
            }
        } catch (EOFException e) {
        }
        leer.close();
    }
}
