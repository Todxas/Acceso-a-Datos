package EjercicioContarVocales;

import java.io.*;

public class Main {
    private static final String RUTA_FICHERO = "src/EjercicioContarVocales/";
    private static final String RESULTADO_A = "resultadoA.txt";
    private static final String RESULTADO_E = "resultadoE.txt";
    private static final String RESULTADO_I = "resultadoI.txt";
    private static final String RESULTADO_O = "resultadoO.txt";
    private static final String RESULTADO_U = "resultadoU.txt";
    public static void main(String[] args) {
        try {

            String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";

            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pbA = new ProcessBuilder(java, "-cp", classpath, "ContarVocalA");

            ProcessBuilder pbE = new ProcessBuilder(java, "-cp", classpath, "ContarVocalE");

            ProcessBuilder pbI = new ProcessBuilder(java, "-cp", classpath, "ContarVocalI");

            ProcessBuilder pbO = new ProcessBuilder(java, "-cp", classpath, "ContarVocalO");

            ProcessBuilder pbU = new ProcessBuilder(java, "-cp", classpath, "ContarVocalU");

            Process procesoA = pbA.start();
            Process procesoE = pbE.start();
            Process procesoI = pbI.start();
            Process procesoO = pbO.start();
            Process procesoU = pbU.start();

            procesoA.waitFor();
            procesoE.waitFor();
            procesoI.waitFor();
            procesoO.waitFor();
            procesoU.waitFor();

            int total = 0;

            FileReader frA = new FileReader(RUTA_FICHERO + RESULTADO_A);
            BufferedReader brA = new BufferedReader(frA);
            int cantidadA = Integer.parseInt(brA.readLine());
            brA.close();

            FileReader frE = new FileReader(RUTA_FICHERO + RESULTADO_E);
            BufferedReader brE = new BufferedReader(frE);
            int cantidadE = Integer.parseInt(brE.readLine());
            brE.close();

            FileReader frI = new FileReader(RUTA_FICHERO + RESULTADO_I);
            BufferedReader brI = new BufferedReader(frI);
            int cantidadI = Integer.parseInt(brI.readLine());
            brI.close();

            FileReader frO = new FileReader(RUTA_FICHERO + RESULTADO_O);
            BufferedReader brO = new BufferedReader(frO);
            int cantidadO = Integer.parseInt(brO.readLine());
            brO.close();

            FileReader frU = new FileReader(RUTA_FICHERO + RESULTADO_U);
            BufferedReader brU = new BufferedReader(frU);
            int cantidadU = Integer.parseInt(brU.readLine());
            brU.close();

            total = cantidadA + cantidadE + cantidadI + cantidadO + cantidadU;

            System.out.println("Vocal A: " + cantidadA);
            System.out.println("Vocal E: " + cantidadE);
            System.out.println("Vocal I: " + cantidadI);
            System.out.println("Vocal O: " + cantidadO);
            System.out.println("Vocal U: " + cantidadU);

            System.out.println("--------------------");
            System.out.println("Total de vocales: " + total);

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (InterruptedException e) {

            System.out.println("El proceso fue interrumpido.");
        }
    }
}
