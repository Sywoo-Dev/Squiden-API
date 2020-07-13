package fr.sywoo.api.item.items;

import org.bukkit.Material;

import fr.sywoo.api.item.QuickItem;
import fr.sywoo.api.spigot.LionSpigot;

public class PlayAgainItem extends QuickItem {

	public PlayAgainItem(String group) {
		super(Material.PAPER);
		this.setName("§a§lRejouer");
		this.glow();
		this.setAction(action -> {
			action.getPlayer().sendMessage("§a§lEn attente d'un serveur...");
			LionSpigot.get().addPlayerInWaitingQueue(action.getPlayer(), group);
		});
	}
	
}
