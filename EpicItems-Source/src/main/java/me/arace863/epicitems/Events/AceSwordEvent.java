package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.UUID;

public class AceSwordEvent implements Listener {
    FileConfiguration config;

    public AceSwordEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (this.config.getBoolean("AceSword", true)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (e.getItem() != null && e.getItem().getItemMeta().equals(ItemManager.AceSword.getItemMeta())){
                    if (Cooldown.checkCooldown(e.getPlayer())) {
                        player.getWorld().createExplosion(player.getLocation(), 4.0F, false, false);
                        player.playEffect(EntityEffect.FIREWORK_EXPLODE);
                        Cooldown.setCooldown(e.getPlayer(), 1);
                    } else {
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round((Cooldown.cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000) +"s.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void loseHealth(EntityDamageEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof Player){
            if (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
                event.setCancelled(true);
            }
        }
    }
}
