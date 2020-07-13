package fr.sywoo.api.spigot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.ext.bridge.BridgePlayerManager;
import de.dytanic.cloudnet.ext.bridge.ServiceInfoSnapshotUtil;
import fr.sywoo.api.account.AccountManager;
import fr.sywoo.api.arena.ArenaKitManager;
import fr.sywoo.api.arena.ArenaManager;
import fr.sywoo.api.games.GamePoint;
import fr.sywoo.api.games.PlayerRecap;
import fr.sywoo.api.guilds.GuildsManager;
import fr.sywoo.api.inventory.QuickInventoryManager;
import fr.sywoo.api.item.QuickItemManager;
import fr.sywoo.api.mongodb.MongoDB;
import fr.sywoo.api.reward.RewardManager;
import fr.sywoo.api.serverdata.ServerDataManager;
import fr.sywoo.api.servers.PlayerServerManager;
import fr.sywoo.api.servers.ServerManager;
import fr.sywoo.api.uhcconfig.ConfigManager;
import fr.sywoo.api.utils.GameTeams;

public class LionSpigot extends JavaPlugin {

	private AccountManager accountManager;
	private ServerDataManager serverDataManager;
	private static LionSpigot lionSpigot;
	private ServerManager serverManager;
	private PlayerServerManager playerServerManager;
	private ArenaManager arenaManager;
	private RewardManager rewardManager;
	private ArenaKitManager kitManager;
	private GuildsManager guilds;
	//private HashMap<String, Queue> queues = new HashMap<String, Queue>();
	private ConfigManager configManager;

	private ArrayList<UUID> modifyChat = new ArrayList<UUID>();
	private ArrayList<GameTeams> teams = new ArrayList<GameTeams>();
	
	private GamePoint gamePoint;
	private PlayerRecap recap;
	
	private String name, displayname;
	
	@Override
	public void onEnable() {
        MongoDB mongoDB = new MongoDB("G8q5FWpmjhUsq5h6uLvJLrx","mkYpDvYpjPqxZKWk9f8msPL", "51.75.240.11", "admin");
		rewardManager = new RewardManager(mongoDB);
		configManager = new ConfigManager(mongoDB);
		this.accountManager = new AccountManager(mongoDB);
		this.serverDataManager = new ServerDataManager(mongoDB);
		this.arenaManager = new ArenaManager(mongoDB);
		this.guilds = new GuildsManager(mongoDB);
		this.gamePoint = new GamePoint();
		this.kitManager = new ArenaKitManager(mongoDB);
		new QuickInventoryManager(this);
		new QuickItemManager(this);
		super.onEnable();
		serverManager = new ServerManager();
		playerServerManager = new PlayerServerManager();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        name = "play.squiden.fr";
        displayname = "Squiden";
	}

	public ConfigManager getConfigManager() {
		return configManager;
	}

//	public HashMap<String, Queue> getQueues() {
//		return queues;
//	}

	public RewardManager getRewardManager() {
		return rewardManager;
	}
	
	public void addPlayerInWaitingQueue(Player player, String group, boolean uhc) {
		sendPluginMessage(player, "wq", player.getUniqueId().toString(), group, String.valueOf(uhc));
	}
	
	public void addPlayerInWaitingQueue(Player player, String group) {
		sendPluginMessage(player, "wq", player.getUniqueId().toString(), group, String.valueOf(false));
	}

	public void broadcastLobby(Player player, String servername) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("announcement");
        out.writeUTF(servername);
        player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
	}
	
	public void sendPluginMessage(Player player, String... messages) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        for(String strs : messages) {
        	out.writeUTF(strs);
        }
        player.sendPluginMessage(this, "BungeeCord", out.toByteArray());
	}

	@SuppressWarnings("deprecation")
	public void fallback(List<Player> players){
		List<ServiceInfoSnapshot> serviceInfoSnapshotList = new ArrayList<>();
		CloudNetDriver.getInstance().getCloudServices().stream()
		.filter(serviceInfoSnapshot1 -> serviceInfoSnapshot1.getServiceId().getName().startsWith("Lobby-"))
		.forEach(serviceInfoSnapshot -> serviceInfoSnapshotList.add(serviceInfoSnapshot));
		ServiceInfoSnapshot service = serviceInfoSnapshotList.get(0);
		int i = 0;
		for(Player player : players){
			if(ServiceInfoSnapshotUtil.getPlayers(service).size() + 1 > ServiceInfoSnapshotUtil.getMaxPlayers(service)){
				i++;
				service = serviceInfoSnapshotList.get(i);
			}
			BridgePlayerManager.getInstance().proxySendPlayer(player.getUniqueId(), service.getServiceId().getName());
		}
	}

	@SuppressWarnings("deprecation")
	public void fallback(Player player){
		List<ServiceInfoSnapshot> serviceInfoSnapshotList = new ArrayList<>();
		CloudNetDriver.getInstance().getCloudServices().stream()
		.filter(serviceInfoSnapshot1 -> serviceInfoSnapshot1.getServiceId().getName().startsWith("Lobby-"))
		.forEach(serviceInfoSnapshot -> serviceInfoSnapshotList.add(serviceInfoSnapshot));
		ServiceInfoSnapshot service = serviceInfoSnapshotList.get(0);
		getPlayerServerManager().sendPlayerToServer(player, service);
	}

	@Override
	public void onLoad() {
		lionSpigot = this;
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public ArrayList<GameTeams> getTeams(){
		return teams;
	}
	
	public GameTeams getPlayerTeam(Player player) {
		GameTeams toReturn = null;
		for(GameTeams t : teams) {
			if(t.getPlayers().contains(player.getUniqueId())) {
				toReturn = t;
				break;
			}
		}
		return toReturn;
	}
	
	public GameTeams getTeam(String name) {
		GameTeams toReturn = null;
		for(GameTeams t : teams) {
			if(t.getName().equalsIgnoreCase(name)) {
				toReturn = t;
				break;
			}
		}
		return toReturn;
	}

	public ArenaManager getArenaManager() {
		return arenaManager;
	}
	public ArrayList<UUID> getModifyChat(){
		return modifyChat;
	}
	public AccountManager getAccountManager() { return accountManager; }
	public static LionSpigot get() { return lionSpigot; }
	public PlayerServerManager getPlayerServerManager() {
		return playerServerManager;
	}
	public ServerManager getServerManager() {
		return serverManager;
	}
	public ServerDataManager getServerDataManager() {
		return serverDataManager;
	}
	public GuildsManager getGuildsManager() {
		return guilds;
	}
	
	public ArenaKitManager getArenaKitManager() {
		return kitManager;
	}

	public GamePoint getGamePoint() {
		return gamePoint;
	}

	public PlayerRecap getRecap() {
		return recap;
	}
	
	public String getProjectName() {
		return name;
	}
	
	public String getProjectDisplayName() {
		return displayname;
	}
}
