package me.toshiodev.minions.commands;

import me.toshiodev.minions.guis.MinionUI;
import me.toshiodev.minions.guis.MinionUIType;
import me.toshiodev.minions.minions.Minion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            Minion minion = new Minion("cobblestone",player.getLocation(),player.getName(),2);
            if (player.hasPermission("minions.test")){
                if (strings[0].equalsIgnoreCase("gui")){
                    if (strings.length == 1){
                        player.sendMessage("§cUsage: /test gui <type>");
                        return false;
                    }
                    switch (strings[1]){
                        case "principal":
                            player.openInventory(new MinionUI(minion, MinionUIType.PRINCIPAL).getInventory());
                            break;
                        case "layout":
                            player.openInventory(new MinionUI(minion, MinionUIType.LAYOUT).getInventory());
                            break;
                        case "crafting":
                            new MinionUI(minion, MinionUIType.CRAFTING);
                            break;
                        case "tiers":
                            new MinionUI(minion, MinionUIType.TIERS);
                            break;
                    }
                }
            }
        }else{
            commandSender.sendMessage("You must be a player to use this command");
        }
        return false;
    }
}
