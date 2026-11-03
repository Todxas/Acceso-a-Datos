package FicherosXML;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Zoomenos5kg {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("src/FicherosXML/Zoo.xml"));
            NodeList lista = documento.getElementsByTagName("Peso");
            for (int i = 0; i < lista.getLength(); i++) {
                Element peso = (Element) lista.item(i);
                int valor = Integer.parseInt(peso.getTextContent());
                peso.setTextContent(String.valueOf(valor - 5));
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(
                    new DOMSource(documento),
                    new StreamResult(new File("Zoo2.xml"))
            );
            System.out.println("Zoo2.xml creado:");
            for (int i = 0; i < lista.getLength(); i++) {
                System.out.println(lista.item(i).getTextContent() + " kg");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el documento XML.");
        }
    }
}