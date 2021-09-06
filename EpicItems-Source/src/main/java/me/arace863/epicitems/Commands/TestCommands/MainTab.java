package me.arace863.epicitems.Commands.TestCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainTab implements TabCompleter {

    List<String> arguments = new ArrayList<String>();
    List<String> arguments1 = new ArrayList<String>();

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (arguments.isEmpty()) {
            arguments.add("info"); arguments.add("items"); arguments.add("stats"); arguments.add("giveItem"); arguments.add("help"); arguments.add("checkForUpdates");
        }

        if (arguments1.isEmpty()) {
            arguments1.add("acesword");
            arguments1.add("airstrike");
            arguments1.add("bonemerang");
            arguments1.add("endermanbow");
            arguments1.add("endermansword");
            arguments1.add("evokerstaff");
            arguments1.add("explosivebow");
            arguments1.add("grapplinghook");
            arguments1.add("healingsword");
            arguments1.add("knockbackstick");
            arguments1.add("rocketlauncher");
            arguments1.add("runaansbow");
            arguments1.add("ultradrill");
        }

        List<String> result = new ArrayList<String>();
        if (args.length == 1){
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase(Locale.ROOT)))
                    result.add(a);
            }
            return result;
        }
        if (args.length == 2){
            for (String a : arguments1) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase(Locale.ROOT)))
                    result.add(a);
            }
            return result;
        }
        return null;
    }
}
