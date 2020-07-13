package fr.sywoo.api.uhcconfig;

import java.util.ArrayList;
import java.util.List;

import fr.sywoo.api.item.ApiItem;

public class UHCConfig {

    private int netheribus, netheribus_damage, skyhight, skyhight_limit, skyhight_damage, blood_diamond_damage, blood_gold_damage, pvptime, killshrink, bow_swap, time_bomb;
    private int weakness_link, longshot_distance, master_apple, ultra_apple, blitz, master_level, nosneak, toxicfood, best_pve_time;
    private int vanilla_plus, soup_heal, diamond_limit, notower, keepclean, battleroyal_structures, battleroyal_distance, final_border, time_to_final_border, bordermove, max_player, start_border, erratic_pvp;
    private int barebone_diamonds, barebone_gapple, barebone_arrow, barebone_string, jump_limit, jump_damage;

    private int admin_kills, admin_top_points, admin_max_top, admin_limit_kill, admin_after_limit_point, admin_top_between_point;
	private int teamMaxSize, switchpatrick, trapped_luck, time, noKillCaveY, noKillCaveTime;

    private Structures.Stuff battleroyal_stuff;

    private String name;
    
    private UhcType type;
    private KickStat kickstat;
    
//    private ArrayList<ItemStack> item_list = new ArrayList<>();
//    private ItemStack helmet, chestplate, leggings, boots;

    private Rule rule;

    private int mumbleDistance;

    private int manaMax, manaCost, manaRegen;

    private List<String> scenariosList = new ArrayList<>();
    private List<ApiItem> items = new ArrayList<ApiItem>();

    private boolean coordonates, allow_spectate, allow_nether, allow_end, tab_visible, tab_hearths, point_systeme, annonce, team, teamChat;

	public enum SharedLifeEnum{
		ONE_BAR,
		MULTI_BAR;
	}

	private SharedLifeEnum sharedlife;

    
    public UHCConfig setRule(Rule rule) {
        this.rule = rule;
        return this;
    }

    public Rule getRule() {
        return rule;
    }

    public UHCConfig setMumbleDistance(int mumbleDistance) {
        this.mumbleDistance = mumbleDistance;
        return this;
    }

    public int getManaMax() {
        return manaMax;
    }

    public int getTeamMaxSize() {
		return teamMaxSize;
	}

	public UHCConfig setTeamMaxSize(int teamMaxSize) {
		this.teamMaxSize = teamMaxSize;
		return this;
	}

	public int getSwitchpatrick() {
		return switchpatrick;
	}

	public UHCConfig setSwitchpatrick(int switchpatrick) {
		this.switchpatrick = switchpatrick;
		return this;
	}

	public int getTrapped_luck() {
		return trapped_luck;
	}

	public UHCConfig setTrapped_luck(int trapped_luck) {
		this.trapped_luck = trapped_luck;
		return this;
	}

	public int getTime() {
		return time;
	}

	public UHCConfig setTime(int time) {
		this.time = time;
		return this;
	}

	public boolean isAnnonce() {
		return annonce;
	}

	public UHCConfig setAnnonce(boolean annonce) {
		this.annonce = annonce;
		return this;
	}

	public boolean isTeam() {
		return team;
	}

	public UHCConfig setTeam(boolean team) {
		this.team = team;
		return this;
	}

	public SharedLifeEnum getSharedlife() {
		return sharedlife;
	}

	public UHCConfig setSharedlife(SharedLifeEnum sharedlife) {
		this.sharedlife = sharedlife;
		return this;
	}

	public UHCConfig setManaMax(int manaMax) {
        this.manaMax = manaMax;
        return this;
    }

    public int getManaCost() {
        return manaCost;
    }

    public UHCConfig setManaCost(int manaCost) {
        this.manaCost = manaCost;
        return this;
    }

    public int getManaRegen() {
        return manaRegen;
    }

    public UHCConfig setManaRegen(int manaRegen) {
        this.manaRegen = manaRegen;
        return this;
    }

