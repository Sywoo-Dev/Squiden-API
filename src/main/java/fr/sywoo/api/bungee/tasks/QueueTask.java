package fr.sywoo.api.bungee.tasks;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import fr.sywoo.api.bungee.LionBungee;
import fr.sywoo.api.queue.Queue;
import fr.sywoo.api.serverdata.ServerStatus;
import fr.sywoo.api.serverdata.ServersData;
import fr.sywoo.api.serverdata.uhc.UHCData;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class QueueTask {

	public void launch() {
		LionBungee.get().getProxy().getScheduler().schedule(LionBungee.get(), new Runnable() {

			@Override
			public void run() {

				for(Queue queues : LionBungee.get().getQueues().values()){
					if(queues.getPlayers().size() > 0) {

						for(String uuid : queues.getPlayers()){
							ProxiedPlayer player = LionBungee.get().getProxy().getPlayer(UUID.fromString(uuid.replaceFirst(uuid.charAt(0)+"", "")));
							if(player != null) {
								player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aFile d'attente : §e" + queues.getPosition(uuid) + "§a/§e" + queues.getPlayers().size()));
							}
						}

						String uuid = (String) queues.getPlayers().toArray()[0];
						ProxiedPlayer player = LionBungee.get().getProxy().getPlayer(UUID.fromString(uuid.replaceFirst(uuid.charAt(0)+"", "")));
						if(player == null){
							queues.getPlayers().remove(null);
							queues.getPlayers().remove(uuid);
							continue;
						}

						if (queues.getGroup() != null) {
							int free = 0;
							for (String str : LionBungee.get().getServerManager().getServerGroup(queues.getGroup())) {
								ServersData data = LionBungee.get().getServerDataManager().get(str);
								if(data == null) {
									data = new ServersData("Squiden", str, ServerStatus.WAITING, queues.getGroup());
									LionBungee.get().getServerDataManager().create(data);
								}
								if (data.getServerStatus() == ServerStatus.WAITING) {
									free++;
									queues.setServersData(data);
									if(data.canJoin()) {
										queues.removePlayer(player.getUniqueId());
										player.sendMessage(new TextComponent("§aVous aller rejoindre §e" + str));
										player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aEnvoie en cours !"));
										player.connect(ProxyServer.getInstance().getServerInfo(data.getName()));
									}
									break;
								}
							}
							if(free == 0) {
								String name = LionBungee.get().getServerManager().createAndGetServerName(queues.getGroup());
								LionBungee.get().getServerDataManager().create(new ServersData("Squiden", name, ServerStatus.WAITING, queues.getGroup()));
							}
						}
						
						if(!queues.getGroup().contains("UHC")) continue;
						if(queues.getServersData() == null) continue;
						ServersData serverData = queues.getServersData();		
						UHCData data = serverData.getUhcData();
						if(data == null) continue;
						System.out.println("Queue: " + queues.getGame()  + " " + data.isWhitelist());
						if(data.isWhitelist()) {
							if(LionBungee.get().getAccountManager().get(player.getUniqueId()).getRank().hasPermission("moderation.tool")
									|| LionBungee.get().getAccountManager().get(player.getUniqueId()).getRank().hasPermission("queue.priority")
									|| serverData.getOwner().equalsIgnoreCase(player.getName())
									|| data.getWhitelisted().contains(player.getUniqueId())){

								queues.removePlayer(player.getUniqueId());					
								player.sendMessage(new TextComponent("§7§m-----------------------------------------------------"));
								player.sendMessage(new TextComponent("§aVotre serveur est lancé !"));
								player.sendMessage(new TextComponent("§bTéléportation..."));
								player.sendMessage(new TextComponent("§cPassage outre de la file d'attente"));
								player.sendMessage(new TextComponent("§7§m-----------------------------------------------------"));
								player.connect(ProxyServer.getInstance().getServerInfo(queues.getServersData().getName()));
							}
						} else {
							queues.removePlayer(player.getUniqueId());
							player.sendMessage(new TextComponent("§7§m-----------------------------------------------------"));
							player.sendMessage(new TextComponent("§aVotre serveur s'est lancé !"));
							player.sendMessage(new TextComponent("§bTéléportation..."));
							player.sendMessage(new TextComponent("§7§m-----------------------------------------------------"));
							player.connect(ProxyServer.getInstance().getServerInfo(queues.getServersData().getName()));
						}
					}
				}

			}
		}, 1, 1, TimeUnit.SECONDS);
	}

}
