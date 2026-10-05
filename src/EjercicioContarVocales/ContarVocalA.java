package EjercicioContarVocales;

import java.io.*;

public class ContarVocalA {
    private static final String RUTA_DIRECTORIO = "src/EjercicioContarVocales/";
    private static final String NOMBRE_FICHERO = "elquijote.txt";
    private static final String RESULTADO_A = "resultadoA.txt";

    public static void main(String[] args) {

        int contador = 0;

        try {

            FileReader fr = new FileReader(RUTA_DIRECTORIO + NOMBRE_FICHERO);

            int caracter;

            while ((caracter = fr.read()) != -1) {

                char letra = Character.toLowerCase((char) caracter);

                if (letra == 'a') {
                    contador++;
                }
            }

            fr.close();

            FileWriter fw = new FileWriter(RUTA_DIRECTORIO + RESULTADO_A);
            fw.write(String.valueOf(contador));
            fw.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
