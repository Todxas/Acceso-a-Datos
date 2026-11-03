package JSON;



import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestionVideojuegos {

    private static final String RUTA_FICHERO = "src/JSON/";
    private static final String NOMBRE_FICHERO = "videojuegos.json";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 3;
        while (opcion != 0) {
            System.out.println(" === GESTION DE VIDEOJUEGOS === ");
            System.out.println("1. Crear documento JSON");
            System.out.println("2. Mostrar videojuegos");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:

            }
        }
    }

    private static void crearDocumento() {
        // Crea los videojuegos
        Videojuego[] videojuegos = {
                new Videojuego("Isaac", "PC", 2011),
                new Videojuego("The legend of zelda: Breath of the wild", "Nintendo Switch", 2017),
                new Videojuego("The Last of Us", "Multiplataforma", 2022)
        };



    }
}
