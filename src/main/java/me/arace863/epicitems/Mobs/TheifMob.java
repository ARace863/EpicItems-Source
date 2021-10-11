/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Mobs;

import net.minecraft.server.v1_16_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.entity.Villager;

public class TheifMob extends EntityVillager {

    public TheifMob(Location loc) {
        super(EntityTypes.VILLAGER, ((CraftWorld) loc.getWorld()).getHandle());
        if (Bukkit.getVersion().contains("1.16.1")){
            Villager villager = (Villager) this.getBukkitEntity();

            this.setPosition(loc.getX(), loc.getY(), loc.getZ());
            this.setCustomName(new ChatComponentText(ChatColor.GOLD + "Legendary Thief"));
            this.setCustomNameVisible(true);
            villager.setMaxHealth(50.0D);
            this.setHealth(50.0F);

            this.goalSelector.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class, 15, 1.0D, 1.0D));
            this.goalSelector.a(1, new PathfinderGoalPanic(this, 2.0D));
            this.goalSelector.a(2, new PathfinderGoalRandomStrollLand(this, 0.6D));
            this.goalSelector.a(3, new PathfinderGoalRandomLookaround(this));
        }
    }
}
