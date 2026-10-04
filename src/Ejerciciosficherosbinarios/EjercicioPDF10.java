package Ejerciciosficherosbinarios;

import java.io.*;

public class EjercicioPDF10 {
    public static void main(String[] args) throws IOException {
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/nominas.bin"));
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/temporal.dat"));
        int eliminados = 0;
        try {
            while (true) {
                String nombre = leer.readUTF();
                int bajas = leer.readInt();
                double nomina = leer.readDouble();
                if (bajas == 0) {
                    nomina = nomina * 1.05;
                }
                else if (bajas >= 4 && bajas <= 10) {
                    nomina = nomina * 0.90;
                }
                else if (bajas > 10) {
                    eliminados++;
                    continue;
                }
                escribir.writeUTF(nombre);
                escribir.writeInt(bajas);
                escribir.writeDouble(nomina);
            }
        } catch (EOFException e) {
        }
        leer.close();
        escribir.close();
        File antiguo = new File("src/Ejerciciosficherosbinarios/nominas.bin");
        antiguo.delete();
        File nuevo = new File("src/Ejerciciosficherosbinarios/temporal.dat");
        nuevo.renameTo(antiguo);
        System.out.println("Nóminas actualizadas.");
        System.out.println("Empleados eliminados: " + eliminados);
    }
}
