package fr.sywoo.api.item;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class QuickEvent {

    private PlayerInteractEvent event;
    private InventoryClickEvent event2;
    public QuickEvent(PlayerInteractEvent event) {
        this.event = event;
    }

    public QuickEvent(InventoryClickEvent event2) {
    	this.event2 = event2;
    }

    public ClickType getInventoryClickType() {
    	if(event2 == null) return null;
    	return event2.getClick();
    }
    
	public Player getPlayer(){
        if(event != null) {
        	return event.getPlayer();
        }
        if(event2 != null) {
        	return (Player) event2.getWhoClicked();
        }
        System.out.println("NPE !");
        return null;
    }


    public Action getAction(){
        return event.getAction();
    }


}
