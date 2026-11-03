package FicherosXML;

import org.w3c.dom.Document;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class Zoof100kg {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/FicherosXML/Zoo.xml"));
            NodeList lista = doc.getElementsByTagName("Felino");
            for (int i = 0; i < lista.getLength(); i++) {
                Element felino = (Element) lista.item(i);

                String nombre = felino.getElementsByTagName("Nombre").item(0).getTextContent();
                int peso = Integer.parseInt(
                        felino.getElementsByTagName("Peso").item(0).getTextContent()
                );
                if (peso > 100) {
                    System.out.println(nombre + " - " + peso + " kg");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al crear el documento XML.");
        }
    }
}
