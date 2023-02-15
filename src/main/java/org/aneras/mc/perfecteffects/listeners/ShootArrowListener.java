package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class ShootArrowListener implements Listener {
    private final Map<Projectile, BukkitTask> ArrowTasks = new HashMap<>();
    private final PerfectEffects plugin;

    public ShootArrowListener(PerfectEffects plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ArrowShoot(@Nonnull EntityShootBowEvent e) {
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if (!Names.get().getBoolean("Lobby")) {
                final AbstractArrow arrow = (Arrow) e.getProjectile();
                ArrowTasks.put(arrow, new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (!arrow.isOnGround() && !arrow.isDead()) {
                            World w = arrow.getWorld();
                            Location l = arrow.getLocation();
                            arrow.setCritical(false);
                            switch (plugin.data.getArrowFlag(p.getUniqueId())) {
                                case 1: {
                                    for (double t = 0; t <= 2 * Math.PI; t += Math.PI / 16) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.REDSTONE, arrow.getLocation().add(x, y, 0), 3, new Particle.DustOptions(Color.fromBGR(255, 0, 0), 1));
                                    }
                                    break;
                                }
                                case 2:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.HEART, arrow.getLocation().add(x, y, 0),  1);
                                    }
                                    break;
                                case 3:
                                    for (double t = 0; t <= Math.PI; t += Math.PI / 3) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.SLIME, arrow.getLocation().add(x, y, 0), 0);
                                        w.spawnParticle(Particle.SLIME, arrow.getLocation().add(-x, y, 0), 0);
                                    }

                                    break;
                                case 4:
                                    w.spawnParticle(Particle.WATER_DROP, arrow.getLocation(),  50);
                                    break;
                                case 5:
                                    w.spawnParticle(Particle.VILLAGER_ANGRY, l, 2);
                                    break;
                                case 6:
                                    for (double t = 0; t <= Math.PI / 4; t += Math.PI / 16) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.VILLAGER_HAPPY, arrow.getLocation().add(x, y, 0), 1);
                                        w.spawnParticle(Particle.VILLAGER_HAPPY, arrow.getLocation().add(-x, y, 0), 1);
                                        w.spawnParticle(Particle.VILLAGER_HAPPY, arrow.getLocation().add(x, -y, 0), 1);
                                        w.spawnParticle(Particle.VILLAGER_HAPPY, arrow.getLocation().add(-x, -y, 0), 1);
                                    }
                                    break;
                                case 7:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.SPELL, arrow.getLocation().add(x, y, 0),  1);
                                    }
                                    break;
                                case 8:
                                    for (double t = 0; t <= 2 * Math.PI; t += 0.5) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.CRIT_MAGIC, arrow.getLocation().add(x, y, 0),  0);
                                    }
                                    break;
                                case 9:
                                    for (double t = 0; t <= 2 * Math.PI; t += 0.5) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.FLAME, arrow.getLocation().add(x, y, 0),  0);
                                    }
                                    break;
                                case 10:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.END_ROD, arrow.getLocation().add(x, y, 0),  0);
                                    }
                                    break;
                                case 11:
                                    w.spawnParticle(Particle.SNOW_SHOVEL, l, 5);
                                    break;
                                case 12:
                                    w.spawnParticle(Particle.PORTAL, l, 50);
                                    break;
                                case 13: {
                                    ItemStack dropDiamond = new ItemStack(Material.DIAMOND);
                                    Item diamond = w.dropItem(l, dropDiamond);
                                    diamond.setGravity(false);
                                    diamond.setPickupDelay(Integer.MAX_VALUE);
                                    Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), diamond::remove, 10, 10);
                                    break;
                                }
                                case 14: {
                                    ItemStack dropGold = new ItemStack(Material.GOLD_INGOT);
                                    Item gold = w.dropItem(l, dropGold);
                                    gold.setGravity(false);
                                    gold.setPickupDelay(Integer.MAX_VALUE);
                                    Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), gold::remove, 10, 10);
                                    break;
                                }
                                case 15:
                                    w.spawnParticle(Particle.NOTE, l, 1);
                                    break;
                                case 16:
                                    w.spawnParticle(Particle.DAMAGE_INDICATOR, l, 2);
                                    break;
                                case 17:
                                    w.spawnParticle(Particle.SPELL_WITCH, l, 5);
                                    break;
                                case 18:
                                    w.spawnParticle(Particle.CRIT_MAGIC, arrow.getLocation(),  5);
                                    break;
                                case 19:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.FALLING_LAVA, arrow.getLocation().add(x, y, 0),  5);
                                    }
                                    break;
                                case 20:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.SQUID_INK, arrow.getLocation().add(x, y, 0),  1);
                                    }
                                    break;
                                case 21:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.25* Math.cos(t);
                                        double y = 0.25* Math.sin(t);
                                        w.spawnParticle(Particle.NAUTILUS, arrow.getLocation().add(x, y, 0),  0);
                                    }
                                    break;
                                case 22:
                                    for (double t = 0; t <= 2 * Math.PI; t += 1) {
                                        double x = 0.5 * Math.cos(t);
                                        double y = 0.5 * Math.sin(t);
                                        w.spawnParticle(Particle.TOTEM, arrow.getLocation().add(x, y, 0),  0);
                                    }
                                    break;
                                default: {
                                    cancel();
                                }
                            }
                        } else cancel();
                    }
                }.runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), 0L, 1L));
            }
        }
    }

}