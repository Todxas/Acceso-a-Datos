package FicherosXML;

import org.w3c.dom.Document;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class GestionPeliculas {
    private static final String RUTA_FICHERO = "src/FicherosXML/";
    private static final String NOMBRE_FICHERO = "peliculas.xml";

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int opcion = 10;
        while (opcion != 0){
            System.out.println("GESTION DE PELICULAS");
            System.out.println("1. crea documento XML");
            System.out.println("2. Mostrar peliculas");
            System.out.println("3. Modificar titulo");
            System.out.println("4. Añadir pelicula");
            System.out.println("0. Salir");
            System.out.println("Elige que quieres hacer");
            opcion = sc.nextInt();
        }
        sc.close();
    }
    private static void crearDocumento() {
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documento = builder.newDocument();
        Element peliculas = documento.createElement("peliculas");
        Element catalogo = documento.createElement("catalogo");
        peliculas.appendChild(catalogo);

        String[] anios = {"1999","2014","2000"};
        String[] titulos = {"Matrix","Interestellar","Gladiator"};
        String[] directores = {"Lana y Lilly wachowski","Christopher Nolan","Ridley Scott"};

        for (int i =0; i < titulos.length; i++){
            Element pelicula = documento.createElement("pelicula");
            pelicula.setAttribute("anio",anios[i]);
            catalogo.appendChild(pelicula);
            Element titulo = documento.createElement("titulo");
            titulo.setTextContent(titulos[i]);
            pelicula.appendChild(titulo);
            Element director = documento.createElement("director");
            director.setTextContent(directores[i]);
            pelicula.appendChild(director);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(documento),new StreamResult(new File(RUTA_FICHERO + NOMBRE_FICHERO)));
            System.out.println("Documento XML creado correctamente.");
        }
        } catch (Exception e){
            System.out.println("Error al crear el documentoXML");
        }
    }
    private static void mostrarPeliculas() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();

        } catch (Exception e){
            System.out.println("Error al leer el documento XML");
        }
    }
}
