package EjerciciosAmpliacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del fichero: ");
        String nombre = teclado.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(nombre));

        String linea;
        int contador = 0;

        while ((linea = br.readLine()) != null) {
            System.out.println(linea + " " + contador);
            contador++;

            if (contador == 24) {
                System.out.println("Pulsa Intro para continuar...");
                teclado.nextLine();
                contador = 0;
            }
        }

        br.close();
    }
}
