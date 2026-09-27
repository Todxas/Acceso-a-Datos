package EjerciciosAmpliacion;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del fichero: ");
        String nombre = teclado.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(nombre));

        ArrayList<String> lineas = new ArrayList<>();

        String linea;

        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));

        for (int i = lineas.size() - 1; i >= 0; i--) {
            bw.write(lineas.get(i));
            bw.newLine();
        }

        bw.close();

        System.out.println("Fichero creado.");
    }
}
