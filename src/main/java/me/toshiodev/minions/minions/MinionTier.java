package me.toshiodev.minions.minions;

public class MinionTier {
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
