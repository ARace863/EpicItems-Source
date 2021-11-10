/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    public void onShoot(EntityShootBowEvent event) {
        if (this.config.getBoolean("RunaansBow", true)) {
            if (event.getBow() != null && event.getBow().getItemMeta().hasLore()){
                if (event.getBow() != null && event.getBow().getItemMeta().getLore().contains("§8EpicItem-TSB")){
                    try {
                        Arrow arrow = (Arrow)event.getProjectile();
                        Arrow arrow1 = (Arrow)event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                        arrow1.setDamage(arrow.getDamage() / 2.0D);
                        arrow1.setKnockbackStrength(10);
                        arrow1.setShooter(event.getEntity());
                        arrow1.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(30.0D)));
                        Arrow arrow2 = (Arrow)event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                        arrow2.setDamage(arrow.getDamage() / 2.0D);
                        arrow2.setKnockbackStrength(10);
                        arrow2.setShooter(event.getEntity());
                        arrow2.setVelocity(arrow.getVelocity().rotateAroundY(Math.toRadians(-30.0D)));
                        Player player = (Player) event.getEntity();
                        Cooldown.setCooldown(player, this.config.getInt("RunaansBowCooldown"));
                    }catch (NullPointerException exception){
                        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                        exception.printStackTrace();
                    }

                }
            }
        }

    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (this.config.getBoolean("RunaansBow", true)) {
            Player player = event.getPlayer();
            if (this.config.getBoolean("ExplosiveBowQuiver", true)){
                if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.TripleStrikeBow.getItemMeta())) {
                    player.getInventory().setItemInOffHand(ItemManager.Quiver);
                }
            }
        }
    }
}
