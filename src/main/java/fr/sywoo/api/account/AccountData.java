package fr.sywoo.api.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import fr.sywoo.api.account.configs.HikabrainConfig;
import fr.sywoo.api.account.configs.KapturConfig;
import fr.sywoo.api.account.configs.SlasherConfig;
import fr.sywoo.api.account.particles.DeathParticle;
import fr.sywoo.api.account.particles.HubParticle;
import fr.sywoo.api.account.particles.KillParticle;
import fr.sywoo.api.guilds.Guilds;
import fr.sywoo.api.icon.Icon;
import fr.sywoo.api.jump.Jump;
import fr.sywoo.api.pets.Pets;
import fr.sywoo.api.rank.Rank;
import fr.sywoo.api.report.Report;
import fr.sywoo.api.reward.Reward;
import fr.sywoo.api.sanction.BanData;
import fr.sywoo.api.sanction.MuteData;
import fr.sywoo.api.settings.Settings;
import fr.sywoo.api.statistics.AOEStats;
import fr.sywoo.api.statistics.GolemRushStats;
import fr.sywoo.api.statistics.HikabrainStats;
import fr.sywoo.api.statistics.KapturStats;
import fr.sywoo.api.statistics.SkywarsStats;
import fr.sywoo.api.statistics.SlasherStats;
import fr.sywoo.api.statistics.UHCRunStats;

public class AccountData {

    private UUID uuid;
    private Rank rank;
    private int coins, squids;
    private Jump jump;
    private BanData banData;
    private MuteData muteData;
    
    private boolean vanished = false;
    private boolean moderation = false;
    private boolean connected = true;
    
    private List<Report> report = new ArrayList<>();
    private Set<UUID> friends = new HashSet<UUID>();
    private Set<Pets> buyPets = new HashSet<Pets>();
    private Set<Requests> requests = new HashSet<Requests>();
    private Set<UUID> banned_players = new HashSet<UUID>();
    private Set<Reward> playerReward;
    private Set<String> buyHubParticles = new HashSet<String>();
    private Set<String> buyKillParticles = new HashSet<String>();
    private Set<String> buyDeathParticle = new HashSet<String>();

    private Set<String> particleColors = new HashSet<String>();
    private Set<String> particleType = new HashSet<String>();

    private Icon icon;
    private Settings settings;
    private Pets actualPet;
    private String id, password, last_server, guild, guildrank, name, displayName;
    private double stars, xpWon;
    private boolean host, RGB;
    private Date hostExpire, firstConnection;
    
    private KapturStats kapturStats;
    private AOEStats aoeStats;
    private GolemRushStats golemStats;
    private HikabrainStats hikabrainStats;
    private UHCRunStats uhcRunStats;
    private SkywarsStats skywarsStats;
    private SlasherStats slasherStats;
    
    private HubParticle hubParticle;
    private KillParticle killParticle;
    private DeathParticle deathParticle;
    
    private HikabrainConfig hikaConfig;
    private SlasherConfig slasherConfig;
    private KapturConfig kapturConfig;
    
    public AccountData(UUID uuid, String name, Rank rank) {
        this.uuid = uuid;
        this.displayName = name;
        this.name = name.toLowerCase();
        this.rank = rank;
        this.coins = 0;
        this.jump = new Jump(-1);
        this.settings = new Settings();
        this.playerReward = new HashSet<Reward>();
        this.icon = new Icon("§r", "§r");
        this.last_server = null;
        this.stars = 0;
        this.guild = "Aucune";
        this.guildrank = "Aucun";
        this.xpWon = 0;
        this.squids = 0;
        this.firstConnection = new Date();
        host = false;
        hostExpire = new Date();
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        this.id = generatedString;
        
        this.kapturStats = new KapturStats();
        this.aoeStats = new AOEStats();
        this.golemStats = new GolemRushStats();
        this.hikabrainStats = new HikabrainStats();
        this.uhcRunStats = new UHCRunStats();
        this.skywarsStats = new SkywarsStats();
    }
    
    public AccountData setDeathParticle(DeathParticle particle) {
    	this.deathParticle = particle;
    	return this;
    }
    