    public int getMumbleDistance() {
        return mumbleDistance;
    }

    public UhcType getUhcType() {
        return type;
    }

    public UHCConfig setUhcType(UhcType uhcType) {
        this.type = uhcType;
        return this;
    }

    public String getName() {
        return name;
    }

    public UHCConfig setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getScenariosList() {
        return scenariosList;
    }

    public UHCConfig setScenariosList(List<String> scenariosList) {
        this.scenariosList = scenariosList;
        return this;
    }

    public int getNetheribus() {
        return netheribus;
    }

    public UHCConfig setNetheribus(int netheribus) {
        this.netheribus = netheribus;
        return this;
    }

    public int getNetheribus_damage() {
        return netheribus_damage;
    }

    public UHCConfig setNetheribus_damage(int netheribus_damage) {
        this.netheribus_damage = netheribus_damage;
        return this;
    }

    public int getSkyhight() {
        return skyhight;
    }

    public UHCConfig setSkyhight(int skyhight) {
        this.skyhight = skyhight;
        return this;
    }

    public int getSkyhight_limit() {
        return skyhight_limit;
    }

    public UHCConfig setSkyhight_limit(int skyhight_limit) {
        this.skyhight_limit = skyhight_limit;
        return this;
    }

    public int getSkyhight_damage() {
        return skyhight_damage;
    }

    public UHCConfig setSkyhight_damage(int skyhight_damage) {
        this.skyhight_damage = skyhight_damage;
        return this;
    }

    public int getBlood_diamond_damage() {
        return blood_diamond_damage;
    }

    public UHCConfig setBlood_diamond_damage(int blood_diamond_damage) {
        this.blood_diamond_damage = blood_diamond_damage;
        return this;
    }

    public int getBlood_gold_damage() {
        return blood_gold_damage;
    }

    public UHCConfig setBlood_gold_damage(int blood_gold_damage) {
        this.blood_gold_damage = blood_gold_damage;
        return this;
    }

    public int getPvptime() {
        return pvptime;
    }

    public UHCConfig setPvptime(int pvptime) {
        this.pvptime = pvptime;
        return this;
    }

    public int getKillshrink() {
        return killshrink;
    }

    public UHCConfig setKillshrink(int killshrink) {
        this.killshrink = killshrink;
        return this;
    }

    public int getBow_swap() {
        return bow_swap;
    }

    public UHCConfig setBow_swap(int bow_swap) {
        this.bow_swap = bow_swap;
        return this;
    }

    public int getTime_bomb() {
        return time_bomb;
    }

    public UHCConfig setTime_bomb(int time_bomb) {
        this.time_bomb = time_bomb;
        return this;
    }

    public int getWeakness_link() {
        return weakness_link;
    }

    public UHCConfig setWeakness_link(int weakness_link) {
        this.weakness_link = weakness_link;
        return this;
    }

    public int getLongshot_distance() {
        return longshot_distance;
    }

    public UHCConfig setLongshot_distance(int longshot_distance) {
        this.longshot_distance = longshot_distance;
        return this;
    }

    public int getMaster_apple() {
        return master_apple;
    }

    public UHCConfig setMaster_apple(int master_apple) {
        this.master_apple = master_apple;
        return this;
    }

    public int getUltra_apple() {
        return ultra_apple;
    }

    public UHCConfig setUltra_apple(int ultra_apple) {
        this.ultra_apple = ultra_apple;
        return this;
    }

    public int getBlitz() {
        return blitz;
    }

    public UHCConfig setBlitz(int blitz) {
        this.blitz = blitz;
        return this;
    }

    public int getMaster_level() {
        return master_level;
    }

    public UHCConfig setMaster_level(int master_level) {
        this.master_level = master_level;
        return this;
    }

    public int getNosneak() {
        return nosneak;
    }

    public UHCConfig setNosneak(int nosneak) {
        this.nosneak = nosneak;
        return this;
    }

    public int getToxicfood() {
        return toxicfood;
    }

