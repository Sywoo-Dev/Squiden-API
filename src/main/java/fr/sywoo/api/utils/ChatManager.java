package fr.sywoo.api.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.sywoo.api.account.AccountData;
import fr.sywoo.api.guilds.Guilds;
import fr.sywoo.api.sanction.MuteData;
import fr.sywoo.api.settings.Settings.SettingsEnum;
import fr.sywoo.api.spigot.LionSpigot;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ChatManager {

	private boolean chat, team, guildTag, useColor;
	private ArrayList<HashMap<List<UUID>, String>> teams;

	public ChatManager(ArrayList<HashMap<List<UUID>, String>> teams, boolean guildTag, boolean useColor) {
		this.team = true;
		this.chat = true;
		this.teams = teams;
		this.guildTag = guildTag;
		this.useColor = useColor;
	}

	public ChatManager(boolean guildTag, boolean useColor) {
		this.chat = true;
		this.team = false;
		teams = null;
		this.guildTag = guildTag;
		this.useColor = useColor;
	}

	public void sendMessage(Player player, String prefix, String message) {
		if (LionSpigot.get().getModifyChat().contains(player.getUniqueId())) {
			return;
		}
		AccountData account = LionSpigot.get().getAccountManager().get(player.getUniqueId());
		if (account.getMuteData() != null) {
			MuteData mute = LionSpigot.get().getAccountManager().get(player.getUniqueId()).getMuteData();
			if (mute.getDuration().after(new Date())) {
				player.sendMessage("§c§lModération §f»§r §cVous êtes mute pendant: §e"
						+ new FormatTime(mute.getDuration()).toFormatString() + "§c Pour: §e" + mute.getReason()
						+ " §cPar: §e" + mute.getAuthor());
				return;
			} else {
				LionSpigot.get().getAccountManager().update(account.setMuteData(null));
			}
		}
		if (guildTag) {
			Guilds guild = LionSpigot.get().getGuildsManager().get(account.getGuildsName());
			if (guild != null) {
				prefix = ChatColor.translateAlternateColorCodes('&', guild.getPrefix()) + "§r " + prefix;
			}
		}

		if (Bukkit.getServerName().contains("UHC-")) {
			if (LionSpigot.get().getServerDataManager().get(Bukkit.getServerName()).getOwner()
					.equalsIgnoreCase(account.getName())) {
				prefix = "§c[Host] §f" + player.getName();
			}
		}

		if (team && !message.startsWith("!") && teams != null) {
			boolean sended = false;
			for (GameTeams teams : LionSpigot.get().getTeams()) {
				if (teams.getPlayers().contains(player.getUniqueId())) {
					for (UUID uuids : teams.getPlayers()) {
						Player targets = Bukkit.getPlayer(uuids);
						if (targets != null) {
							targets.sendMessage(prefix + "§f (Team) §f» " + message);
							sended = true;
						}
					}
				}
			}
			if (!sended) {
				Bukkit.broadcastMessage("§8§lSpec » §7" + message);
			}
		} else {
			if (message.startsWith("!") && team) {
				message = message.replaceFirst("!", "");
				prefix += " §f(Global) ";
			}

			for (Player players : Bukkit.getOnlinePlayers()) {
				if(Bukkit.getServerName().contains("Lobby")) {
					if(LionSpigot.get().getAccountManager().get(players.getUniqueId()).getSettings().getSeeChat() == SettingsEnum.DISALLOW) {
						continue;
					}
					if(LionSpigot.get().getAccountManager().get(players.getUniqueId()).getSettings().getSeeChat() == SettingsEnum.FRIENDS) {
						if(!LionSpigot.get().getAccountManager().get(players.getUniqueId()).getFriends().contains(player.getUniqueId())) {
							continue;
						}
					}
				}
				players.spigot().sendMessage(getMessage(player, players, account, prefix, message));
			}

		}

	}
	
	private TextComponent getMessage(Player player, Player to, AccountData account, String prefix, String message) {
		TextComponent component = new TextComponent("");

		if (Bukkit.getServerName().contains("Lobby")) {
			String overtext = "§bSquids §f" + account.getSquids() + "\n" + "§cXp §f"
					+ new DecimalFormat("#0.00").format(account.getXpWon()) + "\n" + "§3Membre depuis §f"
					+ new SimpleDateFormat("MM-yyyy").format(account.getFirstConnection());

			if (player.getUniqueId().toString().equalsIgnoreCase("e6d249f5-b4cd-4ade-b9ca-5cf2f51891d0")) {
				overtext += "\n§cI'm CEO Bitch";
			}

			if (player.getUniqueId().toString().equalsIgnoreCase("b20aded9-d503-427f-aa65-17e047e700e5")) {
				overtext += "\n§cOui bah HE !";
			}
			
			if (player.getUniqueId().toString().equalsIgnoreCase("9f5da19a-640e-43ec-b733-860524352454")) {
				overtext += "\n§bJe suis fragile";
			}
			if (player.getUniqueId().toString().equalsIgnoreCase("1583546b-6ac4-4404-bd15-6a325815ef8b")) {
				overtext += "\n§dJ'aime les patates douces";
			}
			component.addExtra(new TextComponentBuilder("§e[*] ")
					.setHoverEvent(HoverEvent.Action.SHOW_TEXT, overtext).toText());
		}
		
		String tempMessage = message;
		
		if (message.contains(to.getName())) {
			new Title().sendActionBar(to, player.getName() + " §aVous à mentionné");
			to.playSound(to.getLocation(), Sound.NOTE_PLING, 20, 20);
			if (account.getRank().hasPermission("lionuhc.chat") || account.getRank().hasPermission("lionuhc.chat.color")) {
				tempMessage = message.replace(to.getName(), "§5§l" + to.getName() + "§f");
			} else {
				tempMessage = message.replace(to.getName(), "§5§l" + to.getName() + "§7");
			}

		}


		if (account.getRank().hasPermission("lionuhc.chat.color") && useColor) {
			component.addExtra(new TextComponentBuilder(
					prefix + " §f» " + ChatColor.translateAlternateColorCodes('&', tempMessage)).toText());
		} else if (account.getRank().hasPermission("lionuhc.chat")) {
			component.addExtra(new TextComponentBuilder(prefix + " §f» " + tempMessage).toText());
		} else {
			component.addExtra(new TextComponentBuilder(prefix + " §7» " + tempMessage).toText());
		}
		
		return component;
	}

	public boolean isChat() {
		return chat;
	}

	public void setChat(boolean chat) {
		this.chat = chat;
	}

	public boolean isTeam() {
		return team;
	}

	public void setTeam(boolean team) {
		this.team = team;
	}

	public ArrayList<HashMap<List<UUID>, String>> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<HashMap<List<UUID>, String>> teams) {
		this.teams = teams;
	}

	public void addModify(Player player) {
		LionSpigot.get().getModifyChat().add(player.getUniqueId());
	}

	public void removeModifiy(Player player) {
		LionSpigot.get().getModifyChat().remove(player.getUniqueId());
	}

	public boolean isGuildTag() {
		return guildTag;
	}

	public void setGuildTag(boolean guildTag) {
		this.guildTag = guildTag;
	}

	public boolean canUseColor() {
		return useColor;
	}

	public void setUseColor(boolean useColor) {
		this.useColor = useColor;
	}
}