    public DeathParticle getDeathParticle() {
    	return deathParticle;
    }
    
    public boolean isConnected() {
    	return connected;
    }
    
    public boolean hasGuildRequest(String guildName) {
    	for(Requests reqs : requests) {
    		if(reqs.getType() == RequestType.GUILDS) {
    			if(reqs.getGuildName().equalsIgnoreCase(guildName)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public AccountData setConnected(boolean connected) {
    	this.connected = connected;
    	return this;
    }
    
    public HikabrainConfig getHikaBrainConfig() {
    	if(hikaConfig == null) {
    		return new HikabrainConfig();
    	}
    	return hikaConfig;
    }
    
    public AccountData setKapturConfig(KapturConfig config) {
    	this.kapturConfig = config;
    	return this;
    }
    
    public KapturConfig getKapturConfig() {
    	if(kapturConfig == null) {
    		return new KapturConfig();
    	}
    	return kapturConfig;
    }
    
    public AccountData setSlasherConfig(SlasherConfig config) {
    	this.slasherConfig = config;
    	return this;
    }
    
    public SlasherConfig getSlasherConfig() {
    	if(slasherConfig == null) {
    		return new SlasherConfig();
    	}
    	return slasherConfig;
    }
    
    public AccountData setHikaBrainConfig(HikabrainConfig config) {
    	this.hikaConfig = config;
    	return this;
    }
    
    public KillParticle getKillParticle() {
    	return killParticle;
    }
    
    public AccountData setKillParticle(KillParticle particle) {
    	this.killParticle = particle;
    	return this;
    }
    
    public KapturStats getKapturStats() {
    	if(kapturStats == null) return new KapturStats();
    	return kapturStats;
    }
    
    public AccountData setKapturStats(KapturStats stats) {
    	this.kapturStats = stats;
    	return this;
    }
    
    public SlasherStats getSlasherStats() {
    	if(slasherStats == null) return new SlasherStats();
    	return slasherStats;
    }
    
    public AccountData setSkywarsStats(SlasherStats stats) {
    	this.slasherStats = stats;
    	return this;
    }
    
    public SkywarsStats getSkywarsStats() {
    	if(skywarsStats == null) return new SkywarsStats();
    	return skywarsStats;
    }
    
    public AccountData setSkywarsStats(SkywarsStats stats) {
    	this.skywarsStats = stats;
    	return this;
    }
    
    public HikabrainStats getHikabrainStats() {
    	if(hikabrainStats == null) return new HikabrainStats();
    	return hikabrainStats;
    }
    
    public AccountData setHikabrainStats(HikabrainStats stats) {
    	this.hikabrainStats = stats;
    	return this;
    }
    
    public GolemRushStats getGolemStats() {
    	if(golemStats == null) return new GolemRushStats();
    	return golemStats;
    }
    
    public AccountData setGolemStats(GolemRushStats stats) {
    	this.golemStats = stats;
    	return this;
    }
    
    public AOEStats getAoeStats() {
    	if(aoeStats == null) return new AOEStats();
    	return aoeStats;
    }
    
    public AccountData setAOEStats(AOEStats stats) {
    	this.aoeStats = stats;
    	return this;
    }


	public Date getFirstConnection() {
    	return firstConnection;
    }
    
    public HubParticle getHubParticle() {
		return hubParticle;
	}
    
	public AccountData setHubParticle(HubParticle hubParticle) {
		this.hubParticle = hubParticle;
		return this;
	}

	public Set<String> getParticleColors() {
		return particleColors;
	}

	public AccountData setParticleColors(Set<String> particleColors) {
		this.particleColors = particleColors;
		return this;
	}

	public Set<String> getParticleType() {
		return particleType;
	}

	public AccountData setParticleType(Set<String> particleType) {
		this.particleType = particleType;
		return this;
	}

	public boolean isRGB() {
		return RGB;
	}

	public AccountData setRGB(boolean rGB) {
		RGB = rGB;
		return this;
	}

	public AccountData addRequests(Requests request) {
    	if(requests == null) {
    		requests = new HashSet<Requests>();
    	}
    	requests.add(request);
    	return this;
    }
    
    public AccountData removeRequests(Requests request) {
    	requests.remove(request);
    	return this;
    }
    
    public AccountData setRequests(Set<Requests> requestes) {
    	this.requests = requestes;
    	return this;
    }
    
    public Set<Requests> getRequests(){
    	if(requests == null) {
    		requests = new HashSet<Requests>();
    		return this.requests;
    	}
    	return this.requests;
    }
    
    public AccountData setGuildRank(String rank) {
    	this.guildrank = rank;
    	return this;
    }
    
    public String getGuildRank() {
    	return guildrank;
    }
    
    public AccountData setGuild(Guilds guilds) {
    	if(guilds == null) {
    		this.guild = "Aucune";
    		return this;
    	}
    	this.guild = guilds.getName();
    	return this;
    }
    
    public AccountData addXP(double xp) {
    	this.xpWon += xp;
    	return this;
    }
    
    public String getGuildsName() {
    	return this.guild;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getSquids() {
    	return this.squids;
    }

    public AccountData setSquids(int shishi) {
    	this.squids = shishi;
    	return this;
    }
    
    public AccountData addSquids(int shishi) {
    	this.squids += shishi;
    	return this;
    }
    
    public AccountData removeSquids(int shishi) {
    	this.squids -= shishi;
    	return this;
    }
    
    public AccountData setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getId() {
        return id;
    }

    public Set<UUID> getBannedPlayers() {
        return banned_players;
    }

    public AccountData addBannedPlayers(UUID uuid){
        this.banned_players.add(uuid);
        return this;
    }

    public AccountData removeBannedPlayers(UUID uuid){
        this.banned_players.remove(uuid);
        return this;
    }

    public AccountData clearBannedPlayers(){
        this.banned_players.clear();
        return this;
    }

    public Pets getActualPet(){
        return actualPet;
    }

    public AccountData setActualPets(Pets pets){
        this.actualPet = pets;
        return this;
    }

    public void checkBuyPets(){
        if(buyPets == null){
            buyPets = new HashSet<Pets>();
        }
    }

    public Set<Pets> getBuyPets() {
        checkBuyPets();
        return buyPets;
    }

    public AccountData addBuyPets(Pets pets){
        checkBuyPets();
        this.buyPets.add(pets);
        return this;
    }

    public AccountData removeBuyPets(Pets pets){
        checkBuyPets();
        this.buyPets.remove(pets);
        return this;
    }

    public AccountData clearBuyPets(){
        checkBuyPets();
        this.buyPets.clear();
        return this;
    }

    public Settings getSettings() {
        if(settings == null) setSettings(new Settings());
        return settings;
    }

    public AccountData setSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    public Set<Reward> getPlayerReward() {
        if(playerReward == null){
            return new HashSet<Reward>();
        }
        return playerReward;
    }

    public Reward getReward(String name){
        for(Reward reward : playerReward){
            if(reward.getRewardName().equalsIgnoreCase(name)){
                return reward;
            }
        }
        return null;
    }

    public AccountData setPlayerReward(Set<Reward> playerReward) {
        this.playerReward = playerReward;
        return this;
    }

    public AccountData addPlayerReward(Reward reward){
        this.playerReward.add(reward);
        return this;
    }

    public AccountData removePlayerReward(Reward reward){
        this.playerReward.remove(reward);
        return this;
    }

    public String getPrefix(){
    	if(icon.getCurrentIcon() == null) return rank.getColor() + rank.getDisplayName() + icon.getCurrentColor();
        if(!(icon.getCurrentIcon().equalsIgnoreCase("§r"))){
            return rank.getColor() + rank.getDisplayName() + icon.getCurrentColor() + icon.getCurrentIcon() + rank.getColor() + " ";
        }
        return rank.getColor() + rank.getDisplayName();
    }

    public Icon getIcon() {
        if(icon == null){ icon = new Icon("§r", "§r"); }
        return icon;
    }

    public AccountData setIcon(Icon icon) {
        this.icon = icon;
        return this;
    }

    public boolean isModeration() {
        return moderation;
    }

    public AccountData setModeration(boolean moderation) {
        this.moderation = moderation;
        return this;
    }

    public void checkReport(){
        if(report == null){
            report = new ArrayList<>();
        }
    }

    public void checkFriends(){
        if(friends == null){
            friends = new HashSet<UUID>();
        }
    }

    public Set<UUID> getFriends() {
        checkFriends();
        return friends;
    }

    public List<Report> getReport() {
        checkReport();
        return report;
    }

    public AccountData addFriend(UUID uuid){
        checkFriends();
        this.friends.add(uuid);
        return this;
    }

    public AccountData addReport(Report report){
        checkReport();
        this.report.add(report);
        return this;
    }

    public AccountData removeFriend(UUID uuid){
        checkFriends();
        this.friends.remove(uuid);
        return this;
    }

    public AccountData clearReport(){
        checkReport();
        this.report.clear();
        return this;
    }

    public AccountData clearFriends(){
        this.friends.clear();
        return this;
    }

    public MuteData getMuteData() {
        return muteData;
    }

    public AccountData setMuteData(MuteData muteData) {
        this.muteData = muteData;
        return this;
    }

    public AccountData setVanished(boolean vanished) {
        this.vanished = vanished;
        return this;
    }

    public boolean isVanished() {
        return vanished;
    }

    public BanData getBanData() {
        return banData;
    }

    public AccountData setBanData(BanData banData) {
        this.banData = banData;
        return this;
    }

    public Jump getJump() {
        if(jump == null){
            jump = new Jump(-1);
        }
        return jump;
    }

    public AccountData setJump(Jump jump) {
        this.jump = jump;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccountData setName(String name) {
        this.name = name;
        return this;
    }

    public UUID getUUID() { return uuid; }

    public Rank getRank() { return rank; }
    public AccountData setRank(Rank rank) { this.rank = rank;return this; }

    public int getCoins() { return coins; }
    public AccountData setCoins(int coins) { this.coins = coins;return this; }
    public AccountData addCoins(int coins){ setCoins(getCoins() + coins); return this; }
    public AccountData removeCoins(int coins){ setCoins(getCoins() - coins); return this; }

	public String getLastServer() {
		return last_server;
	}

	public AccountData setLastServer(String last_server) {
		this.last_server = last_server;
		return this;
	}

	public double getStars() {
		return stars;
	}

	public AccountData setStars(double stars) {
		this.stars = stars;
		return this;
	}

	public double getXpWon() {
		return xpWon;
	}

	public boolean isHost() {
		return host;
	}

	public AccountData setHost(boolean host) {
		this.host = host;
		return this;
	}

	public Date getHostExpire() {
		return hostExpire;
	}

	public AccountData setHostExpire(Date hostExpire) {
		this.hostExpire = hostExpire;
		return this;
	}
	
	public AccountData addHubParticle(String particle) {
		this.buyHubParticles.add(particle);
		return this;
	}
	
	public AccountData removeHubParticle(String particle) {
		this.buyHubParticles.remove(particle);
		return this;
	}
	
	public Set<String> getHubParticles(){
		return this.buyHubParticles;
	}
	
	public AccountData addKillParticle(String particle) {
		this.buyKillParticles.add(particle);
		return this;
	}
	
	public AccountData removeKillParticle(String particle) {
		this.buyKillParticles.remove(particle);
		return this;
	}
	
	public Set<String> getKillParticles(){
		return this.buyKillParticles;
	}
	
	public AccountData addDeathParticle(String particle) {
		this.buyDeathParticle.add(particle);
		return this;
	}
	
	public AccountData removeDeathParticle(String particle) {
		this.buyDeathParticle.remove(particle);
		return this;
	}
	
	public Set<String> getDeathParticles(){
		return this.buyDeathParticle;
	}

	public UHCRunStats getUhcRunStats() {
		if(uhcRunStats == null) return new UHCRunStats();
		return uhcRunStats;
	}

	public AccountData setUhcRunStats(UHCRunStats uhcRunStats) {
		this.uhcRunStats = uhcRunStats;
		return this;
	}

	public String getDisplayName() {
		return displayName;
	}

	public AccountData setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}

}