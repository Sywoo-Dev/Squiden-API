package fr.sywoo.api.item;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

public class QuickItem {

    private ItemStack is;
    private boolean canDrop = true;
    private Consumer<QuickEvent> consumer;

    public QuickItem(Material m) {
        this(m, 1);
    }

    public QuickItem(ItemStack is) {
        this.is = is;
    }

    public QuickItem(Material m, int amount) {
        is = new ItemStack(m, amount);
    }

    public QuickItem(Material m, int amount, int meta){
        is = new ItemStack(m, amount, (short) meta);
    }


    public QuickItem clone() {
        return new QuickItem(is);
    }

    public QuickItem setDurability(short dur) {
        is.setDurability(dur);
        return this;
    }

    public QuickItem glow(){
        ItemMeta itemMeta = is.getItemMeta();
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is.setItemMeta(itemMeta);
        return this;
    }

    public QuickItem setName(String name) {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return this;
    }

    public String getName(){
        ItemMeta im = is.getItemMeta();
        return im.getDisplayName();
    }

    public QuickItem addUnsafeEnchantment(Enchantment ench, int level) {
        is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public QuickItem removeEnchantment(Enchantment ench) {
        is.removeEnchantment(ench);
        return this;
    }

    public QuickItem setSkullOwner(String owner) {
        try {
            SkullMeta im = (SkullMeta) is.getItemMeta();
            im.setOwner(owner);
            is.setItemMeta(im);
        } catch (ClassCastException expected) {
        }
        return this;
    }

    public QuickItem addEnchant(Enchantment ench, int level, boolean show) {
        ItemMeta im = is.getItemMeta();
        im.addEnchant(ench, level, show);
        is.setItemMeta(im);
        return this;
    }

    public Map<Enchantment, Integer> getEnchants(){
        ItemMeta im = is.getItemMeta();
        return im.getEnchants();
    }
    
    public QuickItem setCanDrop(boolean drop) {
    	this.canDrop = drop;
    	return this;
    }
    
    public boolean canDrop() {
    	return this.canDrop;
    }

    public QuickItem addItemFlag(ItemFlag... itemFlags){
        ItemMeta im = is.getItemMeta();
        im.addItemFlags(itemFlags);
        is.setItemMeta(im);
        return this;
    }

    public QuickItem hideEnchant(){
        ItemMeta im = is.getItemMeta();
        im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is.setItemMeta(im);
        return this;
    }

    public QuickItem setInfinityDurability() {
        is.setDurability(Short.MIN_VALUE);
        return this;
    }

    public QuickItem setUmbreakable() {
    	ItemMeta im = is.getItemMeta();
    	im.spigot().setUnbreakable(true);
    	is.setItemMeta(im);
    	return this;
    }
    
    public QuickItem setLore(String... lore) {
        ItemMeta im = is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        is.setItemMeta(im);
        return this;
    }

    public QuickItem setLore(List<String> lore) {
        ItemMeta im = is.getItemMeta();
        im.setLore(lore);
        is.setItemMeta(im);
        return this;
    }

    public List<String> getLore(){
        ItemMeta im = is.getItemMeta();
        return im.getLore();
    }

    public QuickItem setLeatherArmorColor(Color color) {
        try {
            LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
            im.setColor(color);
            is.setItemMeta(im);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Color getLeatherArmorColor(){
        LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
        return im.getColor();
    }

    public QuickItem setCustomHead(String name) {
        ItemMeta headM = this.is.getItemMeta();
        try {
            Field field = headM.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            PropertyMap propertyMap = profile.getProperties();
            byte[] encodedData = name.getBytes();
            propertyMap.put("textures", new Property("textures", new String(encodedData)));
            field.set(headM, profile);
        }
        catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException e) {
            e.printStackTrace();
        }
        this.is.setItemMeta(headM);
        return this;
    }

    public QuickItem setAction(Consumer<QuickEvent> consumer){
        this.consumer = consumer;
        return this;
    }

    public ItemStack toItemStack(){
        if(consumer != null) QuickItemManager.registerItem(this.is, consumer);
        return this.is;
    }

}
