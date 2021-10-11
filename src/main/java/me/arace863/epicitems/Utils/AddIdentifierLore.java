/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AddIdentifierLore implements Listener {

    @EventHandler
    public void createLore(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();

        //Sorry for whoever has to read this eyesore of code. will optimise later...
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            if (event.getItem() != null && event.getItem().getItemMeta().hasLore()){
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§dEnderman Sword")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-EndermanSword")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-EndermanSword");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§4♠ Ace Sword")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-AceSword")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-AceSword");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§6Rocket Launcher")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-RPG")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-RPG");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§6Bonemerang")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-Bonemerang")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-Bonemerang");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§aGrappling Hook")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-GrapplingHook")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-GrapplingHook");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§cEnderman Bow [UNFINISHED]")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-EndermanBow")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-EndermanBow");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§cExplosive Bow [UNFINISHED]")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-ExplosiveBow")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-ExplosiveBow");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals("§6Runaan's Bow")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-TSB")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-TSB");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Evoker Staff")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-EvokerStaff")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-EvokerStaff");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Airstrike")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-Airstrike")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-Airstrike");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Knockback Stick")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-KnockStick")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-KnockStick");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Healing Sword")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-HealingSword")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-HealingSword");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
                if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Ultra Drill")){
                    if (!event.getItem().getItemMeta().getLore().contains("§8EpicItem-UltraDrill")){
                        List<String> lore = new ArrayList<String>();
                        if(meta.hasLore()){
                            lore = meta.getLore();
                        }
                        lore.add(" ");
                        lore.add("§8EpicItem-UltraDrill");
                        meta.setLore(lore);
                        player.getInventory().getItemInMainHand().setItemMeta(meta);
                    }
                }
            }
        }
    }
}
