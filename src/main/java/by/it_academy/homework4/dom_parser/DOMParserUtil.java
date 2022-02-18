package by.it_academy.homework4.dom_parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParserUtil {

    private static final String XML_PATH = "journalXML.xml";

    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try {
            return factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException log");
            return null;
        }
    }

    public static Document parseXMLDocument() {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(XML_PATH));
            } catch (SAXException e) {
                e.printStackTrace();
                System.out.println("SAXException log");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException log");
            }
        }
        return document;
    }
}