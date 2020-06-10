package eu.endermite.effectsonhit.commands;

import eu.endermite.effectsonhit.EffectsOnHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import java.util.ArrayList;
import java.util.List;

public class OnHitMain implements TabExecutor {
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

			switch (strings[0]) {
				case "reload":
					ReloadCommand.reloadConfig(commandSender);
					break;
				default:
					commandSender.sendMessage(EffectsOnHit.getPlugin().getCache().getWrongArgumentMessage());
					break;
			}
		return true;
	}

	public static List<String> commandManager() {
		List<String> commandList = new ArrayList<String>();
		commandList.add("reload");
		return commandList;
	}


	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {

		List<String> suggestions = new ArrayList<>();

		if (strings.length == 0) {
			for (String commandstring : commandManager()) {
				if (commandstring.startsWith(strings[0])) {
					suggestions.add(commandstring);
				}
			}
		}

		return suggestions;
	}
}
