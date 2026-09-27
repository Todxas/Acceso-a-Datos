package EjerciciosAmpliacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del fichero: ");
        String nombre = teclado.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(nombre));

        int contador = 0;

        while (br.readLine() != null) {
            contador++;
        }

        br.close();

        System.out.println("Líneas: " + contador);
    }
}
