package eu.endermite.effectsonhit.commands;

import eu.endermite.effectsonhit.EffectsOnHit;
import org.bukkit.command.CommandSender;

public class ReloadCommand {
	public static void reloadConfig(CommandSender commandSender) {
		if (commandSender.hasPermission("effectsonhit.reload")) {
			EffectsOnHit.getPlugin().reloadConfig();
			EffectsOnHit.getPlugin().reloadCache();
			commandSender.sendMessage(EffectsOnHit.getPlugin().getCache().getConfigReloadedMessage());
		} else {
			commandSender.sendMessage(EffectsOnHit.getPlugin().getCache().getNoPermMessage());
		}
	}
}
