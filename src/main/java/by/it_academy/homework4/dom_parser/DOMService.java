package by.it_academy.homework4.dom_parser;

import by.it_academy.homework4.entity.Article;
import by.it_academy.homework4.entity.Contact;
import by.it_academy.homework4.entity.Hotkey;
import by.it_academy.homework4.entity.Journal;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.stream.Collectors;

public class DOMService {
    private Journal journal;
    private Contact contact;
    private List<Article> articles;
    private List<Hotkey> hotkeys;
    private NodeList nodeList;

    public DOMService(Journal journal, Contact contact, List<Article> articles, List<Hotkey> hotkeys, NodeList nodeList) {
        this.journal = journal;
        this.contact = contact;
        this.articles = articles;
        this.hotkeys = hotkeys;
        this.nodeList = nodeList;
    }

    public Journal getJournalFromXML() {
        NodeUtil.getNodeListStream(nodeList).forEach(journalNode -> {
            if (journalNode instanceof Element) {
                switch (journalNode.getNodeName()) {
                    case "journal_title" -> journal.setJournalTitle(journalNode
                            .getLastChild()
                            .getTextContent()
                            .trim());
                    case "contacts" -> getContactsFromXML(journalNode.getChildNodes());
                    case "articles" -> getArticlesFromXML(journalNode.getChildNodes());
                }
            }
        });
        return journal;
    }

    private void getContactsFromXML(NodeList nodeList) {
        NodeUtil.getNodeListStream(nodeList).forEach(contactNode -> {
            if (contactNode instanceof Element) {
                String contactContent = contactNode
                        .getLastChild()
                        .getTextContent()
                        .trim();
                switch (contactNode.getNodeName()) {
                    case "address" -> contact.setAddress(contactContent);
                    case "tel" -> contact.setTel(contactContent);
                    case "email" -> contact.setEmail(contactContent);
                    case "journal_url" -> contact.setJournalURL(contactContent);
                }
                journal.setContact(contact);
            }
        });
    }


    private void getArticlesFromXML(NodeList nodeList) {
        NodeUtil.getNodeListStream(nodeList).forEach(articlesNode -> {
            if (articlesNode instanceof Element) {
                Article article = new Article();
                String articleID = articlesNode.getAttributes().
                        getNamedItem("ID").getNodeValue();
                article.setId(articleID);
                articles.add(getArticleFromXML(article, articlesNode.getChildNodes(), articleID));
            }
        });
        journal.setArticles(articles);
    }

    private Article getArticleFromXML(Article article, NodeList nodeList, String articleID) {
        NodeUtil.getNodeListStream(nodeList).forEach(articleNode -> {
            if (articleNode instanceof Element) {
                String articleContent = articleNode
                        .getLastChild()
                        .getTextContent()
                        .trim();
                switch (articleNode.getNodeName()) {
                    case "title" -> article.setArticleTitle(articleContent);
                    case "author" -> article.setAuthor(articleContent);
                    case "url" -> article.setArticleURL(articleContent);
                    case "hotkeys" -> getHotkeyFromXML(article, articleNode.getChildNodes(), articleID);
                }
            }
        });
        return article;
    }


    private void getHotkeyFromXML(Article article, NodeList nodeList, String articleID) {
        NodeUtil.getNodeListStream(nodeList).forEach(hotkeysNode -> {
            if (hotkeysNode instanceof Element) {
                Hotkey hotkey = new Hotkey();
                hotkey.setId(articleID);
                hotkey.setHotkey(hotkeysNode.getTextContent().trim());
                hotkeys.add(hotkey);
            }
        });
        article.setHotkeys(hotkeys
                .stream()
                .filter(n -> n.getId().equals(article.getId()))
                .collect(Collectors.toList()));
    }
}