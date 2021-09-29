package me.arace863.epicitems.Utils.Managers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class MobManager {

    public void zombie(Zombie zombie){
        zombie.setGlowing(true);
        zombie.setBaby(false);
        zombie.setCanPickupItems(false);
        zombie.setCustomName(ChatColor.GRAY + "[Lvl 1] " + ChatColor.RED + "Zombie");
        zombie.setCustomNameVisible(true);
        zombie.setSilent(true);
        zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
        zombie.getEquipment().setItemInOffHand(new ItemStack(Material.ROTTEN_FLESH));
        zombie.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        zombie.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        zombie.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
    }
}
