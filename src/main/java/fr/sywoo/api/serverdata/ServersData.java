package fr.sywoo.api.serverdata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.queue.Queue;
import fr.sywoo.api.serverdata.uhc.UHCData;
import fr.sywoo.api.serverdata.uhc.UServerTypes;
import fr.sywoo.api.spigot.LionSpigot;

public class ServersData {

    private ServerStatus serverStatus;
    //private GameType type;
    private String name;
    private String owner;
    private Queue queue;
    private UHCData uhcData;
    private boolean canJoin;
    private ArrayList<UUID> insides;

    public ServersData(String owner, String name, ServerStatus serverStatus, String type) {
        this.name = name;
        //this.type = GameType.valueOf(type.toUpperCase());
        this.owner = owner;
        this.serverStatus = serverStatus;
        this.canJoin = false;
        this.insides = new ArrayList<UUID>();
    }
    
    public ServersData(String owner, String name, ServerStatus serverStatus, GameType type) {
        this.name = name;
        //this.type = type;
        this.owner = owner;
        this.serverStatus = serverStatus;
        this.canJoin = false;
        this.insides = new ArrayList<UUID>();
    }
    
    public ServersData addPlayer(UUID uuid) {
    	insides.add(uuid);
    	return this;
    }
    
    public ServersData removePlayer(UUID uuid) {
    	insides.remove(uuid);
    	return this;
    }
    
    public void onShutdown() {
    	for(UUID uuids : insides) {
    		AccountData data = LionSpigot.get().getAccountManager().get(uuids);
    		if(data.getLastServer().equalsIgnoreCase(Bukkit.getServerName())) {
    			LionSpigot.get().getAccountManager().update(data.setLastServer(null));
    		}
    	}
    }

    public ServerStatus getServerStatus() {
        return serverStatus;
    }

    public ServersData setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
        return this;
    }

    public UHCData getUhcData() {
    	if(uhcData == null) {
    		return new UHCData(0, 1200, 3600, 250, true, false, 25, UServerTypes.PUBLIC.toString(), new HashSet<Integer>());
    	}
    	return this.uhcData;
    }
    
    public ServersData setUhcData(UHCData uhcData) {
    	this.uhcData = uhcData;
    	return this;
    }

    public Queue getQueue() {
        return queue;
    }

    public ServersData setQueue(Queue queue) {
        this.queue = queue;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServersData setName(String name) {
        this.name = name;
        return this;
    }

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

//	public GameType getType() {
//		return type;
//	}
//
//	public void setType(GameType type) {
//		this.type = type;
//	}

	public boolean canJoin() {
		return canJoin;
	}

	public ServersData setCanJoin(boolean canJoin) {
		this.canJoin = canJoin;
		return this;
	}
}
