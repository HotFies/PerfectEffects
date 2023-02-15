package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.aneras.mc.trails.other.Laser;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
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
import java.util.Random;

public class BedBreakListener implements Listener {
    private final PerfectEffects plugin;
    Block bed_1, bed_2, campfireGlobal, AnvilGlobal;
    public BedBreakListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void BedBreakPlayer(@Nonnull BlockBreakEvent e) throws ReflectiveOperationException {
        Player p = e.getPlayer();
        if(!Names.get().getBoolean("Lobby")) {
            if (e.getBlock().getType() == Material.RED_BED || e.getBlock().getType() == Material.CYAN_BED ||
                    e.getBlock().getType() == Material.BLUE_BED || e.getBlock().getType() == Material.GREEN_BED
                    || e.getBlock().getType() == Material.WHITE_BED || e.getBlock().getType() == Material.PINK_BED
                    || e.getBlock().getType() == Material.ORANGE_BED || e.getBlock().getType() == Material.MAGENTA_BED
                    || e.getBlock().getType() == Material.LIGHT_BLUE_BED || e.getBlock().getType() == Material.YELLOW_BED
                    || e.getBlock().getType() == Material.LIME_BED || e.getBlock().getType() == Material.GRAY_BED
                    || e.getBlock().getType() == Material.LIGHT_GRAY_BED || e.getBlock().getType() == Material.PURPLE_BED
                    || e.getBlock().getType() == Material.BROWN_BED || e.getBlock().getType() == Material.BLACK_BED) {
                switch (plugin.data.getBedFlag(p.getUniqueId())){
                    case 0:{
                        World w = e.getBlock().getWorld();
                        Location l = e.getBlock().getLocation();
                        w.playEffect(l, Effect.ENDERDRAGON_GROWL, 1);
                        break;
                    }
                    case 1:{
                        World w = e.getBlock().getWorld();
                        Location l = e.getBlock().getLocation();
                        w.strikeLightningEffect(l);
                        break;
                    }
                    case 2:{
                        Location l = e.getBlock().getLocation();
                        Squid ent = (Squid) p.getWorld().spawnEntity(l.add(0, 1, 0), EntityType.SQUID);
                        ent.setGravity(false);
                        ent.setVelocity(new Vector(0, 2.5, 0).multiply(0.2));
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            Firework fw = (Firework) p.getWorld().spawnEntity(ent.getLocation(), EntityType.FIREWORK);
                            FireworkMeta fwMeta = fw.getFireworkMeta();
                            fwMeta.addEffect(FireworkEffect.builder().withColor(Color.BLACK).with(FireworkEffect.Type.BALL).build());
                            fwMeta.setPower(5);
                            fw.setFireworkMeta(fwMeta);
                            fw.detonate();
                            ent.remove();
                        }, 20L);
                        break;
                    }
                    case 3:{
                        Location l = e.getBlock().getLocation();
                        Firework fw = (Firework) p.getWorld().spawnEntity(l, EntityType.FIREWORK);
                        FireworkMeta fwMeta = fw.getFireworkMeta();
                        Random r = new Random();
                        int rt = r.nextInt(4) + 1;
                        FireworkEffect.Type type = null;
                        if (rt == 1) type = FireworkEffect.Type.BALL;
                        if (rt == 2) type = FireworkEffect.Type.BALL_LARGE;
                        if (rt == 3) type = FireworkEffect.Type.BURST;
                        if (rt == 4) type = FireworkEffect.Type.CREEPER;
                        int r1i = r.nextInt(17) + 1;
                        int r2i = r.nextInt(17) + 1;
                        Color c1 = getColor(r1i);
                        Color c2 = getColor(r2i);
                        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
                        fwMeta.addEffect(effect);
                        int rp = r.nextInt(2) + 1;
                        fwMeta.setPower(rp);
                        fw.setFireworkMeta(fwMeta);
                        break;
                    }
                    case 4:{
                        World w = p.getWorld();
                        Block block = e.getBlock();
                        ArmorStand stand = (ArmorStand) w.spawnEntity(block.getLocation().add(0, 1.5, 0), EntityType.ARMOR_STAND);
                        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
                        headMeta.setOwner(p.getName());
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
                        org.aneras.mc.trails.other.Laser laser = new Laser.GuardianLaser(p.getLocation().add(0, 1.7, 0), p.getLocation(), -1, 12);
                        laser.start(PerfectEffects.getPlugin(PerfectEffects.class));
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            try {
                                laser.moveStart(p.getLocation());
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
                    case 5:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation().add(0, 1, 0);
                        final int[] b = {0};
                        for (int i = 0; i < 5; i++) {
                            LivingEntity bat = (LivingEntity) w.spawnEntity(l, EntityType.BAT);
                            ArmorStand stand = (ArmorStand) w.spawnEntity(bat.getLocation(), EntityType.ARMOR_STAND);
                            PotionEffect visible = new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1);
                            ItemStack head = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRjODgwNTNjMWE4NTNmNzE2NmM5ZTkzYmIzYzUxN2YwODE5NTQ0NzM5ZGJlYWJkNDhhODU5Y2VkNDIwYjcwYiJ9fX0=");
                            bat.addPotionEffect(visible);
                            stand.setVisible(false);
                            bat.setPassenger(stand);
                            bat.setSilent(true);
                            stand.setItem(EquipmentSlot.HEAD, head);
                            Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                b[0]++;
                                if (b[0] < 500) {
                                    w.spawnParticle(Particle.REDSTONE, bat.getLocation().add(0, 2, 0), 10, new Particle.DustOptions(Color.fromRGB(121, 6, 4), 1));
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                                        bat.remove();
                                        stand.remove();
                                    }, 100);

                                }
                            }, 1, 1);
                        }
                        break;
                    }
                    case 6:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation();
                        String name = p.getName();
                        int bedBreakCount = plugin.data.getBedBreakCount(p.getUniqueId());
                        bedBreakCount++;
                        plugin.data.changeBedBreakCount(p.getUniqueId(), bedBreakCount);
                        ArmorStand stand = (ArmorStand) w.spawnEntity(l.clone().add(0.5, -1, 0), EntityType.ARMOR_STAND);
                        stand.setVisible(false);
                        stand.setCustomNameVisible(true);
                        stand.setCustomName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("BedBreakCount"))).replace("%player%", name).replace("%BedBreakCount%", Integer.toString(plugin.data.getBedBreakCount(p.getUniqueId()))));
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), stand::remove, 500);
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                if (i < 75) {
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.5, 0.25, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.5, 0.5, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.5, 0.75, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.75, 0.75, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.25, 0.75, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    w.spawnParticle(Particle.REDSTONE, l.clone().add(0.5, 1, 0), 2, new Particle.DustOptions(Color.BLACK, 1));
                                    i++;
                                }
                            }
                        }, 1, 1);
                        break;
                    }
                    case 7:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation();
                        Block campfire = l.clone().add(0.5, 0, 0.5).getBlock();
                        l.add(0.5, 0.5, 0.5);
                        campfireGlobal = campfire;
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                if (i < 100) {
                                    campfire.setType(Material.CAMPFIRE);
                                    w.spawnParticle(Particle.SMOKE_LARGE, l, 0);
                                }
                                i++;
                            }
                        }, 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            campfireGlobal = null;
                            campfire.setType(Material.AIR);
                        }, 100);
                        break;
                    }
                    case 8:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation();
                        l.add(0.5, 1, 0.5);
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;

                            @Override
                            public void run() {
                                if (i < 100) {
                                    w.spawnParticle(Particle.BLOCK_CRACK, l, 100, Material.REDSTONE_BLOCK.createBlockData());
                                }
                                i++;
                            }
                        }, 1, 1);
                        break;
                    }
                    case 9:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation();
                        Wither wither = (Wither) w.spawnEntity(l, EntityType.WITHER);
                        wither.setCustomNameVisible(false);
                        wither.setCustomName("wither");
                        wither.setGravity(false);
                        wither.setSilent(true);
                        Bukkit.getScheduler().runTaskTimer(PerfectEffects.getPlugin(PerfectEffects.class), new Runnable() {
                            int i = 0;
                            @Override
                            public void run() {
                                wither.setRotation(i, 0);
                                i += 20000;
                            }
                        }, 1, 1);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            Firework fw = (Firework) p.getWorld().spawnEntity(l.add(0, 2, 0), EntityType.FIREWORK);
                            FireworkMeta fwMeta = fw.getFireworkMeta();
                            fwMeta.addEffect(FireworkEffect.builder().withColor(Color.BLACK).with(FireworkEffect.Type.BALL).build());
                            fwMeta.setPower(5);
                            fw.setFireworkMeta(fwMeta);
                            fw.detonate();
                            wither.remove();
                        }, 100);
                        break;
                    }
                    case 10:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation();
                        l.add(0.5, 1, 0.5);
                        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
                        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
                        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
                        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
                        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
                        bootsMeta.setColor(Color.BLACK);
                        chestplateMeta.setColor(Color.BLACK);
                        leggingsMeta.setColor(Color.BLACK);
                        boots.setItemMeta(bootsMeta);
                        chestplate.setItemMeta(chestplateMeta);
                        leggings.setItemMeta(leggingsMeta);
                        ArmorStand negr1 = (ArmorStand) w.spawnEntity(l.clone().add(-0.75, 0, 0.75), EntityType.ARMOR_STAND);
                        ArmorStand negr2 = (ArmorStand) w.spawnEntity(l.clone().add(-0.75, 0, -1.75), EntityType.ARMOR_STAND);
                        ArmorStand negr3 = (ArmorStand) w.spawnEntity(l.clone().add(0.75, 0, 0.75), EntityType.ARMOR_STAND);
                        ArmorStand negr4 = (ArmorStand) w.spawnEntity(l.clone().add(0.75, 0, -1.75), EntityType.ARMOR_STAND);
                        ItemStack head = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2Q0ODMwZWMxYzMyZjk0OTVlYWY3MjJkZDA3MmMxYTU3OTI3MWYyNWNhMzg1YWMwNDQxYzViNjhiNThmY2Q0In19fQ==");
                        negr1.setItem(EquipmentSlot.HEAD, head);
                        negr1.setItem(EquipmentSlot.CHEST, chestplate);
                        negr1.setItem(EquipmentSlot.LEGS, leggings);
                        negr1.setItem(EquipmentSlot.FEET, boots);

                        negr2.setItem(EquipmentSlot.HEAD, head);
                        negr2.setItem(EquipmentSlot.CHEST, chestplate);
                        negr2.setItem(EquipmentSlot.LEGS, leggings);
                        negr2.setItem(EquipmentSlot.FEET, boots);

                        negr3.setItem(EquipmentSlot.HEAD, head);
                        negr3.setItem(EquipmentSlot.CHEST, chestplate);
                        negr3.setItem(EquipmentSlot.LEGS, leggings);
                        negr3.setItem(EquipmentSlot.FEET, boots);

                        negr4.setItem(EquipmentSlot.HEAD, head);
                        negr4.setItem(EquipmentSlot.CHEST, chestplate);
                        negr4.setItem(EquipmentSlot.LEGS, leggings);
                        negr4.setItem(EquipmentSlot.FEET, boots);

                        negr1.setVisible(false);
                        negr2.setVisible(false);
                        negr3.setVisible(false);
                        negr4.setVisible(false);

                        Block bed = l.clone().add(0, 1, 0).getBlock();
                        Block bed2 = l.clone().add(0, 1, -1).getBlock();
                        bed.setType(Material.BLACK_SHULKER_BOX);
                        bed2.setType(Material.BLACK_SHULKER_BOX);
                        bed_1 = bed;
                        bed_2 = bed2;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            negr1.remove();
                            negr2.remove();
                            negr3.remove();
                            negr4.remove();
                            bed.setType(Material.AIR);
                            bed2.setType(Material.AIR);
                            bed_1 = null;
                            bed_2 = null;
                        }, 100);
                        break;
                    }
                    case 11:{
                        World w = p.getWorld();
                        Location l = e.getBlock().getLocation();
                        Location ltoSpawn = l.clone().add(0.5, 20, 0.5);
                        FallingBlock fallingAnvil = w.spawnFallingBlock(ltoSpawn, Material.DAMAGED_ANVIL, (byte) 0);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(PerfectEffects.getPlugin(PerfectEffects.class), () -> {
                            Block anvilToRemove = fallingAnvil.getLocation().getBlock();
                            anvilToRemove.setType(Material.AIR);
                            fallingAnvil.remove();
                            w.spawnParticle(Particle.BLOCK_CRACK, fallingAnvil.getLocation(), 500, Material.ANVIL.createBlockData());
                        }, (long) 35.5);
                        break;
                    }
                }
            }
        }
    }
    @EventHandler
    public void OnClick(@Nonnull EntityDamageEvent e){
        if(e.getEntity().getName().equals("wither")){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void BedDestroy(@Nonnull BlockBreakEvent e){
        if(e.getBlock().equals(bed_1) || e.getBlock().equals(bed_2) || e.getBlock().equals(campfireGlobal) || e.getBlock().equals(AnvilGlobal)){
            e.setCancelled(true);
        }
    }
    private Color getColor(int i) {
        Color c = null;
        if(i==1){
            c=Color.AQUA;
        }if(i==2){
            c=Color.BLACK;
        }if(i==3){
            c=Color.BLUE;
        }if(i==4){
            c=Color.FUCHSIA;
        }if(i==5){
            c=Color.GRAY;
        }if(i==6){
            c=Color.GREEN;
        }if(i==7){
            c=Color.LIME;
        }if(i==8){
            c=Color.MAROON;
        }if(i==9){
            c=Color.NAVY;
        }if(i==10){
            c=Color.OLIVE;
        }if(i==11){
            c=Color.ORANGE;
        }if(i==12){
            c=Color.PURPLE;
        }if(i==13){
            c=Color.RED;
        }if(i==14){
            c=Color.SILVER;
        }if(i==15){
            c=Color.TEAL;
        }if(i==16){
            c=Color.WHITE;
        }if(i==17){
            c=Color.YELLOW;
        }
        return c;
    }
}