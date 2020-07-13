package fr.sywoo.api.item.items;

import org.bukkit.Material;

import fr.sywoo.api.item.QuickItem;
import fr.sywoo.api.spigot.LionSpigot;

public class HubItem extends QuickItem{

	public HubItem() {
		super(Material.BED);
		this.setName("§b§l/hub");
		this.glow();
		this.setAction(action -> {
			action.getPlayer().sendMessage("§a§lRetour au hub...");
			LionSpigot.get().fallback(action.getPlayer());
		});
	}
	
}
