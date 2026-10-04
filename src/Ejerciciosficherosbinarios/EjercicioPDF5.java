package Ejerciciosficherosbinarios;

import java.io.*;

public class EjercicioPDF5 {
    public static void main(String[] args) throws IOException {
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/datosbeca.bin"));
        try {
            while (true) {
                String nombre = leer.readUTF();
                String sexo = leer.readUTF();
                int edad = leer.readInt();
                int suspensos = leer.readInt();
                String residencia = leer.readUTF();
                double ingresos = leer.readDouble();
                String beca = leer.readUTF();
                if (beca.equalsIgnoreCase("SI") && suspensos < 2) {
                    double total = 1500;
                    if (ingresos <= 12000)
                        total = total + 500;
                    if (edad < 23)
                        total = total + 200;
                    if (suspensos == 0)
                        total = total + 500;
                    if (suspensos == 1)
                        total = total + 200;
                    if (residencia.equalsIgnoreCase("NO"))
                        total = total + 1000;
                    System.out.println(nombre + " -> " + total + "€");
                }
            }
        } catch (EOFException e) {
        }
        leer.close();
    }
}
