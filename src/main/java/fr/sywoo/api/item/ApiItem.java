package fr.sywoo.api.item;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ApiItem {
	
	private Material material;
	private byte data;
	private String name;
	private int amount;
	private List<Enchantment> enchs;
	private List<Integer> levels;
	private Set<ItemFlag> flags;
	private List<String> lores;
	private boolean unbreakable;
	
	@SuppressWarnings("deprecation")
	public ApiItem(ItemStack item) {
		this.material = item.getType();
		this.data = item.getData().getData();
		this.amount = item.getAmount();
		
		if(item.getItemMeta() != null) {
			this.name = item.getItemMeta().getDisplayName();
			for(Entry<Enchantment, Integer> entrys : item.getEnchantments().entrySet()) {
				enchs.add(entrys.getKey());
				levels.add(entrys.getValue());
			}
			this.flags = item.getItemMeta().getItemFlags();
			this.lores = item.getItemMeta().getLore();
			this.unbreakable = item.getItemMeta().spigot().isUnbreakable();
		}
	}
	
	
	
	public Material getMaterial() {
		return material;
	}



	public void setMaterial(Material material) {
		this.material = material;
	}



	public byte getData() {
		return data;
	}



	public void setData(byte data) {
		this.data = data;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public List<Enchantment> getEnchs() {
		return enchs;
	}



	public void setEnchs(List<Enchantment> enchs) {
		this.enchs = enchs;
	}



	public List<Integer> getLevels() {
		return levels;
	}



	public void setLevels(List<Integer> levels) {
		this.levels = levels;
	}



	public Set<ItemFlag> getFlags() {
		return flags;
	}



	public void setFlags(Set<ItemFlag> flags) {
		this.flags = flags;
	}



	public List<String> getLores() {
		return lores;
	}



	public void setLores(List<String> lores) {
		this.lores = lores;
	}



	public boolean isUnbreakable() {
		return unbreakable;
	}



	public void setUnbreakable(boolean unbreakable) {
		this.unbreakable = unbreakable;
	}



	public ItemStack getItem(Material material, byte data, String name, int amount, List<Enchantment> enchs, List<Integer> levels, Set<ItemFlag> flags, List<String> lores) {
		ItemStack stack = new ItemStack(material, amount, data);
		
		ItemMeta meta = stack.getItemMeta();
		if(name != null) meta.setDisplayName(name);
		if (enchs != null && levels != null) {
			if (enchs.size() > 0 && levels.size() > 0) {
				for (int i = 0; i < enchs.size(); i++) {
					int level = levels.get(i);
					Enchantment enchantement = enchs.get(i);
					if (enchantement.getMaxLevel() > level) {
						stack.addUnsafeEnchantment(enchantement, level);
					} else {
						meta.addEnchant(enchantement, level, true);
					}
				}
			} 
		}
		if (flags != null) {
			if (flags.size() > 0) {
				flags.forEach(action -> {
					meta.addItemFlags(action);
				});
			} 
		}
		
		if(lores != null) {
			if(lores.size() > 0) {
				meta.setLore(lores);
			}
		}
		
		return stack;
	}

}
