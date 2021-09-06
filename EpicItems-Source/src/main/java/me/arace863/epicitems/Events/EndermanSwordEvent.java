package me.arace863.epicitems.Events;

import java.util.Set;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
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
                if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.EndermanSword.getItemMeta())){
                    Block block = player.getTargetBlock((Set) null, 8);
                    Location location = block.getLocation();
                    float pitch = player.getEyeLocation().getPitch();
                    float yaw = player.getEyeLocation().getYaw();
                    location.add(0.0D, 1.0D, 0.0D);
                    location.setYaw(yaw);
                    location.setPitch(pitch);
                    player.teleport(location);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10.0F, 5.0F);
                }
            }
        }
    }
}
