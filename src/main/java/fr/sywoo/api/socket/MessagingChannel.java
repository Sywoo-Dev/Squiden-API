package fr.sywoo.api.socket;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import fr.sywoo.api.spigot.LionSpigot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.UUID;

public class MessagingChannel implements PluginMessageListener {

	public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
		ByteArrayDataInput input = ByteStreams.newDataInput(bytes);
		String subchannel = input.readUTF();
		System.out.println(subchannel);
		if (subchannel.equalsIgnoreCase("messages")) {
			for (Player players : Bukkit.getOnlinePlayers()) {
				players.sendMessage(input.readUTF());
			}
		}

		if (subchannel.equalsIgnoreCase("money")) {
			UUID uuid = UUID.fromString(input.readUTF());
			String name = input.readUTF();
			int money = Integer.valueOf(input.readUTF());
			System.out.println(uuid.toString());
			Player target = Bukkit.getPlayer(name);
			Bukkit.broadcastMessage(target.getDisplayName() + " §aViens d'acheter " + money + " Coins");
			LionSpigot.get().getAccountManager().get(target.getUniqueId()).addCoins(money);
		}

	}

}