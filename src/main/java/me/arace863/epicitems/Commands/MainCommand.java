/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Commands;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.GUI.GUIMethods;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Updaters.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.UUID;

public class MainCommand implements CommandExecutor {
    EpicItems plugin;
    FileConfiguration config;

    public MainCommand(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("epicitems.main") || sender.hasPermission("op")){
            if (label.equalsIgnoreCase("epicitems")) { // Main command
                if (args.length >= 1) {

                    if (args[0].equalsIgnoreCase("menu")) {
                        if (sender instanceof Player){
                            Player player = (Player) sender;
                            GUIMethods guiMethods = new GUIMethods(plugin);
                            guiMethods.openMenu(player);
                        }else{
                            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Only players can use /epicitems <menu>!");
                        }
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("info")) {
                        (new UpdateChecker(this.plugin, 93541)).getVersion((version) -> {
                            sender.sendMessage(" ");

                            sender.sendMessage(ChatColor.YELLOW + "Epic Items");
                            sender.sendMessage(" ");
                            sender.sendMessage(ChatColor.AQUA + "Version: " + ChatColor.RED + this.plugin.getDescription().getVersion());
                            sender.sendMessage(ChatColor.AQUA + "Author: " + ChatColor.RED + this.plugin.getDescription().getAuthors());
                            sender.sendMessage(ChatColor.AQUA + "Spigot API Version: " + ChatColor.RED + this.plugin.getDescription().getAPIVersion());
                            sender.sendMessage(" ");
                            sender.sendMessage(ChatColor.DARK_GRAY + "UUID: " + UUID.randomUUID());
                        });
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("help")) {
                        sender.sendMessage(" ");
                        sender.sendMessage(ChatColor.YELLOW + "Help");
                        sender.sendMessage(" ");
                        sender.sendMessage(ChatColor.RED + "If you need support with the plugin or you have discovered a bug,");
                        sender.sendMessage(ChatColor.RED + "report it here: " + ChatColor.BLUE + "§nhttps://dsc.gg/epicitems");
                        sender.sendMessage(" ");
                        sender.sendMessage(ChatColor.AQUA + "-----------[ Commands ]-----------");
                        sender.sendMessage(ChatColor.GREEN + "Items:");
                        sender.sendMessage(ChatColor.GRAY + "Ace Sword - /acesword");
                        sender.sendMessage(ChatColor.GRAY + "Airstrike - /airstrike");
                        sender.sendMessage(ChatColor.GRAY + "Bonemerang - /bonemerang");
                        sender.sendMessage(ChatColor.GRAY + "Enderman Bow - /endermanbow");
                        sender.sendMessage(ChatColor.GRAY + "Enderman Sword - /endermansword");
                        sender.sendMessage(ChatColor.GRAY + "Evoker Staff - /evokerstaff");
                        sender.sendMessage(ChatColor.GRAY + "Explosive Bow - /explosivebow");
                        sender.sendMessage(ChatColor.GRAY + "Grappling Hook - /grapplinghook");
                        sender.sendMessage(ChatColor.GRAY + "Healing Sword - /healingsword");
                        sender.sendMessage(ChatColor.GRAY + "Knockback Stick - /knockbackstick");
                        sender.sendMessage(ChatColor.GRAY + "Rocket Launcher - /rpg");
                        sender.sendMessage(ChatColor.GRAY + "Runaan's Bow - /runaansbow");
                        sender.sendMessage(ChatColor.GRAY + "Ultra Drill - /ultradrill");
                        sender.sendMessage(" ");
                        sender.sendMessage(ChatColor.GREEN + "Utilities:");
                        sender.sendMessage(ChatColor.GRAY + "Main Command - /epicitems");
                        sender.sendMessage(ChatColor.GRAY + "Creative Mode - /gmc");
                        sender.sendMessage(ChatColor.GRAY + "Survival Mode - /gms");
                        sender.sendMessage(ChatColor.GRAY + "Heal - /heal");
                        sender.sendMessage(ChatColor.GRAY + "Item GUI - /items");
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("giveItem")) {
                        Player target;
                        try {
                            if (args[1].equalsIgnoreCase("acesword")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Ace Sword");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.AceSword});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Ace Sword");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("airstrike")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Airstrike");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.Airstrike});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Airstrike");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("bonemerang")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Bonemerang");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.Bonemerang});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Bonemerang");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("endermanbow")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Enderman Bow");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.EndermanBow});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Enderman Bow");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("endermansword")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Enderman Sword");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.EndermanSword});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Enderman Sword");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("evokerstaff")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Evoker Staff");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.EvokerStaff});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Evoker Staff");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("explosivebow")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Explosive Bow");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.ExplosiveBow});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Explosive Bow");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("grapplinghook")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Grappling Hook");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.GrapplingHook});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Grappling Hook");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("healingsword")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Healing Sword");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.HealingSword});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Healing Sword");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("knockbackstick")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Knockback Stick");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.KnockStick});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Knockback Stick");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("rocketlauncher")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Rocket Launcher");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.Rpg});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Rocket Launcher");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("runaansbow")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Runaan's Bow");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.TripleStrikeBow});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Runaan's Bow");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("ultradrill")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Ultra Drill");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.UltraDrill});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Ultra Drill");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }

                            if (args[1].equalsIgnoreCase("stealthstrike")) {
                                target = Bukkit.getPlayer(args[2]);
                                if (target == null){
                                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "That is not a player! /epicitems <giveItem> <targetPlayer>");
                                }else{
                                    sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Stealth Strike");
                                    target.getInventory().addItem(new ItemStack[]{ItemManager.StealthStrike});
                                    target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Stealth Strike");
                                    if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                        if (sender instanceof Player){
                                            Song jingle = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\unlock.nbs"));
                                            RadioSongPlayer rsp = new RadioSongPlayer(jingle);
                                            Player player = (Player) sender;
                                            rsp.addPlayer(player);
                                            rsp.setPlaying(true);
                                        }
                                    }
                                }
                            }
                        }catch (ArrayIndexOutOfBoundsException e){
                            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Please provide a player name!");
                        }

                        return true;
                    }

                    if (args[0].equalsIgnoreCase("items")) {
                        if (sender instanceof Player){
                            Player player = (Player) sender;
                            GUIMethods guiMethods = new GUIMethods(plugin);
                            guiMethods.openItemGUI(player);
                        }else{
                            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Only players can use /epicitems <items>!");
                        }
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("stats")) {
                        if (this.config.getBoolean("bStats", true)) {
                            sender.sendMessage(ChatColor.YELLOW + "Stats");
                            sender.sendMessage(" ");
                            sender.sendMessage(ChatColor.RED + "Link: https://bstats.org/plugin/bukkit/Epic%20Items%20-%20Custom%20Items/12375");
                            return true;
                        }else{
                            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You must have the 'bStats' option set to true in the config.yml file to use this feature!");
                        }
                    }

                    if (args[0].equalsIgnoreCase("checkForEpicItem")) {
                        if (sender instanceof Player){
                            Player player = (Player) sender;
                            if (player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§8EpicItem-AceSword")) {
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] §aSuccess! Detected an EpicItem");
                                if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                    Song trueNBS = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\true.nbs"));
                                    RadioSongPlayer trueR = new RadioSongPlayer(trueNBS);
                                    trueR.addPlayer(player);
                                    trueR.setPlaying(true);
                                }
                            } else {
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] §cThat is not an EpicItem");
                                if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                    Song falseNBS = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\false.nbs"));
                                    RadioSongPlayer falseR = new RadioSongPlayer(falseNBS);
                                    falseR.addPlayer(player);
                                    falseR.setPlaying(true);
                                }
                            }
                        }else{
                            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Only players can use /epicitems <checkForEpicItem>!");
                        }

                        return true;
                    }


                    if (args[0].equalsIgnoreCase("checkForUpdates")) {
                        (new UpdateChecker(this.plugin, 93541)).getVersion((version) -> {
                            if (this.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                                sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "No update found, check again later!");
                            } else {
                                sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "§cFound an update! Download it here" + ChatColor.BLUE + " https://www.spigotmc.org/resources/epic-items-custom-items.93541/" + ChatColor.RED + "to download it!");
                                this.plugin.updateAvailable = true;
                            }

                        });
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("itemStore")) {
                        if (sender instanceof Player){
                            Player player = (Player) sender;
                            if (Bukkit.getPluginManager().isPluginEnabled("Vault")){
                                GUIMethods guiMethods = new GUIMethods(plugin);
                                guiMethods.openVaultStoreGUI(player);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems]" + ChatColor.RED + " You must have the Vault plugin installed to use this, Install it here: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/vault.34315/");
                            }
                        }else{
                            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Only players can use /epicitems <items>!");
                        }
                        return true;
                    }
                }else{
                    sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "/epicitems <info, help, giveItem, items, stats, checkForEpicItem, checkForUpdates, itemStore>");
                }
            }
        }else{
            sender.sendMessage(ChatColor.RED + "Running EpicItems v" + plugin.getDescription().getVersion());
            sender.sendMessage("Error message: No permission");
        }
        return false;
    }
}