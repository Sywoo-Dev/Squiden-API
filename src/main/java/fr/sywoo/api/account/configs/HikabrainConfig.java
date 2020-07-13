package fr.sywoo.api.account.configs;

public class HikabrainConfig {

	private int sword, pickaxe, gapple;
	
	public HikabrainConfig() {
		sword = 0;
		pickaxe = 1;
		gapple = 2;
	}

	public int getSword() {
		return sword;
	}

	public HikabrainConfig setSword(int sword) {
		this.sword = sword;
		return this;
	}

	public int getPickaxe() {
		return pickaxe;
	}

	public HikabrainConfig setPickaxe(int pickaxe) {
		this.pickaxe = pickaxe;
		return this;
	}

	public int getGapple() {
		return gapple;
	}

	public HikabrainConfig setGapple(int gapple) {
		this.gapple = gapple;
		return this;
	}
	
}
