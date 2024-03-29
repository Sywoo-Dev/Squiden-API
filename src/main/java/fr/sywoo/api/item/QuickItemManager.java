package fr.sywoo.api.item;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class QuickItemManager {

    private static Map<String, Consumer<QuickEvent>> quickItem;
    private static Gson gson;

    public QuickItemManager(JavaPlugin javaPlugin) {
        gson = new Gson();
        quickItem = new HashMap<>();
        Bukkit.getServer().getPluginManager().registerEvents(new QuickListeners(this), javaPlugin);
    }

    @SuppressWarnings("deprecation")
	static void registerItem(ItemStack itemStack, Consumer<QuickEvent> consumer){
        quickItem.put(gson.toJson(new QuickItemData(itemStack.getType(), itemStack.getData().getData(), itemStack.getItemMeta())), consumer);
    }

    @SuppressWarnings("deprecation")
	Consumer<QuickEvent> getEventQuickItem(ItemStack itemStack){
        return quickItem.get(gson.toJson(new QuickItemData(itemStack.getType(), itemStack.getData().getData(), itemStack.getItemMeta())));
    }

}
