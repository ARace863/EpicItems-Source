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
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

public class AceSwordEvent implements Listener {
    FileConfiguration config;

    public AceSwordEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (this.config.getBoolean("AceSword", true) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && e.getItem() != null && e.getItem().getItemMeta().equals(ItemManager.AceSword.getItemMeta())) {
            if (Cooldown.checkCooldown(e.getPlayer())) {
                player.getWorld().createExplosion(player.getLocation(), this.config.getInt("aceSwordExplosivePower"), false, false);
                player.playEffect(EntityEffect.FIREWORK_EXPLODE);
                Cooldown.setCooldown(e.getPlayer(), this.config.getInt("AceSwordCooldown"));

            } else {
                player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
            }
        }

    }

    @EventHandler
    public void loseHealth(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player && event.getCause() == DamageCause.BLOCK_EXPLOSION) {
            event.setCancelled(true);

        }

    }
}