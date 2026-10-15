package FicherosDeAccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    private static final String NOMBRE_FICHERO = "practicas.dat";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile f = new RandomAccessFile(RUTA_FICHERO + NOMBRE_FICHERO, "rw");
        System.out.print("Número de alumnos: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        f.setLength(0);
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre: ");
            escribirTexto(f, sc.nextLine(), 10);
            System.out.print("Apellidos: ");
            escribirTexto(f, sc.nextLine(), 35);
            System.out.print("DNI: ");
            escribirTexto(f, sc.nextLine(), 9);
            System.out.print("Vehículo: ");
            f.writeInt(sc.nextInt());
            System.out.print("Número de clases: ");
            f.writeInt(sc.nextInt());
            sc.nextLine();
        }
        f.seek(0);
        while (f.getFilePointer() < f.length()) {
            String nombre = leerTexto(f, 10);
            String apellidos = leerTexto(f, 35);
            String dni = leerTexto(f, 9);
            int vehiculo = f.readInt();
            int clases = f.readInt();
            System.out.println(nombre + " " + apellidos + " " + dni + " Vehículo: " + vehiculo + " Clases: " + clases);
        }
        f.close();
    }
    static void escribirTexto(RandomAccessFile f, String s, int n)
            throws IOException {
        s = String.format("%-" + n + "s", s);
        for (int i = 0; i < n; i++) f.writeChar(s.charAt(i));
    }
    static String leerTexto(RandomAccessFile f, int n)
            throws IOException {
        String s = "";
        for (int i = 0; i < n; i++) s += f.readChar();
        return s.trim();
    }
}
