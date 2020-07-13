package fr.sywoo.api.statistics;

public class AOEStats extends GameStatistics{

	private int destroyedBuildings;
	
	public AOEStats() {
		destroyedBuildings = 0;
	}

	public int getDestroyedBuildings() {
		return destroyedBuildings;
	}

	public AOEStats setDestroyedBuildings(int destroyedBuildings) {
		this.destroyedBuildings = destroyedBuildings;
		return this;
	}
	
}
