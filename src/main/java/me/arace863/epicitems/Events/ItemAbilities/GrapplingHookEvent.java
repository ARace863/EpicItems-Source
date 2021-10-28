/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.Bukkit;
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
        if (this.config.getBoolean("GrapplingHook", true)){
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()){
                if (player.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§8EpicItem-GrapplingHook")){
                    if (event.getState().equals(PlayerFishEvent.State.REEL_IN)){
                        if (Cooldown.checkCooldown(event.getPlayer())) {
                            try {
                                Location playerLocation = player.getLocation();
                                Location hookLocation = event.getHook().getLocation();
                                Location change = hookLocation.subtract(playerLocation);
                                player.setVelocity(change.toVector().multiply(this.config.getDouble("pullVelocityOfGrapplingHook")));
                                if (this.config.getBoolean("grapplingHookSpeed", true)){
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 5));
                                }
                                Cooldown.setCooldown(event.getPlayer(), this.config.getInt("GrapplingHookCooldown"));
                            }catch (NullPointerException exception){
                                Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                                exception.printStackTrace();
                            }

                        } else {
                            player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round((Cooldown.cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000) +"s.");
                        }
                    }
                }
            }
        }
    }
}
