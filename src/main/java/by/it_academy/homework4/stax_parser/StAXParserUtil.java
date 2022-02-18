package by.it_academy.homework4.stax_parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParserUtil {

    private static final String XML_PATH = "journalXML.xml";

    public static XMLStreamReader getXMLStreamReader() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            return factory.createXMLStreamReader(
                    ClassLoader.getSystemResourceAsStream(XML_PATH));
        } catch (XMLStreamException e) {
            System.out.println("XMLStreamException ERROR");
            e.printStackTrace();
            return null;
        }
    }
}