package me.arace863.epicitems;

import me.arace863.epicitems.Commands.Commands;
import me.arace863.epicitems.Commands.TestCommands.MainCommand;
import me.arace863.epicitems.Commands.TestCommands.MainTab;
import me.arace863.epicitems.Events.*;
import me.arace863.epicitems.GUI.GUImoveItem;
import me.arace863.epicitems.GUI.ItemsGUI;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import me.arace863.epicitems.Utils.Metrics;
import me.arace863.epicitems.Utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicItems extends JavaPlugin {
    public boolean updateAvailable = false;


    public EpicItems() {
    }

    public void onEnable() {

        //Console Message
        System.out.println(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "       EpicItems has Started up!");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "                 v1.5");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + " WARNING: You cannot repost, sell or take");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "        credit for this plugin");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "--------------------------------------");
        Bukkit.getConsoleSender().sendMessage("  ");

        ItemManager.init();
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
        this.getServer().getPluginManager().registerEvents(new UltraDrillEvent(), this);

        //Cooldown
        Cooldown.setupCooldown();

        //Config
        this.saveDefaultConfig();

        if (this.getConfig().getBoolean("bStats", true)) {
            this.getLogger().info("Enabling plugin metrics");
            new Metrics(this, 12375);
        }

        if (this.getConfig().getBoolean("CheckForUpdates", true)) {
            this.getLogger().info("Checking for updates ...");
            (new UpdateChecker(this, 93541)).getVersion((version) -> {
                if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                    this.getLogger().info("There is no new update available.");
                } else {
                    this.getLogger().info("A new update is available! Go to https://www.spigotmc.org/resources/epic-items-custom-items.93541/ to download it");
                    this.updateAvailable = true;
                }

            });
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
}
