package Binario;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {

        FileOutputStream f = new FileOutputStream("binario0-100.bin");

        for (int i = 0; i < 100; i++)
            f.write(i);

        f.close();

        FileInputStream f2 = new FileInputStream("binario0-100.bin");

        int n;
        while ((n = f2.read()) != -1)
            System.out.println(n);

        f2.close();
    }
}
