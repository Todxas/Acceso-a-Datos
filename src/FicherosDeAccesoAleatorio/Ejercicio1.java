package FicherosDeAccesoAleatorio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio1 {
    private static final String RUTA_FICHERO = "src/FicherosDeAccesoAleatorio/";
    private static final String NOMBRE_FICHERO = "enteros.dat";
    public static void main(String[] args) throws IOException {
        /*esto lo hago para que cada vez que se inicie el programa borre el fichero para luego crear uno nuevo*/
        try (FileOutputStream fos = new FileOutputStream(RUTA_FICHERO+ NOMBRE_FICHERO);) {
        } catch (IOException e) {
            System.out.println("Ocurrió un error al vaciar el fichero: " + e.getMessage());
        }
        try (RandomAccessFile fichero = new RandomAccessFile(RUTA_FICHERO + NOMBRE_FICHERO,"rw")){

            for (int i = 0; i < 6; i++){
                fichero.writeInt(1);
            }
            for (int i = 0; i < 10; i++){
                fichero.writeInt(2);
            }
            fichero.seek(0);
            for (int i = 0; i < 16; i++){
                System.out.println(fichero.readInt());
            }
            int numero = 10;
            Scanner sc = new Scanner(System.in);
            while (numero < 0 || numero > 9){
                System.out.println("dime un numero del 0 al 9");
                numero = sc.nextInt();
            }

            fichero.seek(0);

            for (int i = 0; i < 16; i++) {
                long posicion = fichero.getFilePointer();
                int valor = fichero.readInt();
                if (valor == 2){
                    fichero.seek(posicion);
                    fichero.writeInt(numero);
                }
            }
            fichero.seek(0);
            while (fichero.getFilePointer()<fichero.length()){
                System.out.println(fichero.readInt());
            }
        }
        catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
