package by.it_academy.homework4.stax_parser;

import by.it_academy.homework4.entity.Article;
import by.it_academy.homework4.entity.Contact;
import by.it_academy.homework4.entity.Hotkey;
import by.it_academy.homework4.entity.Journal;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StAXParser {
    private Journal journal;
    private Contact contact;
    private List<Article> articles;
    private Article article;
    private List<Hotkey> hotkeys;
    private String tagContent;
    private Hotkey hotkey;

    public Journal printJournalFromXML() {
        try {
            XMLStreamReader reader = StAXParserUtil.getXMLStreamReader();
            if (reader != null) {
                while (reader.hasNext()) {
                    int event = reader.next();
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT -> {
                            if ("journal_title".equals(reader.getLocalName())) {
                                journal = new Journal();
                            }
                            if ("contacts".equals(reader.getLocalName())) {
                                contact = new Contact();
                            }
                            if ("articles".equals(reader.getLocalName())) {
                                articles = new ArrayList<>();
                            }
                            if ("article".equals(reader.getLocalName())) {
                                article = new Article();
                                article.setId(reader.getAttributeValue(0));
                            }
                            if ("hotkeys".equals(reader.getLocalName())) {
                                hotkeys = new ArrayList<>();
                            }
                            if ("hotkey".equals(reader.getLocalName())) {
                                hotkey = new Hotkey();
                            }
                        }
                        case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
                        case XMLStreamConstants.END_ELEMENT -> {
                            if ("journal_title".equals(reader.getLocalName())) {
                                journal.setJournalTitle(tagContent);
                            }
                            if ("address".equals(reader.getLocalName())) {
                                contact.setAddress(tagContent);
                            }
                            if ("tel".equals(reader.getLocalName())) {
                                contact.setTel(tagContent);
                            }
                            if ("email".equals(reader.getLocalName())) {
                                contact.setEmail(tagContent);
                            }
                            if ("journal_url".equals(reader.getLocalName())) {
                                contact.setJournalURL(tagContent);
                            }
                            if ("contacts".equals(reader.getLocalName())) {
                                journal.setContact(contact);
                            }
                            if ("title".equals(reader.getLocalName()) && article != null) {
                                article.setArticleTitle(tagContent);
                            }
                            if ("author".equals(reader.getLocalName()) && article != null) {
                                article.setAuthor(tagContent);
                            }
                            if ("url".equals(reader.getLocalName()) && article != null) {
                                article.setArticleURL(tagContent);
                            }
                            if ("hotkey".equals(reader.getLocalName())) {
                                hotkey.setHotkey(tagContent);
                                hotkeys.add(hotkey);
                                article.setHotkeys(hotkeys);
                            }
                            if ("article".equals(reader.getLocalName())) {
                                articles.add(article);
                            }
                            if ("articles".equals(reader.getLocalName())) {
                                journal.setArticles(articles);
                            }
                        }
                    }
                }
            }
            return journal;
        } catch (XMLStreamException e) {
            System.out.println("XMLStreamException ERROR");
            e.printStackTrace();
            return null;
        }
    }
}