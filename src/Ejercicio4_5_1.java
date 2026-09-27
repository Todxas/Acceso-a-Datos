import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4_5_1 {
    public static void main(String[] args) throws IOException {
        //reutilizare esta parte del codigo del ejercicio 3_5_2
        File fichero = new File("C:\\Users\\dalch\\Curso26-27\\Acceso-a-Datos\\datos.txt");
        if (fichero.exists()) {
            System.out.println("El fichero ya existe");
        }
        else {
            fichero.createNewFile();
            System.out.println("fichero creado");
        }
        //hasta aqui la reutilizacion
        BufferedReader br = new BufferedReader(new FileReader(fichero));

        int lineas = 0;
        String linea;
        while ((br.readLine()) != null) {
            lineas++;
        }
        br.close();
        System.out.println("lineas: " + lineas);
    }
}
