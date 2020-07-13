package fr.sywoo.api.guilds;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildsRank {
	
	private String name, prefix;
	private List<UUID> players;
	private List<String> playersName, permissions;
	private int position;
	
	public GuildsRank(String name, int position) {
		this.name = name;
		this.prefix = "[" + name + "]";
		this.players = new ArrayList<UUID>();
		this.playersName = new ArrayList<String>();
		this.permissions = new ArrayList<String>();
		this.position = position;
	}
	
	public GuildsRank setName(String name) {
		this.name = name;
		return this;
	}
	
	public GuildsRank setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}
	
	public GuildsRank addPlayer(UUID uuid, String name) {
		players.add(uuid);
		playersName.add(name);
		return this;
	}
	
	public GuildsRank removePlayer(UUID uuid, String name) {
		players.remove(uuid);
		playersName.remove(name);
		return this;
	}
	
	public GuildsRank setPermissions(List<String> permissions) {
		this.permissions = permissions;
		return this;
	}
	
	public GuildsRank addPermission(String perm) {
		this.permissions.add(perm);
		return this;
	}
	
	public GuildsRank removePermission(String perm) {
		this.permissions.remove(perm);
		return this;
	}

	public final String getName() {
		return name;
	}

	public final String getPrefix() {
		return prefix;
	}

	public final List<UUID> getPlayers() {
		return players;
	}

	public final List<String> getPlayersName() {
		return playersName;
	}

	public final List<String> getPermissions() {
		return permissions;
	}

	public int getPosition() {
		return position;
	}

	public GuildsRank setPosition(int position) {
		this.position = position;
		return this;
	}
	
	

}
