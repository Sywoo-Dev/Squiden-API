package fr.sywoo.api.bungee;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.sywoo.api.account.AccountManager;
import fr.sywoo.api.bungee.command.CommandChatStaff;
import fr.sywoo.api.bungee.command.CommandTeleport;
import fr.sywoo.api.bungee.command.messages.CommandMessage;
import fr.sywoo.api.bungee.command.messages.CommandResponse;
import fr.sywoo.api.bungee.listeners.MessageReceive;
import fr.sywoo.api.bungee.listeners.PlayerJoin;
import fr.sywoo.api.bungee.tasks.QueueTask;
import fr.sywoo.api.guilds.GuildsManager;
import fr.sywoo.api.mongodb.MongoDB;
import fr.sywoo.api.queue.Queue;
import fr.sywoo.api.serverdata.ServerDataManager;
import fr.sywoo.api.servers.ServerManager;
import fr.sywoo.api.socket.Connection;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class LionBungee extends Plugin {

    private ServerSocket serverSocket;
    public List<Socket> socketList = new ArrayList<>();
    private static LionBungee instance;
    private AccountManager accountManager;
	private ServerManager serverManager;
	private ServerDataManager serverDataManager;
	private GuildsManager guilds;
	private HashMap<String, Queue> queues = new HashMap<String, Queue>();

	public HashMap<String, Queue> getQueues() {
		return queues;
	}
	public HashMap<ProxiedPlayer, ProxiedPlayer> lastSpeaker = new HashMap<ProxiedPlayer, ProxiedPlayer>();

    @Override
    public void onEnable() {
        instance = this;
        MongoDB mongoDB = new MongoDB("G8q5FWpmjhUsq5h6uLvJLrx","mkYpDvYpjPqxZKWk9f8msPL", "51.75.240.11", "admin");
        accountManager = new AccountManager(mongoDB);
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandChatStaff("staff"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandTeleport("ptp"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandMessage("msg"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new CommandResponse("r"));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new PlayerJoin());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new MessageReceive());
        ProxyServer.getInstance().registerChannel("BungeeCord");
		serverManager = new ServerManager();
		this.serverDataManager = new ServerDataManager(mongoDB);
		guilds = new GuildsManager(mongoDB);
		
		new QueueTask().launch();
		
        try {
            serverSocket = new ServerSocket(165);
            System.out.println("Port de Socket : " + 165);
            Thread thread = new Thread(new Connection(serverSocket));
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }
    
    public ServerManager getServerManager() {
    	return serverManager;
    }

    @Override
    public void onDisable() {
    	serverDataManager.clear();
    }

    public static LionBungee get() {
        return instance;
    }
	public ServerDataManager getServerDataManager() {
		return serverDataManager;
	}

	public GuildsManager getGuilds() {
		return guilds;
	}
}
