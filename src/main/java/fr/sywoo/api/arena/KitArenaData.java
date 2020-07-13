package fr.sywoo.api.arena;

import java.util.UUID;

public class KitArenaData {
	
	private int kit, kills, maxKillStreak, death;
	private UUID uuid;
	
	public KitArenaData(UUID player) {
		uuid = player;
		kit = kills = maxKillStreak = death;
	}

	public int getKit() {
		return kit;
	}

	public KitArenaData setKit(int kit) {
		this.kit = kit;
		return this;
	}

	public int getKills() {
		return kills;
	}

	public KitArenaData setKills(int kills) {
		this.kills = kills;
		return this;
	}

	public int getMaxKillStreak() {
		return maxKillStreak;
	}

	public KitArenaData setMaxKillStreak(int maxKillStreak) {
		this.maxKillStreak = maxKillStreak;
		return this;
	}

	public int getDeath() {
		return death;
	}

	public KitArenaData setDeath(int death) {
		this.death = death;
		return this;
	}

	public UUID getUUID() {
		return uuid;
	}

	public KitArenaData setUuid(UUID uuid) {
		this.uuid = uuid;
		return this;
	}
	
	

}
