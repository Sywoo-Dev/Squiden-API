package fr.sywoo.api.servers;

import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.ext.bridge.BridgePlayerManager;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerServerManager {

    @SuppressWarnings("deprecation")
	public void sendPlayerToServer(Player player, String serverName){
        BridgePlayerManager.getInstance().proxySendPlayer(player.getUniqueId(), serverName);
    }

    @SuppressWarnings("deprecation")
	public void sendPlayerToServer(UUID uuid, String serverName){
        BridgePlayerManager.getInstance().proxySendPlayer(uuid, serverName);
    }

    @SuppressWarnings("deprecation")
	public void sendPlayerToServer(Player player, ServiceInfoSnapshot serviceInfoSnapshot){
        BridgePlayerManager.getInstance().proxySendPlayer(player.getUniqueId(), serviceInfoSnapshot.getServiceId().getName());
    }

}
