package fr.sywoo.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.spigot.LionSpigot;

public class TabManager {

    public void reloadTab(){
        for(Player player : Bukkit.getOnlinePlayers()){
        	
            AccountData accountData = LionSpigot.get().getAccountManager().get(player.getUniqueId());
            if(accountData == null) continue;
            String nickname = LionSpigot.get().getAccountManager().get(player.getUniqueId()).getPrefix();
            String teamname = LionSpigot.get().getAccountManager().get(player.getUniqueId()).getRank().getPower() + player.getName().charAt(0) + player.getName().charAt(1) + + player.getName().charAt(2);

            if(nickname.length() > 16){
                nickname = nickname.substring(nickname.length()-2, nickname.length());
            }
            
            if(accountData.getRank().hasPermission("*")){
                TeamsTagsManager.setNameTag(player, teamname, nickname, " §a✔");
            }else if(accountData.isHost()){
                TeamsTagsManager.setNameTag(player, teamname, nickname, " §e✯");
            }else {
                TeamsTagsManager.setNameTag(player, teamname, nickname, "");
            }
        }
    }

}
