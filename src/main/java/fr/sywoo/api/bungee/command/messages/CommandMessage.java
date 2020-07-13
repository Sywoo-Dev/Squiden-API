package fr.sywoo.api.bungee.command.messages;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.bungee.LionBungee;
import fr.sywoo.api.settings.Settings.SettingsEnum;
import fr.sywoo.api.utils.TextComponentBuilder;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandMessage extends Command {

    public CommandMessage(String name) {
        super(name);
    }

    @SuppressWarnings("deprecation")
	@Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            if(args.length >= 2){
                if(ProxyServer.getInstance().getPlayer(args[0]) != null){
                    ProxiedPlayer player = (ProxiedPlayer) sender;
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                    
                    AccountData data = LionBungee.get().getAccountManager().get(target.getUniqueId());
                    if(data.getSettings().getMessage() == SettingsEnum.DISALLOW) {
                    	player.sendMessage(new TextComponent("§cCe joueur n'accepte pas les messages privés."));
                    	return;
                    }
                    
                    if(data.getSettings().getMessage() == SettingsEnum.FRIENDS) {
                    	if(!data.getFriends().contains(player.getUniqueId())) {
                    		player.sendMessage(new TextComponent("§cCe joueur accepte seulement les messages privés de ses amis."));
                    		return;
                    	}
                    }
                    StringBuilder builder = new StringBuilder();
                    for(int i = 1; i < args.length; i++){
                        builder.append(args[i] + " ");
                    }
                    player.sendMessage(new TextComponentBuilder("§f[§cMP§f] » §a Vous §f➦ §a" + target.getName() + " §f: §e" + builder.toString())
                            .setHoverEvent(HoverEvent.Action.SHOW_TEXT, "§aClique ici pour répondre à " + target.getName())
                            .setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + target.getName() + " ").toText());
                    
                    target.sendMessage(new TextComponentBuilder("§f[§cMP§f] » §a " + player.getName() + " §f➦§a Vous §f: §e" + builder.toString())
                            .setHoverEvent(HoverEvent.Action.SHOW_TEXT, "§aClique ici pour répondre à " + player.getName())
                            .setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + player.getName() + " ").toText());
                    
                    LionBungee.get().lastSpeaker.put(player, target);
                    LionBungee.get().lastSpeaker.put(target, player);
                    
                } else {
                    sender.sendMessage("§cCe joueur n'existe pas");
                }
            } else {
                sender.sendMessage("§cUtilisation : /msg <player>");
            }
        }
    }
}
