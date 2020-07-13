package fr.sywoo.api.uhcconfig;

/**
 * @Author : Baptiste#0001
 **/

public class Rule {

    private boolean stripMining, rollerCoastering, pokeHoling, iPvp, towers, digDown, crossTeam, friendlyFire, reconnectAfterBorder;
    private boolean potions, timePotion, levelPotion, heal, regen, strenght, damage, poison, jump, speed, invisibility, slow, weakness, mumble;

    private double borderSpeed;

    public Rule() {
        stripMining = true;
        rollerCoastering = true;
        pokeHoling = true;
        iPvp = true;
        towers = true;
        digDown = true;
        crossTeam = false;
        friendlyFire = false;
        reconnectAfterBorder = true;
        timePotion = true;
        levelPotion = true;
        heal = true;
        regen = true;
        strenght = true;
        poison = true;
        jump = true;
        speed = true;
        invisibility = true;
        slow = true;
        weakness = true;
        damage = true;
        mumble = false;
    }

    public boolean isStripMining() {
        return stripMining;
    }

    public void setStripMining(boolean stripMining) {
        this.stripMining = stripMining;
    }

    public boolean isRollerCoastering() {
        return rollerCoastering;
    }

    public void setRollerCoastering(boolean rollerCoastering) {
        this.rollerCoastering = rollerCoastering;
    }

    public boolean isPokeHoling() {
        return pokeHoling;
    }

    public void setPokeHoling(boolean pokeHoling) {
        this.pokeHoling = pokeHoling;
    }

    public boolean isiPvp() {
        return iPvp;
    }

    public void setiPvp(boolean iPvp) {
        this.iPvp = iPvp;
    }

    public boolean isTowers() {
        return towers;
    }

    public void setTowers(boolean towers) {
        this.towers = towers;
    }

    public boolean isDigDown() {
        return digDown;
    }

    public void setDigDown(boolean digDown) {
        this.digDown = digDown;
    }

    public boolean isCrossTeam() {
        return crossTeam;
    }

    public void setCrossTeam(boolean crossTeam) {
        this.crossTeam = crossTeam;
    }

    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    public void setFriendlyFire(boolean friendlyFire) {
        this.friendlyFire = friendlyFire;
    }

    public boolean isReconnectAfterBorder() {
        return reconnectAfterBorder;
    }

    public void setReconnectAfterBorder(boolean reconnectAfterBorder) {
        this.reconnectAfterBorder = reconnectAfterBorder;
    }

    public boolean isTimePotion() {
        return timePotion;
    }

    public void setTimePotion(boolean timePotion) {
        this.timePotion = timePotion;
    }

    public boolean isLevelPotion() {
        return levelPotion;
    }

    public void setLevelPotion(boolean levelPotion) {
        this.levelPotion = levelPotion;
    }

    public boolean isHeal() {
        return heal;
    }

    public void setHeal(boolean heal) {
        this.heal = heal;
    }

    public boolean isRegen() {
        return regen;
    }

    public void setRegen(boolean regen) {
        this.regen = regen;
    }

    public boolean isStrenght() {
        return strenght;
    }

    public void setStrenght(boolean strenght) {
        this.strenght = strenght;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isSpeed() {
        return speed;
    }

    public void setSpeed(boolean speed) {
        this.speed = speed;
    }

    public boolean isInvisibility() {
        return invisibility;
    }

    public void setInvisibility(boolean invisibility) {
        this.invisibility = invisibility;
    }

    public boolean isSlow() {
        return slow;
    }

    public void setSlow(boolean slow) {
        this.slow = slow;
    }

    public boolean isWeakness() {
        return weakness;
    }

    public void setWeakness(boolean weakness) {
        this.weakness = weakness;
    }

    public double getBorderSpeed() {
        return borderSpeed;
    }

    public void setBorderSpeed(double borderSpeed) {
        this.borderSpeed = borderSpeed;
    }

    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }

    public boolean isPotions() {
        return potions;
    }

    public void setPotions(boolean potions) {
        this.potions = potions;
    }

    public boolean isDamage() {
        return damage;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }

    public boolean isMumble() {
        return mumble;
    }

    public void setMumble(boolean mumble) {
        this.mumble = mumble;
    }


}
