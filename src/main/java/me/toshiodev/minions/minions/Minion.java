package me.toshiodev.minions.minions;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Minion {

    private boolean isActive;
    private boolean forCraft;
    private UUID uuid;
    private Location loc;
    private String name;
    private String owner;
    private MinionType type;
    private MinionTier currentTier;
    private ArrayList<MinionTier> tiers;
    private int minionTier;
    private Layout layout;
    public Minion(String name, Location loc, String owner){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.loc = loc;
        this.owner = owner;

        for (MinionType type : MinionType.values()) {
            if (Arrays.stream(type.getMinions()).anyMatch(name::equals)) {
                this.type = type;
            }
        }
        this.tiers = new ArrayList<>();
        addTiers();
        this.layout = new Layout(this);


    }
    public void addTiers(){
        switch (type){
            case FARMING:
                tiers = new FarmingTiers().getTiers(this);
                break;
            case MINING:
                tiers = new MiningTiers().getTiers(this);
                break;
            case COMBAT:
                break;
            case SLAYER:
                break;
            case FORAGING:
                break;
            case FISHING:
                break;
            case OTHER:
                break;
        }
    }

    public void setMinionTier(int minionTier) {
        this.minionTier = minionTier;
    }

    public void setActive(boolean active){
        this.isActive = active;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public Layout getLayout() {
        return layout;
    }

    public MinionType getType() {
        return type;
    }
}

class MinionTier{
    private int id;
    private boolean forCraft;
    private int cooldown;
    private int maxStorage;
    private String headUrl;

    public MinionTier(int id, int cooldown, int maxStorage, String headUrl, boolean forCraft) {
        this.id = id;
        this.cooldown = cooldown;
        this.maxStorage = maxStorage;
        this.headUrl = headUrl;
        this.forCraft = forCraft;
    }

    public int getId() {
        return id;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public boolean isForCraft() {
        return forCraft;
    }
}

class FarmingTiers{
    private ArrayList<MinionTier> tiers;

    public ArrayList<MinionTier> getTiers(Minion minion){
        switch (minion.getName()){
            case "wheat":
                break;
            case "carrot":
                break;
            case "potato":
                break;
            case "pumpkin":
                break;
            case "melon":
                break;
            case "mushroom":
                break;
            case "cocoa":
                break;
            case "cactus":
                break;
            case "sugar_cane":
                break;
            case "cow":
                break;
            case "pig":
                break;
            case "chicken":
                break;
            case "sheep":
                break;
            case "rabbit":
                break;
            case "nether_warts":
                break;
        }
        return tiers;
    }
}
class MiningTiers{

    private ArrayList<MinionTier> tiers;

    public ArrayList<MinionTier> getTiers(Minion minion){
        int[] cooldowns;
        int[] maxStorages;
        boolean[] forCrafts;
        switch (minion.getName()){
            case "cobblestone":
                cooldowns = new int[]{14, 14, 12, 12, 10, 10, 9, 9, 8, 8, 7, 6};
                maxStorages = new int[]{64, 192, 192, 384, 384, 576, 576, 768, 768, 960, 960, 960};
                forCrafts = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, true};
                tiers = TiersUtils.parseTiers(cooldowns, maxStorages, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjljMzhmZTRmYzk4YTI0ODA3OWNkMDRjNjViNmJmZjliNDUwMTdmMTY0NjBkYWIzYzM0YzE3YmZjM2VlMWQyZiJ9fX0=",forCrafts);
                break;
            case "coal":
                cooldowns = new int[]{15,15,13,13,12,12,10,10,9,9,7,6};
                maxStorages = new int[]{64,192,192,384,384,576,576,768,768,960,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU3MDVjZjg2NGRmMmMxODJlMzJjNDg2YjcxNDdjYmY3ODJhMGFhM2RmOGE2ZDYxNDUzOTM5MGJmODRmYjE1ZCJ9fX0=",forCrafts);
                break;
            case "iron":
                cooldowns = new int[]{17,17,15,15,14,14,12,12,10,10,8,7};
                maxStorages = new int[]{64,192,192,384,384,576,576,768,768,960,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTczMDkyY2FlYTg5ZGQxMmQzNjgzNzVmMWEwOTc3OTZlM2JjODhmODA5YWNjZjMyMDcwNmJkYzA0OGNkNGM1ZSJ9fX0=",forCrafts);
                break;
            case "gold":
                break;
            case "diamond":
                break;
            case "lapis":
                break;
            case "emerald":
                break;
            case "redstone":
                break;
            case "quartz":
                break;
            case "obsidian":
                break;
            case "glowstone":
                break;
            case "gravel":
                break;
            case "ice":
                break;
            case "sand":
                break;
            case "end_stone":
                break;
            case "mithril":
                break;
            case "hard_stone":
                break;
        }

        return tiers;
    }
}

class TiersUtils{
    public static ArrayList<MinionTier> parseTiers(int[] cooldowns, int[] storages, ArrayList<String> heads, boolean[] forCrafts){
        ArrayList<MinionTier> tiers = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < cooldowns.length; i++){
            tiers.add(new MinionTier(id,cooldowns[i],storages[i],heads.get(i),forCrafts[i]));
            id++;
        }
        return tiers;
    }
    public static ArrayList<MinionTier> parseTiers(int[] cooldowns, int[] storages, String head){
        ArrayList<MinionTier> tiers = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < cooldowns.length; i++){
            tiers.add(new MinionTier(id,cooldowns[i],storages[i],head,false));
            id++;
        }
        return tiers;
    }
    public static ArrayList<MinionTier> parseTiers(int[] cooldowns, int[] storages, String head,boolean[] forCrafts){
        ArrayList<MinionTier> tiers = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < cooldowns.length; i++){
            tiers.add(new MinionTier(id,cooldowns[i],storages[i],head,forCrafts[i]));
            id++;
        }
        return tiers;
    }
}