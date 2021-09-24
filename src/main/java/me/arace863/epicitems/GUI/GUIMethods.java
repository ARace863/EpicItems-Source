package me.arace863.epicitems.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUIMethods {

    public void openItemGUI(Player player) {
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
    }
}
