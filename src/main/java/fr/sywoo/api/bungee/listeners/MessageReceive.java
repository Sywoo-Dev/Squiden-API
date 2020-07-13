package fr.sywoo.api.bungee.listeners;

import java.util.UUID;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.bungee.LionBungee;
import fr.sywoo.api.guilds.Guilds;
import fr.sywoo.api.queue.Queue;
import fr.sywoo.api.serverdata.ServerStatus;
import fr.sywoo.api.serverdata.ServersData;
import fr.sywoo.api.utils.TextComponentBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MessageReceive implements Listener {

	@EventHandler
	public void onMessage(PluginMessageEvent event) {
		System.out.println(event.getTag());
		if (event.getTag().equals("BungeeCord")) {
			ByteArrayDataInput input = ByteStreams.newDataInput(event.getData());
			String subchannel = input.readUTF();
			System.out.println(subchannel);
			if (subchannel.equalsIgnoreCase("announcement")) {
				ByteArrayDataInput in = ByteStreams.newDataInput(event.getData());
				in.readUTF();
				String servername = in.readUTF();
				System.out.println("ServerName = " + servername);
				if (LionBungee.get().getServerManager().isExist(servername)) {
					ServersData data = LionBungee.get().getServerDataManager().get(servername);
					AccountData owner = LionBungee.get().getAccountManager().get(data.getOwner());
					for (ProxiedPlayer players : LionBungee.get().getProxy().getPlayers()) {
						TextComponent message = new TextComponent(
								owner.getPrefix() + owner.getName() + "§a A lancé son Host !");
						TextComponent join = new TextComponent("§f§l[§eRejoindre ➠ §f§l]");
						join.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/join " + servername));
						message.addExtra(join);

						if (players.getServer().getInfo().getName().contains("Arena")
								|| players.getServer().getInfo().getName().contains("Lobby")) {
							players.sendMessage(message);
						}
					}
				}
			}

			if (subchannel.equalsIgnoreCase("wq")) {
				UUID uuid = UUID.fromString(input.readUTF());
				String game = input.readUTF();

				if (Queue.getPlayerQueue(uuid) != null) {
					Queue.getPlayerQueue(uuid).removePlayer(uuid);
				}

				if (LionBungee.get().getServerManager().getServerGroup(game).size() == 0) {
					String name = LionBungee.get().getServerManager().createAndGetServerName(game);
					LionBungee.get().getServerDataManager()
					.create(new ServersData("Squiden", name, ServerStatus.WAITING, game));
					LionBungee.get().getProxy().getPlayer(uuid)
					.sendMessage(new TextComponent("§a§lUn serveur est en cours de lancement !"));
				}
				if (!Queue.existFor(game)) {
					new Queue(game);
				}
				AccountData data = LionBungee.get().getAccountManager().get(uuid);
				Queue.getByName(game).addPlayer(data.getRank().getPower() + uuid);
			}
			
			
			

			if (subchannel.equalsIgnoreCase("friends")) {
				String name = input.readUTF();
				String sender = input.readUTF();
				ProxiedPlayer player = LionBungee.get().getProxy().getPlayer(name);
				if (player != null) {
					player.sendMessage(ChatMessageType.ACTION_BAR,
							new TextComponent("§aVous avez une demande d'ami !"));

					TextComponent component = new TextComponent(sender + " §aVous à envoyé une demande d'ami ");
					component.addExtra(new TextComponentBuilder("§c[Refuser] ")
							.setClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends denied " + sender).toText());
					component.addExtra(new TextComponentBuilder("§a[Accepter]")
							.setClickEvent(ClickEvent.Action.RUN_COMMAND, "/friends accept " + sender).toText());

					player.sendMessage(component);
				}
			}

			if (subchannel.equalsIgnoreCase("guilds")) {
				String name = input.readUTF();
				String guilds = input.readUTF();
				ProxiedPlayer player = LionBungee.get().getProxy().getPlayer(name);
				if (player != null) {
					player.sendMessage(ChatMessageType.ACTION_BAR,
							new TextComponent("§aVous avez été invité dans une guilde "));

					TextComponent component = new TextComponent(
							"§aVous avez été invité dans la guilde §e" + guilds + " ");
					component.addExtra(new TextComponentBuilder("§c[Refuser] ")
							.setClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild denied " + guilds).toText());
					component.addExtra(new TextComponentBuilder("§a[Accepter]")
							.setClickEvent(ClickEvent.Action.RUN_COMMAND, "/guild join " + guilds).toText());

					player.sendMessage(component);
				}
			}

			if (subchannel.equalsIgnoreCase("guildchat")) {
				String name = input.readUTF();
				String sender = input.readUTF();
				Guilds guild = LionBungee.get().getGuilds().get(name);
				if (guild == null)
					return;
				String message = input.readUTF();
				message = message.replace("§", " ");
				for (String names : guild.getPlayersName()) {
					System.out.println("sended");
					ProxiedPlayer player = LionBungee.get().getProxy().getPlayer(names);
					if (player == null)
						continue;
					player.sendMessage(new TextComponent("§6§l[Guilde] §e" + sender + " §f: " + message));
				}
			}

		}
	}
}
