package fr.sywoo.api.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

import java.util.List;

public abstract class IQuickInventory {


    private String name;
    private int size;
    private InventoryType inventoryType;
    private boolean closable;

    public IQuickInventory(String name, int size) {
        this.name = name;
        this.size = size;
        this.closable = true;
    }

    public IQuickInventory(String name, InventoryType inventoryType) {
        this.name = name;
        this.inventoryType = inventoryType;
    }

    String getName() { return name; }
    int getSize() { return size; }

    InventoryType getInventoryType() { return inventoryType; }

    boolean isClosable() { return closable; }
    public void setClosable(boolean closable) { this.closable = closable; }

    public void open(Player player){ QuickInventory.open(player, this); }

    public List<QuickInventory> getPlayersOpenInventory(){
        return QuickInventoryManager.getPlayerOpenInventory(this);
    }

    public abstract void contents(QuickInventory quickInventory);
}
