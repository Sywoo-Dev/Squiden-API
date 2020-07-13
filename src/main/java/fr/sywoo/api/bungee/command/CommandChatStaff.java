package fr.sywoo.api.bungee.command;

import fr.sywoo.api.bungee.LionBungee;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.HoverEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandChatStaff extends Command {

    public CommandChatStaff(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (sender instanceof ProxiedPlayer) {

            ProxiedPlayer player = (ProxiedPlayer) sender;

            if (LionBungee.get().getAccountManager().get(player.getUniqueId()).getRank().hasPermission("lionuhc.chatstaff")) {
                for (ProxiedPlayer proxieds : LionBungee.get().getProxy().getPlayers()) {
                    if (LionBungee.get().getAccountManager().get(proxieds.getUniqueId()).getRank().hasPermission("lionuhc.chatstaff")) {

                        String msg = "";

                        for (int i = 0; i < args.length; i++) {
                            msg += args[i] + " ";
                        }

                        BaseComponent component = new TextComponent(
                                "§a[Canal Staff] §3" + player.getName() + " §e" + msg);
                        component.setHoverEvent(new HoverEvent(Action.SHOW_TEXT,
                                new ComponentBuilder("§a/staff pour parler dans le canal staff").create()));
                        component.setClickEvent(
                                new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, "/staff"));

                        proxieds.sendMessage(component);
                    }
                }
            }

        }

    }

}
