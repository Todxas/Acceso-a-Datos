package Ejerciciosficherosbinarios;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/numeros.dat"));
        for (int i = 1; i <= 50; i++) {
            escribir.writeInt(i);
        }
        escribir.close();
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/numeros.dat"));
        for (int i = 1; i <= 50; i++) {
            System.out.println(leer.readInt());
        }
        leer.close();
    }
}
