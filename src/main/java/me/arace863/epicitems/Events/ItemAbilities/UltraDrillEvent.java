/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class UltraDrillEvent implements Listener {

    BlockFace blockFace = null;
    FileConfiguration config;

    public UltraDrillEvent(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            blockFace = event.getBlockFace();
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Item Ability: Super Mine §e§lRIGHT CLICK")) {
            if (Cooldown.checkCooldown(event.getPlayer())){
                try {
                    Cooldown.setCooldown(event.getPlayer(), this.config.getInt("UltraDrillCooldown"));
                    if (blockFace.equals(BlockFace.UP) || blockFace.equals(BlockFace.DOWN)){
                        Block block1 = block.getRelative(BlockFace.EAST);
                        Block block2 = block.getRelative(BlockFace.WEST);
                        Block block3 = block.getRelative(BlockFace.NORTH);
                        Block block4 = block.getRelative(BlockFace.SOUTH);
                        Block block5 = block.getRelative(BlockFace.SOUTH_WEST);
                        Block block6 = block.getRelative(BlockFace.SOUTH_EAST);
                        Block block7 = block.getRelative(BlockFace.NORTH_WEST);
                        Block block8 = block.getRelative(BlockFace.NORTH_EAST);
                        if (block1.getType().equals(Material.STONE) || block1.getType().equals(Material.ANDESITE) || block1.getType().equals(Material.DIORITE) || block1.getType().equals(Material.GRANITE) || block1.getType().equals(Material.BASALT)){
                            block1.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block2.getType().equals(Material.STONE) || block2.getType().equals(Material.ANDESITE) || block2.getType().equals(Material.DIORITE) || block2.getType().equals(Material.GRANITE) || block2.getType().equals(Material.BASALT)){
                            block2.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block3.getType().equals(Material.STONE) || block3.getType().equals(Material.ANDESITE) || block3.getType().equals(Material.DIORITE) || block3.getType().equals(Material.GRANITE) || block3.getType().equals(Material.BASALT)){
                            block3.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block4.getType().equals(Material.STONE) || block4.getType().equals(Material.ANDESITE) || block4.getType().equals(Material.DIORITE) || block4.getType().equals(Material.GRANITE) || block4.getType().equals(Material.BASALT)){
                            block4.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block5.getType().equals(Material.STONE) || block5.getType().equals(Material.ANDESITE) || block5.getType().equals(Material.DIORITE) || block5.getType().equals(Material.GRANITE) || block5.getType().equals(Material.BASALT)){
                            block5.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block6.getType().equals(Material.STONE) || block6.getType().equals(Material.ANDESITE) || block6.getType().equals(Material.DIORITE) || block6.getType().equals(Material.GRANITE) || block6.getType().equals(Material.BASALT)){
                            block6.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block7.getType().equals(Material.STONE) || block7.getType().equals(Material.ANDESITE) || block7.getType().equals(Material.DIORITE) || block7.getType().equals(Material.GRANITE) || block7.getType().equals(Material.BASALT)){
                            block7.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block8.getType().equals(Material.STONE) || block8.getType().equals(Material.ANDESITE) || block8.getType().equals(Material.DIORITE) || block8.getType().equals(Material.GRANITE) || block8.getType().equals(Material.BASALT)){
                            block8.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }
                    }

                    if (blockFace.equals(BlockFace.EAST) || blockFace.equals(BlockFace.WEST)){
                        Block block1 = block.getRelative(BlockFace.UP);
                        Block block2 = block.getRelative(BlockFace.DOWN);
                        Block block3 = block.getRelative(BlockFace.NORTH);
                        Block block4 = block.getRelative(BlockFace.SOUTH);
                        Block block5 = block1.getRelative(BlockFace.NORTH);
                        Block block6 = block1.getRelative(BlockFace.SOUTH);
                        Block block7 = block2.getRelative(BlockFace.NORTH);
                        Block block8 = block2.getRelative(BlockFace.SOUTH);
                        if (block1.getType().equals(Material.STONE) || block1.getType().equals(Material.ANDESITE) || block1.getType().equals(Material.DIORITE) || block1.getType().equals(Material.GRANITE) || block1.getType().equals(Material.BASALT)){
                            block1.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block2.getType().equals(Material.STONE) || block2.getType().equals(Material.ANDESITE) || block2.getType().equals(Material.DIORITE) || block2.getType().equals(Material.GRANITE) || block2.getType().equals(Material.BASALT)){
                            block2.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block3.getType().equals(Material.STONE) || block3.getType().equals(Material.ANDESITE) || block3.getType().equals(Material.DIORITE) || block3.getType().equals(Material.GRANITE) || block3.getType().equals(Material.BASALT)){
                            block3.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block4.getType().equals(Material.STONE) || block4.getType().equals(Material.ANDESITE) || block4.getType().equals(Material.DIORITE) || block4.getType().equals(Material.GRANITE) || block4.getType().equals(Material.BASALT)){
                            block4.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block5.getType().equals(Material.STONE) || block5.getType().equals(Material.ANDESITE) || block5.getType().equals(Material.DIORITE) || block5.getType().equals(Material.GRANITE) || block5.getType().equals(Material.BASALT)){
                            block5.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block6.getType().equals(Material.STONE) || block6.getType().equals(Material.ANDESITE) || block6.getType().equals(Material.DIORITE) || block6.getType().equals(Material.GRANITE) || block6.getType().equals(Material.BASALT)){
                            block6.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block7.getType().equals(Material.STONE) || block7.getType().equals(Material.ANDESITE) || block7.getType().equals(Material.DIORITE) || block7.getType().equals(Material.GRANITE) || block7.getType().equals(Material.BASALT)){
                            block7.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block8.getType().equals(Material.STONE) || block8.getType().equals(Material.ANDESITE) || block8.getType().equals(Material.DIORITE) || block8.getType().equals(Material.GRANITE) || block8.getType().equals(Material.BASALT)){
                            block8.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }
                    }

                    if (blockFace.equals(BlockFace.NORTH) || blockFace.equals(BlockFace.SOUTH)){
                        Block block1 = block.getRelative(BlockFace.UP);
                        Block block2 = block.getRelative(BlockFace.DOWN);
                        Block block3 = block.getRelative(BlockFace.EAST);
                        Block block4 = block.getRelative(BlockFace.WEST);
                        Block block5 = block1.getRelative(BlockFace.EAST);
                        Block block6 = block1.getRelative(BlockFace.WEST);
                        Block block7 = block2.getRelative(BlockFace.EAST);
                        Block block8 = block2.getRelative(BlockFace.WEST);
                        if (block1.getType().equals(Material.STONE) || block1.getType().equals(Material.ANDESITE) || block1.getType().equals(Material.DIORITE) || block1.getType().equals(Material.GRANITE) || block1.getType().equals(Material.BASALT)){
                            block1.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block2.getType().equals(Material.STONE) || block2.getType().equals(Material.ANDESITE) || block2.getType().equals(Material.DIORITE) || block2.getType().equals(Material.GRANITE) || block2.getType().equals(Material.BASALT)){
                            block2.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block3.getType().equals(Material.STONE) || block3.getType().equals(Material.ANDESITE) || block3.getType().equals(Material.DIORITE) || block3.getType().equals(Material.GRANITE) || block3.getType().equals(Material.BASALT)){
                            block3.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block4.getType().equals(Material.STONE) || block4.getType().equals(Material.ANDESITE) || block4.getType().equals(Material.DIORITE) || block4.getType().equals(Material.GRANITE) || block4.getType().equals(Material.BASALT)){
                            block4.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block5.getType().equals(Material.STONE) || block5.getType().equals(Material.ANDESITE) || block5.getType().equals(Material.DIORITE) || block5.getType().equals(Material.GRANITE) || block5.getType().equals(Material.BASALT)){
                            block5.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block6.getType().equals(Material.STONE) || block6.getType().equals(Material.ANDESITE) || block6.getType().equals(Material.DIORITE) || block6.getType().equals(Material.GRANITE) || block6.getType().equals(Material.BASALT)){
                            block6.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block7.getType().equals(Material.STONE) || block7.getType().equals(Material.ANDESITE) || block7.getType().equals(Material.DIORITE) || block7.getType().equals(Material.GRANITE) || block7.getType().equals(Material.BASALT)){
                            block7.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }

                        if (block8.getType().equals(Material.STONE) || block8.getType().equals(Material.ANDESITE) || block8.getType().equals(Material.DIORITE) || block8.getType().equals(Material.GRANITE) || block8.getType().equals(Material.BASALT)){
                            block8.setType(Material.AIR);
                            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                                block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.STONE));
                            }else{
                                block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.COBBLESTONE));
                            }
                        }
                    }
                }catch (NullPointerException exception){
                    Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                    exception.printStackTrace();
                }

            }else{
                player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(player.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
            }
        }
    }
}
