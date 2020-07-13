package fr.sywoo.api.arena;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;

public class ArenaData {

    private Material food;
    private Material block;
    private double kill, death, kdaReset;
    private int sword = 1, bow = 2, rod = 3, water= 4, blocks = 5, slotFood = 6, gapple = 7;
    private UUID uuid;
    private int killstreak;
    private long playTime;
    private List<Material> buyFood = new ArrayList<>();
    private List<Material> buyBlocks = new ArrayList<>();
    private String swordName, username;
    private Integer bestKillStreak;

    public ArenaData(String username, UUID uuid, Material food, Material block) {
        this.food = food;
        this.block = block;
        this.uuid = uuid;
        this.username = username;
        death = 0; kill = 0; killstreak = 0; kdaReset = 0; playTime = 0; swordName = ""; bestKillStreak = 0;
    }

    public long getPlayTime() {
        return playTime;
    }
    
    public String getName() {
    	return this.username;
    }
    
    public ArenaData setName(String username) {
    	this.username = username;
    	return this;
    }

    public ArenaData setPlayTime(int playTime) {
        this.playTime = playTime;
        return this;
    }

    public Integer getBestKillStreak() {
        if(bestKillStreak == null) bestKillStreak = 0;
        return bestKillStreak;
    }

    public ArenaData setBestKillStreak(Integer bestKillStreak) {
        this.bestKillStreak = bestKillStreak;
        return this;
    }

    public int getSword() {
        return sword;
    }

    public ArenaData setSword(int sword) {
        this.sword = sword;
        return this;
    }

    public int getBow() {
        return bow;
    }

    public ArenaData setBow(int bow) {
        this.bow = bow;
        return this;
    }

    public int getRod() {
        return rod;
    }

    public ArenaData setRod(int rod) {
        this.rod = rod;
        return this;
    }

    public int getWater() {
        return water;
    }

    public ArenaData setWater(int water) {
        this.water = water;
        return this;
    }

    public int getBlocks() {
        return blocks;
    }

    public ArenaData setBlocks(int blocks) {
        this.blocks = blocks;
        return this;
    }

    public int getSlotFood() {
        return slotFood;
    }

    public ArenaData setSlotFood(int slotFood) {
        this.slotFood = slotFood;
        return this;
    }

    public int getGapple() {
        return gapple;
    }

    public ArenaData setGapple(int gapple) {
        this.gapple = gapple;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getSwordName() {
        return swordName;
    }

    public ArenaData setSwordName(String swordName) {
        this.swordName = swordName;
        return this;
    }

    public List<Material> getBuyFood() {
        checkFood();
        return buyFood;
    }

    public List<Material> getBuyBlocks() {
        checkBlock();
        return buyBlocks;
    }

    public void checkFood(){
        if(buyFood == null){
            buyFood = new ArrayList<>();
        }
    }

    public void checkBlock(){
        if(buyBlocks == null){
            buyBlocks = new ArrayList<>();
        }
    }

    public ArenaData addBuyBlock(Material material){
        checkBlock();
        this.buyBlocks.add(material);
        return this;
    }

    public ArenaData removeBuyBlock(Material material){
        checkBlock();
        this.buyBlocks.remove(material);
        return this;
    }

    public ArenaData clearBuyBlocks(){
        checkBlock();
        this.buyBlocks.clear();
        return this;
    }

    public ArenaData addBuyFood(Material material){
        checkFood();
        this.buyFood.add(material);
        return this;
    }

    public ArenaData removeBuyFood(Material material){
        checkFood();
        this.buyFood.remove(material);
        return this;
    }

    public ArenaData clearBuyFood(){
        checkFood();
        this.buyFood.clear();
        return this;
    }

    public int getKillstreak() {
        return killstreak;
    }

    public ArenaData addKillStreak(int killstreak){
        this.killstreak+=killstreak;
        return this;
    }

    public ArenaData setKillstreak(int killstreak) {
        this.killstreak = killstreak;
        return this;
    }

    public UUID getUUID() {
        return uuid;
    }

    public ArenaData setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public double getKdaReset() {
        return kdaReset;
    }

    public ArenaData setKdaReset(double kdaReset) {
        this.kdaReset = kdaReset;
        return this;
    }

    public ArenaData addKill(int kill){
        this.kill+=kill;
        return this;
    }

    public ArenaData addDeath(int death){
        this.death+=death;
        return this;
    }

    public double getKill() {
        return kill;
    }

    public ArenaData setKill(int kill) {
        this.kill = kill;
        return this;
    }

    public double getDeath() {
        return death;
    }

    public ArenaData setDeath(int death) {
        this.death = death;
        return this;
    }

    public Material getFood() {
        return food;
    }

    public ArenaData setFood(Material food) {
        this.food = food;
        return this;
    }

    public Material getBlock() {
        return block;
    }

    public ArenaData setBlock(Material block) {
        this.block = block;
        return this;
    }

    public String getKda(){
        return new DecimalFormat("#.##").format((kill / death));
    }

}
