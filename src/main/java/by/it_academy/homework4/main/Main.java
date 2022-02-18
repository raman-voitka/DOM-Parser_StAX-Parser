package by.it_academy.homework4.main;

import by.it_academy.homework4.dom_parser.DOMParserUtil;
import by.it_academy.homework4.dom_parser.DOMService;
import by.it_academy.homework4.dom_parser.NodeUtil;
import by.it_academy.homework4.entity.Article;
import by.it_academy.homework4.entity.Contact;
import by.it_academy.homework4.entity.Hotkey;
import by.it_academy.homework4.entity.Journal;
import by.it_academy.homework4.stax_parser.StAXParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Journal journal = new Journal();
        Contact contact = new Contact();
        List<Article> articles = new ArrayList<>();
        List<Hotkey> hotkeys = new ArrayList<>();
        Document document = DOMParserUtil.parseXMLDocument();
        NodeList nodeList = NodeUtil.getNodeList(document);
        DOMService service = new DOMService(journal, contact, articles, hotkeys, nodeList);
        StAXParser StAXParser = new StAXParser();
        System.out.println("Result Got By DOMParser");
        System.out.println(service.getJournalFromXML().toString());
        System.out.println("Result Got By StAXParser");
        System.out.println(StAXParser.printJournalFromXML());
    }
}
