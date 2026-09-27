import java.io.*;

public class Ejercicio4_5_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("copia.txt"));
        String linea;
        while ((linea = br.readLine()) != null) {
            bw.write(linea);
            bw.newLine();
        }
        bw.close();
        br.close();
        System.out.println("Fichero copiado");
    }
}
