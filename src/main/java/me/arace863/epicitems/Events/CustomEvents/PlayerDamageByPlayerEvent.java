/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.CustomEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageByPlayerEvent extends EntityDamageByEntityEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    protected Player damager;
    protected Player damagee;
    public PlayerDamageByPlayerEvent(Player damager, Player damagee, EntityDamageEvent.DamageCause cause, double damage) {
        super(damager, damagee, cause, damage);
        this.damager = damager;
        this.damagee = damagee;
    }

    @Override
    public Player getDamager() {
        return damager;
    }

    @Override
    public Player getEntity() {
        return damagee;
    }

    public Player getPlayer() {
        return damagee;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
