package fr.sywoo.api.bungee.command;

import fr.sywoo.api.bungee.LionBungee;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandTeleport extends Command {

    public CommandTeleport(String name) {
        super(name);
    }

    @SuppressWarnings("deprecation")
	@Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(LionBungee.get().getAccountManager().get(player.getUniqueId()).getRank().hasPermission("lionuhc.proxyteleport")){
                if(args.length == 1){
                    ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                    if(target != null){
                        player.connect(target.getServer().getInfo());
                    } else {
                        player.sendMessage("§cMerci de préciser un joueur connecté !");
                    }
                } else {
                    sender.sendMessage("§cUtilisation : /ptp <player>");
                }
            }
        }
    }
}
