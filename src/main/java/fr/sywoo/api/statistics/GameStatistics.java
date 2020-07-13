package fr.sywoo.api.statistics;

public class GameStatistics {
	
	private int victory, lose, kills, deaths, assistances, partyPlayed;
	private long timePlayed;
	
	public GameStatistics() {
		timePlayed = victory = lose = kills = deaths = assistances = partyPlayed = 0;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(int victory) {
		this.victory = victory;
	}
	
	public void addVictory() {
		this.victory++;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
	public void addLose() {
		this.lose++;
	}

	public int getKills() {
		return kills;
	}
	
	public void addKill() {
		this.kills++;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	
	public void addDeath() {
		this.deaths++;
	}

	public int getAssistances() {
		return assistances;
	}
	
	public void addAssistance() {
		this.assistances++;
	}

	public void setAssistances(int assistances) {
		this.assistances = assistances;
	}

	public long getTimePlayed() {
		return timePlayed;
	}
	
	public void addSecondPlayed() {
		this.timePlayed++;
	}

	public void setTimePlayed(long timePlayed) {
		this.timePlayed = timePlayed;
	}

	public int getPartyPlayed() {
		return partyPlayed;
	}

	public void setPartyPlayed(int partyPlayed) {
		this.partyPlayed = partyPlayed;
	}

}
