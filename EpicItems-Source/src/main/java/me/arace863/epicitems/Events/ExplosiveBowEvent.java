package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
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
                        world.createExplosion(arrowloc, 3.0F, false, false);
                        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10.0F, 5.0F);
                }
            }
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (this.config.getBoolean("ExplosiveBow", true)){
            Player player = event.getPlayer();
            if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.ExplosiveBow.getItemMeta())) {
                player.getInventory().setItemInOffHand(ItemManager.Quiver);
            }
        }
    }
}
