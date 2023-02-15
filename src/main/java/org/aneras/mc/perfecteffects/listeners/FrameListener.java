package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.aneras.mc.perfecteffects.other.RenderMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.annotation.Nonnull;

public class FrameListener implements Listener {
    private final PerfectEffects plugin;
    public FrameListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void ClickFrame(@Nonnull EntityDamageByEntityEvent e) {
        if (!Names.get().getBoolean("Lobby")) {
            if (e.getEntity() instanceof ItemFrame) {
                e.setCancelled(true);
                if (e.getDamager() instanceof Player) {
                    Player p = (Player) e.getDamager();
                    ItemFrame itemFrame = (ItemFrame) e.getEntity();
                    ItemStack map = new ItemStack((Material.FILLED_MAP));
                    MapMeta mapMeta = (MapMeta) map.getItemMeta();
                    MapView view = Bukkit.createMap(p.getWorld());
                    for (MapRenderer rend : view.getRenderers()) {
                        view.removeRenderer(rend);
                    }
                    view.addRenderer(new RenderMap(plugin));
                    mapMeta.setMapView(view);
                    map.setItemMeta(mapMeta);
                    itemFrame.setRotation(itemFrame.getRotation());
                    itemFrame.setItem(map);

                }
            }
            if (e.getEntity() instanceof Player) {
                if (e.getDamager() instanceof Firework) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
