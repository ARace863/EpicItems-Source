package me.arace863.epicitems.Commands;

import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public Commands() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("epicitems.give") && !player.hasPermission("op")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                player.getWorld().spawnParticle(Particle.BARRIER, player.getLocation(), 10);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 10.0F, 1.0F);
            } else {
                if (cmd.getName().equalsIgnoreCase("endermansword")) {
                    player.getInventory().addItem(ItemManager.EndermanSword);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Enderman Sword§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("acesword")) {
                    player.getInventory().addItem(ItemManager.AceSword);
                    player.sendMessage(ChatColor.GREEN + "Gave the §4Ace Sword§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("rpg")) {
                    player.getInventory().addItem(ItemManager.Rpg);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Rocket Launcher§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("bonemerang")) {
                    player.getInventory().addItem(ItemManager.Bonemerang);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Bonemerang§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("grapplinghook")) {
                    player.getInventory().addItem(ItemManager.GrapplingHook);
                    player.sendMessage(ChatColor.GREEN + "Gave the Grappling Hook to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("endermanbow")) {
                    player.getInventory().addItem(ItemManager.EndermanBow);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Enderman Bow§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("explosivebow")) {
                    player.getInventory().addItem(ItemManager.ExplosiveBow);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Explosive Bow§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("runaansbow")) {
                    player.getInventory().addItem(ItemManager.TripleStrikeBow);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Runaan's Bow§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("evokerstaff")) {
                    player.getInventory().addItem(ItemManager.EvokerStaff);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Evoker Staff§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("airstrike")) {
                    player.getInventory().addItem(ItemManager.Airstrike);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Airstrike§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("knockbackstick")) {
                    player.getInventory().addItem(ItemManager.KnockStick);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Knockback Stick§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("healingsword")) {
                    player.getInventory().addItem(ItemManager.HealingSword);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Healing Sword§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("ultradrill")) {
                    player.getInventory().addItem(ItemManager.UltraDrill);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Ultra Drill§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                // Non item commands
                if (cmd.getName().equalsIgnoreCase("gmc")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.GREEN + "Set " + player.getName() + "'s gamemode to creative!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }
                if (cmd.getName().equalsIgnoreCase("gms")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.GREEN + "Set " + player.getName() + "'s gamemode to survival!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("heal")) {
                    player.setHealth(20.0D);
                    player.setFoodLevel(20);
                    player.sendMessage(ChatColor.GREEN + "Successfully healed " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("losehealth")) {
                    player.setHealth(1.0D);
                    player.setFoodLevel(1);
                    player.sendMessage(ChatColor.GREEN + "Successfully damaged " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }
            }
        }
        return true;
    }
}
