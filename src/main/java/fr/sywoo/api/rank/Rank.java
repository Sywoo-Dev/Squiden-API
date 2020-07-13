package fr.sywoo.api.rank;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private String name;
    private String displayName;
    private String power;
    private List<String> permissions;
    private int maxFriends;
    private int maxParty;
    private String color;

    public Rank(RankEnum rankEnum){
        this.name = rankEnum.getName();
        this.displayName = rankEnum.getDisplayName();
        this.power = rankEnum.getPower();
        this.maxFriends = rankEnum.getFriends();
        this.maxParty = rankEnum.getParty();
        this.permissions = new ArrayList<>();
        this.color = rankEnum.getColor();
    }

    public Rank setColor(String color) {
        this.color = color;
        return this;
    }

    public String getColor() {
        return color;
    }

    public int getMaxFriends() {
        return maxFriends;
    }

    public int getMaxParty() {
        return maxParty;
    }

    public String getName() { return name; }
    public Rank setName(String name) {
        this.name = name;
        return this;
    }

    public String getDisplayName() { return displayName; }
    public Rank setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getPower() { return power; }
    public Rank setPower(String power) {
        this.power = power;
        return this;
    }


    public List<String> getPermissions() {
        if(permissions == null) permissions = new ArrayList<>();
        return permissions;
    }

    public boolean hasPermission(String perm){
        checkPerms();
        if(permissions.contains("*")){
            return true;
        }
        return permissions.contains(perm);
    }

    public Rank addPermission(String permission){
        checkPerms();
        if (permissions.contains(permission)) {
            return this;
        } else {
            permissions.add(permission);
            return this;
        }
    }

    public Rank addTPermission(String[] permission){
        checkPerms();
        for(String str : permission){
            if(permissions.contains(str)) continue;
            permissions.add(str);
        }
        return this;
    }

    public Rank removePermission(String permission){
        checkPerms();
        if (permissions.contains(permission)) {
            permissions.remove(permission);
            return this;
        } else {
            return this;
        }
    }

    private void checkPerms(){
        if(permissions == null){ permissions = new ArrayList<>(); }
    }

}
