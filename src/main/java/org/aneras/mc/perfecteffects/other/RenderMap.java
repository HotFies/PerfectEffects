package org.aneras.mc.perfecteffects.other;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class RenderMap extends MapRenderer {
    private PerfectEffects plugin;
    public RenderMap(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @Override
    public void render(@Nonnull MapView view, @Nonnull MapCanvas canvas, Player player) {
        try {
            switch (plugin.data.getFrameFlag(player.getUniqueId())){
                case 0:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "default.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 1:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "1.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 2:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "2.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 3:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "3.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 4:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "4.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 5:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "5.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 6:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "6.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 7:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "7.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 8:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "8.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 9:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "9.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 10:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "10.jpg"));
                    canvas.drawImage(0, 0, image);
                }
                case 11:{
                    BufferedImage image = ImageIO.read(new File(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("MGEffects")).getDataFolder() + File.separator + "Pictures", "11.jpg"));
                    canvas.drawImage(0, 0, image);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}