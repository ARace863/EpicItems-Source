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
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class StealthStrikeEvent implements Listener {
    FileConfiguration config;
    EpicItems plugin;

    public StealthStrikeEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
        this.plugin = plugin;
    }

    int stealthtimer;

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {

        stealthtimer = config.getInt("stealthStrikeTime");

        Player player = e.getPlayer();
        if (this.config.getBoolean("StealthStrike", true) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (e.getItem() != null && e.getItem().getItemMeta().hasLore()){
                if (e.getItem() != null && e.getItem().getItemMeta().getLore().contains("§8EpicItem-StealthStrike")){
                    if (Cooldown.checkCooldown(e.getPlayer())) {
                        try {
                            player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You are now hidden!");
                            player.getWorld().playSound(player.getLocation(), Sound.MUSIC_CREDITS, 10.0F, 5.0F);

                            (new BukkitRunnable(){
                                @Override
                                public void run() {
                                    //Run the timer
                                    stealthtimer--;

                                    player.sendTitle("§",ChatColor.DARK_GRAY + "Visible in " + stealthtimer);

                                    //Hide player
                                    for (Player players : Bukkit.getOnlinePlayers()){
                                        //Hide target for everyone
                                        players.hidePlayer(plugin, player);
                                    }

                                    //Show player
                                    if (stealthtimer <= 0){
                                        //Show player after the timer hits 0
                                        for (Player players : Bukkit.getOnlinePlayers()){
                                            players.showPlayer(plugin, player);
                                        }
                                        player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.GREEN + "You are now visible!");
                                        cancel();
                                    }
                                }
                            }).runTaskTimer(plugin, 0, 20);

                            Cooldown.setCooldown(e.getPlayer(), this.config.getInt("StealthStrikeCooldown"));
                        }catch (NullPointerException exception){
                            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                            exception.printStackTrace();
                        }

                    } else {
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (this.config.getBoolean("StealthStrike", true)) {
            Player p = event.getPlayer();
            if (p.getEquipment().getItemInMainHand().getItemMeta().getDisplayName().equals(ItemManager.StealthStrike.getItemMeta().getDisplayName())) {
                event.setCancelled(true);
            }
        }
    }
}
