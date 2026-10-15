package FicherosDeAccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    private static final String NOMBRE_FICHERO = "juegos.dat";
    public static void main(String[] args) throws IOException {
        /*esto lo hago para que cada vez que se inicie el programa borre el fichero para luego crear uno nuevo*/
        try (FileOutputStream fos = new FileOutputStream(RUTA_FICHERO+ NOMBRE_FICHERO);) {
        } catch (IOException e) {
            System.out.println("Ocurrió un error al vaciar el fichero: " + e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        RandomAccessFile f = new RandomAccessFile(RUTA_FICHERO + NOMBRE_FICHERO, "rw");
        System.out.print("Número de juegos: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        f.seek(f.length());
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Número de orden: ");
            f.writeInt(sc.nextInt());
            sc.nextLine();
            System.out.print("Nombre: ");
            escribirTexto(f, sc.nextLine(), 10);
            System.out.print("Edad mínima: ");
            f.writeInt(sc.nextInt());
            sc.nextLine();
            System.out.print("Temática: ");
            escribirTexto(f, sc.nextLine(), 10);
        }
        f.seek(0);
        while (f.getFilePointer() < f.length()) {
            int orden = f.readInt();
            String nombre = leerTexto(f, 10);
            int edad = f.readInt();
            String tema = leerTexto(f, 10);
            System.out.println(orden + " - " + nombre + " - " + edad + " - " + tema);
        }
        f.close();
    }
    static void escribirTexto(RandomAccessFile f, String s, int n)
            throws IOException {
        s = String.format("%-" + n + "s", s);
        for (int i = 0; i < n; i++)
            f.writeChar(s.charAt(i));
    }
    static String leerTexto(RandomAccessFile f, int n)
            throws IOException {
        String s = "";
        for (int i = 0; i < n; i++)
            s += f.readChar();
        return s.trim();
    }
}

