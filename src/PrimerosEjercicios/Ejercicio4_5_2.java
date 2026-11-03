package PrimerosEjercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4_5_2 {
    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce una palabra para buscar: ");
        String palabra = leer.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("datos.txt"));

        String linea;
        int contador = 0;
        while ((linea = br.readLine()) != null) {
            if (linea.contains(palabra)) {
                contador++;
            }
        }
        br.close();
        System.out.println("lineas encontradas: " + contador);
    }
}
