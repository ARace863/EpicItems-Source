package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class RunaansBowEvent implements Listener {

    FileConfiguration config;

    public RunaansBowEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event){
        if (this.config.getBoolean("RunaansBow", true)){
            if (event.getBow() != null && event.getBow().getItemMeta().equals(ItemManager.TripleStrikeBow.getItemMeta())){
                if (event.getProjectile() instanceof Arrow){
                    if (event.getEntity() instanceof Player){
                        if (event.getBow() != null && event.getBow().getItemMeta() != null && event.getBow().getItemMeta().getLore() != null
                                && event.getBow().getItemMeta().getLore().contains("§7shares your damage")){

                            Arrow arrow = (Arrow) event.getProjectile();

                            Arrow arrow1 = event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                            arrow1.setDamage(arrow.getDamage() / 2);
                            arrow1.setKnockbackStrength(10);
                            arrow1.setShooter(event.getEntity());
                            arrow1.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(30)));

                            Arrow arrow2 = event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                            arrow2.setDamage(arrow.getDamage() / 2);
                            arrow2.setKnockbackStrength(10);
                            arrow2.setShooter(event.getEntity());
                            arrow2.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(-30)));
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (this.config.getBoolean("RunaansBow", true)){
            Player player = event.getPlayer();
            if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.TripleStrikeBow.getItemMeta())) {
                player.getInventory().setItemInOffHand(ItemManager.Quiver);
            }
        }
    }
}
