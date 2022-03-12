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
    private double cooldown;
    private int maxStorage;
    private String headUrl;

    public MinionTier(int id, double cooldown, int maxStorage, String headUrl, boolean forCraft) {
        this.id = id;
        this.cooldown = cooldown;
        this.maxStorage = maxStorage;
        this.headUrl = headUrl;
        this.forCraft = forCraft;
    }

    public int getId() {
        return id;
    }

    public double getCooldown() {
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
        double[] cooldowns;
        int[] maxStorages = new int[]{64, 192, 192, 384, 384, 576, 576, 768, 768, 960, 960, 960};
        boolean[] forCrafts;
        switch (minion.getName()){
            case "cobblestone":
                cooldowns = new double[]{14, 14, 12, 12, 10, 10, 9, 9, 8, 8, 7, 6};
                forCrafts = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, true};
                tiers = TiersUtils.parseTiers(cooldowns, maxStorages, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjljMzhmZTRmYzk4YTI0ODA3OWNkMDRjNjViNmJmZjliNDUwMTdmMTY0NjBkYWIzYzM0YzE3YmZjM2VlMWQyZiJ9fX0=",forCrafts);
                break;
            case "coal":
                cooldowns = new double[]{15,15,13,13,12,12,10,10,9,9,7,6};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU3MDVjZjg2NGRmMmMxODJlMzJjNDg2YjcxNDdjYmY3ODJhMGFhM2RmOGE2ZDYxNDUzOTM5MGJmODRmYjE1ZCJ9fX0=",forCrafts);
                break;
            case "iron":
                cooldowns = new double[]{17,17,15,15,14,14,12,12,10,10,8,7};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTczMDkyY2FlYTg5ZGQxMmQzNjgzNzVmMWEwOTc3OTZlM2JjODhmODA5YWNjZjMyMDcwNmJkYzA0OGNkNGM1ZSJ9fX0=",forCrafts);
                break;
            case "gold":
                cooldowns = new double[]{22,22,20,20,18,18,16,16,14,14,11,9};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTkwODIzNWExY2JlY2MwM2E3MmNkZjcxMGY0ZWQ1MTlkNjViNGRhNjJiNTRhNGVmOThhNzQwOGZjZjUxYjgzYiJ9fX0=",forCrafts);
                break;
            case "diamond":
                cooldowns = new double[]{29,29,27,27,25,25,22,22,19,19,15,12};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmRiMDA4MDY4ODIzODQ0ZDEyOWVmZDgzOWM4MzA2NTBkOThlZWE4MTA0Y2YyYjMyNmE5YmU3ZGZiMTdhYjk5ZCJ9fX0=",forCrafts);
                break;
            case "lapis":
                cooldowns = new double[]{29,29,27,27,25,25,23,23,21,21,18,16};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZhMzNjNzYzNDhlYTAzODk0MzY0MmRiNzYzY2EyYmFiMjc4YTAwNWJiNjczNWEyM2RjMWM4MDFkZGVkNmNkZSJ9fX0=",forCrafts);
                break;
            case "emerald":
                cooldowns = new double[]{28,28,26,26,24,24,21,21,18,18,14,12};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVlYTU0YTc1MjAxZDY0NWIyMGNiMzRhMmExNTVkYjU0YTkyMzhmYTBiOWQ5MjVmYTNhMmRkYzA2NmFmMjdjOSJ9fX0=",forCrafts);
                break;
            case "redstone":
                cooldowns = new double[]{29,29,27,27,25,25,23,23,21,21,18,16};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,true,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWUyMWY4Y2ZlOGNjMGUwODk5MGQ1MjE2NWU3OGU2ZjgxNmY0ZjhlMWNlN2NiMGYwYTZjOGViZTFkYTg1ZTQyYSJ9fX0=",forCrafts);
                break;
            case "quartz":
                cooldowns = new double[]{22.5,22.5,21,21,19,19,17,17,14.5,14.5,11.5};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmU3MmJlMWY3OTFkOTIzOTVjNGNmMDEzMzVkMDc4ZGU1YWY0M2Q5YzZmY2JjM2EzODc1M2RjNTY5NDJmNGE0NiJ9fX0=",forCrafts);
                break;
            case "obsidian":
                cooldowns = new double[]{45,45,42,42,39,39,35,35,30,30,24,21};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc5OWUzZTY4NTk5OTAyZTRkMmExZjZhODNlODUxY2VkOTIzYjQxN2NiZWY2MTZmNGIyMGY1MjFkNzNjYzBiZCJ9fX0=",forCrafts);
                break;
            case "glowstone":
                cooldowns = new double[]{25,25,23,23,21,21,19,19,16,16,13};
                int[] glowstoneMaxStorage = new int[]{64,192,192,384,384,576,576,768,768,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,glowstoneMaxStorage,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTFmNGYwOTY5NjY4YzM2ZThiNzM5ODE2NWViY2YyYTEzM2NhODhiMmI4YjNiZTZlOWM2Mzg0MzIwZmZiMTUwNyJ9fX0=",forCrafts);
                break;
            case "gravel":
                cooldowns = new double[]{26,26,24,24,22,22,19,19,16,16,13};
                int[] gravelMaxStorage = new int[]{64,192,192,384,384,576,576,768,768,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,false};
                tiers = TiersUtils.parseTiers(cooldowns,gravelMaxStorage,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGEzNzAwODk2MTE3ZmQ5NDg4OWIwMjE2ZDEyNGYxZTY3ZTRmMGU5Y2EzYjA0ZDE2OGY4NDlhMjk3YmUyMDQ3ZCJ9fX0=",forCrafts);
                break;
            case "ice":
                cooldowns = new double[]{14,14,12,12,10,10,9,9,8,8,7};
                int[] iceMaxStorage = new int[]{64,192,192,384,384,576,576,768,768,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,true,true,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,iceMaxStorage,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGYxMmJmNzY4MTFkZjJjMDIwY2VjZDM0Y2Q4ZDFmMmFlZDI4YTU2MDY3NDMyODEzMGQyZDM1YTBlOWI1YzdiOSJ9fX0=",forCrafts);
                break;
            case "sand":
                cooldowns = new double[]{26,26,24,24,22,22,19,19,16,16,13};
                int[] sandMaxStorage = new int[]{64,192,192,384,384,576,576,768,768,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,false};
                tiers = TiersUtils.parseTiers(cooldowns,sandMaxStorage,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmEyMjBlMzhiYTI1NTVlOWNkZDYyMmMzMDg0MDc1MjM5ODcyOWI1Y2E0ZTQ5NzdlMTk5N2U0MWYyOTliNTA4MSJ9fX0=",forCrafts);
                break;
            case "end_stone":
                cooldowns = new double[]{26,26,24,24,22,22,19,19,16,16,13};
                int[] endsntoneMaxStorage = new int[]{64,192,192,384,384,576,576,768,768,960,960};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,false};
                tiers = TiersUtils.parseTiers(cooldowns,endsntoneMaxStorage,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzk5NGJlM2RjZmJiNGVkMGE1YTc0OTViNzMzNWFmMWEzY2VkMGI1ODg4YjUwMDcyODZhNzkwNzY3YzNiNTdlNiJ9fX0=",forCrafts);
                break;
            case "mithril":
                cooldowns = new double[]{80,80,75,75,70,70,65,65,60,60,55,50};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,false,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzYyZmE2NzBmZjg1OTliMzJhYjM0NDE5NWJhMTVmM2VmNjRjM2E4YWE4YTM3ODIxYzA4Mzc1OTUwY2I3NGNkMCJ9fX0=",forCrafts);
                break;
            case "hard_stone":
                cooldowns = new double[]{14,14,12,12,10,10,9,9,8,8,7,6};
                forCrafts = new boolean[]{false,false,false,false,false,false,false,false,false,true,true,true};
                tiers = TiersUtils.parseTiers(cooldowns,maxStorages,"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWU4YmFiOTQ5MzcwOGJlZGEzNDI1NTYwNmQ1ODgzYjg3NjI3NDZiY2JlNmM5NGU4Y2E3OGE3N2E0MDhjOGJhOCJ9fX0=",forCrafts);
                break;
        }

        return tiers;
    }
}

class TiersUtils{
    public static ArrayList<MinionTier> parseTiers(double[] cooldowns, int[] storages, ArrayList<String> heads, boolean[] forCrafts){
        ArrayList<MinionTier> tiers = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < cooldowns.length; i++){
            tiers.add(new MinionTier(id,cooldowns[i],storages[i],heads.get(i),forCrafts[i]));
            id++;
        }
        return tiers;
    }
    public static ArrayList<MinionTier> parseTiers(double[] cooldowns, int[] storages, String head){
        ArrayList<MinionTier> tiers = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < cooldowns.length; i++){
            tiers.add(new MinionTier(id,cooldowns[i],storages[i],head,false));
            id++;
        }
        return tiers;
    }
    public static ArrayList<MinionTier> parseTiers(double[] cooldowns, int[] storages, String head,boolean[] forCrafts){
        ArrayList<MinionTier> tiers = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < cooldowns.length; i++){
            tiers.add(new MinionTier(id,cooldowns[i],storages[i],head,forCrafts[i]));
            id++;
        }
        return tiers;
    }
}