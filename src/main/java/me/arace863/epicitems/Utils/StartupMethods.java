/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Utils;

import me.arace863.epicitems.Commands.Commands;
import me.arace863.epicitems.Commands.MainCommand;
import me.arace863.epicitems.Commands.MainTab;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Events.*;
import me.arace863.epicitems.Events.ItemAbilities.*;
import me.arace863.epicitems.GUI.GUImoveItem;
import me.arace863.epicitems.GUI.ItemsGUI;
import me.arace863.epicitems.Items.AddIdentifierLore;
import me.arace863.epicitems.Utils.Updaters.ConfigUpdater;
import me.arace863.epicitems.Utils.Updaters.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class StartupMethods {
    EpicItems plugin;

    public StartupMethods(EpicItems plugin) {
        this.plugin = plugin;
    }

    public void startUpMessage() {
        System.out.println(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "---------------[ EpicItems ]---------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "         Started up successfully");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "                  v" + plugin.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "       Spigot API version: " + plugin.getDescription().getAPIVersion() + "-1.17");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "             Plugin Key: 93541");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "            Made by ARace863");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "            Server Version:");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + " " + Bukkit.getVersion());
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "-------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(" ");
    }

    public void checkForUpdate() {
        if (plugin.getConfig().getBoolean("CheckForUpdates", true)) {
            plugin.getLogger().info("Checking for updates ...");
            (new UpdateChecker(plugin, 93541)).getVersion((version) -> {
                if (plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                    plugin.getLogger().info("There is no new update available.");
                } else {
                    plugin.getLogger().info("A new update is available! Go to https://www.spigotmc.org/resources/epic-items-custom-items.93541/ to download it");
                    plugin.updateAvailable = true;
                }

            });
        } else {
            System.out.println("[EpicItems] Disabled Update Checker");
        }
    }

    public void enableBstats() {
        if (plugin.getConfig().getBoolean("bStats", true)) {
            plugin.getLogger().info("Enabling metrics ...");
            new Metrics(plugin, 12375);
        } else {
            System.out.println("Disabled bStats");
        }
    }

    public void checkForNoteBlockAPI() {
        if (plugin.getConfig().getBoolean("CheckForNoteBlockAPI", true)) {
            boolean NoteBlockAPI = true;
            if (!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")) {
                System.out.println(" ");
                Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "                ! WARNING - EpicItems !");
                System.out.println(" ");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Please install NoteBlockAPI for certain features within EpicItems");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Install here: https://www.spigotmc.org/resources/noteblockapi.19287/");
                System.out.println(" ");
                NoteBlockAPI = false;
            }
        }
    }

    public void registerCommands() {
        plugin.getCommand("endermansword").setExecutor(new Commands(plugin));
        plugin.getCommand("acesword").setExecutor(new Commands(plugin));
        plugin.getCommand("rpg").setExecutor(new Commands(plugin));
        plugin.getCommand("bonemerang").setExecutor(new Commands(plugin));
        plugin.getCommand("items").setExecutor(new ItemsGUI(plugin));
        plugin.getCommand("grapplinghook").setExecutor(new Commands(plugin));
        plugin.getCommand("endermanbow").setExecutor(new Commands(plugin));
        plugin.getCommand("explosivebow").setExecutor(new Commands(plugin));
        plugin.getCommand("runaansbow").setExecutor(new Commands(plugin));
        plugin.getCommand("evokerstaff").setExecutor(new Commands(plugin));
        plugin.getCommand("airstrike").setExecutor(new Commands(plugin));
        plugin.getCommand("knockbackstick").setExecutor(new Commands(plugin));
        plugin.getCommand("healingsword").setExecutor(new Commands(plugin));
        plugin.getCommand("ultradrill").setExecutor(new Commands(plugin));
        plugin.getCommand("epicstore").setExecutor(new Commands(plugin));
        plugin.getCommand("epicitems").setExecutor(new MainCommand(plugin));
        plugin.getCommand("epicitems").setTabCompleter(new MainTab());
        plugin.getCommand("epicmenu").setExecutor(new Commands(plugin));
        plugin.getCommand("stealthstrike").setExecutor(new Commands(plugin));

        plugin.getCommand("loadmap").setExecutor(new Commands(plugin));
    }

    public void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new BonemerangEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new RocketLauncherEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EndermanSwordEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AceSwordEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GUImoveItem(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GrapplingHookEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new CustomDropEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new RunaansBowEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EvokerStaffEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Test(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new UpdatePlayerEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EndermanBowEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new HealingSwordEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new UltraDrillEvent(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new NoteBlockAPIcheck(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new AddIdentifierLore(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new StealthStrikeEvent(plugin), plugin);
    }

    public void updateConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");

        try {
            ConfigUpdater.update(plugin, "config.yml", configFile, Arrays.asList());
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        plugin.reloadConfig();
    }
}
