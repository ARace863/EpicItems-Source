/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.GUI;

import me.arace863.epicitems.EpicItems;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemsGUI implements CommandExecutor {
    EpicItems plugin;

    public ItemsGUI(EpicItems plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (!player.hasPermission("op") && !player.hasPermission("epicitems.itemgui")) {
                sender.sendMessage(ChatColor.RED + "Running EpicItems v" + plugin.getDescription().getVersion());
                sender.sendMessage("Error message: No permission");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 10.0F, 1.0F);
            } else {
                GUIMethods guiMethods = new GUIMethods(plugin);
                guiMethods.openItemGUI(player);
            }
        }
        return true;
    }
}
