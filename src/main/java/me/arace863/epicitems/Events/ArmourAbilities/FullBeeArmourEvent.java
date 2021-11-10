/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ArmourAbilities;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class FullBeeArmourEvent implements Listener {

    @EventHandler
    public void onArmourDrag(InventoryClickEvent event){
        if (event.getClickedInventory().equals(InventoryType.PLAYER)){
            event.getWhoClicked().sendMessage("LOL");event.getAction();
        }
    }
}
