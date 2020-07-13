package fr.sywoo.api.statistics;

public class KapturStats extends GameStatistics{

	private int catchedBeacon, finalKills, tntPlaced;
	
	public KapturStats() {
		catchedBeacon = finalKills = tntPlaced = 0;
	}

	public int getCatchedBeacon() {
		return catchedBeacon;
	}

	public KapturStats setCatchedBeacon(int catchedBeacon) {
		this.catchedBeacon = catchedBeacon;
		return this;
	}
	
	public KapturStats addCatchedBeacon() {
		this.catchedBeacon++;
		return this;
	}

	public int getFinalKills() {
		return finalKills;
	}

	public KapturStats setFinalKills(int finalKills) {
		this.finalKills = finalKills;
		return this;
	}
	
	public KapturStats addFinalKills() {
		this.finalKills++;
		return this;
	}

	public int getTntPlaced() {
		return tntPlaced;
	}

	public KapturStats setTntPlaced(int tntPlaced) {
		this.tntPlaced = tntPlaced;
		return this;
	}
	
	public KapturStats addTntPlaced() {
		this.tntPlaced++;
		return this;
	}
	
}
