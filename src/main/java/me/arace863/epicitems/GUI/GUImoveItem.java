package me.arace863.epicitems.GUI;

import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class GUImoveItem implements Listener {
    public GUImoveItem() {
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player player = (Player)e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Epic Items")) {
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
            }
            e.setCancelled(true);
        }
    }
}
