package fr.sywoo.api.account.configs;

import java.util.HashSet;
import java.util.Set;

public class SlasherConfig {

	private String weapon, skin;
	private Set<String> possededSkins, possededWeapons;
	
	public SlasherConfig() {
		weapon = "STONE_AXE";
		skin = "random";
		possededWeapons = new HashSet<String>();
		possededWeapons.add("STONE_AXE");
		
		possededSkins = new HashSet<String>();
	}

	public String getWeapon() {
		return weapon;
	}

	public SlasherConfig setWeapon(String weapon) {
		this.weapon = weapon;
		return this;
	}

	public String getSkin() {
		return skin;
	}

	public SlasherConfig setSkin(String skin) {
		this.skin = skin;
		return this;
	}

	public Set<String> getPossededSkins() {
		return possededSkins;
	}

	public SlasherConfig setPossededSkins(Set<String> possededSkins) {
		this.possededSkins = possededSkins;
		return this;
	}
	
	public Set<String> getPossededWeapons(){
		return possededWeapons;
	}
	
	public SlasherConfig setPossededWeapons(Set<String> possededWeapons) {
		this.possededWeapons = possededWeapons;
		return this;
	}
	
}
