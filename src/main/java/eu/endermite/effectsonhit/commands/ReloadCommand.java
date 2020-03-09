package eu.endermite.effectsonhit.commands;

import eu.endermite.effectsonhit.EffectsOnHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender.hasPermission("effectsonhit.reload")) {
            EffectsOnHit.getPlugin().reloadConfig();
            EffectsOnHit.getPlugin().reloadCache();
            commandSender.sendMessage("Config reloaded!");
        }
        else {
            commandSender.sendMessage("You don't have permission to do this!");
        }
            return true;
    }
}
