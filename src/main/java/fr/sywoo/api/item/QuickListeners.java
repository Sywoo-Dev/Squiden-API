package fr.sywoo.api.item;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

class QuickListeners implements Listener {

    private QuickItemManager quickItemManager;

    QuickListeners(QuickItemManager quickItemManager) {
        this.quickItemManager = quickItemManager;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
    	ItemStack stack = event.getItemDrop().getItemStack();
    	if(stack == null) return;
    	if(quickItemManager.getEventQuickItem(stack) != null) {
    		event.setCancelled(true);
    	}
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        ItemStack itemStack = event.getItem();
        if(itemStack == null)return;
        Consumer<QuickEvent> consumer = quickItemManager.getEventQuickItem(itemStack);
        if(consumer != null){
            consumer.accept(new QuickEvent(event));
        }
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event){
    	if(event.getClickedInventory() == null) return;
        ItemStack itemStack = event.getCurrentItem();
        if(itemStack == null)return;
        Consumer<QuickEvent> consumer = quickItemManager.getEventQuickItem(itemStack);
        if(consumer != null){
            consumer.accept(new QuickEvent(event));
        }
    }

}
