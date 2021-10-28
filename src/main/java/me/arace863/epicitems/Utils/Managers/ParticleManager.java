/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Utils.Managers;

import me.arace863.epicitems.EpicItems;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ParticleManager {
    EpicItems plugin;

    public ParticleManager(EpicItems plugin) {
        this.plugin = plugin;
    }

    public void waveParticle(Entity entity) {
        World world = entity.getWorld();
        new BukkitRunnable() {
            double t = Math.PI / 4;
            Location loc = entity.getLocation();

            public void run() {
                t = t + 0.1 * Math.PI;
                for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
                    double x = t * Math.cos(theta);
                    double y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 1.5;
                    double z = t * Math.sin(theta);
                    loc.add(x, y, z);
                    world.spawnParticle(Particle.FIREWORKS_SPARK, loc, 1, 0, 0, 0, 0);
                    loc.subtract(x, y, z);

                    theta = theta + Math.PI / 64;

                    x = t * Math.cos(theta);
                    y = 2 * Math.exp(-0.1 * t) * Math.sin(t) + 1.5;
                    z = t * Math.sin(theta);
                    loc.add(x, y, z);
                    world.spawnParticle(Particle.SPELL_WITCH, loc, 1, 0, 0, 0);
                    loc.subtract(x, y, z);
                }
                if (t > 20) {
                    this.cancel();
                }
            }

        }.runTaskTimer(this.plugin, 0, 1);
    }

    public void fireSpiral(Entity entity){
        final World world = entity.getWorld();
        new BukkitRunnable() {
            Location loc = entity.getLocation();
            double t = 0;
            double r = 1;

            @Override
            public void run() {
                t = t + Math.PI/8;
                double x = r*cos(t);
                double y = t;
                double z = r*sin(t);
                loc.add(x, y, z);
                world.spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                loc.subtract(x, y, z);
                if (t > Math.PI*4){
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void ashCone(final Entity entity){
        new BukkitRunnable() {
            double phi = 0;

            @Override
            public void run() {
                phi += Math.PI/16;
                double x; double y; double z;
                Location loc = entity.getLocation();
                World world = entity.getWorld();
                for (double t = 0; t <= 2*Math.PI; t += Math.PI/16) {
                    for (double i = 0; i <= 1; i += 1){
                        x = 0.15*(2*Math.PI-t)*cos(t + phi + i*Math.PI);
                        y = 0.5*t;
                        z = 0.15*(2*Math.PI-t)*sin(t + phi + i*Math.PI);
                        loc.add(x,y,z);
                        world.spawnParticle(Particle.ASH, loc, 0, 0, 0, 0, 1);
                        loc.subtract(x,y,z);
                    }
                }
                if (phi > 10*Math.PI) {
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 2);
    }

    public void waterSphere(Entity entity){
        final Location loc = entity.getLocation();
        World world = entity.getWorld();
        new BukkitRunnable() {
            double phi = 0;
            @Override
            public void run() {
                phi += Math.PI/10;
                for (double theta = 0; theta <= 2*Math.PI; theta += Math.PI/40) {
                    double r = 1.5;
                    double x = r*cos(theta)*sin(phi);
                    double y = r*cos(phi) + 1.5;
                    double z = r*sin(theta)*sin(phi);
                    loc.add(x,y,z);
                    world.spawnParticle(Particle.WATER_DROP, loc, 0, 0, 0, 0, 1);
                    loc.subtract(x,y,z);
                }

                if (phi > Math.PI){
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void lavaSphere(Entity entity){
        final Location loc = entity.getLocation();
        World world = entity.getWorld();
        new BukkitRunnable() {
            double phi = 0;
            @Override
            public void run() {
                phi += Math.PI/10;
                for (double theta = 0; theta <= 2*Math.PI; theta += Math.PI/40) {
                    double r = 1.5;
                    double x = r*cos(theta)*sin(phi);
                    double y = r*cos(phi) + 1.5;
                    double z = r*sin(theta)*sin(phi);
                    loc.add(x,y,z);
                    world.spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                    loc.subtract(x,y,z);
                }

                if (phi > Math.PI){
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    // TODO: 9/26/2021 Add FireBallRod particle here from advanced bukkit tutorials guide 
}
