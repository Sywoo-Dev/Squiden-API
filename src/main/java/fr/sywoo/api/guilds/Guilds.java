package fr.sywoo.api.guilds;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.Player;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.spigot.LionSpigot;

public class Guilds {

	private String name, prefix, tag, displayName;
	private UUID owner;
	private Set<UUID> players;
	private Set<String> playersName;
	private Set<GuildsRank> ranks;
		
	private int level, coins, boost;
	private double xp, totalXp;
	
	private Date boost_expire;
	private int maxPlayer;
	
	public Guilds(String name, UUID owner) {
		this.displayName = name;
		this.name = name.toLowerCase();
		this.prefix = "[" + displayName + "]";
		this.owner = owner;
		this.level = 1;
		this.xp = 0;
		this.players = new HashSet<UUID>();
		this.playersName = new HashSet<String>();
		this.ranks = new HashSet<GuildsRank>();
		this.tag = "Guilde du serveur squiden.fr";
		this.coins = 0;
		this.boost = 0;
		this.maxPlayer = 50;
		this.boost_expire = new Date();
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
	public Guilds addTotalXp(double xp) {
		this.totalXp += xp;
		return this;
	}
	
	public Guilds removeTotalXp(double xp) {
		this.totalXp -= xp;
		return this;
	}
	
	public double getTotalXp() {
		return this.totalXp;
	}
	
	public Guilds addRank(GuildsRank rank) {
		this.ranks.add(rank);
		return this;
	}
	
	public Guilds downRank(String name) {
		GuildsRank r = null;
		for(GuildsRank rank : ranks) {
			if(rank.getName().equalsIgnoreCase(name)) {
				r = rank;
			}
		}
		if(r != null) {
			int pos = r.getPosition();
			pos++;
			for(GuildsRank rank : ranks) {
				if(rank.getPosition() >= pos) {
					rank.setPosition(pos-1);
				}
			}
		}
		return this;
	}
	
	public Guilds upRank(String name) {
		GuildsRank r = null;
		for(GuildsRank rank : ranks) {
			if(rank.getName().equalsIgnoreCase(name)) {
				r = rank;
			}
		}
		if(r != null) {
			int pos = r.getPosition();
			pos--;
			for(GuildsRank rank : ranks) {
				if(rank.getPosition() >= pos) {
					rank.setPosition(pos+1);
				}
			}
		}
		return this;
	}
	
	public GuildsRank getRankByName(String rankname) {
		for(GuildsRank rank : ranks) {
			if(rank.getName().equalsIgnoreCase(rankname)) {
				return rank;
			}
		}
		return null;
	}
	
	public GuildsRank getRankByPosition(int position) {
		for(GuildsRank rank : ranks) {
			if(rank.getPosition() == position) {
				return rank;
			}
		}
		return null;
	}
	
	public GuildsRank getRank(UUID uuid) {
		for(GuildsRank rank : ranks) {
			if(rank.getPlayers().contains(uuid)) {
				return rank;
			}
		}
		return null;
	}
	
	public Set<GuildsRank> getRanks(){
		return this.ranks;
	}
		
	public Guilds addPlayer(Player player) {
		AccountData data = LionSpigot.get().getAccountManager().get(player.getUniqueId());
		if(data.getGuildsName() != null) {
			if(!data.getGuildsName().equalsIgnoreCase("aucune")) {
				LionSpigot.get().getGuildsManager().get(data.getGuildsName()).removePlayer(player.getName());
				data.setGuild(new Guilds("Aucune", UUID.randomUUID()));
			}
		}
		players.add(player.getUniqueId());
		playersName.add(player.getName());
		data.setGuild(this);
		LionSpigot.get().getAccountManager().update(data);
		return this;
	}
	
	public Guilds removePlayer(String name) {
		AccountData data = LionSpigot.get().getAccountManager().get(name.toLowerCase());
		if(data.getGuildsName() != null) {
			if(!data.getGuildsName().equalsIgnoreCase("Aucune")) {
				data.setGuild(null);
				data.setGuildRank("Aucun");
				LionSpigot.get().getAccountManager().update(data);
			}
		}
		players.remove(data.getUUID());
		playersName.remove(name);
		return this;
	}
	
	public Set<String> getPlayersName(){
		return playersName;
	}
	
	public Guilds setMaxPlayer(int max) {
		this.maxPlayer = max;
		return this;
	}
	
	public Guilds setBoost(int boost, Date expiration) {
		this.boost = boost;
		this.boost_expire = expiration;
		return this;
	}
	
	public Guilds addXP(double d) {
		if(boost_expire.before(new Date())){
			this.xp += d;
		}else {
			this.xp += d * Double.valueOf("1." + boost);
		}
		if(xp >= level*5000) {
			this.level++;
			this.xp -= level*5000;
		}
		return this;
	}
	
	public Date getBoostExpire() {
		return this.boost_expire;
	}
	
	public int getBoost() {
		return this.boost;
	}
	
	public Guilds removeXP(double d) {
		if(level <= 1) return this;
		this.xp += d;
		while(xp < 0) {
			if(level <= 1) {
				this.xp = 0;
				this.level = 1;
				break;
			}
			this.level--;
			this.xp += level*5000;
		}
		return this;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public double getXP() {
		return this.xp;
	}
	
	public Guilds addCoins(int i) {
		this.coins += i;
		return this;
	}
	
	public Guilds removeCoins(int i) {
		this.coins -= i;
		return this;
	}
	
	public Guilds setCoins(int i) {
		this.coins = i;
		return this;
	}
	
	public int getCoins() {
		return this.coins;
	}
	
	public Guilds setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Guilds setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public Guilds setTag(String tag) {
		this.tag = tag;
		return this;
	}
	
	public String getTag() {
		return this.tag;
	}
	
	public Guilds setOwner(UUID owner) {
		this.owner = owner;
		return this;
	}
	
	public UUID getOwner() {
		return this.owner;
	}
	
	public Guilds setPlayers(Set<UUID> players) {
		this.players = players;
		return this;
	}
	
	public Set<UUID> getPlayers(){
		return this.players;
	}

	public int getMaxPlayer() {
		return maxPlayer;
	}
	
}
