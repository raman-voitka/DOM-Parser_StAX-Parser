package by.it_academy.homework4.entity;

import java.util.List;

public class Article {
    private String id;
    private String articleTitle;
    private String author;
    private String articleURL;
    private List<Hotkey> hotkeys;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleURL() {
        return articleURL;
    }

    public void setArticleURL(String articleURL) {
        this.articleURL = articleURL;
    }

    public List<Hotkey> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<Hotkey> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "\n" + "\t" + "\t" + "\t" + "article ID: " + id +
                "\n" + "\t" + "\t" + "\t" + "title: \"" + articleTitle + '\"' +
                "\n" + "\t" + "\t" + "\t" + "author: " + author +
                "\n" + "\t" + "\t" + "\t" + "url: " + articleURL +
                "\n" + "\t" + "\t" + "\t" + "hotkeys:" +
                "\n" + hotkeys.toString().substring(1, hotkeys.toString().length() - 1).replace(",", "\n");
    }
}