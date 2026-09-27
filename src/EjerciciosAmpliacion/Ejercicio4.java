package EjerciciosAmpliacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
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

        for (int i = lineas.size() - 1; i >= 0; i--) {
            System.out.println(lineas.get(i));
        }
    }
}
