package me.toshiodev.minions.commands;

import me.toshiodev.minions.Init;
import me.toshiodev.minions.MPlayer;
import me.toshiodev.minions.minions.Minion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.toshiodev.minions.Init.getPlayer;
import static me.toshiodev.minions.Init.updatePlayer;

public class CommandMinion implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Init.prefix + "You must be a player to use this command.");
        }else {
            Player player = (Player) commandSender;
            MPlayer mPlayer = getPlayer(player.getName());
            if (strings.length == 0) {
                player.sendMessage(Init.prefix + "You must specify a minion.");
            }else {
                String id = strings[0];
                int idTier;
                if(strings[1] != null) {
                    idTier = Integer.parseInt(strings[1]);
                    Minion minion = new Minion(id,player.getLocation(),player.getName(),idTier);
                    minion.setActive(false);
                    mPlayer.addMinion(minion);
                    updatePlayer(mPlayer);
                    player.sendMessage(Init.prefix + "You has minion head in your inventory.");
                }else {
                    player.sendMessage(Init.prefix + "You must specify a tier.");
                }

            }
        }
        return false;
    }
}
