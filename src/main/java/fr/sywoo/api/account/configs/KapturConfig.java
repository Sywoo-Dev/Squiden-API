package fr.sywoo.api.account.configs;

public class KapturConfig {

	private int sword, pickaxe, food;
	
	public KapturConfig() {
		sword = 0;
		pickaxe = 1;
		food = 8;
	}

	public int getSword() {
		return sword;
	}

	public KapturConfig setSword(int sword) {
		this.sword = sword;
		return this;
	}

	public int getPickaxe() {
		return pickaxe;
	}

	public KapturConfig setPickaxe(int pickaxe) {
		this.pickaxe = pickaxe;
		return this;
	}
	
	public int getFood() {
		return this.food;
	}
	
	public KapturConfig setFood(int food) {
		this.food = food;
		return this;
	}
	
}
