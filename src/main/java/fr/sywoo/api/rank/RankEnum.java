package fr.sywoo.api.rank;

import java.util.ArrayList;
import java.util.List;

public enum RankEnum {

    ADMIN("Admin","Admin ", "0", -1, 500, 20, true, new String[]{"*"}, "§b"),
    
    RESPONSABLE("Responsable", "Resp ", "1", 5, 500, 20, true, 
    		new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.servers.start", "lionuhc.chatstaff", "moderation.tool",
                    "moderation.tool.ban", "moderation.tool.fly", "moderation.tool.freeze", "moderation.tool.kick", "moderation.tool.mute", "moderation.tool.tp",
                    "moderation.tool.vanish", "moderation.tool.verif", "lionuhc.proxyteleport", "gac.alerts", "lionuhc.rank", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§c"),
    
    DEVELOPPEUR("Developpeur", "Dev ", "2", 3, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.servers.start", "lionuhc.chatstaff", "gac.alerts", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§6"),
    
    COMMERCIAL("Commercial", "Com ", "2z", 3, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.servers.start", "lionuhc.chatstaff", "gac.alerts", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§e"),
    
    MODERATEUR("Moderateur", "Mod ", "3", 0, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.lobby.fly", "lionuhc.chatstaff", "moderation.tool", "moderation.tool.ban",
                    "moderation.tool.fly", "moderation.tool.freeze", "moderation.tool.kick", "moderation.tool.mute", "moderation.tool.tp",
                    "moderation.tool.vanish", "moderation.tool.verif", "lionuhc.proxyteleport", "lionuhc.servers.start", "gac.alerts", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§a"),
    
    MODERATEURT("Moderateur", "Mod-T ", "4", 0, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.lobby.fly", "lionuhc.chatstaff", "moderation.tool",
                    "moderation.tool.fly", "moderation.tool.freeze", "moderation.tool.kick", "moderation.tool.mute", "moderation.tool.tp", "gac.alerts",
                    "moderation.tool.vanish", "moderation.tool.verif", "lionuhc.proxyteleport", "lionuhc.servers.start", "gac.alerts", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§1"),
    
    HELPER("Helper", "Helper ", "5",  0, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.chatstaff", "moderation.tool.kick", "moderation.tool.mute",
            		"lionuhc.servers.start", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§3"),
    
    FAMOUS("Famous", "Famous ", "6",  -1,  100, 20, false,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.servers.start", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§5"),
    
    FRIEND("Friend", "Friend ", "7",  3, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.servers.start", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§d"),
    
    BUILDER("Builder", "Builder ", "8",  0, 100, 20, true,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "lionuhc.lobby.fly", "lionuhc.servers.start", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§2"),
    
    GRAPHISTE("Graph", "Graph ", "9", 0, 100, 20, true,
            new String[]{"lionuhc.chat.color", "lionuhc.chat", "lionuhc.lobby.fly", "lionuhc.servers.start", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§d"),
    
    LEGEND("Legend", "Legend ", "a", 5, 100, 20, false,
            new String[]{"lionuhc.chat", "lionuhc.chat.color", "full.access", "connect.broadcast", "hub.doublejump", "hub.join"}, "§b"),
    
    HERO("Hero", "Hero ", "b", 3, 50, 11, false,
            new String[]{"lionuhc.chat.color", "lionuhc.chat", "full.access", "hub.doublejump"}, "§5"),
    
    VIPPLUS("Vipp", "Vip+ ", "c", 1,  35, 7, false,
            new String[]{"lionuhc.chat", "full.access", "hub.doublejump"}, "§a"),
    
    VIP("Vip", "Vip ", "d", 1, 20, 5, false,
            new String[]{"lionuhc.chat", "hub.doublejump"}, "§e"),
    
    JOUEUR("Joueur", "", "e", 0, 10, 3, false, new String[]{""}, "§7");

    private String name, displayName, power;
    private int coinsPerMonths, freePets, kdaReset, friends, party;
    private String[] permissions;
    private boolean staff;
    private String color;

    RankEnum(String name, String displayName, String power, int kdaReset, int friends, int party, boolean staff, String[] permissions, String color){
        this.color = color;
        this.name = name;
        this.displayName = displayName;
        this.power = power;
        this.permissions = permissions;
        this.kdaReset = kdaReset;
        this.friends = friends;
        this.party = party;
    }

    public String getColor() {
        return color;
    }

    public RankEnum setColor(String color) {
        this.color = color;
        return this;
    }

    public boolean isStaff() {
        return staff;
    }

    public int getParty() {
        return party;
    }

    public int getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }

    public RankEnum setName(String name) {
        this.name = name;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public RankEnum setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getPower() {
        return power;
    }

    public RankEnum setPower(String power) {
        this.power = power;
        return this;
    }

    public int getCoinsPerMonths() {
        return coinsPerMonths;
    }

    public RankEnum setCoinsPerMonths(int coinsPerMonths) {
        this.coinsPerMonths = coinsPerMonths;
        return this;
    }

    public int getFreePets() {
        return freePets;
    }

    public RankEnum setFreePets(int freePets) {
        this.freePets = freePets;
        return this;
    }

    public int getKdaReset() {
        return kdaReset;
    }

    public RankEnum setKdaReset(int kdaReset) {
        this.kdaReset = kdaReset;
        return this;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public List<String> getAPermissions(){
        List<String> listPerm = new ArrayList<>();
        for(String perm : permissions){
            listPerm.add(perm);
        }
        return listPerm;
    }

    public RankEnum setPermissions(String[] permissions) {
        this.permissions = permissions;
        return this;
    }

    public static RankEnum getRankByName(String name){
        for(RankEnum rankEnum : values()){
            if(rankEnum.getName().equalsIgnoreCase(name)){
                return rankEnum;
            }
        }
        return null;
    }

}
