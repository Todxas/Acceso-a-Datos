import java.io.File;

public class Ejercicio3_5_3 {
    public static void main(String[] args) {
        File carpeta = new File("C:\\Users\\dalch\\Curso26-27\\Acceso-a-Datos\\carpeta");

        File [] archivos = carpeta.listFiles();
        for (File archivo : archivos) {
            if (archivo.isFile()) {
                System.out.println(archivo.getName() + " -> Fichero");
            }
            else {
                System.out.println(archivo.getName() + " -> Directorio");
            }
        }
    }
}
