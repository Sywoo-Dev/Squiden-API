package fr.sywoo.api.games;

public enum QueueGames {

	ARENA("Arena","Sywoo", "Arena", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	ARENAKIT("Arena Kit","Sywoo", "Arena", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	HIKABRAIN("Hikabrain","Maygo", "Hikabrain", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	KAPTUR("Kaptur", "Sywoo","Kaptur", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	UHCRUN("UhcRun","Maygo", "UhcRun", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	SKYWARS("Skywars","Sywoo", "Skywars", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	SLASHER("Slasher","Maygo", "Slasher", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	GOLEMRUSH("GolemRush","Maygo", "GolemRush", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	AGEOFEMPIRE("AgeOfEmpire","Sywoo", "AOE", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE"),
	UHCHOST("UHC Host","Sywoo & Maygo", "UHC", "§d§k|§r §e§lBêta §d§k|", "Insert", "Description", "HERE");

	
	private String name, dev, group, annotation;
	private String[] description;
	
	private QueueGames(String name,String developper, String group, String annotation, String... description) {
		this.name = name;
		this.dev = developper;
		this.group = group;
		this.annotation = annotation;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public String getDevelopper() {
		return dev;
	}
	public String getGroup() {
		return group;
	}
	public String getAnnotation() {
		return annotation;
	}
	public String[] getDescription() {
		return description;
	}

}