    public UHCConfig setToxicfood(int toxicfood) {
        this.toxicfood = toxicfood;
        return this;
    }

    public int getBest_pve_time() {
        return best_pve_time;
    }

    public UHCConfig setBest_pve_time(int best_pve_time) {
        this.best_pve_time = best_pve_time;
        return this;
    }

    public int getVanilla_plus() {
        return vanilla_plus;
    }

    public UHCConfig setVanilla_plus(int vanilla_plus) {
        this.vanilla_plus = vanilla_plus;
        return this;
    }

    public int getSoup_heal() {
        return soup_heal;
    }

    public UHCConfig setSoup_heal(int soup_heal) {
        this.soup_heal = soup_heal;
        return this;
    }

    public int getDiamond_limit() {
        return diamond_limit;
    }

    public UHCConfig setDiamond_limit(int diamond_limit) {
        this.diamond_limit = diamond_limit;
        return this;
    }

    public int getNotower() {
        return notower;
    }

    public UHCConfig setNotower(int notower) {
        this.notower = notower;
        return this;
    }

    public int getKeepclean() {
        return keepclean;
    }

    public UHCConfig setKeepclean(int keepclean) {
        this.keepclean = keepclean;
        return this;
    }

    public int getBattleroyal_structures() {
        return battleroyal_structures;
    }

    public UHCConfig setBattleroyal_structures(int battleroyal_structures) {
        this.battleroyal_structures = battleroyal_structures;
        return this;
    }

    public int getBattleroyal_distance() {
        return battleroyal_distance;
    }

    public UHCConfig setBattleroyal_distance(int battleroyal_distance) {
        this.battleroyal_distance = battleroyal_distance;
        return this;
    }

    public int getFinal_border() {
        return final_border;
    }

    public UHCConfig setFinal_border(int final_border) {
        this.final_border = final_border;
        return this;
    }

    public int getTime_to_final_border() {
        return time_to_final_border;
    }

    public UHCConfig setTime_to_final_border(int time_to_final_border) {
        this.time_to_final_border = time_to_final_border;
        return this;
    }

    public int getBordermove() {
        return bordermove;
    }

    public UHCConfig setBordermove(int bordermove) {
        this.bordermove = bordermove;
        return this;
    }

    public int getMax_player() {
        return max_player;
    }

    public UHCConfig setMax_player(int max_player) {
        this.max_player = max_player;
        return this;
    }

    public int getStart_border() {
        return start_border;
    }

    public UHCConfig setStart_border(int start_border) {
        this.start_border = start_border;
        return this;
    }

    public int getErratic_pvp() {
        return erratic_pvp;
    }

    public UHCConfig setErratic_pvp(int erratic_pvp) {
        this.erratic_pvp = erratic_pvp;
        return this;
    }

    public int getBarebone_diamonds() {
        return barebone_diamonds;
    }

    public UHCConfig setBarebone_diamonds(int barebone_diamonds) {
        this.barebone_diamonds = barebone_diamonds;
        return this;
    }

    public int getBarebone_gapple() {
        return barebone_gapple;
    }

    public UHCConfig setBarebone_gapple(int barebone_gapple) {
        this.barebone_gapple = barebone_gapple;
        return this;
    }

    public int getBarebone_arrow() {
        return barebone_arrow;
    }

    public UHCConfig setBarebone_arrow(int barebone_arrow) {
        this.barebone_arrow = barebone_arrow;
        return this;
    }

    public int getBarebone_string() {
        return barebone_string;
    }

    public UHCConfig setBarebone_string(int barebone_string) {
        this.barebone_string = barebone_string;
        return this;
    }

    public int getJump_limit() {
        return jump_limit;
    }

    public UHCConfig setJump_limit(int jump_limit) {
        this.jump_limit = jump_limit;
        return this;
    }

    public int getJump_damage() {
        return jump_damage;
    }

    public UHCConfig setJump_damage(int jump_damage) {
        this.jump_damage = jump_damage;
        return this;
    }

