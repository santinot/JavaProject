//Classe per lettura file di configuazione database ed ottenere informazioni necessarie
package src.main.java;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class LettoreXML {
    private Document doc;

    public LettoreXML(String path) {
        //Creazione del documento
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File(path));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl() {
        return ((Element) doc.getElementsByTagName("database").item(0)).getElementsByTagName("url").item(0).getTextContent();
    }

    public String getUsername() {
        return ((Element) doc.getElementsByTagName("database").item(0)).getElementsByTagName("username").item(0).getTextContent();
    }

    public String getPassword() {
        return ((Element) doc.getElementsByTagName("database").item(0)).getElementsByTagName("password").item(0).getTextContent();
    }

    public String getName() {
        return ((Element) doc.getElementsByTagName("database").item(0)).getElementsByTagName("name").item(0).getTextContent();
    }
}