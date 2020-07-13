package fr.sywoo.api.bungee.command.messages;

import fr.sywoo.api.bungee.LionBungee;
import fr.sywoo.api.utils.TextComponentBuilder;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandResponse extends Command {

	public CommandResponse(String name) {
		super(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer){
			if(args.length >= 1){
				ProxiedPlayer player = (ProxiedPlayer) sender;
				ProxiedPlayer target = LionBungee.get().lastSpeaker.get(player);
				if(target != null) {
					StringBuilder builder = new StringBuilder();
					for(int i = 0; i < args.length; i++){
						builder.append(args[i] + " ");
					}
					player.sendMessage(new TextComponentBuilder("§f[§cMP§f] » §a Vous §f➦ §a" + target.getName() + " §f: §e" + builder.toString())
							.setHoverEvent(HoverEvent.Action.SHOW_TEXT, "§aClique ici pour répondre à " + target.getName())
							.setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/r ").toText());

					target.sendMessage(new TextComponentBuilder("§f[§cMP§f] » §a " + player.getName() + " §f➦ §aVous §f: §e" + builder.toString())
							.setHoverEvent(HoverEvent.Action.SHOW_TEXT, "§aClique ici pour répondre à " + player.getName())
							.setClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/r ").toText());

					LionBungee.get().lastSpeaker.put(player, target);
					LionBungee.get().lastSpeaker.put(target, player);

				} else {
					sender.sendMessage("§cMerci d'utiliser /msg <player> pour entamer une discussion.");
				}
			} else {
				sender.sendMessage("§cUtilisation : /r <message>");
			}
		}
	}

}
