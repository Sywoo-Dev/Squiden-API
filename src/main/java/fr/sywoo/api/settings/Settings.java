package fr.sywoo.api.settings;

public class Settings {

    private SettingsEnum
            message = SettingsEnum.ALLOW,
            friend = SettingsEnum.ALLOW,
            party = SettingsEnum.ALLOW,
            seeChat = SettingsEnum.ALLOW,
            shopOptions = SettingsEnum.ALLOW,
            autoReconnect = SettingsEnum.ALLOW,
            seePlayers = SettingsEnum.ALLOW;

    public SettingsEnum getMessage() {
        return message;
    }

    public Settings setMessage(SettingsEnum message) {
        this.message = message;
        return this;
    }

    public SettingsEnum getFriend() {
        return friend;
    }

    public Settings setFriend(SettingsEnum friend) {
        this.friend = friend;
        return this;
    }
    
    public Settings setAutoRecconnect(SettingsEnum autoReconnect) {
    	this.autoReconnect = autoReconnect;
    	return this;
    }
    
    public SettingsEnum getAutoReconnect() {
    	return autoReconnect;
    }

    public SettingsEnum getParty() {
        return party;
    }

    public Settings setParty(SettingsEnum party) {
        this.party = party;
        return this;
    }

    public SettingsEnum getSeeChat() {
        return seeChat;
    }

    public Settings setSeeChat(SettingsEnum seeChat) {
        this.seeChat = seeChat;
        return this;
    }

    public SettingsEnum getShopOptions() {
        return shopOptions;
    }

    public Settings setShopOptions(SettingsEnum shopOptions) {
        this.shopOptions = shopOptions;
        return this;
    }
    
    public Settings setSeePlayers(SettingsEnum seePlayers) {
    	this.seePlayers = seePlayers;
    	return this;
    }
    
    public SettingsEnum getSeePlayers() {
    	return seePlayers;
    }

    public enum SettingsEnum{

        ALLOW("INK_SACK", "LIME","§aActivés"),
        FRIENDS("INK_SACK", "RED", "§6Seulement par les amis"),
        DISALLOW("INK_SACK", "ORANGE", "§cDésactivés");

        private String itemStack;
        private String dyeColor;
        private String name;

        SettingsEnum(String itemStack, String dyeColor, String name) {
            this.itemStack = itemStack;
            this.dyeColor = dyeColor;
            this.name = name;
        }

        public String getDyeColor() {
            return dyeColor;
        }

        public SettingsEnum setDyeColor(String dyeColor) {
            this.dyeColor = dyeColor;
            return this;
        }

        public String getItemStack() {
            return itemStack;
        }

        public SettingsEnum setItemStack(String itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public String getName() {
            return name;
        }

        public SettingsEnum setName(String name) {
            this.name = name;
            return this;
        }
    }

}
