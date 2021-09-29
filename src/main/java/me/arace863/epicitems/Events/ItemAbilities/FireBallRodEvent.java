package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import me.arace863.epicitems.Utils.Managers.ParticleManager;
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

public class FireBallRodEvent implements Listener {
    FileConfiguration config;
    EpicItems plugin;

    public FireBallRodEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (this.config.getBoolean("FireBallRod", true) && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-FireballRod")){
                    if (Cooldown.checkCooldown(event.getPlayer())) {
                        Fireball fireball = player.getWorld().spawn(player.getEyeLocation(), Fireball.class);
                        fireball.setYield(0);
                        fireball.setCustomName("EpicFireball");
                        fireball.setVelocity(player.getLocation().getDirection());

                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                if (!fireball.isDead()){
                                    fireball.getWorld().spawnParticle(Particle.FLAME,  fireball.getLocation(), 1);
                                }else{
                                    ParticleManager particleManager = new ParticleManager(plugin);
                                    particleManager.fireSpiral(fireball);
                                    cancel();
                                }
                            }
                        }.runTaskTimer(plugin, 0L, 2L);
                        Cooldown.setCooldown(event.getPlayer(), this.config.getInt("FireBallRodCooldown"));
                    } else {
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        if (event.getEntity().getCustomName() != null & event.getEntity().getCustomName().equals("EpicFireball")){
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 5, true);
            for (Entity entity : event.getEntity().getNearbyEntities(5,5,5)){
                LivingEntity livingEntity = (LivingEntity) entity;
                double distance = event.getEntity().getLocation().distanceSquared(livingEntity.getLocation());
                if (distance <= 0.5){
                    if (!livingEntity.isDead()){
                        livingEntity.setVelocity(new Location(livingEntity.getWorld(), 0, 1, 0).toVector());
                    }
                }else{
                    livingEntity.setVelocity(livingEntity.getLocation().subtract(event.getEntity().getLocation()).toVector().multiply(1/ distance));
                }
            }
        }
    }
}
