package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ExplosiveBowEvent implements Listener {
    FileConfiguration config;

    public ExplosiveBowEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Arrow arrow = (Arrow) event.getEntity();
        Player player = (Player) arrow.getShooter();
        Location arrowloc = arrow.getLocation();
        World world = player.getWorld();
        if (event.getEntityType() != EntityType.PLAYER){
            return;
        }
        if (this.config.getBoolean("ExplosiveBow", true)){
            if (event.getEntity().getShooter() instanceof Player){
                if (player.getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.EndermanBow.getItemMeta())){
                    if (Cooldown.checkCooldown(player)){
                        world.createExplosion(arrowloc, 3.0F, false, false);
                        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10.0F, 5.0F);
                        Cooldown.setCooldown(player, this.config.getInt("ExplosiveBowCooldown"));
                    }else{
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (this.config.getBoolean("ExplosiveBow", true)){
            Player player = event.getPlayer();
            if (this.config.getBoolean("RunaansBowQuiver", true)){
                if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.ExplosiveBow.getItemMeta())) {
                    player.getInventory().setItemInOffHand(ItemManager.Quiver);
                }
            }
        }
    }
}
