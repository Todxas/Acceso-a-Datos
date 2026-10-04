package Ejerciciosficherosbinarios;
import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class EjercicioPDF1 {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Cantidad de numeros: ");
        int cantidad = teclado.nextInt();
        System.out.print("Minimo: ");
        int minimo = teclado.nextInt();
        System.out.print("Maximo: ");
        int maximo = teclado.nextInt();
        DataOutputStream escribir = new DataOutputStream(new FileOutputStream("src/Ejerciciosficherosbinarios/num_aleat.bin", true));
        for (int i = 0; i < cantidad; i++) {
            int numero = random.nextInt(maximo - minimo + 1) + minimo;
            escribir.writeInt(numero);
        }
        escribir.close();
        DataInputStream leer = new DataInputStream(new FileInputStream("src/Ejerciciosficherosbinarios/num_aleat.bin"));
        System.out.println("Numeros:");
        try {
            while (true) {
                System.out.println(leer.readInt());
            }
        } catch (EOFException e) {
        }
        leer.close();
    }
}
