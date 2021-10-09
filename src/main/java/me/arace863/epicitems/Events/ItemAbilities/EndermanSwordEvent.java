package me.arace863.epicitems.Events.ItemAbilities;

import java.util.Set;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EndermanSwordEvent implements Listener {
    FileConfiguration config;

    public EndermanSwordEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (this.config.getBoolean("EndermanSword", true)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR)){
                if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                    if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-EndermanSword")){
                        if (Cooldown.checkCooldown(player)){
                            Block block = player.getTargetBlock((Set) null, this.config.getInt("endermanSwordTeleportDistance"));
                            Location location = block.getLocation();
                            float pitch = player.getEyeLocation().getPitch();
                            float yaw = player.getEyeLocation().getYaw();
                            location.add(0.0D, 1.0D, 0.0D);
                            location.setYaw(yaw);
                            location.setPitch(pitch);
                            player.teleport(location);
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10.0F, 5.0F);
                            Cooldown.setCooldown(event.getPlayer(), this.config.getInt("EndermanSwordCooldown"));
                        }else{
                            player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                        }
                    }
                }
            }
        }
    }
}
