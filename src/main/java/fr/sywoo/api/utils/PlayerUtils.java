package fr.sywoo.api.utils;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import fr.sywoo.api.spigot.LionSpigot;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class PlayerUtils {
	
	public static void respawnToSpectate(Player player) {
		respawnPacket(player);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				player.setGameMode(GameMode.SPECTATOR);
			}
		}.runTaskLaterAsynchronously(LionSpigot.get(), 5L);
	}
	
	public static void respawnAndTeleport(Player player, Location to) {
		respawnPacket(player);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				player.teleport(to);
			}
		}.runTaskLaterAsynchronously(LionSpigot.get(), 5L);
	}
	
	public static void respawnPacket(Player entity) {
        new BukkitRunnable() {
            
            @Override
            public void run() {
                PacketPlayInClientCommand cmd = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
                ((CraftPlayer) entity).getHandle().playerConnection.a(cmd);
                entity.setSprinting(true);
            }
        }.runTaskLater(LionSpigot.get(), 3L);
    }
	
	public static void respawnWithDelay(Player player, Location to, int delay, GameMode gm) {
		respawnPacket(player);
		new Title().sendTitle(player, 5, delay*20-10, 5, "§a§lRespawn dans", delay + " secondes");
		new BukkitRunnable() {
			
			@Override
			public void run() {
				player.setGameMode(GameMode.SPECTATOR);
			}
		}.runTaskLaterAsynchronously(LionSpigot.get(), 5L);
		new BukkitRunnable() {
			
			@Override
			public void run() {
				player.teleport(to);
				player.setGameMode(gm);
			}
		}.runTaskLaterAsynchronously(LionSpigot.get(), delay*20);
	}
	
	public static void reset(Player player) {
		player.getInventory().clear();
		player.updateInventory();
		player.setGameMode(GameMode.SURVIVAL);
		player.setWalkSpeed((float) 0.2);
		player.setFlying(false);
		player.setAllowFlight(false);
		player.resetMaxHealth();
		player.setHealth(player.getMaxHealth());
		for(PotionEffect effects : player.getActivePotionEffects()) {
			player.removePotionEffect(effects.getType());
		}
	}

}
