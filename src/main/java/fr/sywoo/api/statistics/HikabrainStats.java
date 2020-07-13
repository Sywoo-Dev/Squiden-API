package fr.sywoo.api.statistics;

public class HikabrainStats extends GameStatistics{

	private int perfects, duoVictory, soloVictory, quatroVictory;
	
	public HikabrainStats() {
		perfects = 0;
	}

	public int getPerfects() {
		return perfects;
	}

	public HikabrainStats setPerfects(int perfects) {
		this.perfects = perfects;
		return this;
	}
	
	public HikabrainStats addPerfect() {
		this.perfects++;
		return this;
	}

	public int getDuoVictory() {
		return duoVictory;
	}
	
	public HikabrainStats addDuoVictory() {
		duoVictory++;
		return this;
	}

	public int getSoloVictory() {
		return soloVictory;
	}
	
	public HikabrainStats addSoloVictory() {
		soloVictory++;
		return this;
	}

	public int getQuatroVictory() {
		return quatroVictory;
	}
	
	public HikabrainStats addQuatroVictory() {
		quatroVictory++;
		return this;
	}
	
}
