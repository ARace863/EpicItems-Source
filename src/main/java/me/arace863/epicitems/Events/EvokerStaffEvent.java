package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

public class EvokerStaffEvent implements Listener {
    FileConfiguration config;

    public EvokerStaffEvent(EpicItems instance) {
        this.config = instance.getConfig();
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (this.config.getBoolean("EvokerStaff", true) && (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                if (event.getItem() != null && event.getItem().getItemMeta().getLore().contains("§8EpicItem-EvokerStaff")){
                    BlockIterator iter = new BlockIterator(p, this.config.getInt("evokerStaffMaxRange"));
                    Block lastBlock = iter.next();

                    while(iter.hasNext()) {
                        lastBlock = iter.next();
                        if (lastBlock.getType().isSolid()) {
                            break;
                        }
                    }

                    Location l = lastBlock.getLocation();
                    l.setY(l.getY() + 1.0D);
                    l.setX(l.getX() + 0.5D);
                    l.setZ(l.getZ() + 0.5D);

                    try {
                        if (Cooldown.checkCooldown(event.getPlayer())) {
                            p.getWorld().spawnEntity(l, EntityType.EVOKER_FANGS);
                            event.setCancelled(true);
                            Cooldown.setCooldown(event.getPlayer(), this.config.getInt("EvokerStaffCooldown"));
                        } else {
                            p.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(p.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                        }

                    } catch (NullPointerException var7) {
                        var7.printStackTrace();
                    }
                }
            }
        }
    }
}
