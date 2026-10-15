package FicherosDeAccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Ejercicio7 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile entrada = new RandomAccessFile(RUTA_FICHERO + "precio.dat", "r");
        RandomAccessFile salida = new RandomAccessFile(RUTA_FICHERO + "descuento.dat", "rw");
        System.out.print("Porcentaje de descuento: ");
        double descuento = sc.nextDouble();
        salida.setLength(0);
        while (entrada.getFilePointer() < entrada.length()) {
            leerTexto(entrada, 10); // Nombre
            String dni = leerTexto(entrada, 9);
            entrada.readInt(); // Clases
            double precio = entrada.readDouble();
            double precioFinal = precio * (1 - descuento / 100);
            escribirTexto(salida, dni, 9);
            salida.writeDouble(precio);
            salida.writeDouble(precioFinal);
        }
        salida.seek(0);
        while (salida.getFilePointer() < salida.length()) {
            String dni = leerTexto(salida, 9);
            double anterior = salida.readDouble();
            double nuevo = salida.readDouble();
            System.out.printf("%s - Antes: %.2f € - Después: %.2f €%n", dni, anterior, nuevo);
        }
        entrada.close();
        salida.close();
    }
    static String leerTexto(RandomAccessFile f, int n)
            throws IOException {
        String s = "";
        for (int i = 0; i < n; i++) s += f.readChar();
        return s.trim();
    }
    static void escribirTexto(RandomAccessFile f, String s, int n)
            throws IOException {
        s = String.format("%-" + n + "s", s);
        for (int i = 0; i < n; i++) f.writeChar(s.charAt(i));
    }
}
