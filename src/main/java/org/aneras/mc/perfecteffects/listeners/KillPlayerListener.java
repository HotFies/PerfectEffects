package org.aneras.mc.perfecteffects.listeners;


import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.Objects;

public class KillPlayerListener implements Listener {
    private final PerfectEffects plugin;
    public KillPlayerListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void KillPlayer(@Nonnull PlayerDeathEvent e) throws ReflectiveOperationException {
        if (!Names.get().getBoolean("Lobby")) {
            if (e.getEntity().getKiller() != null) {
                Player killer = e.getEntity().getKiller();
                Player player = e.getEntity().getPlayer();
                switch (plugin.data.getKillFlag(killer.getUniqueId())) {
                    case 1: {
                        Firework fw = (Firework) Objects.requireNonNull(player).getWorld().spawnEntity(killer.getLocation(), EntityType.FIREWORK);
                        FireworkMeta fwMeta = fw.getFireworkMeta();
                        fwMeta.addEffect(FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build());
                        fw.setFireworkMeta(fwMeta);
                        fw.detonate();
                        break;
                    }
                    case 2: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        w.strikeLightningEffect(l);
                        break;
                    }
                    case 3: {
                        Location l = Objects.requireNonNull(player).getLocation();
                        Squid ent = (Squid) player.getWorld().spawnEntity(l.add(0, 1, 0), EntityType.SQUID);
                        ent.setGravity(false);
                        ent.setVelocity(new Vector(0, 2.5, 0).multiply(0.2));
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            Firework fw = (Firework) player.getWorld().spawnEntity(ent.getLocation(), EntityType.FIREWORK);
                            FireworkMeta fwMeta = fw.getFireworkMeta();
                            fwMeta.addEffect(FireworkEffect.builder().withColor(Color.BLACK).with(FireworkEffect.Type.BALL).build());
                            fwMeta.setPower(5);
                            fw.setFireworkMeta(fwMeta);
                            fw.detonate();
                            ent.remove();
                        }, 20L);
                    }
                    break;
                    case 4: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        w.spawnParticle(Particle.EXPLOSION_LARGE, l.add(0, 1, 0), 5);
                        w.createExplosion(l.add(0, 1.5, 0), 0);
                        break;
                    }
                    case 5: {
                        World w = killer.getWorld();
                        Location l = Objects.requireNonNull(player).getLocation();
                        ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(l.add(0, 1.5, 0), EntityType.ARMOR_STAND);
                        stand.setVisible(false);
                        ItemStack head = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE2YzFlZGYyZjQzMmM5MGQ2NTk4YWE2ZTg2MGEzMzAzZjg1Zjc2MzdkYTgyZGQ0YjUxNTFmZjY2NWZlZTNhMiJ9fX0=");
                        stand.setItem(EquipmentSlot.HEAD, head);
                        stand.setVelocity(new Vector(0, 7, 0).multiply(0.2));
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            i[0]++;
                            if (i[0] < 15) {
                                w.spawnParticle(Particle.REDSTONE.builder().color(Color.WHITE).particle(), stand.getLocation().add(0, -0.3, 0), 20, new Particle.DustOptions(Color.WHITE, 1));
                            }
                        }, 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            w.spawnParticle(Particle.BLOCK_CRACK, stand.getLocation().add(0, 1.5, 0), 500, Material.REDSTONE_BLOCK.createBlockData());
                            stand.remove();
                        }, 20L);
                        break;
                    }
                    case 6: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation().add(0, 2, 0);
                        ItemStack cookie = new ItemStack(Material.COOKIE);
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            i[0]++;
                            if (i[0] < 100) {
                                Item item = w.dropItem(l, cookie);
                                item.setGravity(false);
                                item.setPickupDelay(Integer.MAX_VALUE);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), item::remove, 20);
                            }
                        }, 1, 1);
                        break;
                    }
                    case 7: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        w.spawnParticle(Particle.SMOKE_LARGE, l, 250);
                        w.playSound(l, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 25, 0);
                        break;
                    }
                    case 8: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation().add(0, 2, 0);
                        ItemStack gold_ingot = new ItemStack(Material.GOLD_INGOT);
                        ItemStack gold_block = new ItemStack(Material.GOLD_BLOCK);
                        ItemStack gold_nugget = new ItemStack(Material.GOLD_NUGGET);
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            i[0]++;
                            if (i[0] < 10) {
                                Item ingot = w.dropItem(l, gold_ingot);
                                Item block = w.dropItem(l, gold_block);
                                Item nugget = w.dropItem(l, gold_nugget);
                                ingot.setGravity(false);
                                block.setGravity(false);
                                nugget.setGravity(false);
                                ingot.setPickupDelay(Integer.MAX_VALUE);
                                block.setPickupDelay(Integer.MAX_VALUE);
                                nugget.setPickupDelay(Integer.MAX_VALUE);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                    ingot.remove();
                                    block.remove();
                                    nugget.remove();
                                }, 20);
                            }
                        }, 3, 5);
                        break;
                    }
                    case 9: {
                        World w = Objects.requireNonNull(player).getWorld();
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            i[0]++;
                            if (i[0] < 150) {
                                w.spawnParticle(Particle.FLAME, killer.getLocation().add(-0.15, 0, 0), 0);
                                w.spawnParticle(Particle.FLAME, killer.getLocation().add(0.15, 0, 0), 0);
                            }
                        }, 1, 1);
                        break;
                    }
                    case 10: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        w.spawnParticle(Particle.BLOCK_CRACK, l.add(0, 0, 0), 100, Material.REDSTONE_BLOCK.createBlockData());
                        w.spawnParticle(Particle.BLOCK_CRACK, l.add(0, 1, 0), 100, Material.REDSTONE_BLOCK.createBlockData());
                        break;
                    }
                    case 11: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation().add(0, 2, 0);
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            i[0]++;
                            if (i[0] < 7) {
                                Chicken chicken = (Chicken) w.spawnEntity(l.add(0, 1, 0), EntityType.CHICKEN);
                                chicken.setMaxHealth(Double.MAX_VALUE);
                                chicken.setHealth(2048);
                                chicken.setBaby();

                                Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), chicken::remove, 50);
                            }
                        }, 5, 5);
                        break;
                    }
                    case 12: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation().add(0, 1, 0);
                        for (int i = 0; i < 10; i++) {
                            Rabbit rabbit = (Rabbit) w.spawnEntity(l, EntityType.RABBIT);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                rabbit.setMaxHealth(Double.MAX_VALUE);
                                rabbit.setHealth(2048);
                                w.createExplosion(rabbit.getLocation(), 0);
                                rabbit.remove();
                            }, 20);
                        }
                        break;
                    }
                    case 13: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation().add(0, 1, 0);
                        final int[] b = {0};
                        for (int i = 0; i < 7; i++) {
                            Bat bat = (Bat) w.spawnEntity(l, EntityType.BAT);
                            bat.setMaxHealth(Double.MAX_VALUE);
                            bat.setHealth(2048);
                            Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                b[0]++;
                                if (b[0] < 725) {
                                    w.spawnParticle(Particle.REDSTONE, bat.getLocation().add(0, 0.1, 0), 10, new Particle.DustOptions(Color.GRAY, 1));
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), bat::remove, 100);
                                }
                            }, 1, 1);
                        }
                        break;
                    }
                    case 14: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        Cow cow = (Cow) player.getWorld().spawnEntity(l.add(0, 1, 0), EntityType.COW);
                        cow.setMaxHealth(Double.MAX_VALUE);
                        cow.setHealth(2048);
                        cow.setGravity(false);
                        cow.setVelocity(new Vector(0, 2.5, 0).multiply(0.2));
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            i[0]++;
                            if (i[0] < 15) {
                                w.spawnParticle(Particle.FLAME, cow.getLocation(), 0);
                            }
                        }, 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            Firework fw = (Firework) player.getWorld().spawnEntity(cow.getLocation(), EntityType.FIREWORK);
                            FireworkMeta fwMeta = fw.getFireworkMeta();
                            fwMeta.addEffect(FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).build());
                            fwMeta.setPower(5);
                            fw.setFireworkMeta(fwMeta);
                            fw.detonate();
                            cow.remove();
                        }, 20L);
                        break;
                    }
                    case 15: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        final int[] b = {0};
                        final int[] i = {0};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            b[0]++;
                            if (b[0] < 4) {
                                ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(l.add(0, 1.5, 0), EntityType.ARMOR_STAND);
                                stand.setVisible(false);
                                ItemStack head = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY4NGYxMTQ4MGMwZmM5NzQ4MGVkMWI3MGMyMzEzOWJiNGZjZDYxNmNjOTY3ZTZjNzc5YmExZDJlZDU1In19fQ==");
                                stand.setItem(EquipmentSlot.HEAD, head);
                                stand.setVelocity(new Vector(0, 7, 0).multiply(0.2));
                                Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                    i[0]++;
                                    if (i[0] < 15) {
                                        w.spawnParticle(Particle.REDSTONE, stand.getLocation().add(0, -0.3, 0), 20, new Particle.DustOptions(Color.WHITE, 1));
                                    }
                                }, 1, 1);
                                Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                    Firework fw = (Firework) player.getWorld().spawnEntity(stand.getLocation(), EntityType.FIREWORK);
                                    FireworkMeta fwMeta = fw.getFireworkMeta();
                                    fwMeta.addEffect(FireworkEffect.builder().withColor(Color.YELLOW).with(FireworkEffect.Type.BALL).build());
                                    fwMeta.setPower(5);
                                    fw.setFireworkMeta(fwMeta);
                                    fw.detonate();
                                    stand.remove();

                                }, 15L);
                            }
                        }, 10, 10);
                        break;
                    }
                    case 16: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation().add(0, 2.5, 0);
                        Location l_1, l_2, l_3, l_4, l_5, l_6, l_7, l_8;
                        l_1 = l.clone().add(1, 0, 0);
                        l_2 = l.clone().add(0, 0, 1);
                        l_3 = l.clone().add(-1, 0, 0);
                        l_4 = l.clone().add(0, 0, -1);
                        l_5 = l_1.clone().add(0, 0, 1);
                        l_6 = l_2.clone().add(-1, 0, 0);
                        l_7 = l_3.clone().add(0, 0, -1);
                        l_8 = l_4.clone().add(1, 0, 0);
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                i++;
                                if (i < 10) {
                                    w.spawnParticle(Particle.REDSTONE, l, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_1, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_5, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_2, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_6, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_3, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_7, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_4, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.REDSTONE, l_8, 10, new Particle.DustOptions(Color.WHITE, 5));
                                    w.spawnParticle(Particle.WATER_DROP, l_1, 5);
                                    w.spawnParticle(Particle.WATER_DROP, l_2, 5);
                                    w.spawnParticle(Particle.WATER_DROP, l_3, 5);
                                    w.spawnParticle(Particle.WATER_DROP, l_4, 5);
                                }
                            }
                        }, 5, 5);
                        break;
                    }
                    case 17: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        w.spawnParticle(Particle.BLOCK_CRACK, l.add(0, 0, 0), 100, Material.WHITE_STAINED_GLASS_PANE.createBlockData());
                        w.spawnParticle(Particle.BLOCK_CRACK, l.add(0, 1, 0), 100, Material.WHITE_STAINED_GLASS_PANE.createBlockData());
                        w.playSound(l, Sound.BLOCK_GLASS_BREAK, 10, 1);
                        break;
                    }
                    case 18: {
                        World w = Objects.requireNonNull(player).getWorld();
                        Location l = player.getLocation();
                        final double[] r = {0.5};
                        final float[] y = {(float) l.getY()};
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;
                            @Override
                            public void run() {
                                i++;
                                if (i < 10) {
                                    for (double t = 0; t <= 5; t += 0.05) {
                                        double x = r[0] * Math.sin(t);
                                        double z = r[0] * Math.cos(t);
                                        w.spawnParticle(Particle.REDSTONE, l.getX() + x, y[0], l.getZ() + z, 0, new Particle.DustOptions(Color.GRAY, 3));
                                        y[0] += 0.01f;
                                        r[0] += 0.01f;
                                    }
                                }
                            }
                        }, 5, 10);
                        break;
                    }
                    case 19: {
                        World w = killer.getWorld();
                        ArmorStand stand = (ArmorStand) w.spawnEntity(killer.getLocation().add(0, 1.5, 0), EntityType.ARMOR_STAND);
                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                        assert player != null;
                        headMeta.setOwner(player.getName());
                        head.setItemMeta(headMeta);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
                        bootsMeta.setColor(Color.fromBGR(255, 255, 0));
                        chestplateMeta.setColor(Color.fromBGR(255, 255, 0));
                        leggingsMeta.setColor(Color.fromBGR(255, 255, 0));
                        boots.setItemMeta(bootsMeta);
                        chestplate.setItemMeta(chestplateMeta);
                        leggings.setItemMeta(leggingsMeta);
                        stand.setItem(EquipmentSlot.HEAD, head);
                        stand.setItem(EquipmentSlot.CHEST, chestplate);
                        stand.setItem(EquipmentSlot.LEGS, leggings);
                        stand.setItem(EquipmentSlot.FEET, boots);
                        stand.setVisible(false);
                        stand.setVelocity(new Vector(0, 12, 0).multiply(0.1));
                        org.aneras.mc.trails.other.Laser laser = new org.aneras.mc.trails.other.Laser.GuardianLaser(killer.getLocation().add(0, 1.7, 0), killer.getLocation(), -1, 12);
                        laser.start(PerfectEffects.getPlugin(PerfectEffects.class));
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            try {
                                laser.moveEnd(stand.getLocation());
                            } catch (ReflectiveOperationException ex) {
                                ex.printStackTrace();
                            }
                        }, 1, 1);
                        Bukkit.getScheduler().runTaskLater(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            stand.setGravity(false);
                            Bukkit.getScheduler().runTaskLater(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                w.createExplosion(stand.getLocation(), 0);
                                w.spawnParticle(Particle.EXPLOSION_LARGE, stand.getLocation(), 5);
                                laser.stop();
                                stand.remove();
                            }, 20);
                        }, 10);
                        break;
                    }
                    case 20: {
                        World w = killer.getWorld();
                        Location l = killer.getLocation();
                        ArmorStand stand = (ArmorStand) w.spawnEntity(l.add(0, 1.5, 0), EntityType.ARMOR_STAND);
                        ItemStack head = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWRkYmQwYmI5NjIyY2UxMjRkYWJiNmJhM2JhYTlhOWVhNzE0MzBmODcwZmVjMTViM2VhODFmMTk2MWE0MTJiMiJ9fX0=");
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        ItemStack sword = new ItemStack(Material.GOLDEN_HOE);
                        stand.setGravity(false);
                        stand.setVisible(false);
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        chestplateMeta.setColor(Color.BLACK);
                        chestplate.setItemMeta(chestplateMeta);
                        stand.setItem(EquipmentSlot.HEAD, head);
                        stand.setItem(EquipmentSlot.CHEST, chestplate);
                        stand.setItem(EquipmentSlot.HAND, sword);
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                if (i < 55) {
                                    org.aneras.mc.trails.other.SpawnWings sp = new org.aneras.mc.trails.other.SpawnWings();
                                    sp.display(stand.getEyeLocation(), killer);
                                }
                                i++;
                            }
                        }, 1, 1);
                        assert player != null;
                        player.sendMessage(ChatColor.RED + Objects.requireNonNull(plugin.config.getConfig().getString("Death Message")).replace("%player_dead%", player.getName()));
                        killer.sendMessage(ChatColor.RED + Objects.requireNonNull(plugin.config.getConfig().getString("Death Message")).replace("%player_dead%", player.getName()));
                        Bukkit.getScheduler().runTaskLater(PerfectEffects.getPlugin(PerfectEffects.class), stand::remove, 60);
                        break;
                    }
                    case 21: {
                        World w = killer.getWorld();
                        assert player != null;
                        Location l = player.getLocation();
                        final int[] b = {0};
                        for (int i = 0; i < 5; i++) {
                            LivingEntity bat = (LivingEntity) w.spawnEntity(l, EntityType.BAT);
                            ArmorStand stand = (ArmorStand) w.spawnEntity(bat.getLocation(), EntityType.ARMOR_STAND);
                            PotionEffect visible = new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1);
                            ItemStack head = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmE1ZWFmNGUxNGJhMmVmMGM3ZGI4Y2Y5M2Q4ZWFjMGZmZmEyMDRiZDE2OTE1NTZjMmIyNTQ1NzEzOTU5NTYyNCJ9fX0=");
                            bat.addPotionEffect(visible);
                            stand.setVisible(false);
                            bat.setPassenger(stand);
                            bat.setSilent(true);
                            stand.setItem(EquipmentSlot.HEAD, head);
                            Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                b[0]++;
                                if (b[0] < 500) {
                                    w.spawnParticle(Particle.REDSTONE, bat.getLocation().add(0, 2, 0), 10, new Particle.DustOptions(Color.fromRGB(255, 128, 0), 1));
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                        bat.remove();
                                        stand.remove();
                                    }, 100);

                                }
                            }, 1, 1);
                        }
                        break;
                    }
                    case 22: {
                        World w = killer.getWorld();
                        assert player != null;
                        Location l = player.getLocation();
                        String name = killer.getName();
                        int killCount = plugin.data.getKillCount(killer.getUniqueId());
                        killCount++;
                        plugin.data.changeKillCount(killer.getUniqueId(), killCount);
                        ArmorStand stand = (ArmorStand) w.spawnEntity(l.clone().add(0, -1, 0), EntityType.ARMOR_STAND);
                        stand.setVisible(false);
                        stand.setCustomNameVisible(true);
                        stand.setCustomName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("KillCount"))).replace("%killer%", name).replace("%KillCount%", Integer.toString(plugin.data.getKillCount(killer.getUniqueId()))));
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), stand::remove, 70);
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                if (i < 75) {
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0, 0.25, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0, 0.5, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0, 0.75, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(-0.25, 0.75, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.25, 0.75, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0, 1, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    i++;
                                }
                            }
                        }, 1, 1);
                        break;
                    }
                }
            }
        }
    }
}
