package PrimerosEjercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio4_5_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("copia.txt"));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                bw.write(linea);
                bw.newLine();
            }
        }
        bw.close();
        br.close();
    }
}
