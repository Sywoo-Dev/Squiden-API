package fr.sywoo.api.account;

import java.util.UUID;

public class Requests {

	private UUID sender, target;
	private RequestType type;
	private String guildName;
	
	public Requests(RequestType type, UUID sender, UUID target) {
		this.type = type;
		this.sender = sender;
		this.target = target;
	}

	public Requests(RequestType type, UUID sender, UUID target, String guildName) {
		this.type = type;
		this.sender = sender;
		this.target = target;
		this.guildName = guildName;
	}
	
	public UUID getSender() {
		return sender;
	}

	public UUID getTarget() {
		return target;
	}

	public RequestType getType() {
		return type;
	}

	public String getGuildName() {
		return guildName;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

}
