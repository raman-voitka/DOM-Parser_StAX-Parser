package by.it_academy.homework4.entity;

public class Contact {
    private String address;
    private String tel;
    private String email;
    private String journalURL;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJournalURL() {
        return journalURL;
    }

    public void setJournalURL(String journalURL) {
        this.journalURL = journalURL;
    }

    @Override
    public String toString() {
        return "\n" + "\t" + "\t" + "\t" + "address: \"" + address + '\"' +
                "\n" + "\t" + "\t" + "\t" + "tel:  " + tel +
                "\n" + "\t" + "\t" + "\t" + "email:  " + email +
                "\n" + "\t" + "\t" + "\t" + "journal_url:  " + journalURL;
    }
}
