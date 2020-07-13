package fr.sywoo.api.serverdata;

public enum ServerStatus {

    WAITING("§eEn attente de joueurs..."),
    INGAME("§aPartie lancée"),
    CLOSING("§cFermeture en cours");

    private String name;

    ServerStatus(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
