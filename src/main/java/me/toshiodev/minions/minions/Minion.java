package me.toshiodev.minions.minions;

import org.bukkit.util.Vector;

public class Minion {
    private String name;
    private MinionType type;
    private String urlHead;
    private int minionTier;
    private int cooldown;
    private int maxStorage;
    private Vector[] blockLayout;
    private int[] invLayout;
    public Minion(String name){

    }

    public String getName() {
        return name;
    }

    public MinionType getType() {
        return type;
    }
}
