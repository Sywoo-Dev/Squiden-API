package fr.sywoo.api.utils;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Team;

import fr.sywoo.api.spigot.LionSpigot;

public abstract class GameTeams {
	
	private String name, prefix, plugin;
	private ArrayList<UUID> players;
	private Location tp;
	private int kills, size;
	private Team scoreboardTeam;
	private Color color;
	
	public GameTeams(String plugin, String name, String prefix, Color color, int size) {
		if(LionSpigot.get().getTeam(name) != null) return;
		this.name = name;
		this.prefix = prefix;
		this.size = size;
		this.players = new ArrayList<UUID>();
		this.kills = 0;
		this.color = color;

		if(Bukkit.getScoreboardManager().getMainScoreboard().getTeam(name) == null) {
			scoreboardTeam = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam(name);
		}else {
			scoreboardTeam = Bukkit.getScoreboardManager().getMainScoreboard().getTeam(name);
		}
		scoreboardTeam.setAllowFriendlyFire(false);
		scoreboardTeam.setPrefix(prefix);
		scoreboardTeam.setNameTagVisibility(NameTagVisibility.ALWAYS);
		LionSpigot.get().getTeams().add(this);
	}

	public void addPlayer(Player player) {
		if(this.players.contains(player.getUniqueId())) {
			player.sendMessage(plugin + "§cVous êtes déjà dans cette équipe !");
			return;
		}
		if(this.players.size() >= size) {
			player.sendMessage(plugin + "§cEquipe complète !");
			return;
		}
		this.players.add(player.getUniqueId());
		player.setDisplayName(prefix + player.getName());
		scoreboardTeam.addEntry(player.getName());
	}

	public ArrayList<UUID> getPlayers(){
		if(players != null) {
			return players;
		}
		return new ArrayList<UUID>();
	}

	public boolean isFull() {
		boolean full = false;
		if(players.size() >= size) {
			full = true;
		}
		return full;
	}

	public void removePlayer(Player player) {
		if(!this.players.contains(player.getUniqueId())) {
			player.sendMessage(plugin + "§cVous n'êtes pas dans cette équipe !");
			return;
		}
		this.players.remove(player.getUniqueId());
		scoreboardTeam.removeEntry(player.getName());
	}

	public void removePlayer(Player player, boolean silent) {
		this.players.remove(player.getUniqueId());
		scoreboardTeam.removeEntry(player.getName());
	}

	public void setInvisibleMate() {
		for(UUID uuids : players) {
			Player player = Bukkit.getPlayer(uuids);
			if(player != null) {
				if(player.isOnline()) {
					for(Player pls : Bukkit.getOnlinePlayers()) {
						if(players.contains(pls.getUniqueId())) {
							player.hidePlayer(pls);
						}
					}
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public String getPrefix() {
		return prefix;
	}

	public Location getTp() {
		return tp;
	}
	
	public int getSize() {
		return size;
	}

	public void setTp(Location tp) {
		this.tp = new Location(tp.getWorld(), tp.getX(), tp.getY()+1, tp.getZ());
	}

	public void addKill() {
		this.kills++;
	}

	public int getKills() {
		return kills;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Team getScoreboardTeam() {
		return scoreboardTeam;
	}
}
