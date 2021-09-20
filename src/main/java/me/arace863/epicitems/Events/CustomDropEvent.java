package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class CustomDropEvent implements Listener {

    FileConfiguration config;

    public CustomDropEvent(EpicItems instance) {
        this.config = instance.getConfig();
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        Location l = e.getEntity().getLocation();
        l.setY(l.getY() + 1.0D);
        if (this.config.getBoolean("evokerDrop") && e.getEntity() instanceof Evoker) {
            e.getEntity().getWorld().dropItem(l, ItemManager.EvokerStaff);
        }

    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e){
        Location l = e.getEntity().getLocation();
        l.setY(l.getY() + 1.0D);
        if (this.config.getBoolean("witherAndEnderDragonDrop") && e.getEntity() instanceof EnderDragon || e.getEntity() instanceof Wither) {
            e.getEntity().getWorld().dropItem(l, ItemManager.ExplosiveBow);
        }
    }
}
