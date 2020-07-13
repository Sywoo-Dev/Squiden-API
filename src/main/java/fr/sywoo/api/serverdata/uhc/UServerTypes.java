package fr.sywoo.api.serverdata.uhc;

public enum UServerTypes {

    PRIVATE("§c§lPrivé"),
    PUBLIC("§a§lPublic");

    private String name;

    private UServerTypes(String name) {
        this.name = name;
    }

    public UServerTypes setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
