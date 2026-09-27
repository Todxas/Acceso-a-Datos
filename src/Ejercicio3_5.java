import java.io.File;

public class Ejercicio3_5 {
    public static void main(String[] args) {
        File carpeta = new File("C:\\Users\\dalch\\Curso26-27\\Acceso-a-Datos\\carpeta");

        if (carpeta.exists()) {
            System.out.println("El directorio ya existe");
        }
        else {
            carpeta.mkdir();
            System.out.println("Directorio creado");
        }
    }
}
