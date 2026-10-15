package FicherosDeAccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio2 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    private static final String NOMBRE_FICHERO = "enteros.dat";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 10;
        do {System.out.println("dime un numero del 0 al 9");
        numero = sc.nextInt();}
        while (numero < 0 || numero > 9);
        System.out.println("Dime cuantas veces quieres ingresar este numero");
        int veces = sc.nextInt();
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA_FICHERO + NOMBRE_FICHERO,"rw")){
            fichero.seek(fichero.length());
            for (int i = 0; i < veces; i++) {
                fichero.writeInt(numero);
            }
            fichero.seek(0);
            while(fichero.getFilePointer()<fichero.length()){
                System.out.println(fichero.readInt());
            }
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
