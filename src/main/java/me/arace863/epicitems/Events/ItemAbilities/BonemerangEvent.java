/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class BonemerangEvent implements Listener {
    EpicItems plugin;
    FileConfiguration config;

    public BonemerangEvent(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (this.config.getBoolean("Bonemerang", true)) {
            if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-Bonemerang")){
                    if (Cooldown.checkCooldown(event.getPlayer())){
                        try {
                            final ArmorStand as = (ArmorStand)player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                            Location destination = player.getLocation().add(player.getLocation().getDirection().multiply(10));
                            player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_INFECT, 10.0F, 5.0F);
                            as.setArms(true);
                            as.setGravity(false);
                            as.setVisible(false);
                            as.setItemInHand(new ItemStack(Material.BONE));
                            as.setRightArmPose(new EulerAngle(Math.toRadians(0.0D), Math.toRadians(120.0D), Math.toRadians(0.0D)));
                            player.getInventory().removeItem(ItemManager.Bonemerang);
                            final Vector vector = destination.subtract(player.getLocation()).toVector();
                            Cooldown.setCooldown(event.getPlayer(), this.config.getInt("BonemerangCooldown"));
                            (new BukkitRunnable() {
                                int distance = 40.87;
                                int i = 0;

                                public void run() {
                                    EulerAngle rot = as.getRightArmPose();
                                    EulerAngle rotnew = rot.add(0.0D, 20.0D, 0.0D);
                                    as.setRightArmPose(rotnew);
                                    if (this.i >= this.distance) {
                                        as.teleport(as.getLocation().subtract(vector.normalize()));
                                        if (this.i >= this.distance * 2) {
                                            as.remove();
                                            player.getInventory().addItem(ItemManager.Bonemerang);
                                            this.cancel();
                                        }
                                    } else {
                                        as.teleport(as.getLocation().add(vector.normalize()));
                                        as.setArms(as.hasArms());
                                    }
                                    
                                    ++this.i;
                                    Entity[] var3 = as.getLocation().getChunk().getEntities();
                                    int var4 = var3.length;

                                    for(int var5 = 0; var5 < var4; ++var5) {
                                        Entity entity = var3[var5];
                                        if (as.getLocation().distanceSquared(entity.getLocation()) < 1.0D && entity != player) {
                                            LivingEntity livingEntity = (LivingEntity)entity;
                                            livingEntity.damage(config.getDouble("bonemerangDamage"), player);
                                        }
                                    }
                                }
                            }).runTaskTimer(this.plugin, 1L, 1L);
                            event.setCancelled(true);
                        }catch (NullPointerException exception){
                            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                            exception.printStackTrace();
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntity(PlayerInteractAtEntityEvent event) {
        if (this.config.getBoolean("Bonemerang", true)) {
            if (event.getRightClicked() instanceof ArmorStand){
                ArmorStand as = (ArmorStand)event.getRightClicked();
                if (as.getItemInHand().getType().equals(Material.BONE)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
