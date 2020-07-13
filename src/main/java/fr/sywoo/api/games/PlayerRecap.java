package fr.sywoo.api.games;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.guilds.Guilds;
import fr.sywoo.api.spigot.LionSpigot;

public class PlayerRecap {
	
	private double guildXp, shishi;
	private UUID uuid;
	
	private static HashMap<UUID, PlayerRecap> recaps = new HashMap<UUID, PlayerRecap>();
	
	public PlayerRecap() {}
	
	public PlayerRecap(Player player) {
		guildXp = 0;
		shishi = 0;
		uuid = player.getUniqueId();
		recaps.put(player.getUniqueId(), this);
	}
	
	public void addXP(double xp) {
		this.guildXp += xp*Double.valueOf("1." + LionSpigot.get().getGamePoint().getBooster());
	}
	
	public void addShishi(int shishi) {
		this.shishi += shishi*Double.valueOf("1." + LionSpigot.get().getGamePoint().getBooster());
	}
	
	public void sendRecap() {
		AccountData data = LionSpigot.get().getAccountManager().get(uuid);
		LionSpigot.get().getAccountManager().update(data.addXP(guildXp));
		LionSpigot.get().getAccountManager().update(data.addSquids((int) shishi));
		if(data.getGuildsName() != null) {
			Guilds guild = LionSpigot.get().getGuildsManager().get(data.getGuildsName());
			LionSpigot.get().getGuildsManager().update(guild.addXP(guildXp));
		}
		Player player = Bukkit.getPlayer(uuid);
		if(player != null) {
			player.sendMessage("§e■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
			player.sendMessage("§7Gain de §bShishi " + shishi);
			if(data.getGuildsName() != null) {
				player.sendMessage("§7Gain d'§aExpérience de Guilde " + guildXp);
			}
			player.sendMessage("§e■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		}
	}
	
	public static PlayerRecap get(Player player) {
		if(recaps.containsKey(player.getUniqueId())) {
			return recaps.get(player.getUniqueId());
		}
		return null;
	}
}
