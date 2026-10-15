package FicherosDeAccesoAleatorio;


import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    private static final String NOMBRE_FICHERO = "juegos.dat";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile f = new RandomAccessFile(RUTA_FICHERO + NOMBRE_FICHERO, "r");
        System.out.print("¿Qué edad tienes? ");
        int edadUsuario = sc.nextInt();
        while (f.getFilePointer() < f.length()) {
            f.readInt();
            String nombre = leerTexto(f, 10);
            int edad = f.readInt();
            String tema = leerTexto(f, 10);
            if (edad <= edadUsuario)
                System.out.println(nombre + " - " + tema);
        }
        f.close();
    }
    static String leerTexto(RandomAccessFile f, int n)
            throws IOException {
        String s = "";
        for (int i = 0; i < n; i++) s += f.readChar();
        return s.trim();
    }
}
