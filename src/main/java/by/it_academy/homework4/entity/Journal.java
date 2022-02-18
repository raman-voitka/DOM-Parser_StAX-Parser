package by.it_academy.homework4.entity;

import java.util.List;

public class Journal {

    private String journalTitle;
    private Contact contact;
    private List<Article> articles;

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal: \n" +
                "\t" + "journal_title: \"" + journalTitle + '\"' + '\n' +
                "\t" + "contacts: " + contact + '\n' +
                "\t" + "articles: " + articles.toString().substring(1, articles.toString().length() - 1).replace(",", "");
    }
}