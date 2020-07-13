package fr.sywoo.api.queue;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.bungee.LionBungee;
import fr.sywoo.api.serverdata.GameType;
import fr.sywoo.api.serverdata.ServersData;

public class Queue {

	private String game, group;
	private Set<String> players;
	private GameType type;
	private ServersData serversData;

	public Queue(String game) {
		this.players = new HashSet<String>();
		this.game = game;
		this.group = game;
		LionBungee.get().getQueues().put(game, this);
	}

	public Queue(String game, String type, String group) {
		this.players = new HashSet<String>();
		this.game = game;
		this.type = GameType.valueOf(type.toUpperCase());
		this.group = group;
		LionBungee.get().getQueues().put(game, this);
	}

	public Queue(String game, GameType type, String group) {
		this.players = new HashSet<String>();
		this.game = game;
		this.type = type;
		LionBungee.get().getQueues().put(game, this);
	}

	public Queue setServersData(ServersData serversData) {
		this.serversData = serversData;
		return this;
	}

	public ServersData getServersData() {
		return serversData;
	}

	public static boolean playerInQueue(UUID uuid) {
		AccountData data = LionBungee.get().getAccountManager().get(uuid);
		for (Map.Entry<String, Queue> queues : LionBungee.get().getQueues().entrySet()) {
			if (queues.getValue().getPlayers().contains(data.getRank().getPower() + uuid)) {
				return true;
			}
		}
		return false;
	}

	public static Queue getPlayerQueue(UUID uuid) {
		AccountData data = LionBungee.get().getAccountManager().get(uuid);
		for (Map.Entry<String, Queue> queues : LionBungee.get().getQueues().entrySet()) {
			if (queues.getValue().getPlayers().contains(data.getRank().getPower() + uuid)) {
				return queues.getValue();
			}
		}
		return null;
	}

	public static Queue getByName(String game) {
		return LionBungee.get().getQueues().get(game);
	}

	public static boolean existFor(String game) {
		return LionBungee.get().getQueues().containsKey(game);
	}

	public String getGame() {
		return game;
	}

	public String getGroup() {
		return group;
	}

	public Set<String> getPlayers() {
		return players;
	}

	public int getPosition(String player) {
		int i = 0;
		for (String uuids : players) {
			i++;
			if (uuids.equalsIgnoreCase(player))
				break;
		}

		return i;
	}

	public void addPlayer(String player) {
		players.add(player);
	}

	public void removePlayer(UUID uuid) {
		AccountData data = LionBungee.get().getAccountManager().get(uuid);
		players.remove(data.getRank().getPower() + uuid);
	}

	public GameType getType() {
		return type;
	}

	public void setType(GameType type) {
		this.type = type;
	}
}
