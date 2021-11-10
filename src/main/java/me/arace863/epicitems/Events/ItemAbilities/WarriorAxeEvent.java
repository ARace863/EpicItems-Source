/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import me.arace863.epicitems.Utils.Managers.ParticleManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarriorAxeEvent implements Listener {
    EpicItems plugin;
    FileConfiguration config;

    public WarriorAxeEvent(EpicItems plugin){
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        final int damage = 100;
        Player player = event.getPlayer();
        if (config.getBoolean("WarriorAxe", true)){
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                    if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-WarriorsAxe")){
                        if (Cooldown.checkCooldown(event.getPlayer())){
                            try {
                                String lore = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(4);

                                int finaldamage = damage;

                                ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 0.5, 0), EntityType.ARMOR_STAND);

                                as.setArms(true);
                                as.setGravity(false);
                                as.setVisible(false);
                                as.setSmall(true);
                                as.setMarker(true);
                                as.setItemInHand(new ItemStack(Material.NETHERITE_AXE));
                                as.setRightArmPose(new EulerAngle(Math.toRadians(90), Math.toRadians(0), Math.toRadians(0)));

                                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

                                Location dest = player.getLocation().add(player.getLocation().getDirection().multiply(10));
                                Vector vector = dest.subtract(player.getLocation()).toVector();

                                new BukkitRunnable(){
                                    int distance = 30;
                                    int i = 0;

                                    public void run(){

                                        EulerAngle rot = as.getRightArmPose();
                                        EulerAngle rotnew = rot.add(20, 0, 0);
                                        as.setRightArmPose(rotnew);

                                        as.teleport(as.getLocation().add(vector.normalize()));

                                        if(as.getTargetBlockExact(1) != null && !as.getTargetBlockExact(1).isPassable()){
                                            if(!as.isDead()){
                                                as.remove();
                                                if(player.getInventory().firstEmpty() != -1){
                                                    player.getInventory().addItem(ItemManager.WarriorAxe);
                                                }
                                                else{
                                                    player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.WarriorAxe);
                                                }
                                                cancel();
                                            }
                                        }

                                        for(Entity entity : as.getLocation().getChunk().getEntities()){
                                            if(!as.isDead()){
                                                if(as.getLocation().distanceSquared(entity.getLocation()) <= 1){
                                                    if(entity != player && entity != as){
                                                        if(entity instanceof LivingEntity){
                                                            LivingEntity livingentity = (LivingEntity) entity;
                                                            livingentity.damage(finaldamage, player);
                                                            ParticleManager particleManager = new ParticleManager(plugin);
                                                            particleManager.waveParticle(entity);
                                                            as.remove();
                                                            if(player.getInventory().firstEmpty() != -1){
                                                                player.getInventory().addItem(ItemManager.WarriorAxe);
                                                            }
                                                            else{
                                                                player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.WarriorAxe);
                                                            }
                                                            cancel();
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        if(i > distance){
                                            if(!as.isDead()){
                                                as.remove();
                                                if(player.getInventory().firstEmpty() != -1){
                                                    player.getInventory().addItem(ItemManager.WarriorAxe);
                                                }
                                                else{
                                                    player.getWorld().dropItemNaturally(player.getLocation(), ItemManager.WarriorAxe);
                                                }
                                                cancel();
                                            }
                                        }

                                        i++;
                                    }
                                }.runTaskTimer(plugin, 0L, 1L);

                                event.setCancelled(true);
                            } catch (NullPointerException e){
                                Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                                e.printStackTrace();
                            }

                            Cooldown.setCooldown(player, this.config.getInt("WarriorAxeCooldown"));
                        } else {
                            player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                        }
                    }
                }
            }
        }
    }
}
