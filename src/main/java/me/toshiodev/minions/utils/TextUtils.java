package me.toshiodev.minions.utils;

import org.bukkit.ChatColor;

public class TextUtils {

    public static String chatColored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String upperCaseFirst(String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }

    public static String upperFirstinEachWord(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(upperCaseFirst(word)).append(" ");
        }
        return sb.toString().trim();
    }

    public static String lowerCaseFirst(String text) {
        return Character.toLowerCase(text.charAt(0)) + text.substring(1);
    }

    public static String format(String text) {
        if (text.contains("_")){
            text = text.replace("_", " ");
        }
        return chatColored(upperFirstinEachWord(text));
    }
    public static String romanize(int number) {
        if (number == 0) {
            return "N";
        }
        if (number < 0) {
            return "-" + romanize(-number);
        }
        String roman = "";
        while (number > 0) {
            if (number >= 1000) {
                roman += "M";
                number -= 1000;
            } else if (number >= 900) {
                roman += "CM";
                number -= 900;
            } else if (number >= 500) {
                roman += "D";
                number -= 500;
            } else if (number >= 400) {
                roman += "CD";
                number -= 400;
            } else if (number >= 100) {
                roman += "C";
                number -= 100;
            } else if (number >= 90) {
                roman += "XC";
                number -= 90;
            } else if (number >= 50) {
                roman += "L";
                number -= 50;
            } else if (number >= 40) {
                roman += "XL";
                number -= 40;
            } else if (number >= 10) {
                roman += "X";
                number -= 10;
            } else if (number >= 9) {
                roman += "IX";
                number -= 9;
            } else if (number >= 5) {
                roman += "V";
                number -= 5;
            } else if (number >= 4) {
                roman += "IV";
                number -= 4;
            } else if (number >= 1) {
                roman += "I";
                number -= 1;
            }
        }
        return roman;
    }
}
