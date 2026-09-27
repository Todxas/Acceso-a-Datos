package EjerciciosAmpliacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("frases.txt"));

        System.out.println("Escribe frases, cuando quieras terminar, escribe fin: ");

        String frase = teclado.nextLine();

        while (!frase.equalsIgnoreCase("fin")) {
            bw.write(frase);
            bw.newLine();

            frase = teclado.nextLine();
        }

        bw.close();

        System.out.println("Fichero guardado.");
    }
}
