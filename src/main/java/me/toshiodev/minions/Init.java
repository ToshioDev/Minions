package me.toshiodev.minions;

import me.toshiodev.minions.commands.CommandMinion;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Init extends JavaPlugin implements Listener {

    private static Plugin plugin;
    public static String prefix = "§a[§bMinions§a] §7";

    // Player Cache
    private static ArrayList<MPlayer> players = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getConsoleSender().sendMessage(prefix + "§aPlugin has been enabled!");
        getServer().getPluginCommand("minions").setExecutor(new CommandMinion());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // delete all armor stands spigot code
        for (Entity entity : Bukkit.getWorld("world").getEntities()) {
            if (entity instanceof ArmorStand) {
                entity.remove();
            }
        }
        players.clear();
        getServer().getConsoleSender().sendMessage(prefix + "§cPlugin has been disabled!");
    }

    public static void addPlayer(MPlayer player) {
        players.add(player);
    }
    public static void removePlayer(MPlayer player) {
        players.remove(player);
    }
    public static void updatePlayer(MPlayer player) {
        players.remove(player);
        players.add(player);
    }
    public static MPlayer getPlayer(String name) {
        for (MPlayer player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public static ArrayList<MPlayer> getPlayers() {
        return players;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        MPlayer player = new MPlayer(event.getPlayer().getName());
        players.add(player);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

}
