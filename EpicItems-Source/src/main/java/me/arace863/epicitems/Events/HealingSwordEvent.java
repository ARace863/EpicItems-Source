package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
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
                        if (player.getHealth() == 1){
                            player.setHealth(player.getHealth() + 19);
                        }

                        if (player.getHealth() == 2){
                            player.setHealth(player.getHealth() + 18);
                        }

                        if (player.getHealth() == 3){
                            player.setHealth(player.getHealth() + 17);
                        }

                        if (player.getHealth() == 4){
                            player.setHealth(player.getHealth() + 16);
                        }

                        if (player.getHealth() == 5){
                            player.setHealth(player.getHealth() + 15);
                        }

                        if (player.getHealth() == 6){
                            player.setHealth(player.getHealth() + 14);
                        }

                        if (player.getHealth() == 7){
                            player.setHealth(player.getHealth() + 13);
                        }

                        if (player.getHealth() == 8){
                            player.setHealth(player.getHealth() + 12);
                        }

                        if (player.getHealth() == 9){
                            player.setHealth(player.getHealth() + 11);
                        }

                        if (player.getHealth() == 10){
                            player.setHealth(player.getHealth() + 10);
                        }

                        if (player.getHealth() == 11){
                            player.setHealth(player.getHealth() + 9);
                        }

                        if (player.getHealth() == 12){
                            player.setHealth(player.getHealth() + 8);
                        }

                        if (player.getHealth() == 13){
                            player.setHealth(player.getHealth() + 7);
                        }

                        if (player.getHealth() == 14){
                            player.setHealth(player.getHealth() + 6);
                        }

                        if (player.getHealth() == 15){
                            player.setHealth(player.getHealth() + 5);
                        }

                        if (player.getHealth() == 16){
                            player.setHealth(player.getHealth() + 4);
                        }

                        if (player.getHealth() == 17){
                            player.setHealth(player.getHealth() + 3);
                        }

                        if (player.getHealth() == 18){
                            player.setHealth(player.getHealth() + 2);
                        }

                        if (player.getHealth() == 19){
                            player.setHealth(player.getHealth() + 1);
                        }

                }
            }
    }
}
