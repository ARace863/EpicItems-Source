/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.arace863.epicitems.EpicItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class UtilOptions {
    FileConfiguration config;
    EpicItems plugin;

    public UtilOptions(EpicItems plugin) {
        this.config = plugin.getConfig();
        this.plugin = plugin;
    }

    public ItemStack getSkull(String url){
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url == null || url.isEmpty())
            return skull;
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(skullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        skull.setItemMeta(skullMeta);
        return skull;
    }

    public void playerMessage(Player player, String message) {
        player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.translateAlternateColorCodes('&', message));
        // TODO: 10/9/2021 Replace all strings with this method to get rid of the pesky '§' 
    }

    public void consoleMessages(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.translateAlternateColorCodes('&', message));
    }
}
