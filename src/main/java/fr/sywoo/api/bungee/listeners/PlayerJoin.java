package fr.sywoo.api.bungee.listeners;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.bungee.LionBungee;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PostLoginEvent event) {
		if(LionBungee.get().getAccountManager().get(event.getPlayer().getName().toLowerCase()) == null) return;
		if (!LionBungee.get().getAccountManager().get(event.getPlayer().getUniqueId()).getName().toLowerCase()
				.equalsIgnoreCase(event.getPlayer().getName())) {
			event.getPlayer().sendMessage(new TextComponent("§cDétéction du changement de pseudo...."));
			event.getPlayer().sendMessage(new TextComponent("§aChangement de pseudo éfféctué dans la base de donnée ! Bon jeux"));
			LionBungee.get().getAccountManager().update(LionBungee.get().getAccountManager()
					.get(event.getPlayer().getUniqueId()).setDisplayName(event.getPlayer().getName()));
			LionBungee.get().getAccountManager().update(LionBungee.get().getAccountManager()
					.get(event.getPlayer().getUniqueId()).setName(event.getPlayer().getName().toLowerCase()));
		}

		AccountData data = LionBungee.get().getAccountManager().get(event.getPlayer().getUniqueId());
		LionBungee.get().getAccountManager().update(data.setConnected(true));
		if (LionBungee.get().getAccountManager().get(event.getPlayer().getUniqueId()).getRank().getColor() == null) {
			data.getRank().setColor("§7");
			LionBungee.get().getAccountManager().update(data);
		}
	}
	
	@EventHandler
	public void onQuit(PlayerDisconnectEvent event) {
		AccountData data = LionBungee.get().getAccountManager().get(event.getPlayer().getUniqueId());
		LionBungee.get().getAccountManager().update(data.setConnected(false));
	}

}
