package me.arace863.epicitems.Commands;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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
import java.util.UUID;

public class MainCommand implements CommandExecutor {
    EpicItems plugin;
    FileConfiguration config;

    public MainCommand(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("epicitems")) { // Main command
            if (args.length == 0) {
                sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Running version " + this.plugin.getDescription().getVersion() + " Made by ARace863");
                sender.sendMessage(ChatColor.RED + "Usage: /epicitems <info>, <help>, <items>, <giveitem>, <stats>, <checkForEpicItem>");
                return true;
            }



            if (args.length >= 1) {

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
                    sender.sendMessage(ChatColor.RED + "report it here: " + ChatColor.BLUE + "§nhttps://discord.gg/A6Zd2e8Zbn§r§c or message ARace863#0171");
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
                    if (args[1].equalsIgnoreCase("acesword")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Ace Sword");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.AceSword});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Ace Sword");
                    }

                    if (args[1].equalsIgnoreCase("airstrike")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Airstrike");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.Airstrike});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Airstrike");
                    }

                    if (args[1].equalsIgnoreCase("bonemerang")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Bonemerang");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.Bonemerang});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Bonemerang");
                    }

                    if (args[1].equalsIgnoreCase("endermanbow")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Enderman Bow");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.EndermanBow});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Enderman Bow");
                    }

                    if (args[1].equalsIgnoreCase("endermansword")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Enderman Sword");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.EndermanSword});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Enderman Sword");
                    }

                    if (args[1].equalsIgnoreCase("evokerstaff")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Evoker Staff");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.EvokerStaff});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Evoker Staff");
                    }

                    if (args[1].equalsIgnoreCase("explosivebow")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Explosive Bow");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.ExplosiveBow});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Explosive Bow");
                    }

                    if (args[1].equalsIgnoreCase("grapplinghook")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Grappling Hook");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.GrapplingHook});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Grappling Hook");
                    }

                    if (args[1].equalsIgnoreCase("healingsword")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Healing Sword");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.HealingSword});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Healing Sword");
                    }

                    if (args[1].equalsIgnoreCase("knockbackstick")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Knockback Stick");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.KnockStick});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Knockback Stick");
                    }

                    if (args[1].equalsIgnoreCase("rocketlauncher")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Rocket Launcher");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.Rpg});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Rocket Launcher");
                    }

                    if (args[1].equalsIgnoreCase("runaansbow")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Runaan's Bow");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.TripleStrikeBow});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Runaan's Bow");
                    }

                    if (args[1].equalsIgnoreCase("ultradrill")) {
                        target = Bukkit.getPlayer(args[2]);
                        sender.sendMessage(ChatColor.GREEN + "You gave " + target.getDisplayName() + " the " + ChatColor.DARK_RED + "Ultra Drill");
                        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        target.getInventory().addItem(new ItemStack[]{ItemManager.UltraDrill});
                        target.sendMessage(ChatColor.GREEN + "You have recived the " + ChatColor.DARK_RED + "Ultra Drill");
                    }

                    return true;
                }

                if (args[0].equalsIgnoreCase("items")) {
                    if (sender instanceof Player){
                        Player player = (Player) sender;
                        Inventory gui = Bukkit.createInventory(player, 45, ChatColor.RED + "Epic Items");
                        ItemStack acesword = new ItemStack(Material.IRON_SWORD);
                        ItemStack endermansword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemStack bonemerang = new ItemStack(Material.BONE);
                        ItemStack rpg = new ItemStack(Material.GOLDEN_SHOVEL);
                        ItemStack hook = new ItemStack(Material.FISHING_ROD);
                        ItemStack ebow = new ItemStack(Material.BOW);
                        ItemStack explosivebow = new ItemStack(Material.TNT);
                        ItemStack triplestrikebow = new ItemStack(Material.ARROW);
                        ItemMeta aceswordmeta = acesword.getItemMeta();
                        aceswordmeta.setDisplayName(ChatColor.DARK_RED + "Ace Sword");
                        ArrayList<String> aceswordlore = new ArrayList();
                        aceswordlore.add("§7Damage: §c+50");
                        aceswordlore.add("");
                        aceswordlore.add("§6Item Ability: §e§lRIGHT CLICK");
                        aceswordlore.add("§7Teleport 8 blocks ahead and gain");
                        aceswordlore.add(ChatColor.GRAY + "speed while exploding surrounding blocks");
                        aceswordlore.add("");
                        aceswordlore.add(ChatColor.DARK_RED + "§lSUPREME");
                        aceswordmeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                        aceswordmeta.setLore(aceswordlore);
                        acesword.setItemMeta(aceswordmeta);
                        ItemMeta endermanswordmeta = endermansword.getItemMeta();
                        endermanswordmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Enderman Sword");
                        ArrayList<String> endermanswordlore = new ArrayList();
                        endermanswordlore.add("§7Damage: §c+20");
                        endermanswordlore.add("");
                        endermanswordlore.add("§6Item Abulity: §e§lRIGHT CLICK");
                        endermanswordlore.add("§7Teleport 8 blocks ahead and gain speed");
                        endermanswordlore.add("");
                        endermanswordlore.add(ChatColor.LIGHT_PURPLE + "§lMYTHIC");
                        endermanswordmeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                        endermanswordmeta.setLore(endermanswordlore);
                        endermansword.setItemMeta(endermanswordmeta);
                        ItemMeta bonemerangmeta = bonemerang.getItemMeta();
                        bonemerangmeta.setDisplayName(ChatColor.GOLD + "Bonemerang");
                        ArrayList<String> bonemeranglore = new ArrayList();
                        bonemeranglore.add("§7Damage: §c+70");
                        bonemeranglore.add("");
                        bonemeranglore.add("§6Item Ability: Swing §e§lRIGHT CLICK");
                        bonemeranglore.add("§7Throw bone a short distance, dealing");
                        bonemeranglore.add("§7the damage an arrow would.");
                        bonemeranglore.add("§7Deals §cdouble damage§7 when coming back.");
                        bonemeranglore.add("§7Pierces up to §e10 §7foes");
                        bonemeranglore.add(" ");
                        bonemeranglore.add("§6§lLEGENDARY BOW");
                        bonemerangmeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                        bonemerangmeta.setLore(bonemeranglore);
                        bonemerang.setItemMeta(bonemerangmeta);
                        ItemMeta rpgmeta = rpg.getItemMeta();
                        rpgmeta.setDisplayName(ChatColor.GOLD + "Rocket Launcher");
                        ArrayList<String> lore = new ArrayList();
                        lore.add("§7Damage: §c+70");
                        lore.add("");
                        lore.add("§6Item Ability: Ricochet Rocket §e§lRIGHT CLICK");
                        lore.add("§7Fires a rocket that explodes for");
                        lore.add("§c1,000 §7damage and when ricocheting");
                        lore.add("§7off the ground creates explosions for");
                        lore.add("§7half the damage");
                        lore.add("");
                        lore.add(ChatColor.GOLD + "§lLEGENDARY");
                        rpgmeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                        rpgmeta.setLore(lore);
                        rpg.setItemMeta(rpgmeta);
                        ItemMeta hookmeta = hook.getItemMeta();
                        hookmeta.setDisplayName(ChatColor.GREEN + "Grappling Hook");
                        ArrayList<String> alore = new ArrayList();
                        alore.add("§7Travel around in style using");
                        alore.add("§7this Grappling Hook.");
                        alore.add("");
                        alore.add("§a§lUNCOMMON");
                        hookmeta.setLore(alore);
                        hook.setItemMeta(hookmeta);
                        ItemMeta ebowmeta = ebow.getItemMeta();
                        ebowmeta.setDisplayName(ChatColor.GOLD + "Enderman Bow");
                        ArrayList<String> ebowlore = new ArrayList();
                        ebowlore.add("§7Damage: §c+70");
                        ebowlore.add("");
                        ebowlore.add("§6Item Ability: Teleport");
                        ebowlore.add("§7Teleport wherever your");
                        ebowlore.add("§7arrow lands.");
                        ebowlore.add(" ");
                        ebowlore.add("§6§lLEGENDARY");
                        ebowmeta.setLore(ebowlore);
                        ebow.setItemMeta(ebowmeta);
                        ItemMeta expbowmeta = explosivebow.getItemMeta();
                        expbowmeta.setDisplayName(ChatColor.GOLD + "Explosive Bow");
                        ArrayList<String> abclore = new ArrayList();
                        abclore.add("§7Damage: §c+50");
                        abclore.add("");
                        abclore.add("§6Item Ability: Missile");
                        abclore.add("§7Creates an explosion for");
                        abclore.add("§7wherever your arrow lands.");
                        abclore.add(" ");
                        abclore.add("§6§lLEGENDARY");
                        expbowmeta.setLore(abclore);
                        explosivebow.setItemMeta(expbowmeta);
                        ItemMeta trpstrikebowmeta = triplestrikebow.getItemMeta();
                        trpstrikebowmeta.setDisplayName(ChatColor.GOLD + "Runaan's Bow");
                        ArrayList<String> abcloree = new ArrayList();
                        abcloree.add("§7Damage: §c+50");
                        abcloree.add("");
                        abcloree.add(ChatColor.GOLD + "Item Ability: Triple Shot §e§lRIGHT CLICK");
                        abcloree.add("§7Shoot 3 multiple arrows but");
                        abcloree.add("§7shares your damage");
                        abcloree.add("§7with the arrows.");
                        abcloree.add("");
                        abcloree.add(ChatColor.GOLD + "§lLEGENDARY");
                        trpstrikebowmeta.setLore(abcloree);
                        triplestrikebow.setItemMeta(trpstrikebowmeta);
                        ItemStack[] menu_items = new ItemStack[]{acesword, endermansword, bonemerang, rpg, hook, ebow, explosivebow, triplestrikebow};
                        gui.setContents(menu_items);
                        player.openInventory(gui);
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
                        if (player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore() != null && player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§8EpicItem")) {
                            player.sendMessage(ChatColor.AQUA + "[EpicItems] §aSuccess! Detected an EpicItem");
                        } else {
                            player.sendMessage(ChatColor.AQUA + "[EpicItems] §cThat is not an EpicItem");
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

            }
        }
        return false;
    }
}
