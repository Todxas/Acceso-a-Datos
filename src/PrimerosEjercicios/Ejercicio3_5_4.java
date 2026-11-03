package PrimerosEjercicios;

import java.io.File;

public class Ejercicio3_5_4 {
    public static void main(String[] args) {
        File carpeta = new File("C:\\Users\\dalch\\Curso26-27\\Acceso-a-Datos\\carpeta");
        File fichero = new File("C:\\Users\\dalch\\Curso26-27\\Acceso-a-Datos\\carpeta\\config.txt");
        if (carpeta.delete()){
            System.out.println("carpeta eliminada");
        }
        else {
            System.out.println("no se puede eliminar copias");
        }
        if (fichero.delete()){
            System.out.println("config.txt eliminado");
        }


    }
}
