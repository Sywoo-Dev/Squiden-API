package fr.sywoo.api.report;

public enum ReportType {

    COMBAT("Combat"),
    CHAT("Chat"),
    OTHER("Other");

    private String name;

    ReportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
