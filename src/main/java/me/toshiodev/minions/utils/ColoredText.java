package me.toshiodev.minions.utils;

import org.bukkit.ChatColor;

public class ColoredText {

    public static String chatColored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
