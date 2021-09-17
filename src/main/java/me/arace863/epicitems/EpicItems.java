package me.arace863.epicitems;

import me.arace863.epicitems.Commands.Commands;
import me.arace863.epicitems.Commands.MainCommand;
import me.arace863.epicitems.Commands.MainTab;
import me.arace863.epicitems.Events.*;
import me.arace863.epicitems.GUI.GUImoveItem;
import me.arace863.epicitems.GUI.ItemsGUI;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.ConfigUpdater;
import me.arace863.epicitems.Utils.Cooldown;
import me.arace863.epicitems.Utils.Metrics;
import me.arace863.epicitems.Utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public final class EpicItems extends JavaPlugin {
    public boolean updateAvailable = false;
    static EpicItems plugin;
    private File messagesf;
    public FileConfiguration messages;


    public EpicItems() {
    }

    public void onEnable() {

        plugin = this;

        //Console Message
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
        Bukkit.getConsoleSender().sendMessage("  ");

        plugin.saveConfig();

        //Commands
        this.getCommand("endermansword").setExecutor(new Commands());
        this.getCommand("acesword").setExecutor(new Commands());
        this.getCommand("rpg").setExecutor(new Commands());
        this.getCommand("bonemerang").setExecutor(new Commands());
        this.getCommand("items").setExecutor(new ItemsGUI());
        this.getCommand("grapplinghook").setExecutor(new Commands());
        this.getCommand("endermanbow").setExecutor(new Commands());
        this.getCommand("explosivebow").setExecutor(new Commands());
        this.getCommand("gmc").setExecutor(new Commands());
        this.getCommand("gms").setExecutor(new Commands());
        this.getCommand("heal").setExecutor(new Commands());
        this.getCommand("runaansbow").setExecutor(new Commands());
        this.getCommand("evokerstaff").setExecutor(new Commands());
        this.getCommand("airstrike").setExecutor(new Commands());
        this.getCommand("knockbackstick").setExecutor(new Commands());
        this.getCommand("healingsword").setExecutor(new Commands());
        this.getCommand("ultradrill").setExecutor(new Commands());
        this.getCommand("epicitems").setExecutor(new MainCommand(this));
        this.getCommand("epicitems").setTabCompleter(new MainTab());



        //Events
        this.getServer().getPluginManager().registerEvents(new BonemerangEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new RocketLauncherEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new EndermanSwordEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new AceSwordEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new GUImoveItem(), this);
        this.getServer().getPluginManager().registerEvents(new GrapplingHookEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new CustomDropEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new RunaansBowEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new EvokerStaffEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new Test(this), this);
        this.getServer().getPluginManager().registerEvents(new UpdatePlayerEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new EndermanBowEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new HealingSwordEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new UltraDrillEvent(this), this);
        this.getServer().getPluginManager().registerEvents(new NoteBlockAPIcheck(this), this);


        //Item Manager
        ItemManager.init();


        //Cooldown
        Cooldown.setupCooldown();


        //Config
        this.saveDefaultConfig();
        messagesf = new File(getDataFolder(), "messages.yml");
        messages = new YamlConfiguration();


        if (!messagesf.exists()){
            messagesf.getParentFile().mkdirs();
            saveResource("messages.yml", false);
        }

        try {
            messages.load(messagesf);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        //Config Updater
        saveDefaultConfig();

        //The config needs to exist before using the updater
        File configFile = new File(getDataFolder(), "config.yml");
        File messagesFile = new File(getDataFolder(), "messages.yml");

        try {
            ConfigUpdater.update(plugin, "config.yml", configFile, Arrays.asList());
            ConfigUpdater.update(plugin, "messages.yml", messagesFile, Arrays.asList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        reloadConfig();

        //Checkers
        if (this.getConfig().getBoolean("bStats", true)) {
            this.getLogger().info(messages.getString("bStatsEnabled"));
            new Metrics(this, 12375);
        }else{
            System.out.println(messages.getString("disabledBstats"));
        }


        if (this.getConfig().getBoolean("CheckForUpdates", true)) {
            this.getLogger().info(messages.getString("preCheckForUpdatesMessage"));
            (new UpdateChecker(this, 93541)).getVersion((version) -> {
                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    this.getLogger().info(messages.getString("noUpdate"));
                } else {
                    this.getLogger().info(messages.getString("foundUpdate"));
                    this.updateAvailable = true;
                }

            });
        }else{
            System.out.println(messages.getString("disabledUpdateChecker"));
        }


        if (this.getConfig().getBoolean("CheckForNoteBlockAPI", true)){
            boolean NoteBlockAPI = true;
            if (!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                System.out.println(" ");
                Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "                ! WARNING - EpicItems !");
                System.out.println(" ");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Please install NoteBlockAPI for certain features within EpicItems");
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Install here: https://www.spigotmc.org/resources/noteblockapi.19287/");
                System.out.println(" ");
                NoteBlockAPI = false;
                return;
            }
        }

    }


    public void onDisable() {
        //Disable message
        System.out.println("--------------------------------------");
        System.out.println(" ");
        System.out.println("  EpicItems plugin is shutting down");
        System.out.println(" ");
        System.out.println("--------------------------------------");
    }

    public static EpicItems getInstance(){
        return plugin;
    }
}
