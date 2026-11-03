package FicherosXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class generarZoo {
    private static final String RUTA_FICHERO = "src/FicherosXML/";
    // Nombre del documento XML
    private static final String NOMBRE_FICHERO = "Zoo.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();
            Element Zoo = documento.createElement("Zoo");
            documento.appendChild(Zoo);
            Element Felinos = documento.createElement("Felinos");
            Zoo.appendChild(Felinos);
            String[][] animales ={
                    {"Leon", "Africa", "155"},
                    {"Tigre", "Asia", "215"},
                    {"Lince", "Europa", "20"},
                    {"PanteraTigris", "America", "95"}
            };
            for (String[] animal: animales) {
                Element Felino = documento.createElement("Felino");
                Felinos.appendChild(Felino);

                Element nombre = documento.createElement("Nombre");
                nombre.setTextContent(animal[0]);
                Felino.appendChild(nombre);

                Element origen = documento.createElement("Origen");
                origen.setTextContent(animal[1]);
                Felino.appendChild(origen);

                Element peso = documento.createElement("Peso");
                peso.setTextContent(animal[2]);
                Felino.appendChild(peso);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(documento), new StreamResult(new File(RUTA_FICHERO + NOMBRE_FICHERO)));
            System.out.println("Documento XML creado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear el documento XML.");
        }
    }
}
