package by.it_academy.homework4.entity;

public class Hotkey {
    private String id;
    private String hotkey;

    public String getHotkey() {
        return hotkey;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\t" + "\t" + "\t" + "\t" + "\t" + "hotkey: " + hotkey;
    }
}