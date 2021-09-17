package me.arace863.epicitems.Events;

import java.io.File;
import java.util.Iterator;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

public class Test implements Listener {
    FileConfiguration config;

    public Test(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (this.config.getBoolean("Airstrike", true)) {
            Player p = e.getPlayer();
            if ((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && e.getItem() != null && e.getItem().getItemMeta().equals(ItemManager.Airstrike.getItemMeta())) {
                if (Cooldown.checkCooldown(e.getPlayer())) {
                    BlockIterator iter = new BlockIterator(p, 50);
                    Block finalBlock = iter.next();

                    while(iter.hasNext()) {
                        finalBlock = iter.next();
                        if (finalBlock.getType().isSolid()) {
                            break;
                        }
                    }

                    Location l = finalBlock.getLocation();
                    l.setY(l.getY() + 70.0D);
                    l.setX(l.getX() + 0.5D);
                    l.setZ(l.getZ() + 0.5D);
                    Location l1 = finalBlock.getLocation();
                    l1.setY(l1.getY() + 70.0D);
                    l1.setX(l1.getX() + 15.5D);
                    l1.setZ(l1.getZ() + 0.5D);
                    Location l2 = finalBlock.getLocation();
                    l2.setY(l2.getY() + 70.0D);
                    l2.setX(l2.getX() - 15.5D);
                    l2.setZ(l2.getZ() - 0.5D);

                    try {
                        Location f = p.getLocation();
                        int x = (int)f.getX();
                        int y = (int)f.getY();
                        int z = (int)f.getZ();
                        String string = this.config.getString("message").replaceAll("%x%", Integer.toString(x)).replaceAll("%y%", Integer.toString(y)).replaceAll("%z%", Integer.toString(z));
                        p.getWorld().spawn(l, TNTPrimed.class);
                        p.getWorld().spawn(l, TNTPrimed.class);
                        p.getWorld().spawn(l, TNTPrimed.class);
                        p.getWorld().spawn(l, TNTPrimed.class);
                        p.getWorld().spawn(l, TNTPrimed.class);

                        p.getWorld().spawn(l1, TNTPrimed.class);
                        p.getWorld().spawn(l1, TNTPrimed.class);
                        p.getWorld().spawn(l1, TNTPrimed.class);
                        p.getWorld().spawn(l1, TNTPrimed.class);
                        p.getWorld().spawn(l1, TNTPrimed.class);

                        p.getWorld().spawn(l2, TNTPrimed.class);
                        p.getWorld().spawn(l2, TNTPrimed.class);
                        p.getWorld().spawn(l2, TNTPrimed.class);
                        p.getWorld().spawn(l2, TNTPrimed.class);
                        p.getWorld().spawn(l2, TNTPrimed.class);
                        Bukkit.broadcastMessage(ChatColor.RED + p.getName() + " has launched an airstrike at" + string);
                        Cooldown.setCooldown(e.getPlayer(), this.config.getInt("AirstrikeCooldown"));
                        Iterator var13 = Bukkit.getOnlinePlayers().iterator();

                        while(var13.hasNext()) {
                            Player player = (Player)var13.next();
                            player.sendTitle(ChatColor.RED + "AIRSTRIKE LAUNCHED AT", ChatColor.RED + string, 1, 60, 2);
                            if (Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")){
                                Song airstrikealert = NBSDecoder.parse(new File("C:\\Users\\USER\\Desktop\\Development\\Spigot Plugins\\EpicItems\\src\\main\\java\\me\\arace863\\epicitems\\Songs\\airstrikealert.nbs"));
                                RadioSongPlayer rsp = new RadioSongPlayer(airstrikealert);
                                rsp.addPlayer(player);
                                rsp.setPlaying(true);
                            }
                        }
                    } catch (NullPointerException var15) {
                        var15.printStackTrace();
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round(((Double)Cooldown.cooldowns.get(p.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0D) + "s.");
                }
            }
        }

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (this.config.getBoolean("Airstrike", true)) {
            Player p = event.getPlayer();
            if (p.getEquipment().getItemInMainHand().getItemMeta().getDisplayName().equals(ItemManager.Airstrike.getItemMeta().getDisplayName())) {
                event.setCancelled(true);
            }
        }

    }
}