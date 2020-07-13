package fr.sywoo.api.games;

import org.bukkit.Bukkit;

public class GamePoint {
	
	private int booster;
	
	
	public void addBooster(int b) {
		if(booster + b >= 160) {
			return;
		}
		booster+=b;
		Bukkit.broadcastMessage("§d§lBooster §7» §5Le Boost §eXP §5est de §a" + booster + "%");
	}

	public int getBooster() {
		return booster;
	}

	public void setBooster(int booster) {
		this.booster = booster;
	}

}
