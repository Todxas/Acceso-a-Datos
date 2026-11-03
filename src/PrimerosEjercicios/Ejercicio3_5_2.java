package PrimerosEjercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio3_5_2 {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\dalch\\Curso26-27\\Acceso-a-Datos\\carpeta\\config.txt");

        if (fichero.exists()) {
            System.out.println("El fichero ya existe");
        }
        else {
            fichero.createNewFile();
            System.out.println("fichero creado");
        }
    }
}
