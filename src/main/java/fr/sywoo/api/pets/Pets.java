package fr.sywoo.api.pets;

public class Pets {

    private String name;
    private String type;
    private boolean show;

    public Pets(String name, String type, boolean show) {
        this.name = name;
        this.type = type;
        this.show = show;
    }

    public String getName() {
        return name;
    }

    public Pets setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Pets setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isShow() {
        return show;
    }

    public Pets setShow(boolean show) {
        this.show = show;
        return this;
    }
}
