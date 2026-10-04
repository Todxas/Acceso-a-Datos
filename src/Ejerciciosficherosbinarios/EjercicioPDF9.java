package Ejerciciosficherosbinarios;

import java.io.*;


public class EjercicioPDF9 {
    public static void main(String[] args) throws IOException {
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/Septemp.dat"));
        double max = -999;
        double min = 999;
        double suma = 0;
        String horaMax = "";
        String horaMin = "";
        int cantidad = 0;
        try {
            while (true) {
                int dia = leer.readInt();
                String hora = leer.readUTF();
                double temperatura = leer.readDouble();
                if (temperatura > max) {
                    max = temperatura;
                    horaMax = hora;
                }
                if (temperatura < min) {
                    min = temperatura;
                    horaMin = hora;
                }
                suma = suma + temperatura;
                cantidad++;
            }
        } catch (EOFException e) {
        }
        leer.close();
        double media = suma / cantidad;
        System.out.println("Máxima: " + max + "°C");
        System.out.println("Hora más calurosa: " + horaMax);
        System.out.println("Mínima: " + min + "°C");
        System.out.println("Hora más fría: " + horaMin);
        System.out.println("Media: " + media + "°C");
    }
}
