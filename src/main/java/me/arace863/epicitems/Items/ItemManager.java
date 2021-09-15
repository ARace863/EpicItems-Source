package me.arace863.epicitems.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    public static ItemStack EndermanSword;
    public static ItemStack AceSword;
    public static ItemStack Rpg;
    public static ItemStack Bonemerang;
    public static ItemStack GrapplingHook;
    public static ItemStack EndermanBow;
    public static ItemStack ExplosiveBow;
    public static ItemStack TripleStrikeBow;
    public static ItemStack Quiver;
    public static ItemStack EvokerStaff;
    public static ItemStack Airstrike;
    public static ItemStack KnockStick;
    public static ItemStack HealingSword;
    public static ItemStack UltraDrill;

    public ItemManager() {
    }

    public static void init() {
        createEndermanSword();
        createAceSword();
        createRpg();
        createBonemerang();
        createGrapplingHook();
        createEndermanBow();
        createExplosiveBow();
        createTripleStrikeBow();
        createQuiver();
        createEvokerStaff();
        createAirStrike();
        createKnockStick();
        createHealingSword();
        createUltraDrill();
    }

    private static void createEndermanSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§dEnderman Sword");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+15");
        lore.add("");
        lore.add("§6Item Ability: §e§lRIGHT CLICK");
        lore.add("§7Teleport 8 blocks ahead and gain speed");
        lore.add(" ");
        lore.add(ChatColor.LIGHT_PURPLE + "§lMYTHIC");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15.0D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.05D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        item.setItemMeta(meta);
        EndermanSword = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("endermansword"), item);
        sr.shape(new String[]{" E ", " E ", " S "});
        sr.setIngredient('E', Material.ENDER_PEARL);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createAceSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4♠ Ace Sword");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+15");
        lore.add("");
        lore.add("§6Item Ability: §e§lRIGHT CLICK");
        lore.add("§7Teleport 8 blocks ahead and gain");
        lore.add(ChatColor.GRAY + "speed while exploding surrounding blocks");
        lore.add("");
        lore.add(ChatColor.DARK_RED + "§lSUPREME");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15.0D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        AttributeModifier attackspeed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 100.0D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackspeed);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        item.setItemMeta(meta);
        AceSword = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("acesword"), item);
        sr.shape(new String[]{" S ", " S ", " T "});
        sr.setIngredient('S', Material.IRON_BLOCK);
        sr.setIngredient('T', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createRpg() {
        ItemStack item = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Rocket Launcher");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+70");
        lore.add("");
        lore.add("§6Item Ability: Ricochet Rocket §e§lRIGHT CLICK");
        lore.add("§7Fires a rocket that explodes for");
        lore.add("§c1,000 §7damage and when ricocheting");
        lore.add("§7off the ground creates explosions for");
        lore.add("§7half the damage");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 1 second");
        lore.add("");
        lore.add(ChatColor.GOLD + "§lLEGENDARY");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5.0D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        Rpg = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("rpg"), item);
        sr.shape(new String[]{" S ", " T ", " T "});
        sr.setIngredient('S', Material.GOLD_BLOCK);
        sr.setIngredient('T', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createBonemerang() {
        ItemStack item = new ItemStack(Material.BONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Bonemerang");
        item.addUnsafeEnchantment(Enchantment.PIERCING, 100);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+25");
        lore.add("");
        lore.add("§6Item Ability: Swing §e§lRIGHT CLICK");
        lore.add("§7Throw bone a short distance, dealing");
        lore.add("§7the damage an arrow would.");
        lore.add("§7Deals §cdouble damage§7 when coming back.");
        lore.add("§7Pierces up to §e10 §7foes");
        lore.add(" ");
        lore.add("§6§lLEGENDARY BOW");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Bonemerang = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("bonemerang"), item);
        sr.shape(new String[]{"ST ", "S B", "ST "});
        sr.setIngredient('S', Material.STRING);
        sr.setIngredient('T', Material.BONE_BLOCK);
        sr.setIngredient('B', Material.BONE);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createGrapplingHook() {
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aGrappling Hook");
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Travel around in style using");
        lore.add("§7this Grappling Hook.");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 2 seconds");
        lore.add("");
        lore.add("§a§lUNCOMMON");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        GrapplingHook = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("grapplinghook"), item);
        sr.shape(new String[]{"  T", " TS", "T S"});
        sr.setIngredient('S', Material.SPIDER_EYE);
        sr.setIngredient('T', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createEndermanBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cEnderman Bow [UNFINISHED]");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+10");
        lore.add("");
        lore.add("§6Item Ability: Teleport §e§lRIGHT CLICK");
        lore.add("§7Teleport wherever your");
        lore.add("§7arrow lands.");
        lore.add(" ");
        lore.add("§c§lUNFINISHED");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        EndermanBow = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("endermanbow"), item);
        sr.shape(new String[]{" TS", "T S", " TS"});
        sr.setIngredient('S', Material.ENDER_PEARL);
        sr.setIngredient('T', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createExplosiveBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cExplosive Bow [UNFINISHED]");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+10");
        lore.add("");
        lore.add(ChatColor.GOLD + "Item Ability: Missile");
        lore.add("§7Creates an explosion for");
        lore.add("§7wherever your arrow lands.");
        lore.add(" ");
        lore.add(ChatColor.RED + "§lUNFINISHED");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        ExplosiveBow = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("explosivebow"), item);
        sr.shape(new String[]{" TS", "T S", " TS"});
        sr.setIngredient('S', Material.TNT);
        sr.setIngredient('T', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createTripleStrikeBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Runaan's Bow");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+50");
        lore.add("");
        lore.add(ChatColor.GOLD + "Item Ability: Triple Shot §e§lRIGHT CLICK");
        lore.add("§7Shoot 3 multiple arrows but");
        lore.add("§7shares your damage");
        lore.add("§7with the arrows.");
        lore.add("");
        lore.add(ChatColor.GOLD + "§lLEGENDARY");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        TripleStrikeBow = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("triplestrikebow"), item);
        sr.shape(new String[]{" TS", "T S", " TS"});
        sr.setIngredient('S', Material.ARROW);
        sr.setIngredient('T', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createQuiver() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Quiver");
        List<String> lore = new ArrayList();
        lore.add("When a bow is held, this");
        lore.add("quiver will give you arrows to shoot!");
        lore.add("");
        lore.add(ChatColor.AQUA + "§lSPECIAL");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Quiver = item;
    }

    private static void createEvokerStaff() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Evoker Staff");
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+20");
        lore.add("§7Ability Damage: §c+40");
        lore.add("");
        lore.add("§6Item Ability: Claws §e§lRIGHT CLICK");
        lore.add("§7Summons the deadly fangs of");
        lore.add("§7an Evoker, use with caution.");
        lore.add(" ");
        lore.add("§81 Second cooldown.");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        EvokerStaff = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("evokerstaff"), item);
        sr.shape(new String[]{" EE", " S ", " S "});
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('E', Material.EMERALD);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createAirStrike() {
        ItemStack item = new ItemStack(Material.SEA_PICKLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Airstrike");
        List<String> lore = new ArrayList();
        lore.add("");
        lore.add("§6Item Ability: Missile §e§lRIGHT CLICK");
        lore.add("§7Right click on the ground location you want");
        lore.add("§7to be destroyed with TNT impact");
        lore.add(ChatColor.DARK_GRAY + "10 Second cooldown");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Airstrike = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("airstrike"), item);
        sr.shape(new String[]{"SSS", "SES", "SSS"});
        sr.setIngredient('S', Material.TNT);
        sr.setIngredient('E', Material.REDSTONE);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createKnockStick() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Knockback Stick");
        meta.addEnchant(Enchantment.KNOCKBACK, 5, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        List<String> lore = new ArrayList();
        lore.add(" ");
        lore.add(ChatColor.BLUE + "§lRARE");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        KnockStick = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("knockstick"), item);
        sr.shape(new String[]{" S ", " S ", " S "});
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createHealingSword() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Healing Sword");
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+5");
        lore.add(" ");
        lore.add("§6Item Ability: Super Heal §e§lRIGHT CLICK");
        lore.add("§7Right click to heal you fully");
        lore.add(" ");
        lore.add(ChatColor.BLUE + "§lRARE");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        HealingSword = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("healingsword"), item);
        sr.shape(new String[]{" E ", " E ", " S "});
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('E', Material.GOLD_NUGGET);
        Bukkit.getServer().addRecipe(sr);
    }

    private static void createUltraDrill() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Ultra Drill");
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add(" ");
        lore.add("§6Item Ability: Super Mine §e§lRIGHT CLICK");
        lore.add("§7Use this drill to mine a ");
        lore.add("§73x3 area.");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        UltraDrill = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("ultradrill"), item);
        sr.shape(new String[]{"EEE", " S ", " S "});
        sr.setIngredient('S', Material.STICK);
        sr.setIngredient('E', Material.GOLD_NUGGET);
        Bukkit.getServer().addRecipe(sr);
    }
}

