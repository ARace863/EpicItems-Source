/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;

public class HealingSwordEvent implements Listener {

    FileConfiguration config;

    public HealingSwordEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-HealingSword")){
                    if (Cooldown.checkCooldown(event.getPlayer())){
                        try {
                            player.setHealth(player.getMaxHealth());
                            player.setFoodLevel(20);
                            Cooldown.setCooldown(event.getPlayer(), this.config.getInt("HealingSwordCooldown"));
                            if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                Song heal = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\healingswordheal.nbs"));
                                RadioSongPlayer rsp = new RadioSongPlayer(heal);
                                rsp.addPlayer(player);
                                rsp.setPlaying(true);
                            }
                        }catch (NullPointerException exception){
                            Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                            exception.printStackTrace();
                        }

                    }else{
                        player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                    }
                }
            }
        }
    }
}
