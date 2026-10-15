package FicherosDeAccesoAleatorio;

import java.io.*;

public class Ejercicio6 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    public static void main(String[] args) throws IOException {
        RandomAccessFile entrada = new RandomAccessFile(RUTA_FICHERO + "practicas.dat", "r");
        RandomAccessFile salida = new RandomAccessFile(RUTA_FICHERO + "precio.dat", "rw");
        salida.setLength(0);
        while (entrada.getFilePointer() < entrada.length()) {
            String nombre = leerTexto(entrada, 10);
            leerTexto(entrada, 35); // Apellidos
            String dni = leerTexto(entrada, 9);
            entrada.readInt(); // Vehículo
            int clases = entrada.readInt();
            double precio = clases * 45.70;
            escribirTexto(salida, nombre, 10);
            escribirTexto(salida, dni, 9);
            salida.writeInt(clases);
            salida.writeDouble(precio);
        }
        entrada.close();
        salida.close();
        System.out.println("Fichero precio.dat creado.");
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

