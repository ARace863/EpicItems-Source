package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GrapplingHookEvent implements Listener {

    FileConfiguration config;

    public GrapplingHookEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        if (this.config.getBoolean("GrapplingHook", true)){
            if (name.equals("§aGrappling Hook")) {
                if (event.getState().equals(PlayerFishEvent.State.REEL_IN)){
                    if (Cooldown.checkCooldown(event.getPlayer())) {
                        Location playerLocation = player.getLocation();
                        Location hookLocation = event.getHook().getLocation();
                        Location change = hookLocation.subtract(playerLocation);
                        player.setVelocity(change.toVector().multiply(0.3D));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 5));
                        Cooldown.setCooldown(event.getPlayer(), 2);
                    } else {
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round((Cooldown.cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000) +"s.");
                    }
                }
            }
        }
    }
}
