/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugim or sell it by any means.
 */

package me.arace863.epicitems.Utils;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MapUtils extends MapRenderer {

    private BufferedImage image;
    private boolean done;

    public MapUtils(){
        done = false;
    }

    public MapUtils(String url){
        load(url);
        done = false;
    }

    public boolean load(String url){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL(url));
            image = MapPalette.resizeImage(image);
        } catch (IOException e) {
            return false;
        }
        this.image = image;
        return true;
    }

    @Override
    public void render(MapView view, MapCanvas canvas, Player player) {
        if (done)
            return;

        canvas.drawImage(0, 0, image);

        view.setTrackingPosition(false);
        done = true;
    }
}
