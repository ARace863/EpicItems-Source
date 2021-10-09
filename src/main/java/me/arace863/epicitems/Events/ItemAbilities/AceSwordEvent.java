package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import me.arace863.epicitems.Utils.Managers.ParticleManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Set;

public class AceSwordEvent implements Listener {
    FileConfiguration config;
    EpicItems plugin;

    public AceSwordEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (this.config.getBoolean("AceSword", true) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (e.getItem() != null && e.getItem().getItemMeta().hasLore()){
                if (e.getItem() != null && e.getItem().getItemMeta().getLore().contains("§8EpicItem-AceSword")){
                    if (Cooldown.checkCooldown(e.getPlayer())) {
                        player.getWorld().createExplosion(player.getLocation(), this.config.getInt("aceSwordExplosivePower"), false, false);
                        ParticleManager particleManager = new ParticleManager(plugin);
                        particleManager.lavaSphere(player);
                        Block block = player.getTargetBlock((Set) null, this.config.getInt("endermanSwordTeleportDistance"));
                        Location location = block.getLocation();
                        float pitch = player.getEyeLocation().getPitch();
                        float yaw = player.getEyeLocation().getYaw();
                        location.add(0.0D, 1.0D, 0.0D);
                        location.setYaw(yaw);
                        location.setPitch(pitch);
                        player.teleport(location);

                        Cooldown.setCooldown(e.getPlayer(), this.config.getInt("AceSwordCooldown"));
                    } else {
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                    }
                }
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
