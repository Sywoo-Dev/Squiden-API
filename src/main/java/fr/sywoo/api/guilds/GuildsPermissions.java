package fr.sywoo.api.guilds;

import org.bukkit.Material;

public enum GuildsPermissions {
	
	INVITE("Inviter un joueur", Material.PAPER, "guilds.invite"),
	KICK("Exclure un joueur", Material.BUCKET, "guilds.kick"),
	ADDROLE("Créer un Role", Material.PAPER, "guilds.role.create"),
	DELROLE("Supprimer un Role", Material.PAPER, "guild.role.delete"),
	SETROLE("Modifier un Role", Material.PAPER, "guilds.role.modify"),
	SETPLAYER("Assigner un Role", Material.PAPER, "guilds.player.addrole"),
	USECOINS("Utiliser la cagnotte", Material.DIAMOND, "guilds.coins.use"),
	DEFINETAG("Définir un Tag", Material.PAPER, "guilds.tag.modify");
	
	
	private String label, perm;
	private Material icon;
	
	GuildsPermissions(String label, Material icon, String perm) {
		this.label = label;
		this.icon = icon;
		this.perm = perm;
	}

	public Material getIcon() {
		return icon;
	}
	
	public String getPerm() {
		return perm;
	}
	
	public String getLabel() {
		return label;
	}

}
