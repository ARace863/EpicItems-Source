package me.arace863.epicitems.GUI;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.UtilOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class GUIMethods {
    EpicItems plugin;

    public GUIMethods(EpicItems plugin){
        this.plugin = plugin;
    }

    public void openItemGUI(Player player) {
        Inventory gui = Bukkit.createInventory(player, 45, ChatColor.RED + "Items | EpicItems");
        ItemStack acesword = new ItemStack(Material.IRON_SWORD);
        ItemStack endermansword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack bonemerang = new ItemStack(Material.BONE);
        ItemStack rpg = new ItemStack(Material.GOLDEN_SHOVEL);
        ItemStack hook = new ItemStack(Material.FISHING_ROD);
        ItemStack ebow = new ItemStack(Material.BOW);
        ItemStack explosivebow = new ItemStack(Material.TNT);
        ItemStack triplestrikebow = new ItemStack(Material.ARROW);
        ItemStack air = new ItemStack(Material.AIR);
        ItemStack backtomenu = new ItemStack(Material.BARRIER);

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

        ItemMeta backmeta = backtomenu.getItemMeta();
        backmeta.setDisplayName(ChatColor.RED + "Go back to menu");
        backtomenu.setItemMeta(backmeta);

        ItemStack[] menu_items = new ItemStack[]{acesword, endermansword, bonemerang, rpg, hook, ebow, explosivebow, triplestrikebow, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, backtomenu};
        gui.setContents(menu_items);
        player.openInventory(gui);
    }

    public void openVaultStoreGUI(Player player){
        Inventory gui = Bukkit.createInventory(player, 45, ChatColor.RED + "Store | EpicItems");
        ItemStack acesword = new ItemStack(Material.IRON_SWORD);
        ItemStack airstrike = new ItemStack(Material.SEA_PICKLE);
        ItemStack bonemerang = new ItemStack(Material.BONE);
        ItemStack endermanbow = new ItemStack(Material.ENDER_PEARL);
        ItemStack endermansword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack evokerstaff = new ItemStack(Material.NETHERITE_HOE);
        ItemStack explosivebow = new ItemStack(Material.TNT);
        ItemStack grapplinghook = new ItemStack(Material.FISHING_ROD);
        ItemStack healingsword = new ItemStack(Material.GOLDEN_SWORD);
        ItemStack knockbackstick = new ItemStack(Material.STICK);
        ItemStack rpg = new ItemStack(Material.GOLDEN_SHOVEL);
        ItemStack runaansbow = new ItemStack(Material.ARROW);
        ItemStack ultradrill = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemStack air = new ItemStack(Material.AIR);
        ItemStack buyAll = new ItemStack(Material.EMERALD);
        ItemStack backtomenu = new ItemStack(Material.BARRIER);

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
        aceswordlore.add(" ");
        aceswordlore.add(ChatColor.GREEN + "$2,500");
        aceswordmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        aceswordmeta.setLore(aceswordlore);
        acesword.setItemMeta(aceswordmeta);

        ItemMeta airstrikemeta = airstrike.getItemMeta();
        airstrikemeta.setDisplayName(ChatColor.DARK_PURPLE + "Airstrike");
        List<String> lore = new ArrayList();
        lore.add("");
        lore.add("§6Item Ability: Missile §e§lRIGHT CLICK");
        lore.add("§7Right click on the ground location you want");
        lore.add("§7to be destroyed with TNT impact");
        lore.add(ChatColor.DARK_GRAY + "10 Second cooldown");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add(ChatColor.GREEN + "$1,500");
        aceswordmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        airstrikemeta.setLore(lore);
        airstrike.setItemMeta(airstrikemeta);

        ItemMeta bonemerangmeta = bonemerang.getItemMeta();
        bonemerangmeta.setDisplayName(ChatColor.GOLD + "Bonemerang");
        List<String> lore1 = new ArrayList();
        lore1.add("");
        lore1.add("§7Damage: §c+25");
        lore1.add("");
        lore1.add("§6Item Ability: Swing §e§lRIGHT CLICK");
        lore1.add("§7Throw bone a short distance, dealing");
        lore1.add("§7the damage an arrow would.");
        lore1.add("§7Deals §cdouble damage§7 when coming back.");
        lore1.add("§7Pierces up to §e10 §7foes");
        lore1.add(" ");
        lore1.add("§6§lLEGENDARY BOW");
        lore1.add(" ");
        lore1.add(ChatColor.GREEN + "$2,000");
        bonemerangmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bonemerangmeta.setLore(lore1);
        bonemerang.setItemMeta(bonemerangmeta);

        ItemMeta endermanbowmeta = endermanbow.getItemMeta();
        endermanbowmeta.setDisplayName("§cEnderman Bow");
        List<String> lore2 = new ArrayList();
        lore2.add("");
        lore2.add("§7Damage: §c+10");
        lore2.add("");
        lore2.add("§6Item Ability: Teleport §e§lRIGHT CLICK");
        lore2.add("§7Teleport wherever your");
        lore2.add("§7arrow lands.");
        lore2.add(" ");
        lore2.add("§c§lUNFINISHED");
        lore2.add(" ");
        lore2.add(ChatColor.RED + "Cannot be purchased at this time.");
        endermanbowmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        endermanbowmeta.setLore(lore2);
        endermanbow.setItemMeta(endermanbowmeta);

        ItemMeta endermanswordmeta = endermansword.getItemMeta();
        endermanswordmeta.setDisplayName("§dEnderman Sword");
        List<String> lore3 = new ArrayList();
        lore3.add("");
        lore3.add("§7Damage: §c+15");
        lore3.add("");
        lore3.add("§6Item Ability: §e§lRIGHT CLICK");
        lore3.add("§7Teleport 8 blocks ahead and gain speed");
        lore3.add(" ");
        lore3.add(ChatColor.LIGHT_PURPLE + "§lMYTHIC");
        lore3.add(" ");
        lore3.add(ChatColor.GREEN + "$2,750");
        endermanswordmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        endermanswordmeta.setLore(lore3);
        endermansword.setItemMeta(endermanswordmeta);

        ItemMeta evokerstaffmeta = evokerstaff.getItemMeta();
        evokerstaffmeta.setDisplayName(ChatColor.DARK_PURPLE + "Evoker Staff");
        List<String> lore4 = new ArrayList();
        lore4.add("§7Damage: §c+20");
        lore4.add("§7Ability Damage: §c+40");
        lore4.add("");
        lore4.add("§6Item Ability: Claws §e§lRIGHT CLICK");
        lore4.add("§7Summons the deadly fangs of");
        lore4.add("§7an Evoker, use with caution.");
        lore4.add(" ");
        lore4.add("§81 Second cooldown.");
        lore4.add(" ");
        lore4.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore4.add(" ");
        lore4.add(ChatColor.GREEN + "$1,050");
        evokerstaffmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        evokerstaffmeta.setLore(lore4);
        evokerstaff.setItemMeta(evokerstaffmeta);

        ItemMeta explosivebowmeta = explosivebow.getItemMeta();
        explosivebowmeta.setDisplayName("§cExplosive Bow [UNFINISHED]");
        List<String> lore5 = new ArrayList();
        lore5.add(" ");
        lore5.add("§7Damage: §c+10");
        lore5.add("");
        lore5.add(ChatColor.GOLD + "Item Ability: Missile");
        lore5.add("§7Creates an explosion for");
        lore5.add("§7wherever your arrow lands.");
        lore5.add(" ");
        lore5.add(ChatColor.RED + "§lUNFINISHED");
        lore5.add(" ");
        lore5.add(ChatColor.RED + "Unable to purchase at this time.");
        explosivebowmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        explosivebowmeta.setLore(lore5);
        explosivebow.setItemMeta(explosivebowmeta);

        ItemMeta grapplinghookmeta = grapplinghook.getItemMeta();
        grapplinghookmeta.setDisplayName(ChatColor.GREEN + "Grappling Hook");
        List<String> lore6 = new ArrayList();
        lore6.add("");
        lore6.add("§7Travel around in style using");
        lore6.add("§7this Grappling Hook.");
        lore6.add(ChatColor.DARK_GRAY + "Cooldown: 2 seconds");
        lore6.add("");
        lore6.add("§a§lUNCOMMON");
        lore6.add(" ");
        lore6.add(ChatColor.GREEN + "$500");
        grapplinghookmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        grapplinghookmeta.setLore(lore6);
        grapplinghook.setItemMeta(grapplinghookmeta);

        ItemMeta healingswordmeta = healingsword.getItemMeta();
        healingswordmeta.setDisplayName(ChatColor.BLUE + "Healing Sword");
        List<String> lore7 = new ArrayList();
        lore7.add("");
        lore7.add("§7Damage: §c+5");
        lore7.add(" ");
        lore7.add("§6Item Ability: Super Heal §e§lRIGHT CLICK");
        lore7.add("§7Right click to heal you fully");
        lore7.add(" ");
        lore7.add(ChatColor.BLUE + "§lRARE");
        lore7.add(" ");
        lore7.add(ChatColor.GREEN + "$1,000");
        healingswordmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        healingswordmeta.setLore(lore7);
        healingsword.setItemMeta(healingswordmeta);

        ItemMeta knockbackstickmeta = knockbackstick.getItemMeta();
        knockbackstickmeta.setDisplayName(ChatColor.BLUE + "Knockback Stick");
        List<String> lore8 = new ArrayList();
        lore8.add(" ");
        lore8.add(ChatColor.BLUE + "§lRARE");
        lore8.add(" ");
        lore8.add(ChatColor.GREEN + "$10");
        knockbackstickmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        knockbackstickmeta.setLore(lore8);
        knockbackstick.setItemMeta(knockbackstickmeta);

        ItemMeta rpgmeta = rpg.getItemMeta();
        rpgmeta.setDisplayName("§6Rocket Launcher");
        List<String> lore9 = new ArrayList();
        lore8.add(" ");
        lore9.add("§7Damage: §c+70");
        lore9.add("");
        lore9.add("§6Item Ability: Ricochet Rocket §e§lRIGHT CLICK");
        lore9.add("§7Fires a rocket that explodes for");
        lore9.add("§c1,000 §7damage and when ricocheting");
        lore9.add("§7off the ground creates explosions for");
        lore9.add("§7half the damage");
        lore9.add(ChatColor.DARK_GRAY + "Cooldown: 1 second");
        lore9.add("");
        lore9.add(ChatColor.GOLD + "§lLEGENDARY");
        lore9.add(" ");
        lore9.add(ChatColor.GREEN + "$10,000");
        rpgmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        rpgmeta.setLore(lore9);
        rpg.setItemMeta(rpgmeta);

        ItemMeta tsbmeta = runaansbow.getItemMeta();
        tsbmeta.setDisplayName("§6Runaan's Bow");
        List<String> lore10 = new ArrayList();
        lore10.add(" ");
        lore10.add("§7Damage: §c+50");
        lore10.add("");
        lore10.add(ChatColor.GOLD + "Item Ability: Triple Shot §e§lRIGHT CLICK");
        lore10.add("§7Shoot 3 multiple arrows but");
        lore10.add("§7shares your damage");
        lore10.add("§7with the arrows.");
        lore10.add("");
        lore10.add(ChatColor.GOLD + "§lLEGENDARY");
        lore10.add(" ");
        lore10.add(ChatColor.GREEN + "$3,000");
        tsbmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        tsbmeta.setLore(lore10);
        runaansbow.setItemMeta(tsbmeta);

        ItemMeta ultradrillmeta = runaansbow.getItemMeta();
        ultradrillmeta.setDisplayName(ChatColor.DARK_PURPLE + "Ultra Drill");
        List<String> lore11 = new ArrayList();
        lore11.add(" ");
        lore11.add("§6Item Ability: Super Mine §e§lRIGHT CLICK");
        lore11.add("§7Use this drill to mine a ");
        lore11.add("§73x3 area.");
        lore11.add(" ");
        lore11.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore11.add(" ");
        lore11.add(ChatColor.GREEN + "$1,600");
        ultradrillmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ultradrillmeta.setLore(lore11);
        ultradrill.setItemMeta(ultradrillmeta);

        ItemMeta buyallmeta = buyAll.getItemMeta();
        buyallmeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Buy All Items");
        List<String> loreALL = new ArrayList();
        loreALL.add(" ");
        loreALL.add(ChatColor.GRAY + "Click on the emerald to buy");
        loreALL.add(ChatColor.GRAY + "all the available items for the measly");
        loreALL.add(ChatColor.GRAY + "price of " + ChatColor.RED + "$25,910");
        loreALL.add(" ");
        loreALL.add(ChatColor.GREEN + "$25,910");
        buyallmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        buyallmeta.setLore(loreALL);
        buyAll.setItemMeta(buyallmeta);

        ItemMeta backmeta = backtomenu.getItemMeta();
        backmeta.setDisplayName(ChatColor.RED + "Go back to menu");
        backtomenu.setItemMeta(backmeta);

        ItemStack[] menu_items = new ItemStack[]{acesword, airstrike, bonemerang, endermanbow, endermansword, evokerstaff, explosivebow, grapplinghook, healingsword, knockbackstick, rpg, runaansbow, ultradrill, air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air,  air, buyAll, air, air, air, air, air, air, air, air, air, air, air, air, backtomenu};
        gui.setContents(menu_items);
        player.openInventory(gui);
    }

    public void openMenu(Player player){
        UtilOptions itemMethods = new UtilOptions(plugin);
        Inventory gui = Bukkit.createInventory(player, 54, ChatColor.AQUA + "Epic Items");
        ItemStack air = new ItemStack(Material.AIR);
        ItemStack betaitem = itemMethods.getSkull("https://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025");
        ItemStack checkForUpdate = new ItemStack(Material.EMERALD);
        ItemStack itemsMenu = new ItemStack(Material.GOLDEN_SWORD);
        ItemStack storeMenu = new ItemStack(Material.DIAMOND);

        //Letters
        ItemStack e = itemMethods.getSkull("https://textures.minecraft.net/texture/c9a8516ee017908f7704c7bb0d3197e41c03053cc02528c3590f99c5c31cc90d");
        ItemStack p = itemMethods.getSkull("https://textures.minecraft.net/texture/77fed2dcce31d7253f5ee5c503e85bd8ec086c073ed646a8d69929bf91b64c2c");
        ItemStack i = itemMethods.getSkull("https://textures.minecraft.net/texture/33e672a8afab50e84dac26c2fac6ebef383f012f280da148e027dcbab90a061f");
        ItemStack c = itemMethods.getSkull("https://textures.minecraft.net/texture/68622281c7910bd66f457b91e3c451cfdcc0adc1f3f9f10e8b30c2f54222c78d");
        ItemStack t = itemMethods.getSkull("https://textures.minecraft.net/texture/544dd1e7491ee0db7fe26ac5e39614a409a79f57b9f12657554b2875dd87d49");
        ItemStack m = itemMethods.getSkull("https://textures.minecraft.net/texture/5aed039993918eebf28a85646843dd847e202d4421639ab79e26eddd5b357d7e");
        ItemStack s = itemMethods.getSkull("https://textures.minecraft.net/texture/2080987eda0215be2c39791bdcf1a6ac75beae0ccaaee25acf9479b3b85286f6");

        ItemMeta lettermeta = e.getItemMeta();
        lettermeta.setDisplayName("§");
        e.setItemMeta(lettermeta);

        ItemMeta lettermeta1 = p.getItemMeta();
        lettermeta1.setDisplayName("§");
        p.setItemMeta(lettermeta1);

        ItemMeta lettermeta2 = i.getItemMeta();
        lettermeta2.setDisplayName("§");
        i.setItemMeta(lettermeta2);

        ItemMeta lettermeta3 = c.getItemMeta();
        lettermeta3.setDisplayName("§");
        c.setItemMeta(lettermeta3);

        ItemMeta lettermeta4 = t.getItemMeta();
        lettermeta4.setDisplayName("§");
        t.setItemMeta(lettermeta4);

        ItemMeta lettermeta5 = m.getItemMeta();
        lettermeta5.setDisplayName("§");
        m.setItemMeta(lettermeta5);

        ItemMeta lettermeta6 = s.getItemMeta();
        lettermeta6.setDisplayName("§");
        s.setItemMeta(lettermeta6);

        ItemMeta betaitemmeta = betaitem.getItemMeta();
        betaitemmeta.setDisplayName(ChatColor.RED + "§lWARNING!");
        betaitemmeta.addEnchant(Enchantment.LUCK, 1, true);
        ArrayList<String> betaitemlore = new ArrayList();
        betaitemlore.add("");
        betaitemlore.add(ChatColor.RED + "This menu is in BETA!");
        betaitemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        betaitemmeta.setLore(betaitemlore);
        betaitem.setItemMeta(betaitemmeta);

        ItemMeta checkForUpdateMeta = checkForUpdate.getItemMeta();
        checkForUpdateMeta.setDisplayName(ChatColor.GREEN + "Check For Updates");
        ArrayList<String> checkForUpdateLore = new ArrayList();
        checkForUpdateLore.add(ChatColor.GRAY + "Click to check for an update.");
        checkForUpdateMeta.setLore(checkForUpdateLore);
        checkForUpdate.setItemMeta(checkForUpdateMeta);

        ItemMeta itemsMenuMeta = itemsMenu.getItemMeta();
        itemsMenuMeta.setDisplayName(ChatColor.GREEN + "Items Menu");
        itemsMenuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArrayList<String> itemsMenuLore = new ArrayList();
        itemsMenuLore.add(ChatColor.GRAY + "Click to open the items");
        itemsMenuLore.add(ChatColor.GRAY + "menu with all of the custom");
        itemsMenuLore.add(ChatColor.GRAY + "items provided by EpicItems.");
        itemsMenuMeta.setLore(itemsMenuLore);
        itemsMenu.setItemMeta(itemsMenuMeta);

        ItemMeta storeMeta = storeMenu.getItemMeta();
        storeMeta.setDisplayName(ChatColor.GREEN + "Epic Store");
        ArrayList<String> storeLore = new ArrayList();
        if (Bukkit.getPluginManager().isPluginEnabled("Vault")){
            storeLore.add(ChatColor.GRAY + "Click here to open the");
            storeLore.add(ChatColor.GRAY + "store GUI which must have");
            storeLore.add(ChatColor.GRAY + "Vault and an economy plugin");
            storeLore.add(ChatColor.GRAY + "like Essentials(X)");
            storeLore.add("");
            storeLore.add(ChatColor.DARK_AQUA + "Vault Installed:" + ChatColor.GREEN + " True");
            storeMeta.setLore(storeLore);
        }else{
            storeLore.add(ChatColor.GRAY + "Click here to open the");
            storeLore.add(ChatColor.GRAY + "store GUI which must have");
            storeLore.add(ChatColor.GRAY + "Vault and an economy plugin");
            storeLore.add(ChatColor.GRAY + "like Essentials(X)");
            storeLore.add("");
            storeLore.add(ChatColor.DARK_AQUA + "Vault Installed:" + ChatColor.RED + " False");
            storeMeta.setLore(storeLore);
        }
        storeMenu.setItemMeta(storeMeta);

        ItemStack[] menu_items = new ItemStack[]{air, air, air, air, air, air, air, air, air, air, air, air, air, betaitem, air, air, air, air, air, air, air, air, air, air, air, air, air, air, air, checkForUpdate, air, itemsMenu, air, storeMenu, air, air, air, air, air, air, air, air, air, air, air, e, p, i, c, i, t, e, m, s};
        gui.setContents(menu_items);
        player.openInventory(gui);
    }
}
