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
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ShapedRecipe;
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

        if (this.getConfig().getBoolean("EndermanSwordCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("endermansword"), ItemManager.EndermanSword);
            sr.shape(new String[]{" E ", " E ", " S "});
            sr.setIngredient('E', Material.ENDER_PEARL);
            sr.setIngredient('S', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("AceSwordCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("acesword"), ItemManager.AceSword);
            sr.shape(new String[]{" S ", " S ", " T "});
            sr.setIngredient('S', Material.IRON_BLOCK);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("RocketLauncherCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("rpg"), ItemManager.Rpg);
            sr.shape(new String[]{" S ", " T ", " T "});
            sr.setIngredient('S', Material.GOLD_BLOCK);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("BonemerangCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("bonemerang"), ItemManager.Bonemerang);
            sr.shape(new String[]{"ST ", "S B", "ST "});
            sr.setIngredient('S', Material.STRING);
            sr.setIngredient('T', Material.BONE_BLOCK);
            sr.setIngredient('B', Material.BONE);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("GrapplingHookCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("grapplinghook"), ItemManager.GrapplingHook);
            sr.shape(new String[]{"  T", " TS", "T S"});
            sr.setIngredient('S', Material.SPIDER_EYE);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("EndermanBowCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("endermanbow"), ItemManager.EndermanBow);
            sr.shape(new String[]{" TS", "T S", " TS"});
            sr.setIngredient('S', Material.ENDER_PEARL);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("ExplosiveBowCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("explosivebow"), ItemManager.ExplosiveBow);
            sr.shape(new String[]{" TS", "T S", " TS"});
            sr.setIngredient('S', Material.TNT);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("RunaansBowCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("triplestrikebow"), ItemManager.TripleStrikeBow);
            sr.shape(new String[]{" TS", "T S", " TS"});
            sr.setIngredient('S', Material.ARROW);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("EvokerStaffCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("evokerstaff"), ItemManager.EvokerStaff);
            sr.shape(new String[]{" EE", " S ", " S "});
            sr.setIngredient('S', Material.STICK);
            sr.setIngredient('E', Material.EMERALD);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("AirStrikeCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("airstrike"), ItemManager.Airstrike);
            sr.shape(new String[]{"SSS", "SES", "SSS"});
            sr.setIngredient('S', Material.TNT);
            sr.setIngredient('E', Material.REDSTONE);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("KnockBackStickCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("knockstick"), ItemManager.KnockStick);
            sr.shape(new String[]{" S ", " S ", " S "});
            sr.setIngredient('S', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("HealingSwordCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("healingsword"), ItemManager.HealingSword);
            sr.shape(new String[]{" E ", " E ", " S "});
            sr.setIngredient('S', Material.STICK);
            sr.setIngredient('E', Material.GOLD_NUGGET);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("UltraDrillCraft")){
            ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("ultradrill"), ItemManager.UltraDrill);
            sr.shape(new String[]{"EEE", " S ", " S "});
            sr.setIngredient('S', Material.STICK);
            sr.setIngredient('E', Material.GOLD_NUGGET);
            Bukkit.getServer().addRecipe(sr);
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
