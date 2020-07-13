package fr.sywoo.api.serverdata.uhc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import fr.sywoo.api.uhcconfig.UhcType;

public class UHCData {

    private int timer, pvp, border, borderSize,maxPlayers;
    private List<String> scenarios;
    private boolean whitelist, mumble;
    private String type, customName;
    private List<UUID> whitelisted;
    private UhcType uhcType;
    private Set<Integer> biomes;
    
    public UHCData(int timer, int pvp, int border, int borderSize, boolean whitelist, boolean mumble, int maxPlayers, String type, Set<Integer> biomes) {
        this.timer = timer;
        this.pvp = pvp;
        this.border = border;
        this.borderSize = borderSize;
        this.scenarios = new ArrayList<>();
        this.whitelisted = new ArrayList<UUID>();
        this.whitelist = whitelist;
        this.mumble = mumble;
        this.maxPlayers = maxPlayers;
        this.type = type;
        this.uhcType = UhcType.CLASSIC;
        this.biomes = biomes;
    }

    
    public UHCData setBiomes(Set<Integer> biomes) {
    	this.biomes = biomes;
    	return this;
    }
    
    public Set<Integer> getBiomes(){
    	return this.biomes;
    }
    
    public UHCData setScenarios(List<String> scenarios) {
        this.scenarios = scenarios;
        return this;
    }

    public int getTimer() {
        return timer;
    }

    public UHCData setTimer(int timer) {
        this.timer = timer;
        return this;
    }

    public int getPvp() {
        return pvp;
    }

    public UHCData setPvp(int pvp) {
        this.pvp = pvp;
        return this;
    }

    public int getBorder() {
        return border;
    }

    public UHCData setBorder(int border) {
        this.border = border;
        return this;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public UHCData setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        return this;
    }

    public boolean isWhitelist() {
        return whitelist;
    }

    public UHCData setWhitelist(boolean whitelist) {
        this.whitelist = whitelist;
        return this;
    }

    public boolean isMumble() {
        return mumble;
    }

    public UHCData setMumble(boolean mumble) {
        this.mumble = mumble;
        return this;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public UHCData setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

	public List<String> getScenarios() {
		return scenarios;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public List<UUID> getWhitelisted() {
		return whitelisted;
	}

	public void setWhitelisted(List<UUID> whitelisted) {
		this.whitelisted = whitelisted;
	}

	public UhcType getUhcType() {
		return uhcType;
	}

	public UHCData setUhcType(UhcType uhcType) {
		this.uhcType = uhcType;
		return this;
	}
}
