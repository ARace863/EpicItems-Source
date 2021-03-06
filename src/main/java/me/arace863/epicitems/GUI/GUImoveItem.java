/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.GUI;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Updaters.UpdateChecker;
import me.arace863.epicitems.Utils.UtilOptions;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUImoveItem implements Listener {
    EpicItems plugin;

    public GUImoveItem(EpicItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        UtilOptions utilOptions = new UtilOptions(plugin);
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Items | EpicItems")) {
            if (e.getCurrentItem() != null){
                switch(e.getCurrentItem().getType()) {
                    case IRON_SWORD:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.AceSword});
                        player.sendMessage(ChatColor.GREEN + "Gave the §4Ace Sword§a item!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        break;
                    case DIAMOND_SWORD:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.EndermanSword});
                        player.sendMessage(ChatColor.GREEN + "Gave the §6Enderman Sword§a item!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        break;
                    case BONE:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.Bonemerang});
                        player.sendMessage(ChatColor.GREEN + "Gave the §6Bonemerang§a item!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        break;
                    case GOLDEN_SHOVEL:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.Rpg});
                        player.sendMessage(ChatColor.GREEN + "Gave the §6Rocket Launcher§a item!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        break;
                    case FISHING_ROD:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.GrapplingHook});
                        player.sendMessage(ChatColor.GREEN + "Gave the Grappling Hook item!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        break;
                    case BOW:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.EndermanBow});
                        player.sendMessage(ChatColor.GREEN + "Gave the §6Enderman Bow §aitem!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        break;
                    case TNT:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.ExplosiveBow});
                        player.sendMessage(ChatColor.GREEN + "Gave the §6Explosive Bow §aitem!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    case ARROW:
                        player.closeInventory();
                        player.getInventory().addItem(new ItemStack[]{ItemManager.TripleStrikeBow});
                        player.sendMessage(ChatColor.GREEN + "Gave the §6Runaan's Bow §aitem!");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    case BARRIER:
                        player.closeInventory();
                        GUIMethods guiMethods = new GUIMethods(plugin);
                        guiMethods.openMenu(player);
                }
                e.setCancelled(true);
            }
        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Store | EpicItems")) {
            if (Bukkit.getPluginManager().isPluginEnabled("Vault")){
                Economy eco = EpicItems.getEconomy();
                double balance = eco.getBalance(player);
                if (e.getCurrentItem() != null){
                    switch(e.getCurrentItem().getType()) {
                        case IRON_SWORD:
                            if (balance >= 2500){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Ace Sword for $2,500!");
                                eco.withdrawPlayer(player, 2500);
                                player.getInventory().addItem(ItemManager.AceSword);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case SEA_PICKLE:
                            if (balance >= 1500){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Airstrike for $1,500!");
                                eco.withdrawPlayer(player, 1500);
                                player.getInventory().addItem(ItemManager.Airstrike);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case BONE:
                            if (balance >= 2000){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Bonemerang for $2,000!");
                                eco.withdrawPlayer(player, 2000);
                                player.getInventory().addItem(ItemManager.Bonemerang);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case ENDER_PEARL:
                            player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "This item is not available to purchase at this time!");
                            player.closeInventory();
                            break;
                        case DIAMOND_SWORD:
                            if (balance >= 2750){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Enderman Sword for $2,750!");
                                eco.withdrawPlayer(player, 2750);
                                player.getInventory().addItem(ItemManager.EndermanSword);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case NETHERITE_HOE:
                            if (balance >= 1050){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Evoker Staff for $1,050!");
                                eco.withdrawPlayer(player, 1050);
                                player.getInventory().addItem(ItemManager.EvokerStaff);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case TNT:
                            player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "This item is not available to purchase at this time, Sorry!");
                            player.closeInventory();
                            break;
                        case FISHING_ROD:
                            if (balance >= 500){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Grappling Hook for $500!");
                                eco.withdrawPlayer(player, 500);
                                player.getInventory().addItem(ItemManager.GrapplingHook);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case GOLDEN_SWORD:
                            if (balance >= 1000){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Healing Sword for $1,000!");
                                eco.withdrawPlayer(player, 1000);
                                player.getInventory().addItem(ItemManager.HealingSword);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case STICK:
                            if (balance >= 10){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Knockback Stick for $10!");
                                eco.withdrawPlayer(player, 10);
                                player.getInventory().addItem(ItemManager.KnockStick);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case GOLDEN_SHOVEL:
                            if (balance >= 10000){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Rocket Launcher for $10,000!");
                                eco.withdrawPlayer(player, 10000);
                                player.getInventory().addItem(ItemManager.Rpg);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case ARROW:
                            if (balance >= 3000){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Runaan's Bow for $3,000!");
                                eco.withdrawPlayer(player, 3000);
                                player.getInventory().addItem(ItemManager.TripleStrikeBow);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case DIAMOND_PICKAXE:
                            if (balance >= 1600){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Ultra Drill for $1,600!");
                                eco.withdrawPlayer(player, 1600);
                                player.getInventory().addItem(ItemManager.UltraDrill);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case NETHERITE_AXE:
                            if (balance >= 2000){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought the Warriors Axe for $2,000!");
                                eco.withdrawPlayer(player, 2000);
                                player.getInventory().addItem(ItemManager.WarriorAxe);
                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case EMERALD:
                            if (balance >= 27910){
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You have bought all of the items for $27,910");
                                Bukkit.broadcastMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + player.getDisplayName() + " has bought all of the items for the small amount of $25,910!");
                                eco.withdrawPlayer(player, 27910);
                                player.getInventory().addItem(ItemManager.AceSword);
                                player.getInventory().addItem(ItemManager.Airstrike);
                                player.getInventory().addItem(ItemManager.Bonemerang);
                                player.getInventory().addItem(ItemManager.EndermanSword);
                                player.getInventory().addItem(ItemManager.EvokerStaff);
                                player.getInventory().addItem(ItemManager.GrapplingHook);
                                player.getInventory().addItem(ItemManager.HealingSword);
                                player.getInventory().addItem(ItemManager.KnockStick);
                                player.getInventory().addItem(ItemManager.Rpg);
                                player.getInventory().addItem(ItemManager.TripleStrikeBow);
                                player.getInventory().addItem(ItemManager.UltraDrill);
                                player.getInventory().addItem(ItemManager.WarriorAxe);

                            }else{
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "You cannot afford this item!");
                            }
                            player.closeInventory();
                            break;
                        case BARRIER:
                            player.closeInventory();
                            GUIMethods guiMethods = new GUIMethods(plugin);
                            guiMethods.openMenu(player);
                    }
                }
            }
            e.setCancelled(true);
        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Epic Items")) {
            GUIMethods guiMethods = new GUIMethods(plugin);
            if (e.getCurrentItem() != null){
                switch(e.getCurrentItem().getType()) {
                    case EMERALD:
                        (new UpdateChecker(this.plugin, 93541)).getVersion((version) -> {
                            if (this.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "No update found, check again later!");
                            } else {
                                player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "§cFound an update! Download it here" + ChatColor.BLUE + " https://www.spigotmc.org/resources/epic-items-custom-items.93541/" + ChatColor.RED + "to download it!");
                                this.plugin.updateAvailable = true;
                            }

                        });
                        player.closeInventory();
                        break;
                    case GOLDEN_SWORD:
                        player.closeInventory();
                        guiMethods.openItemGUI(player);
                        break;
                    case DIAMOND:
                        if (Bukkit.getPluginManager().isPluginEnabled("Vault")){
                            player.closeInventory();
                            guiMethods.openVaultStoreGUI(player);
                        }else{
                            player.sendMessage(ChatColor.AQUA + "[EpicItems]" + ChatColor.RED + " You must have the Vault plugin installed to use this, Install it here: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/vault.34315/");
                        }
                        break;
                }
                e.setCancelled(true);
            }
        }

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Item Creator | EpicItems")) {
            GUIMethods guiMethods = new GUIMethods(plugin);
            if (e.getCurrentItem() != null){
                switch(e.getCurrentItem().getType()) {
                    case IRON_SWORD:
                        player.closeInventory();
                        utilOptions.playerMessage(player, "Send your chosen item material in the chat! (Only you will see the message)");
                        break;
                    case DIAMOND:
                        if (Bukkit.getPluginManager().isPluginEnabled("Vault")){
                            player.closeInventory();
                            guiMethods.openVaultStoreGUI(player);
                        }else{
                            player.sendMessage(ChatColor.AQUA + "[EpicItems]" + ChatColor.RED + " You must have the Vault plugin installed to use this, Install it here: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/vault.34315/");
                        }
                        break;
                }
                e.setCancelled(true);
            }
        }
    }
}
