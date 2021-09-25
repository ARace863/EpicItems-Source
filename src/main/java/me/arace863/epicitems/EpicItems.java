package me.arace863.epicitems;

import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.*;
import me.arace863.epicitems.Utils.Databases.MySQL;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicItems extends JavaPlugin {
    public boolean updateAvailable = false;
    static EpicItems plugin;
    public MySQL sql;
    private static Economy economy = null;

    public EpicItems() {
    }

    public void onEnable() {
        plugin = this;
        plugin.saveConfig();

        StartupMethods methods = new StartupMethods(this);

        methods.startUpMessage();
        methods.checkForUpdate();
        methods.enableBstats();
        methods.checkForNoteBlockAPI();
        methods.registerCommands();
        methods.registerEvents();
        methods.updateConfig();

        ItemManager.init();
        Cooldown.setupCooldown();
        setupEconomy();

        //Save recipes
        ShapedRecipe sr;
        if (this.getConfig().getBoolean("EndermanSwordCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("endermansword"), ItemManager.EndermanSword);
            sr.shape(" E ", " E ", " S ");
            sr.setIngredient('E', Material.ENDER_PEARL);
            sr.setIngredient('S', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("AceSwordCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("acesword"), ItemManager.AceSword);
            sr.shape(" S ", " S ", " T ");
            sr.setIngredient('S', Material.IRON_BLOCK);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("RocketLauncherCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("rpg"), ItemManager.Rpg);
            sr.shape(" S ", " T ", " T ");
            sr.setIngredient('S', Material.GOLD_BLOCK);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("BonemerangCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("bonemerang"), ItemManager.Bonemerang);
            sr.shape("ST ", "S B", "ST ");
            sr.setIngredient('S', Material.STRING);
            sr.setIngredient('T', Material.BONE_BLOCK);
            sr.setIngredient('B', Material.BONE);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("GrapplingHookCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("grapplinghook"), ItemManager.GrapplingHook);
            sr.shape("  T", " TS", "T S");
            sr.setIngredient('S', Material.SPIDER_EYE);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("EndermanBowCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("endermanbow"), ItemManager.EndermanBow);
            sr.shape(" TS", "T S", " TS");
            sr.setIngredient('S', Material.ENDER_PEARL);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("ExplosiveBowCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("explosivebow"), ItemManager.ExplosiveBow);
            sr.shape(" TS", "T S", " TS");
            sr.setIngredient('S', Material.TNT);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("RunaansBowCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("triplestrikebow"), ItemManager.TripleStrikeBow);
            sr.shape(" TS", "T S", " TS");
            sr.setIngredient('S', Material.ARROW);
            sr.setIngredient('T', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("EvokerStaffCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("evokerstaff"), ItemManager.EvokerStaff);
            sr.shape(" EE", " S ", " S ");
            sr.setIngredient('S', Material.STICK);
            sr.setIngredient('E', Material.EMERALD);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("AirStrikeCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("airstrike"), ItemManager.Airstrike);
            sr.shape("SSS", "SES", "SSS");
            sr.setIngredient('S', Material.TNT);
            sr.setIngredient('E', Material.REDSTONE);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("KnockBackStickCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("knockstick"), ItemManager.KnockStick);
            sr.shape(" S ", " S ", " S ");
            sr.setIngredient('S', Material.STICK);
            Bukkit.getServer().addRecipe(sr);
        }
        if (this.getConfig().getBoolean("HealingSwordCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("healingsword"), ItemManager.HealingSword);
            sr.shape(" E ", " E ", " S ");
            sr.setIngredient('S', Material.STICK);
            sr.setIngredient('E', Material.GOLD_NUGGET);
            Bukkit.getServer().addRecipe(sr);
        }

        if (this.getConfig().getBoolean("UltraDrillCraft", true)) {
            sr = new ShapedRecipe(NamespacedKey.minecraft("ultradrill"), ItemManager.UltraDrill);
            sr.shape("EEE", " S ", " S ");
            sr.setIngredient('S', Material.STICK);
            sr.setIngredient('E', Material.GOLD_NUGGET);
            Bukkit.getServer().addRecipe(sr);
        }

        //Save config
        this.saveDefaultConfig();
    }

    public void onDisable() {
        //Disable message
        System.out.println("--------------------------------------");
        System.out.println(" ");
        System.out.println("  EpicItems plugin is shutting down");
        System.out.println(" ");
        System.out.println("--------------------------------------");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static EpicItems getInstance(){
        return plugin;
    }
}
