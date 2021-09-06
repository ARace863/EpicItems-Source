package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;


public class EndermanBowEvent implements Listener {

    FileConfiguration config;

    public EndermanBowEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event){
        if (event.getEntity() instanceof Player){
            if (event.getBow() != null && event.getBow().getItemMeta() != null && event.getBow().getItemMeta().getLore() != null
            && event.getBow().getItemMeta().getLore().contains(ItemManager.EndermanBow.getItemMeta().getLore().get(0))){
                if (event.getProjectile() instanceof Arrow){
                    Arrow arrow = (Arrow) event.getProjectile();
                    arrow.setCustomName("Enderman Bow");
                }
            }
        }
    }


    @EventHandler
    public void onBowShoot(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow){
            Arrow arrow = (Arrow) event.getEntity();
            Entity entity = event.getEntity();

                if (entity instanceof Player){
                    Player player = (Player) entity;
                    if (player.getInventory().getItemInMainHand().getItemMeta().hasLore() && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cEnderman Bow")){
                        Location location = event.getEntity().getLocation();
                        event.getEntity().remove();
                        location.setYaw(player.getLocation().getYaw());
                        location.setPitch(player.getLocation().getPitch());
                        player.teleport(location);
                        player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 10.0F, 1.0F);
                        player.sendMessage(ChatColor.DARK_GRAY + "§lSwoosh!");
                    }
                }

        }
    }
}