    public int getAdmin_kills() {
        return admin_kills;
    }

    public UHCConfig setAdmin_kills(int admin_kills) {
        this.admin_kills = admin_kills;
        return this;
    }

    public int getAdmin_top_points() {
        return admin_top_points;
    }

    public UHCConfig setAdmin_top_points(int admin_top_points) {
        this.admin_top_points = admin_top_points;
        return this;
    }

    public int getAdmin_max_top() {
        return admin_max_top;
    }

    public UHCConfig setAdmin_max_top(int admin_max_top) {
        this.admin_max_top = admin_max_top;
        return this;
    }

    public int getAdmin_limit_kill() {
        return admin_limit_kill;
    }

    public UHCConfig setAdmin_limit_kill(int admin_limit_kill) {
        this.admin_limit_kill = admin_limit_kill;
        return this;
    }

    public int getAdmin_after_limit_point() {
        return admin_after_limit_point;
    }

    public UHCConfig setAdmin_after_limit_point(int admin_after_limit_point) {
        this.admin_after_limit_point = admin_after_limit_point;
        return this;
    }

    public int getAdmin_top_between_point() {
        return admin_top_between_point;
    }

    public UHCConfig setAdmin_top_between_point(int admin_top_between_point) {
        this.admin_top_between_point = admin_top_between_point;
        return this;
    }

    public Structures.Stuff getBattleroyal_stuff() {
        return battleroyal_stuff;
    }

    public UHCConfig setBattleroyal_stuff(Structures.Stuff battleroyal_stuff) {
        this.battleroyal_stuff = battleroyal_stuff;
        return this;
    }

    public boolean isCoordonates() {
        return coordonates;
    }

    public UHCConfig setCoordonates(boolean coordonates) {
        this.coordonates = coordonates;
        return this;
    }

    public boolean isAllow_spectate() {
        return allow_spectate;
    }

    public UHCConfig setAllow_spectate(boolean allow_spectate) {
        this.allow_spectate = allow_spectate;
        return this;
    }

    public boolean isAllow_nether() {
        return allow_nether;
    }

    public UHCConfig setAllow_nether(boolean allow_nether) {
        this.allow_nether = allow_nether;
        return this;
    }

    public boolean isAllow_end() {
        return allow_end;
    }

    public UHCConfig setAllow_end(boolean allow_end) {
        this.allow_end = allow_end;
        return this;
    }

    public boolean isTab_visible() {
        return tab_visible;
    }

    public UHCConfig setTab_visible(boolean tab_visible) {
        this.tab_visible = tab_visible;
        return this;
    }

    public boolean isTab_hearths() {
        return tab_hearths;
    }

    public UHCConfig setTab_hearths(boolean tab_hearths) {
        this.tab_hearths = tab_hearths;
        return this;
    }

    public boolean isPoint_systeme() {
        return point_systeme;
    }

    public UHCConfig setPoint_systeme(boolean point_systeme) {
        this.point_systeme = point_systeme;
        return this;
    }

	public KickStat getKickstat() {
		return kickstat;
	}

	public UHCConfig setKickstat(KickStat kickstat) {
		this.kickstat = kickstat;
		return this;
	}

	public boolean isTeamChat() {
		return teamChat;
	}

	public UHCConfig setTeamChat(boolean teamChat) {
		this.teamChat = teamChat;
		return this;
	}

	public int getNoKillCaveY() {
		return noKillCaveY;
	}

	public UHCConfig setNoKillCaveY(int noKillCaveY) {
		this.noKillCaveY = noKillCaveY;
		return this;
	}

	public int getNoKillCaveTime() {
		return noKillCaveTime;
	}

	public UHCConfig setNoKillCaveTime(int noKillCaveTime) {
		this.noKillCaveTime = noKillCaveTime;
		return this;
	}

	public List<ApiItem> getItems() {
		return items;
	}

	public UHCConfig setItems(List<ApiItem> items) {
		this.items = items;
		return this;
	}
}
