package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdatePlayerEvent implements Listener {

    EpicItems plugin;
    FileConfiguration config;

    public UpdatePlayerEvent(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (this.config.getBoolean("CheckForUpdates", true)) {
            (new UpdateChecker(plugin, 93541)).getVersion((version) -> {
                if (this.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                } else {
                    if (player.isOp()){
                        player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "§cA new update is available! Go to" + ChatColor.BLUE + " https://www.spigotmc.org/resources/epic-items-custom-items.93541/" + ChatColor.RED + "to download it");
                        this.plugin.updateAvailable = true;
                    }
                }
            });
        }
    }
}
