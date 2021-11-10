/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FireballRodEvent implements Listener {

    EpicItems plugin;
    FileConfiguration config;

    public FireballRodEvent(EpicItems plugin){
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (config.getBoolean("FireballRod", true)){
            if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
                if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                    if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-FireballRod")){
                        if (Cooldown.checkCooldown(event.getPlayer())) {
                            try {
                                Fireball fireball = event.getPlayer().getWorld().spawn(event.getPlayer().getEyeLocation(), Fireball.class);
                                fireball.setYield(0);
                                fireball.setCustomName("Fireball");
                                fireball.setVelocity(event.getPlayer().getLocation().getDirection());

                                Cooldown.setCooldown(player, config.getInt("FireballRodCooldown"));

                                new BukkitRunnable(){
                                    public void run(){
                                        if(!fireball.isDead()){
                                            fireball.getWorld().spawnParticle(Particle.FLAME, fireball.getLocation(), 1);
                                        }
                                        else{
                                            cancel();
                                        }
                                    }
                                }.runTaskTimer(plugin, 0L, 2L);

                                event.setCancelled(true);
                            } catch (NullPointerException exception){
                                Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                                exception.printStackTrace();
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onLand(ProjectileHitEvent event){
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Fireball")){
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), config.getInt("fireballRodExplosionPower"), false, true);
            for(Entity entity : event.getEntity().getNearbyEntities(5, 5, 5)){
                if(entity instanceof LivingEntity){
                    LivingEntity livingentity = (LivingEntity) entity;
                    double distance = event.getEntity().getLocation().distanceSquared(livingentity.getLocation());
                    if(distance <= 0.5){
                        livingentity.setVelocity(new Location(livingentity.getWorld(), 0, 1, 0).toVector());
                    }
                    else{
                        livingentity.setVelocity(livingentity.getLocation().subtract(event.getEntity().getLocation()).toVector().multiply(1 / distance));
                    }
                }
            }
        }
    }
}
