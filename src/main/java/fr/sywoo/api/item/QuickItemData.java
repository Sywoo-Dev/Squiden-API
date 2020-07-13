package fr.sywoo.api.item;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class QuickItemData {

    private Material material;
    private byte data;
    private ItemMeta itemMeta;


    public QuickItemData(Material material, byte data, ItemMeta itemMeta) {
        this.material = material;
        this.data = data;
        this.itemMeta = itemMeta;
    }

    public Material getMaterial() {
        return material;
    }

    public byte getData() {
        return data;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }
}
