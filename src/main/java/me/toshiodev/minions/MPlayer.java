package me.toshiodev.minions;

import me.toshiodev.minions.minions.Minion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class MPlayer {
    private String name;
    private ArrayList<Minion> minions;

    public MPlayer(String name) {
        this.name = name;
        minions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMinion(Minion minion) {
        minions.add(minion);
    }

    public void removeMinion(Minion minion) {
        minions.remove(minion);
    }

    public ArrayList<Minion> getMinions() {
        return minions;
    }

    public int getMinionsCount() {
        return minions.size();
    }


}
