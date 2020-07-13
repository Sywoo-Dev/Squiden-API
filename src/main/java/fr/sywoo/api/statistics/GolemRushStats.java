package fr.sywoo.api.statistics;

public class GolemRushStats extends GameStatistics{
	
	private long golemDamage, mobKill, usedGadget;
	
	public GolemRushStats() {
		golemDamage = mobKill = usedGadget = 0;
	}

	public long getGolemDamage() {
		return golemDamage;
	}

	public GolemRushStats setGolemDamage(long golemDamage) {
		this.golemDamage = golemDamage;
		return this;
	}

	public long getMobKill() {
		return mobKill;
	}

	public GolemRushStats setMobKill(long mobKill) {
		this.mobKill = mobKill;
		return this;
	}

	public long getUsedGadget() {
		return usedGadget;
	}

	public GolemRushStats setUsedGadget(long usedGadget) {
		this.usedGadget = usedGadget;
		return this;
	}

}
