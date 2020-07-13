package fr.sywoo.api.servers;

import java.util.ArrayList;
import java.util.List;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;

public class ServerManager {

	@SuppressWarnings("deprecation")
	public void createServer(String taskName){
		ServiceInfoSnapshot serviceInfoSnapshot = CloudNetDriver.getInstance().getCloudServiceFactory()
				.createCloudService(CloudNetDriver.getInstance().getServiceTask(taskName));
		CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).start();
	}

	@SuppressWarnings("deprecation")
	public ServiceInfoSnapshot createAndGetServer(String taskName){
		ServiceInfoSnapshot serviceInfoSnapshot = CloudNetDriver.getInstance().getCloudServiceFactory()
				.createCloudService(CloudNetDriver.getInstance().getServiceTask(taskName));
		CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).start();
		return serviceInfoSnapshot;
	}

	@SuppressWarnings("deprecation")
	public String createAndGetServerName(String taskName){
		ServiceInfoSnapshot serviceInfoSnapshot = CloudNetDriver.getInstance().getCloudServiceFactory()
				.createCloudService(CloudNetDriver.getInstance().getServiceTask(taskName));
		CloudNetDriver.getInstance().getCloudServiceProvider(serviceInfoSnapshot).start();
		return serviceInfoSnapshot.getServiceId().getName();
	}

	public boolean isExist(String name) {
		boolean exist = false;
		ServiceInfoSnapshot str = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName(name);
		if(str == null) {
			return false;
		}
		if(str.isConnected()) {
			exist = true;
		}
		return exist;
	}

	public void deleteServer(String serverName){
		CloudNetDriver.getInstance().getCloudServiceProvider(serverName).stop();
	}
	
	public List<String> getServerGroup(String group){
		List<String> lobbylist = new ArrayList<>();
		CloudNetDriver.getInstance().getCloudServiceProvider().getStartedCloudServices().stream()
		.filter(serviceInfoSnapshot -> serviceInfoSnapshot.getServiceId().getName().startsWith(group))
		.forEach(serviceInfoSnapshot ->  lobbylist.add(serviceInfoSnapshot.getServiceId().getName()));
		return lobbylist;
	}
	
	public List<String> getLobbysServers(){
		List<String> lobbylist = new ArrayList<>();
		CloudNetDriver.getInstance().getCloudServiceProvider().getStartedCloudServices().stream()
		.filter(serviceInfoSnapshot -> serviceInfoSnapshot.getServiceId().getName().startsWith("Lobby-"))
		.forEach(serviceInfoSnapshot ->  lobbylist.add(serviceInfoSnapshot.getServiceId().getName()));
		return lobbylist;
	}

}
