package Ejerciciosficherosbinarios;

import java.io.*;
import java.util.Scanner;

public class EjercicioPDF8 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el día: ");
        int diaBuscado = teclado.nextInt();
        Scanner leer = new Scanner(new File("src/Ejerciciosficherosbinarios/temperaturas.txt"));
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/Septemp.dat"));
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();
            String[] partes = linea.split(",");
            int dia = Integer.parseInt(
                    partes[0].replace("Día ", "").trim());
            String hora = partes[1]
                    .replace("Hora ", "").trim();
            double temperatura = Double.parseDouble(
                    partes[2]
                            .replace("Temperatura ", "")
                            .replace("°C", "").trim());
            if (dia == diaBuscado) {
                escribir.writeInt(dia);
                escribir.writeUTF(hora);
                escribir.writeDouble(temperatura);
            }
        }
        leer.close();
        escribir.close();
        System.out.println("Fichero creado.");
    }
}
