package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class HealingSwordEvent implements Listener {

    FileConfiguration config;

    public HealingSwordEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null && event.getItem().getItemMeta().equals(ItemManager.HealingSword.getItemMeta())){
                if (Cooldown.checkCooldown(event.getPlayer())){
                    player.setHealth(20);
                    Cooldown.setCooldown(event.getPlayer(), 10);
                }
            }
        }
    }
}
