package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import javax.annotation.Nonnull;

public class WalkPlayerListener implements Listener {
    private final PerfectEffects plugin;
    public WalkPlayerListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void WalkPlayer(@Nonnull PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        loc.subtract(0, 1, 0);
        Block block = p.getLocation().subtract(0, 1, 0).getBlock();
        if (!Names.get().getBoolean("Lobby")) {
            if (!(block.getType().isInteractable() || !block.getType().isSolid() || Tag.SLABS.isTagged(block.getType())
                    || Tag.BANNERS.isTagged(block.getType()) || Tag.WOODEN_PRESSURE_PLATES.isTagged(block.getType())
                    || Tag.WALLS.isTagged(block.getType()) || block.getType() == Material.LANTERN
                    || block.getType() == Material.GLASS_PANE || block.getType() == Material.BLACK_STAINED_GLASS_PANE
                    || block.getType() == Material.BLUE_STAINED_GLASS_PANE || block.getType() == Material.BROWN_STAINED_GLASS_PANE
                    || block.getType() == Material.CYAN_STAINED_GLASS_PANE || block.getType() == Material.GRAY_STAINED_GLASS_PANE
                    || block.getType() == Material.GREEN_STAINED_GLASS_PANE || block.getType() == Material.LIGHT_BLUE_STAINED_GLASS_PANE
                    || block.getType() == Material.LIGHT_GRAY_STAINED_GLASS_PANE || block.getType() == Material.LIME_STAINED_GLASS_PANE
                    || block.getType() == Material.MAGENTA_STAINED_GLASS_PANE || block.getType() == Material.PINK_STAINED_GLASS_PANE
                    || block.getType() == Material.ORANGE_STAINED_GLASS_PANE || block.getType() == Material.RED_STAINED_GLASS_PANE
                    || block.getType() == Material.PURPLE_STAINED_GLASS_PANE || block.getType() == Material.WHITE_STAINED_GLASS_PANE
                    || block.getType() == Material.YELLOW_STAINED_GLASS_PANE || block.getType() == Material.YELLOW_STAINED_GLASS_PANE
                    || block.getType() == Material.IRON_BARS || block.getType() == Material.CACTUS || block.getType() == Material.COMPOSTER
                    || block.getType() == Material.END_PORTAL_FRAME || block.getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE
                    || block.getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE || block.getType() == Material.STONE_PRESSURE_PLATE)) {
                switch (plugin.data.getWalkFlag(p.getUniqueId())){
                    case 1: {
                        p.sendBlockChange(loc, Material.DIAMOND_ORE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 2: {
                        p.sendBlockChange(loc, Material.GOLD_ORE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 3: {
                        p.sendBlockChange(loc, Material.EMERALD_ORE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 4: {
                        p.sendBlockChange(loc, Material.WHITE_STAINED_GLASS.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 5: {
                        p.sendBlockChange(loc, Material.PINK_STAINED_GLASS.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 6: {
                        p.sendBlockChange(loc, Material.GLASS.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 7: {
                        p.sendBlockChange(loc, Material.RED_STAINED_GLASS.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 8: {
                        p.sendBlockChange(loc, Material.NETHER_QUARTZ_ORE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 9: {
                        p.sendBlockChange(loc, Material.REDSTONE_ORE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 10: {
                        p.sendBlockChange(loc, Material.LAPIS_ORE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 11: {
                        p.sendBlockChange(loc, Material.BLUE_STAINED_GLASS.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 12: {
                        p.sendBlockChange(loc, Material.PINK_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 13: {
                        p.sendBlockChange(loc, Material.LIME_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 14: {
                        p.sendBlockChange(loc, Material.YELLOW_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 15: {
                        p.sendBlockChange(loc, Material.BLUE_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 16: {
                        p.sendBlockChange(loc, Material.MAGENTA_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 17: {
                        p.sendBlockChange(loc, Material.ORANGE_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 18: {
                        p.sendBlockChange(loc, Material.WHITE_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 19: {
                        p.sendBlockChange(loc, Material.CYAN_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 20: {
                        p.sendBlockChange(loc, Material.RED_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                    case 21: {
                        p.sendBlockChange(loc, Material.PURPLE_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;

                    }
                    case 22: {
                        p.sendBlockChange(loc, Material.BLACK_CONCRETE.createBlockData());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> p.sendBlockChange(block.getLocation(), block.getType(), block.getData()), 10);
                        break;
                    }
                }
            }

        }
    }
}
