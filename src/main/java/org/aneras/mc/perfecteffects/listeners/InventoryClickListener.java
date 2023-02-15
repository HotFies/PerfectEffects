package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InventoryClickListener implements Listener {

    private final Map<Player, Inventory> ArrowInv = new HashMap<>();
    private final Map<Player, Inventory> ArrowInv_1 = new HashMap<>();
    private final Map<Player, Inventory> KillInv = new HashMap<>();
    private final Map<Player, Inventory> KillInv_1 = new HashMap<>();
    private final Map<Player, Inventory> WalkInv = new HashMap<>();
    private final Map<Player, Inventory> WalkInv_1 = new HashMap<>();
    private final Map<Player, Inventory> MessageInv_1 = new HashMap<>();
    private final Map<Player, Inventory> MessageInv_2 = new HashMap<>();
    private final Map<Player, Inventory> DeathSoundInv = new HashMap<>();
    private final Map<Player, Inventory> BedInv = new HashMap<>();
    private final Map<Player, Inventory> ChatColorInv = new HashMap<>();
    private final Map<Player, Inventory> FrameInv = new HashMap<>();

    private static Map<Player, Inventory> MainInvHash = new HashMap<>();

    private final PerfectEffects plugin;
    public InventoryClickListener(PerfectEffects plugin, Map<Player, Inventory>  InvToHash) {
        this.plugin = plugin;
        MainInvHash = InvToHash;
    }
    @EventHandler
    public void OnJoin(@Nonnull PlayerJoinEvent e) {
        Player p = e.getPlayer();
        plugin.data.createPlayer(p);
    }
    @EventHandler
    public void ClickTrailsInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory() == MainInvHash.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(11))) {
                ArrowInv(p);
                p.openInventory(ArrowInv.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(13))) {
                WalkInv(p);
                p.openInventory(WalkInv.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(15))) {
                KillInv(p);
                p.openInventory(KillInv.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(29))) {
                MessageInv_1(p);
                p.openInventory(MessageInv_1.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(31))) {
                DeathSoundInv(p);
                p.openInventory(DeathSoundInv.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(33))) {
                BedInv(p);
                p.openInventory(BedInv.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(21))) {
                ChatColorInv(p);
                p.openInventory(ChatColorInv.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(23))) {
                FrameInv(p);
                p.openInventory(FrameInv.get(p));
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(40))) {
                if(Objects.requireNonNull(plugin.config.getConfig().getString("Command")).equalsIgnoreCase("null")) {
                    p.closeInventory();
                }else{
                    p.chat(Objects.requireNonNull(plugin.config.getConfig().getString("Command")));
                }
            }
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void ClickArrowInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int  arrowFlag;
        String mgEffects = "PerfectEffects";
        if (e.getInventory() == ArrowInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                arrowFlag = 0;
                plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                ArrowInv.remove(p);
                ArrowInv(p);
                p.openInventory(ArrowInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if(p.hasPermission("PerfectEffects.Trails.ArrowTrails.Firework")) {
                    arrowFlag = 1;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if(p.hasPermission("PerfectEffects.Trails.ArrowTrails.Heart")) {
                    arrowFlag = 2;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if(p.hasPermission("PerfectEffects.Trails.ArrowTrails.Slime")) {
                    arrowFlag = 3;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if(p.hasPermission("PerfectEffects.Trails.ArrowTrails.WaterParticle")) {
                    arrowFlag = 4;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.AngryVillager")) {
                    arrowFlag = 5;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.HappyVillager")) {
                    arrowFlag = 6;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Spell")) {
                    arrowFlag = 7;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.MagicCrit")) {
                    arrowFlag = 8;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Flame")) {
                    arrowFlag = 9;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.EndRod")) {
                    arrowFlag = 10;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Snow")) {
                    arrowFlag = 11;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv.remove(p);
                    ArrowInv(p);
                    p.openInventory(ArrowInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                ArrowInv_1(p);
                p.openInventory(ArrowInv_1.get(p));
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                p.openInventory(MainInvHash.get(p));
            }
            if (e.getInventory() != ArrowInv.get(p)) return;
            e.setCancelled(true);
        }if (e.getInventory() == ArrowInv_1.get(p)){
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                arrowFlag = 0;
                plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                ArrowInv_1.remove(p);
                ArrowInv_1(p);
                p.openInventory(ArrowInv_1.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Portal")) {
                    arrowFlag = 12;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Diamond")) {
                    arrowFlag = 13;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Gold")) {
                    arrowFlag = 14;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Note")) {
                    arrowFlag = 15;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Damage")) {
                    arrowFlag = 16;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.SpellWitch")) {
                    arrowFlag = 17;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.FallingHoney")) {
                    arrowFlag = 18;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.FallingLava")) {
                    arrowFlag = 19;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Squid")) {
                    arrowFlag = 20;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if(p.hasPermission(mgEffects + ".Trails.ArrowTrails.Nautilus")) {
                    arrowFlag = 21;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if (p.hasPermission(mgEffects + ".Trails.ArrowTrails.Totem")) {
                    arrowFlag = 22;
                    plugin.data.changeArrowFlag(p.getUniqueId(), arrowFlag);
                    ArrowInv_1.remove(p);
                    ArrowInv_1(p);
                    p.openInventory(ArrowInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                ArrowInv(p);
                p.openInventory(ArrowInv.get(p));
            }
        }
        if (e.getInventory() != ArrowInv_1.get(p)) return;
        e.setCancelled(true);
    }
    @EventHandler
    public void ClickKillInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int killFlag;
        String mgEffects = "PerfectEffects";
        if (e.getInventory() == KillInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                killFlag = 0;
                plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                KillInv.remove(p);
                KillInv(p);
                p.openInventory(KillInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.Firework")) {
                    killFlag = 1;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.Lightning")) {
                    killFlag = 2;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.SquidFirework")) {
                    killFlag = 3;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.TNT")) {
                    killFlag = 4;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.OrkHeadFirework")) {
                    killFlag = 5;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.CookieFountain")) {
                    killFlag = 6;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.Smoke")) {
                    killFlag = 7;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.GoldRain")) {
                    killFlag = 8;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.Flame")) {
                    killFlag = 9;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.Blood")) {
                    killFlag = 10;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if(p.hasPermission(mgEffects + ".Trails.KillTrails.ChickenPost")) {
                    killFlag = 11;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv.remove(p);
                    KillInv(p);
                    p.openInventory(KillInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                p.openInventory(MainInvHash.get(p));
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                KillInv_1(p);
                p.openInventory(KillInv_1.get(p));
            }
            if (e.getInventory() != KillInv.get(p)) return;
            e.setCancelled(true);
        }
        if (e.getInventory() == KillInv_1.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                killFlag = 0;
                plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                KillInv_1.remove(p);
                KillInv_1(p);
                p.openInventory(KillInv_1.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Rabbit")) {
                    killFlag = 12;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Bat")) {
                    killFlag = 13;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.CowFirework")) {
                    killFlag = 14;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.PumpkinFirework")) {
                    killFlag = 15;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Rain")) {
                    killFlag = 16;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Glass")) {
                    killFlag = 17;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Tornado")) {
                    killFlag = 18;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Guardian")) {
                    killFlag = 19;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Death")) {
                    killFlag = 20;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Ghosts")) {
                    killFlag = 21;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if (p.hasPermission(mgEffects + ".Trails.KillTrails.Tomb")) {
                    killFlag = 22;
                    plugin.data.changeKillFlag(p.getUniqueId(), killFlag);
                    KillInv_1.remove(p);
                    KillInv_1(p);
                    p.openInventory(KillInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                }else{p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                KillInv(p);
                p.openInventory(KillInv.get(p));
            }
        }
        if (e.getInventory() != KillInv_1.get(p)) return;
        e.setCancelled(true);
    }
    @EventHandler
    public void ClickSoundInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int soundFlag ;
        if (e.getInventory() == DeathSoundInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                soundFlag = 0;
                plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                DeathSoundInv.remove(p);
                DeathSoundInv(p);
                p.openInventory(DeathSoundInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
            } else {
                String mgEffects = "PerfectEffects";
                if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.BlazeDeath")) {
                        soundFlag = 1;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.Portal")) {
                        soundFlag = 2;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.DragonDeath")) {
                        soundFlag = 3;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.DolphinDeath")) {
                        soundFlag = 4;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.DonkeyDeath")) {
                        soundFlag = 5;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.GuardianCurse")) {
                        soundFlag = 6;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.GhastDeath")) {
                        soundFlag = 7;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.VexDeath")) {
                        soundFlag = 8;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.RavagerDeath")) {
                        soundFlag = 9;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.TNTPrimed")) {
                        soundFlag = 10;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                    if (p.hasPermission(mgEffects + ".Trails.DeathSounds.Explode")) {
                        soundFlag = 11;
                        plugin.data.changeSoundFlag(p.getUniqueId(), soundFlag);
                        DeathSoundInv.remove(p);
                        DeathSoundInv(p);
                        p.openInventory(DeathSoundInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_sound"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                    p.openInventory(MainInvHash.get(p));
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("ComingSoon"))));
                }
            }
        }

        if (e.getInventory() != DeathSoundInv.get(p)) return;
        e.setCancelled(true);
    }
    @EventHandler
    public void ClickMessageInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int messageFlag;
        String mgEffects = "PerfectEffects";
        if (e.getInventory() == MessageInv_1.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                messageFlag = 0;
                plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                MessageInv_1.remove(p);
                MessageInv_1(p);
                p.openInventory(MessageInv_1.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#1")) {
                    messageFlag = 1;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(11))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#2")) {
                    messageFlag = 2;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#3")) {
                    messageFlag = 3;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(13))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#4")) {
                    messageFlag = 4;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#5")) {
                    messageFlag = 5;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(15))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#6")) {
                    messageFlag = 6;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#7")) {
                    messageFlag = 7;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(19))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#8")) {
                    messageFlag = 8;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#9")) {
                    messageFlag = 9;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(21))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#10")) {
                    messageFlag = 10;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#11")) {
                    messageFlag = 11;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(23))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#12")) {
                    messageFlag = 12;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#13")) {
                    messageFlag = 13;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(25))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#14")) {
                    messageFlag = 14;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#15")) {
                    messageFlag = 15;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(29))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#16")) {
                    messageFlag = 16;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#17")) {
                    messageFlag = 17;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(31))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#18")) {
                    messageFlag = 18;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#19")) {
                    messageFlag = 19;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(33))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#20")) {
                    messageFlag = 20;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#21")) {
                    messageFlag = 21;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(37))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#22")) {
                    messageFlag = 22;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(38))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#23")) {
                    messageFlag = 23;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(39))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#24")) {
                    messageFlag = 24;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(40))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#25")) {
                    messageFlag = 25;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(41))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#26")) {
                    messageFlag = 26;
                    p.closeInventory();
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(42))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#27")) {
                    messageFlag = 27;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(43))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#28")) {
                    messageFlag = 28;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_1.remove(p);
                    MessageInv_1(p);
                    p.openInventory(MessageInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                p.openInventory(MainInvHash.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                MessageInv_2(p);
                p.openInventory(MessageInv_2.get(p));
            }
            if (e.getInventory() != MessageInv_1.get(p)) return;
            e.setCancelled(true);
        }
        if (e.getInventory() == MessageInv_2.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                messageFlag = 0;
                plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                MessageInv_2.remove(p);
                MessageInv_2(p);
                p.openInventory(MessageInv_2.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#29")) {
                    messageFlag = 29;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(11))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#30")) {
                    messageFlag = 30;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#31")) {
                    messageFlag = 31;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(13))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#32")) {
                    messageFlag = 32;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#33")) {
                    messageFlag = 33;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(15))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#34")) {
                    messageFlag = 34;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#35")) {
                    messageFlag = 35;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(19))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#36")) {
                    messageFlag = 36;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#37")) {
                    messageFlag = 37;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(21))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#38")) {
                    messageFlag = 38;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#39")) {
                    messageFlag = 39;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(23))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#40")) {
                    messageFlag = 40;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#41")) {
                    messageFlag = 41;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(25))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#42")) {
                    messageFlag = 42;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#43")) {
                    messageFlag = 43;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(29))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#44")) {
                    messageFlag = 44;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#45")) {
                    messageFlag = 45;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(31))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#46")) {
                    messageFlag = 46;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#47")) {
                    messageFlag = 47;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(33))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#48")) {
                    messageFlag = 48;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#49")) {
                    messageFlag = 49;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(37))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#50")) {
                    messageFlag = 50;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(38))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#51")) {
                    messageFlag = 51;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(39))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#52")) {
                    messageFlag = 52;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(40))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#53")) {
                    messageFlag = 53;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(41))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#54")) {
                    messageFlag = 54;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(42))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#55")) {
                    messageFlag = 55;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(43))) {
                if (p.hasPermission(mgEffects + ".Trails.Messages.Message#56")) {
                    messageFlag = 56;
                    plugin.data.changeMessageFlag(p.getUniqueId(), messageFlag);
                    MessageInv_2.remove(p);
                    MessageInv_2(p);
                    p.openInventory(MessageInv_2.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_message"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                MessageInv_1(p);
                p.openInventory(MessageInv_1.get(p));
            }
            if (e.getInventory() != MessageInv_2.get(p)) return;
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void ClickBedInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int bedFlag;
        if (e.getInventory() == BedInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                bedFlag = 0;
                plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                BedInv.remove(p);
                BedInv(p);
                p.openInventory(BedInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            } else {
                String mgEffects = "PerfectEffects";
                if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.Lightning")) {
                        bedFlag = 1;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.SquidFirework")) {
                        bedFlag = 2;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.Firework")) {
                        bedFlag = 3;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.GuardianLaser")) {
                        bedFlag = 4;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.Ghosts")) {
                        bedFlag = 5;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.Tomb")) {
                        bedFlag = 6;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.Campfire")) {
                        bedFlag = 7;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.Blood")) {
                        bedFlag = 8;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.WitherFirework")) {
                        bedFlag = 9;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.BlackPersonWithCoffin")) {
                        bedFlag = 10;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                    if (p.hasPermission(mgEffects + ".Trails.BedBreakTrails.BreakAnvil")) {
                        bedFlag = 11;
                        plugin.data.changeBedFlag(p.getUniqueId(), bedFlag);
                        BedInv.remove(p);
                        BedInv(p);
                        p.openInventory(BedInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                    p.openInventory(MainInvHash.get(p));
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("ComingSoon"))));
                }
            }
            if (e.getInventory() != BedInv.get(p)) return;
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void ClickWalkInv(@Nonnull InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        int walkFlag;
        String mgEffects = "PerfectEffects";
        if (e.getInventory() == WalkInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                walkFlag = 0;
                plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                WalkInv.remove(p);
                WalkInv(p);
                p.openInventory(WalkInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.DiamondOre")) {
                    walkFlag = 1;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.GoldOre")) {
                    walkFlag = 2;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.EmeraldOre")) {
                    walkFlag = 3;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.WhiteClass")) {
                    walkFlag = 4;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.PinkClass")) {
                    walkFlag = 5;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.Glass")) {
                    walkFlag = 6;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.RedGlass")) {
                    walkFlag = 7;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.NetherQuartzOre")) {
                    walkFlag = 8;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.RedstoneOre")) {
                    walkFlag = 9;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.LapisOre")) {
                    walkFlag = 10;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.BlueGlass")) {
                    walkFlag = 11;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv.remove(p);
                    WalkInv(p);
                    p.openInventory(WalkInv.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                p.openInventory(MainInvHash.get(p));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                WalkInv_1(p);
                p.openInventory(WalkInv_1.get(p));
            }
            if (e.getInventory() != WalkInv.get(p)) return;
            e.setCancelled(true);
        }
        if (e.getInventory() == WalkInv_1.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                walkFlag = 0;
                plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                WalkInv_1.remove(p);
                WalkInv_1(p);
                p.openInventory(WalkInv_1.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.PinkConcrete")) {
                    walkFlag = 12;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.LimeConcrete")) {
                    walkFlag = 13;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.YellowConcrete")) {
                    walkFlag = 14;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.BlueConcrete")) {
                    walkFlag = 15;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.MagentaConcrete")) {
                    walkFlag = 16;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.OrangeConcrete")) {
                    walkFlag = 17;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.WhiteConcrete")) {
                    walkFlag = 18;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.CyanConcrete")) {
                    walkFlag = 19;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.RedConcrete")) {
                    walkFlag = 20;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.PurpleConcrete")) {
                    walkFlag = 21;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                if (p.hasPermission(mgEffects + ".Trails.WalkTrails.BlackConcrete")) {
                    walkFlag = 22;
                    plugin.data.changeWalkFlag(p.getUniqueId(), walkFlag);
                    WalkInv_1.remove(p);
                    WalkInv_1(p);
                    p.openInventory(WalkInv_1.get(p));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_of_trail"))));
                } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
            }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                WalkInv(p);
                p.openInventory(WalkInv.get(p));
            }
        }
        if (e.getInventory() != WalkInv_1.get(p)) return;
        e.setCancelled(true);
    }
    @EventHandler
    public void ClickChatColorInv(@Nonnull InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int signFlag;
        if (e.getInventory() == ChatColorInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                signFlag = 0;
                plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                ChatColorInv.remove(p);
                ChatColorInv(p);
                p.openInventory(ChatColorInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
            } else {
                String mgEffects = "PerfectEffects";
                if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Gold")) {
                        signFlag = 1;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Blue")) {
                        signFlag = 2;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Yellow")) {
                        signFlag = 3;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Green")) {
                        signFlag = 4;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.DarkPurple")) {
                        signFlag = 5;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.LightPurple")) {
                        signFlag = 6;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.DarkBlue")) {
                        signFlag = 7;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Red")) {
                        signFlag = 8;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.DarkGreen")) {
                        signFlag = 9;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Aqua")) {
                        signFlag = 10;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                    if (p.hasPermission(mgEffects + ".Trails.GGChatColor.Black")) {
                        signFlag = 11;
                        plugin.data.changeSignFlag(p.getUniqueId(), signFlag);
                        ChatColorInv.remove(p);
                        ChatColorInv(p);
                        p.openInventory(ChatColorInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_color_message"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                    p.openInventory(MainInvHash.get(p));
                }
            }
            if (e.getInventory() != ChatColorInv.get(p)) return;
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void ClickFrameInv(@Nonnull InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        int frameFlag = plugin.data.getFrameFlag(p.getUniqueId());
        if (e.getInventory() == FrameInv.get(p)) {
            if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(49))) {
                frameFlag = 0;
                plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                FrameInv.remove(p);
                FrameInv(p);
                p.openInventory(FrameInv.get(p));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
            } else {
                String mgEffects = "PerfectEffects";
                if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(10))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#1")) {
                        frameFlag = 1;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(12))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#2")) {
                        frameFlag = 2;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(14))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#3")) {
                        frameFlag = 3;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(16))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#4")) {
                        frameFlag = 4;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(20))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#5")) {
                        frameFlag = 5;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(22))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#6")) {
                        frameFlag = 6;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(24))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#7")) {
                        frameFlag = 7;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(28))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#8")) {
                        frameFlag = 8;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(30))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#9")) {
                        frameFlag = 9;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(32))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#10")) {
                        frameFlag = 10;
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(34))) {
                    if (p.hasPermission(mgEffects + ".Trails.Sprays.Spray#11")) {
                        plugin.data.changeFrameFlag(p.getUniqueId(), frameFlag);
                        FrameInv.remove(p);
                        FrameInv(p);
                        p.openInventory(FrameInv.get(p));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Change_frame"))));
                    } else {p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("No_permissions"))));}
                } else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(48))) {
                    p.openInventory(MainInvHash.get(p));
                }else if (e.getCurrentItem() != null && e.getCurrentItem().equals(e.getInventory().getItem(50))) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("ComingSoon"))));
                }
            }
            if (e.getInventory() != FrameInv.get(p)) return;
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void closeInv(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();
        if(e.getInventory() == ArrowInv.get(p)){
            ArrowInv.remove(p);
        }else if(e.getInventory() == ArrowInv_1.get(p)){
            ArrowInv_1.remove(p);
        }else if(e.getInventory() == WalkInv.get(p)){
            WalkInv.remove(p);
        }else if(e.getInventory() == WalkInv_1.get(p)){
            WalkInv_1.remove(p);
        }else if(e.getInventory() == KillInv.get(p)){
            KillInv.remove(p);
        }else if(e.getInventory() == KillInv_1.get(p)){
            KillInv_1.remove(p);
        }else if(e.getInventory() == DeathSoundInv.get(p)){
            DeathSoundInv.remove(p);
        }else if(e.getInventory() == MessageInv_1.get(p)){
            MessageInv_1.remove(p);
        }else if(e.getInventory() == MessageInv_2.get(p)){
            MessageInv_2.remove(p);
        }else if(e.getInventory() == BedInv.get(p)){
            BedInv.remove(p);
        }else if(e.getInventory() == ChatColorInv.get(p)){
            ChatColorInv.remove(p);
        }else if(e.getInventory() == FrameInv.get(p)){
            FrameInv.remove(p);
        }

    }

    public void ArrowInv(Player p) {
        Inventory arrowInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Arrow_Inventory_Name"))));
        ArrayList<String> fireworkLore = new ArrayList<>();
        ArrayList<String> emeraldLore = new ArrayList<>();
        ArrayList<String> villLore = new ArrayList<>();
        ArrayList<String> heartLore = new ArrayList<>();
        ArrayList<String> slimeLore = new ArrayList<>();
        ArrayList<String> waterLore = new ArrayList<>();
        ArrayList<String> bottleLore = new ArrayList<>();
        ArrayList<String> cubeLore = new ArrayList<>();
        ArrayList<String> flameLore = new ArrayList<>();
        ArrayList<String> end_rodLore = new ArrayList<>();
        ArrayList<String> snowLore = new ArrayList<>();

        ItemStack firework = new ItemStack(Material.BLUE_DYE);
        ItemMeta fireworkMeta = firework.getItemMeta();
        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta emeraldMeta = emerald.getItemMeta();
        ItemStack vill = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta villMeta = vill.getItemMeta();
        ItemStack heart = new ItemStack(Material.RED_DYE);
        ItemMeta heartMeta = heart.getItemMeta();
        ItemStack slime = new ItemStack(Material.SLIME_BALL);
        ItemMeta slimeMeta = slime.getItemMeta();
        ItemStack water = new ItemStack(Material.BLUE_DYE);
        ItemMeta waterMeta = water.getItemMeta();
        ItemStack bottle = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta bottleMeta = bottle.getItemMeta();
        ItemStack cube = new ItemStack(Material.CHORUS_FLOWER);
        ItemMeta cubeMeta = cube.getItemMeta();
        ItemStack flame = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta flameMeta = flame.getItemMeta();
        ItemStack end_rod = new ItemStack(Material.END_ROD);
        ItemMeta end_rodMeta = end_rod.getItemMeta();
        ItemStack snow = new ItemStack(Material.SNOWBALL);
        ItemMeta snowMeta = snow.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack arrow = new ItemStack(Material.OAK_SIGN);
        ItemMeta arrowMeta = arrow.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack map = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta = map.getItemMeta();

        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Next_Page"))));
        map.setItemMeta(mapMeta);
        arrowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Default"))));
        arrowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        arrow.setItemMeta(arrowMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 0) {
            arrow.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        fireworkLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.1.Description"))));
        fireworkMeta.setLore(fireworkLore);
        fireworkMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.1.Name"))));
        fireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        firework.setItemMeta(fireworkMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 1) {
            firework.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        heartLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.2.Description"))));
        heartMeta.setLore(heartLore);
        heartMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        heartMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.2.Name"))));
        heart.setItemMeta(heartMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 2) {
            heart.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        slimeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.3.Description"))));
        slimeMeta.setLore(slimeLore);
        slimeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        slimeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.3.Name"))));
        slime.setItemMeta(slimeMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 3) {
            slime.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        waterLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.4.Description"))));
        waterMeta.setLore(waterLore);
        waterMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        waterMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.4.Name"))));
        water.setItemMeta(waterMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 4) {
            water.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        villLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.5.Description"))));
        villMeta.setLore(villLore);
        villMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        villMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.5.Name"))));
        vill.setItemMeta(villMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 5) {
            vill.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        emeraldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.6.Description"))));
        emeraldMeta.setLore(emeraldLore);
        emeraldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        emeraldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.6.Name"))));
        emerald.setItemMeta(emeraldMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 6) {
            emerald.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        bottleLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.7.Description"))));
        bottleMeta.setLore(bottleLore);
        bottleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bottleMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.7.Name"))));
        bottle.setItemMeta(bottleMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 7) {
            bottle.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        cubeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.8.Description"))));
        cubeMeta.setLore(cubeLore);
        cubeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cubeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.8.Name"))));
        cube.setItemMeta(cubeMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 8) {
            cube.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        flameLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.9.Description"))));
        flameMeta.setLore(flameLore);
        flameMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        flameMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.9.Name"))));
        flame.setItemMeta(flameMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 9) {
            flame.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        end_rodLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.10.Description"))));
        end_rodMeta.setLore(end_rodLore);
        end_rodMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        end_rodMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.10.Name"))));
        end_rod.setItemMeta(end_rodMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 10) {
            end_rod.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        snowLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.11.Description"))));
        snowMeta.setLore(snowLore);
        snowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        snowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.11.Name"))));
        snow.setItemMeta(snowMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 11) {
            snow.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        arrowInv.setItem(10, firework);
        arrowInv.setItem(12, heart);
        arrowInv.setItem(14, slime);
        arrowInv.setItem(16, water);
        arrowInv.setItem(20, vill);
        arrowInv.setItem(22, emerald);
        arrowInv.setItem(24, bottle);
        arrowInv.setItem(28, cube);
        arrowInv.setItem(30, flame);
        arrowInv.setItem(32, end_rod);
        arrowInv.setItem(34, snow);
        ////////////////////////////////////////
        arrowInv.setItem(0, empty);
        arrowInv.setItem(1, empty);
        arrowInv.setItem(2, empty);
        arrowInv.setItem(3, empty);
        arrowInv.setItem(4, empty);
        arrowInv.setItem(5, empty);
        arrowInv.setItem(6, empty);
        arrowInv.setItem(7, empty);
        arrowInv.setItem(8, empty);
        arrowInv.setItem(9, empty);
        arrowInv.setItem(17, empty);
        arrowInv.setItem(18, empty);
        arrowInv.setItem(26,empty);
        arrowInv.setItem(27, empty);
        arrowInv.setItem(35, empty);
        arrowInv.setItem(36, empty);
        arrowInv.setItem(44, empty);
        arrowInv.setItem(45, empty);
        arrowInv.setItem(46, empty);
        arrowInv.setItem(47, empty);
        arrowInv.setItem(51, empty);
        arrowInv.setItem(52, empty);
        arrowInv.setItem(53, empty);
        //////////////////////////////////

        arrowInv.setItem(48, barrier);
        arrowInv.setItem(50, map);
        arrowInv.setItem(49, arrow);

        ArrowInv.put(p, arrowInv);
    }
    public void ArrowInv_1(Player p){
        Inventory arrowInv = Bukkit.createInventory(null, 54,  ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Arrow_Inventory_Name"))));

        ItemStack arrow = new ItemStack(Material.OAK_SIGN);
        ItemMeta arrowMeta = arrow.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ArrayList<String> portalLore = new ArrayList<>();
        ArrayList<String> diamondLore = new ArrayList<>();
        ArrayList<String> goldLore = new ArrayList<>();
        ArrayList<String> noteLore = new ArrayList<>();
        ArrayList<String> damageLore = new ArrayList<>();
        ArrayList<String> spellLore = new ArrayList<>();
        ArrayList<String> honeyLore = new ArrayList<>();
        ArrayList<String> lavaLore = new ArrayList<>();
        ArrayList<String> squidLore = new ArrayList<>();
        ArrayList<String> nautilusLore = new ArrayList<>();
        ArrayList<String> totemLore = new ArrayList<>();



        ItemStack portal = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        ItemMeta portalMeta = portal.getItemMeta();
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemMeta diamondMeta = diamond.getItemMeta();
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = gold.getItemMeta();
        ItemStack note = new ItemStack(Material.NOTE_BLOCK);
        ItemMeta noteMeta = note.getItemMeta();
        ItemStack damage = new ItemStack(Material.FIRE_CORAL);
        ItemMeta damageMeta = damage.getItemMeta();
        ItemStack spell = new ItemStack(Material.CHORUS_FRUIT);
        ItemMeta spellMeta = spell.getItemMeta();
        ItemStack honey = new ItemStack(Material.HONEY_BOTTLE);
        ItemMeta honeyMeta = honey.getItemMeta();
        ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta lavaMeta = lava.getItemMeta();
        ItemStack squid = new ItemStack(Material.INK_SAC);
        ItemMeta squidMeta = squid.getItemMeta();
        ItemStack nautilus = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta nautilusMeta = nautilus.getItemMeta();
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta totemMeta = totem.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);



        arrowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Default"))));
        arrowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        arrow.setItemMeta(arrowMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 0) {
            arrow.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        portalLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.12.Description"))));
        portalMeta.setLore(portalLore);
        portalMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        portalMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.12.Name"))));
        portal.setItemMeta(portalMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 12) {
            portal.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        diamondLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.13.Description"))));
        diamondMeta.setLore(diamondLore);
        diamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        diamondMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.13.Name"))));
        diamond.setItemMeta(diamondMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 13) {
            diamond.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        goldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.14.Description"))));
        goldMeta.setLore(goldLore);
        goldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        goldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.14.Name"))));
        gold.setItemMeta(goldMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 14) {
            gold.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        noteLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.15.Description"))));
        noteMeta.setLore(noteLore);
        noteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        noteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.15.Name"))));
        note.setItemMeta(noteMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 15) {
            note.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        damageLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.16.Description"))));
        damageMeta.setLore(damageLore);
        damageMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        damageMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.16.Name"))));
        damage.setItemMeta(damageMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 16) {
            damage.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        spellLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.17.Description"))));
        spellMeta.setLore(spellLore);
        spellMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        spellMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.17.Name"))));
        spell.setItemMeta(spellMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 17) {
            spell.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        honeyLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.18.Description"))));
        honeyMeta.setLore(honeyLore);
        honeyMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        honeyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.18.Name"))));
        honey.setItemMeta(honeyMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 18) {
            honey.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        lavaLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.19.Description"))));
        lavaMeta.setLore(lavaLore);
        lavaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lavaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.19.Name"))));
        lava.setItemMeta(lavaMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 19) {
            lava.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        squidLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.20.Description"))));
        squidMeta.setLore(squidLore);
        squidMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        squidMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.20.Name"))));
        squid.setItemMeta(squidMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 20) {
            squid.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        nautilusLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.21.Description"))));
        nautilusMeta.setLore(nautilusLore);
        nautilusMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        nautilusMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.21.Name"))));
        nautilus.setItemMeta(nautilusMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 21) {
            nautilus.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        totemLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.22.Description"))));
        totemMeta.setLore(totemLore);
        totemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        totemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Arrow_Inventory.22.Name"))));
        totem.setItemMeta(totemMeta);
        if(plugin.data.getArrowFlag(p.getUniqueId()) == 22) {
            totem.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        arrowInv.setItem(10, portal);
        arrowInv.setItem(12, diamond);
        arrowInv.setItem(14, gold);
        arrowInv.setItem(16, note);
        arrowInv.setItem(20, damage);
        arrowInv.setItem(22, spell);
        arrowInv.setItem(24, honey);
        arrowInv.setItem(28, lava);
        arrowInv.setItem(30, squid);
        arrowInv.setItem(32, nautilus);
        arrowInv.setItem(34, totem);

        ////////////////////////////////////////
        arrowInv.setItem(0, empty);
        arrowInv.setItem(1, empty);
        arrowInv.setItem(2, empty);
        arrowInv.setItem(3, empty);
        arrowInv.setItem(4, empty);
        arrowInv.setItem(5, empty);
        arrowInv.setItem(6, empty);
        arrowInv.setItem(7, empty);
        arrowInv.setItem(8, empty);
        arrowInv.setItem(9, empty);
        arrowInv.setItem(17, empty);
        arrowInv.setItem(18, empty);
        arrowInv.setItem(26,empty);
        arrowInv.setItem(27, empty);
        arrowInv.setItem(35, empty);
        arrowInv.setItem(36, empty);
        arrowInv.setItem(44, empty);
        arrowInv.setItem(45, empty);
        arrowInv.setItem(46, empty);
        arrowInv.setItem(47, empty);
        arrowInv.setItem(51, empty);
        arrowInv.setItem(52, empty);
        arrowInv.setItem(53, empty);
        arrowInv.setItem(50, empty);
        //////////////////////////////////

        arrowInv.setItem(48, barrier);
        arrowInv.setItem(49, arrow);

        ArrowInv_1.put(p, arrowInv);
    }
    public void WalkInv(Player p){
        Inventory walkInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Walk_Inventory_Name"))));
        ArrayList<String> DiamondLore = new ArrayList<>();
        ArrayList<String> goldLore = new ArrayList<>();
        ArrayList<String> emeraldLore = new ArrayList<>();
        ArrayList<String> WhiteGlassLore = new ArrayList<>();
        ArrayList<String> PinkGlassLore = new ArrayList<>();
        ArrayList<String> GlassLore = new ArrayList<>();
        ArrayList<String> RedGlassLore = new ArrayList<>();
        ArrayList<String> NetherOreLore = new ArrayList<>();
        ArrayList<String> RedstoneOreLore = new ArrayList<>();
        ArrayList<String> LapisOreLore = new ArrayList<>();
        ArrayList<String> BlueGlassLore = new ArrayList<>();

        ItemStack Diamond = new ItemStack(Material.DIAMOND_ORE);
        ItemMeta DiamondMeta = Diamond.getItemMeta();
        ItemStack gold = new ItemStack(Material.GOLD_ORE);
        ItemMeta goldMeta = gold.getItemMeta();
        ItemStack emerald = new ItemStack(Material.EMERALD_ORE);
        ItemMeta emeraldMeta = emerald.getItemMeta();
        ItemStack WhiteGlass = new ItemStack(Material.WHITE_STAINED_GLASS);
        ItemMeta WhiteGlassMeta = WhiteGlass.getItemMeta();
        ItemStack PinkGlass = new ItemStack(Material.PINK_STAINED_GLASS);
        ItemMeta PinkGlassMeta = PinkGlass.getItemMeta();
        ItemStack Glass = new ItemStack(Material.GLASS);
        ItemMeta GlassMeta = Glass.getItemMeta();
        ItemStack RedGlass = new ItemStack(Material.RED_STAINED_GLASS);
        ItemMeta RedGlassMeta = RedGlass.getItemMeta();
        ItemStack NetherOre = new ItemStack(Material.NETHER_QUARTZ_ORE);
        ItemMeta NetherOreMeta = NetherOre.getItemMeta();
        ItemStack RedstoneOre = new ItemStack(Material.REDSTONE_ORE);
        ItemMeta RedstoneOreMeta = RedstoneOre.getItemMeta();
        ItemStack LapisOre = new ItemStack(Material.LAPIS_ORE);
        ItemMeta LapisOreMeta = LapisOre.getItemMeta();
        ItemStack BlueGlass = new ItemStack(Material.BLUE_STAINED_GLASS);
        ItemMeta BlueGlassMeta = BlueGlass.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack boots = new ItemStack(Material.OAK_SIGN);
        ItemMeta bootsMeta = boots.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack map = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta = map.getItemMeta();

        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Next_Page"))));
        map.setItemMeta(mapMeta);

        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Default"))));
        bootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        boots.setItemMeta(bootsMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 0) {
            boots.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }


        DiamondLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.1.Description"))));
        DiamondMeta.setLore(DiamondLore);
        DiamondMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.1.Name"))));
        DiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Diamond.setItemMeta(DiamondMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 1) {
            Diamond.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        goldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.2.Description"))));
        goldMeta.setLore(goldLore);
        goldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.2.Name"))));
        goldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gold.setItemMeta(goldMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 2) {
            gold.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        emeraldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.3.Description"))));
        emeraldMeta.setLore(emeraldLore);
        emeraldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.3.Name"))));
        emeraldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        emerald.setItemMeta(emeraldMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 3) {
            emerald.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        WhiteGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.4.Description"))));
        WhiteGlassMeta.setLore(WhiteGlassLore);
        WhiteGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.4.Name"))));
        WhiteGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WhiteGlass.setItemMeta(WhiteGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 4) {
            WhiteGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        PinkGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.5.Description"))));
        PinkGlassMeta.setLore(PinkGlassLore);
        PinkGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.5.Name"))));
        PinkGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        PinkGlass.setItemMeta(PinkGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 5) {
            PinkGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        GlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.6.Description"))));
        GlassMeta.setLore(GlassLore);
        GlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.6.Name"))));
        GlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Glass.setItemMeta(GlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 6) {
            Glass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        RedGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.7.Description"))));
        RedGlassMeta.setLore(RedGlassLore);
        RedGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.7.Name"))));
        RedGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        RedGlass.setItemMeta(RedGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 7) {
            RedGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        NetherOreLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.8.Description"))));
        NetherOreMeta.setLore(NetherOreLore);
        NetherOreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.8.Name"))));
        NetherOreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        NetherOre.setItemMeta(NetherOreMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 8) {
            NetherOre.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        RedstoneOreLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.9.Description"))));
        RedstoneOreMeta.setLore(RedstoneOreLore);
        RedstoneOreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.9.Name"))));
        RedstoneOreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        RedstoneOre.setItemMeta(RedstoneOreMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 9) {
            RedstoneOre.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        LapisOreLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.10.Description"))));
        LapisOreMeta.setLore(LapisOreLore);
        LapisOreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.10.Name"))));
        LapisOreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        LapisOre.setItemMeta(LapisOreMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 10) {
            LapisOre.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        BlueGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.11.Description"))));
        BlueGlassMeta.setLore(BlueGlassLore);
        BlueGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.11.Name"))));
        BlueGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        BlueGlass.setItemMeta(BlueGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 11) {
            BlueGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }


        walkInv.setItem(10, Diamond);
        walkInv.setItem(12, gold);
        walkInv.setItem(14, emerald);
        walkInv.setItem(16, WhiteGlass);
        walkInv.setItem(20, PinkGlass);
        walkInv.setItem(22, Glass);
        walkInv.setItem(24, RedGlass);
        walkInv.setItem(28, NetherOre);
        walkInv.setItem(30, RedstoneOre);
        walkInv.setItem(32, LapisOre);
        walkInv.setItem(34, BlueGlass);

        ////////////////////////////////////////
        walkInv.setItem(0, empty);
        walkInv.setItem(1, empty);
        walkInv.setItem(2, empty);
        walkInv.setItem(3, empty);
        walkInv.setItem(4, empty);
        walkInv.setItem(5, empty);
        walkInv.setItem(6, empty);
        walkInv.setItem(7, empty);
        walkInv.setItem(8, empty);
        walkInv.setItem(9, empty);
        walkInv.setItem(17, empty);
        walkInv.setItem(18, empty);
        walkInv.setItem(26,empty);
        walkInv.setItem(27, empty);
        walkInv.setItem(35, empty);
        walkInv.setItem(36, empty);
        walkInv.setItem(44, empty);
        walkInv.setItem(45, empty);
        walkInv.setItem(46, empty);
        walkInv.setItem(47, empty);
        walkInv.setItem(51, empty);
        walkInv.setItem(52, empty);
        walkInv.setItem(53, empty);
        //////////////////////////////////

        walkInv.setItem(48, barrier);
        walkInv.setItem(50, map);
        walkInv.setItem(49, boots);

        WalkInv.put(p, walkInv);
    }
    public void WalkInv_1(Player p){
        Inventory walkInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Walk_Inventory_Name"))));
        ArrayList<String> DiamondLore = new ArrayList<>();
        ArrayList<String> goldLore = new ArrayList<>();
        ArrayList<String> emeraldLore = new ArrayList<>();
        ArrayList<String> WhiteGlassLore = new ArrayList<>();
        ArrayList<String> PinkGlassLore = new ArrayList<>();
        ArrayList<String> GlassLore = new ArrayList<>();
        ArrayList<String> RedGlassLore = new ArrayList<>();
        ArrayList<String> NetherOreLore = new ArrayList<>();
        ArrayList<String> RedstoneOreLore = new ArrayList<>();
        ArrayList<String> LapisOreLore = new ArrayList<>();
        ArrayList<String> BlueGlassLore = new ArrayList<>();

        ItemStack Diamond = new ItemStack(Material.PINK_CONCRETE);
        ItemMeta DiamondMeta = Diamond.getItemMeta();
        ItemStack gold = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta goldMeta = gold.getItemMeta();
        ItemStack emerald = new ItemStack(Material.YELLOW_CONCRETE);
        ItemMeta emeraldMeta = emerald.getItemMeta();
        ItemStack WhiteGlass = new ItemStack(Material.BLUE_CONCRETE);
        ItemMeta WhiteGlassMeta = WhiteGlass.getItemMeta();
        ItemStack PinkGlass = new ItemStack(Material.MAGENTA_CONCRETE);
        ItemMeta PinkGlassMeta = PinkGlass.getItemMeta();
        ItemStack Glass = new ItemStack(Material.ORANGE_CONCRETE);
        ItemMeta GlassMeta = Glass.getItemMeta();
        ItemStack RedGlass = new ItemStack(Material.WHITE_CONCRETE);
        ItemMeta RedGlassMeta = RedGlass.getItemMeta();
        ItemStack NetherOre = new ItemStack(Material.CYAN_CONCRETE);
        ItemMeta NetherOreMeta = NetherOre.getItemMeta();
        ItemStack RedstoneOre = new ItemStack(Material.RED_CONCRETE);
        ItemMeta RedstoneOreMeta = RedstoneOre.getItemMeta();
        ItemStack LapisOre = new ItemStack(Material.PURPLE_CONCRETE);
        ItemMeta LapisOreMeta = LapisOre.getItemMeta();
        ItemStack BlueGlass = new ItemStack(Material.BLACK_CONCRETE);
        ItemMeta BlueGlassMeta = BlueGlass.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack boots = new ItemStack(Material.OAK_SIGN);
        ItemMeta bootsMeta = boots.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();

        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.Default"))));
        bootsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        boots.setItemMeta(bootsMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 0) {
            boots.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }


        DiamondLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.12.Description"))));
        DiamondMeta.setLore(DiamondLore);
        DiamondMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.12.Name"))));
        DiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Diamond.setItemMeta(DiamondMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 12) {
            Diamond.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        goldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.13.Description"))));
        goldMeta.setLore(goldLore);
        goldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.13.Name"))));
        goldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gold.setItemMeta(goldMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 13) {
            gold.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        emeraldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.14.Description"))));
        emeraldMeta.setLore(emeraldLore);
        emeraldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.14.Name"))));
        emeraldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        emerald.setItemMeta(emeraldMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 14) {
            emerald.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        WhiteGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.15.Description"))));
        WhiteGlassMeta.setLore(WhiteGlassLore);
        WhiteGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.15.Name"))));
        WhiteGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        WhiteGlass.setItemMeta(WhiteGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 15) {
            WhiteGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        PinkGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.16.Description"))));
        PinkGlassMeta.setLore(PinkGlassLore);
        PinkGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.16.Name"))));
        PinkGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        PinkGlass.setItemMeta(PinkGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 16) {
            PinkGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        GlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.17.Description"))));
        GlassMeta.setLore(GlassLore);
        GlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.17.Name"))));
        GlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Glass.setItemMeta(GlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 17) {
            Glass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        RedGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.18.Description"))));
        RedGlassMeta.setLore(RedGlassLore);
        RedGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.18.Name"))));
        RedGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        RedGlass.setItemMeta(RedGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 18) {
            RedGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        NetherOreLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.19.Description"))));
        NetherOreMeta.setLore(NetherOreLore);
        NetherOreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.19.Name"))));
        NetherOreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        NetherOre.setItemMeta(NetherOreMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 19) {
            NetherOre.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        RedstoneOreLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.20.Description"))));
        RedstoneOreMeta.setLore(RedstoneOreLore);
        RedstoneOreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.20.Name"))));
        RedstoneOreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        RedstoneOre.setItemMeta(RedstoneOreMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 20) {
            RedstoneOre.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        LapisOreLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.21.Description"))));
        LapisOreMeta.setLore(LapisOreLore);
        LapisOreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.21.Name"))));
        LapisOreMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        LapisOre.setItemMeta(LapisOreMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 21) {
            LapisOre.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        BlueGlassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.22.Description"))));
        BlueGlassMeta.setLore(BlueGlassLore);
        BlueGlassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Walk_Inventory.22.Name"))));
        BlueGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        BlueGlass.setItemMeta(BlueGlassMeta);
        if(plugin.data.getWalkFlag(p.getUniqueId()) == 22) {
            BlueGlass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }


        walkInv.setItem(10, Diamond);
        walkInv.setItem(12, gold);
        walkInv.setItem(14, emerald);
        walkInv.setItem(16, WhiteGlass);
        walkInv.setItem(20, PinkGlass);
        walkInv.setItem(22, Glass);
        walkInv.setItem(24, RedGlass);
        walkInv.setItem(28, NetherOre);
        walkInv.setItem(30, RedstoneOre);
        walkInv.setItem(32, LapisOre);
        walkInv.setItem(34, BlueGlass);

        ////////////////////////////////////////
        walkInv.setItem(0, empty);
        walkInv.setItem(1, empty);
        walkInv.setItem(2, empty);
        walkInv.setItem(3, empty);
        walkInv.setItem(4, empty);
        walkInv.setItem(5, empty);
        walkInv.setItem(6, empty);
        walkInv.setItem(7, empty);
        walkInv.setItem(8, empty);
        walkInv.setItem(9, empty);
        walkInv.setItem(17, empty);
        walkInv.setItem(18, empty);
        walkInv.setItem(26,empty);
        walkInv.setItem(27, empty);
        walkInv.setItem(35, empty);
        walkInv.setItem(36, empty);
        walkInv.setItem(44, empty);
        walkInv.setItem(45, empty);
        walkInv.setItem(46, empty);
        walkInv.setItem(47, empty);
        walkInv.setItem(51, empty);
        walkInv.setItem(52, empty);
        walkInv.setItem(53, empty);
        walkInv.setItem(50, empty);
        //////////////////////////////////

        walkInv.setItem(48, barrier);
        walkInv.setItem(49, boots);

        WalkInv_1.put(p, walkInv);
    }
    public void KillInv(Player p) {
        Inventory killInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Kill_Inventory_Name"))));
        ArrayList<String> fireworkLore = new ArrayList<>();
        ArrayList<String> thunderLore = new ArrayList<>();
        ArrayList<String> SquidLore = new ArrayList<>();
        ArrayList<String> TNTLore = new ArrayList<>();
        ArrayList<String> headLore = new ArrayList<>();
        ArrayList<String> cookieLore = new ArrayList<>();
        ArrayList<String> smokeLore = new ArrayList<>();
        ArrayList<String> goldLore = new ArrayList<>();
        ArrayList<String> flameLore = new ArrayList<>();
        ArrayList<String> chickenLore = new ArrayList<>();
        ArrayList<String> bloodLore = new ArrayList<>();

        ItemStack firework = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta fireworkMeta = firework.getItemMeta();
        ItemStack thunder = new ItemStack(Material.BEACON);
        ItemMeta thunderMeta = thunder.getItemMeta();
        ItemStack Squid = new ItemStack(Material.SQUID_SPAWN_EGG);
        ItemMeta SquidMeta = Squid.getItemMeta();
        ItemStack TNT = new ItemStack(Material.TNT);
        ItemMeta TNTMeta = TNT.getItemMeta();
        ItemStack head = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
        ItemMeta headMeta = head.getItemMeta();
        ItemStack cookie = new ItemStack(Material.COOKIE);
        ItemMeta cookieMeta = cookie.getItemMeta();
        ItemStack smoke = new ItemStack(Material.COAL);
        ItemMeta smokeMeta = smoke.getItemMeta();
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = gold.getItemMeta();
        ItemStack flame = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta flameMeta = flame.getItemMeta();
        ItemStack chicken = new ItemStack(Material.FEATHER);
        ItemMeta chickenMeta = chicken.getItemMeta();
        ItemStack blood = new ItemStack(Material.REDSTONE);
        ItemMeta bloodMeta = blood.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack map = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta = map.getItemMeta();
        ItemStack skull = new ItemStack(Material.OAK_SIGN);
        ItemMeta skullMeta = skull.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();

        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Next_Page"))));
        map.setItemMeta(mapMeta);

        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        skullMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Default"))));
        skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skull.setItemMeta(skullMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 0) {
            skull.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        fireworkLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.1.Description"))));
        fireworkMeta.setLore(fireworkLore);
        fireworkMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.1.Name"))));
        fireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        firework.setItemMeta(fireworkMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 1) {
            firework.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        thunderLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.2.Description"))));
        thunderMeta.setLore(thunderLore);
        thunderMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.2.Name"))));
        thunderMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        thunder.setItemMeta(thunderMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 2) {
            thunder.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        SquidLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.3.Description"))));
        SquidMeta.setLore(SquidLore);
        SquidMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.3.Name"))));
        SquidMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        Squid.setItemMeta(SquidMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 3) {
            Squid.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        TNTLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.4.Description"))));
        TNTMeta.setLore(TNTLore);
        TNTMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.4.Name"))));
        TNTMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        TNT.setItemMeta(TNTMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 4) {
            TNT.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        headLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.5.Description"))));
        headMeta.setLore(headLore);
        headMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.5.Name"))));
        headMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        head.setItemMeta(headMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 5) {
            head.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        cookieLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.6.Description"))));
        cookieMeta.setLore(cookieLore);
        cookieMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.6.Name"))));
        cookieMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cookie.setItemMeta(cookieMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 6) {
            cookie.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        smokeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.7.Description"))));
        smokeMeta.setLore(smokeLore);
        smokeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.7.Name"))));
        smokeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        smoke.setItemMeta(smokeMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 7) {
            smoke.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        goldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.8.Description"))));
        goldMeta.setLore(goldLore);
        goldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.8.Name"))));
        goldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gold.setItemMeta(goldMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 8) {
            gold.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        flameLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.9.Description"))));
        flameMeta.setLore(flameLore);
        flameMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.9.Name"))));
        flameMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        flame.setItemMeta(flameMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 9) {
            flame.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        chickenLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.10.Description"))));
        chickenMeta.setLore(chickenLore);
        chickenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.10.Name"))));
        chickenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chicken.setItemMeta(chickenMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 11) {
            chicken.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        bloodLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.11.Description"))));
        bloodMeta.setLore(bloodLore);
        bloodMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.11.Name"))));
        bloodMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        blood.setItemMeta(bloodMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 10) {
            blood.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        killInv.setItem(10, firework);
        killInv.setItem(12, thunder);
        killInv.setItem(14, Squid);
        killInv.setItem(16, TNT);
        killInv.setItem(20, head);
        killInv.setItem(22, cookie);
        killInv.setItem(24, smoke);
        killInv.setItem(28, gold);
        killInv.setItem(30, flame);
        killInv.setItem(32, blood);
        killInv.setItem(34, chicken);

        ////////////////////////////////////////
        killInv.setItem(0, empty);
        killInv.setItem(1, empty);
        killInv.setItem(2, empty);
        killInv.setItem(3, empty);
        killInv.setItem(4, empty);
        killInv.setItem(5, empty);
        killInv.setItem(6, empty);
        killInv.setItem(7, empty);
        killInv.setItem(8, empty);
        killInv.setItem(9, empty);
        killInv.setItem(17, empty);
        killInv.setItem(18, empty);
        killInv.setItem(26,empty);
        killInv.setItem(27, empty);
        killInv.setItem(35, empty);
        killInv.setItem(36, empty);
        killInv.setItem(44, empty);
        killInv.setItem(45, empty);
        killInv.setItem(46, empty);
        killInv.setItem(47, empty);
        killInv.setItem(51, empty);
        killInv.setItem(52, empty);
        killInv.setItem(53, empty);
        //////////////////////////////////

        killInv.setItem(48, barrier);
        killInv.setItem(49, skull);
        killInv.setItem(50, map);

        KillInv.put(p, killInv);
    }
    public void KillInv_1(Player p) {
        Inventory killInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Kill_Inventory_Name"))));
        ArrayList<String> rainLore = new ArrayList<>();
        ArrayList<String> glassLore = new ArrayList<>();
        ArrayList<String> tornadoLore = new ArrayList<>();
        ArrayList<String> guardianLore = new ArrayList<>();
        ArrayList<String> rabbitLore = new ArrayList<>();
        ArrayList<String> batLore = new ArrayList<>();
        ArrayList<String> cowLore = new ArrayList<>();
        ArrayList<String> pumpkinLore = new ArrayList<>();
        ArrayList<String> deathLore = new ArrayList<>();
        ArrayList<String> ghostLore = new ArrayList<>();
        ArrayList<String> funeralLore = new ArrayList<>();

        ItemStack rain = new ItemStack(Material.WATER_BUCKET);
        ItemMeta rainMeta = rain.getItemMeta();
        ItemStack glass = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta glassMeta = glass.getItemMeta();
        ItemStack tornado = new ItemStack(Material.STRING);
        ItemMeta tornadoMeta = tornado.getItemMeta();
        ItemStack guardian = new ItemStack(Material.GUARDIAN_SPAWN_EGG);
        ItemMeta guardianMeta = guardian.getItemMeta();
        ItemStack rabbit = new ItemStack(Material.RABBIT_SPAWN_EGG);
        ItemMeta rabbitMeta = rabbit.getItemMeta();
        ItemStack bat = new ItemStack(Material.BAT_SPAWN_EGG);
        ItemMeta batMeta = bat.getItemMeta();
        ItemStack cow = new ItemStack(Material.COW_SPAWN_EGG);
        ItemMeta cowMeta = cow.getItemMeta();
        ItemStack pumpkin = new ItemStack(Material.CARVED_PUMPKIN);
        ItemMeta pumpkinMeta = pumpkin.getItemMeta();
        ItemStack death = new ItemStack(Material.BONE);
        ItemMeta deathMeta = death.getItemMeta();
        ItemStack ghost = new ItemStack(Material.PAINTING);
        ItemMeta ghostMeta = ghost.getItemMeta();
        ItemStack funeral = new ItemStack(Material.DARK_OAK_SIGN);
        ItemMeta funeralMeta = funeral.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack skull = new ItemStack(Material.OAK_SIGN);
        ItemMeta skullMeta = skull.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();


        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        skullMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.Default"))));
        skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        skull.setItemMeta(skullMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 0) {
            skull.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        rabbitLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.12.Description"))));
        rabbitMeta.setLore(rabbitLore);
        rabbitMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.12.Name"))));
        rabbitMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        rabbit.setItemMeta(rabbitMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 12) {
            rabbit.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        batLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.13.Description"))));
        batMeta.setLore(batLore);
        batMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.13.Name"))));
        batMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bat.setItemMeta(batMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 13) {
            bat.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        cowLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.14.Description"))));
        cowMeta.setLore(cowLore);
        cowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.14.Name"))));
        cowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cow.setItemMeta(cowMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 14) {
            cow.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        pumpkinLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.15.Description"))));
        pumpkinMeta.setLore(pumpkinLore);
        pumpkinMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.15.Name"))));
        pumpkinMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        pumpkin.setItemMeta(pumpkinMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 15) {
            pumpkin.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        rainLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.16.Description"))));
        rainMeta.setLore(rainLore);
        rainMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.16.Name"))));
        rainMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        rain.setItemMeta(rainMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 16) {
            rain.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        glassLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.17.Description"))));
        glassMeta.setLore(glassLore);
        glassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.17.Name"))));
        glassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        glass.setItemMeta(glassMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 17) {
            glass.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        tornadoLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.18.Description"))));
        tornadoMeta.setLore(tornadoLore);
        tornadoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.18.Name"))));
        tornadoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        tornado.setItemMeta(tornadoMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 18) {
            tornado.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        guardianLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.19.Description"))));
        guardianMeta.setLore(guardianLore);
        guardianMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.19.Name"))));
        guardianMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        guardian.setItemMeta(guardianMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 19) {
            guardian.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        deathLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.20.Description"))));
        deathMeta.setLore(deathLore);
        deathMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.20.Name"))));
        deathMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        death.setItemMeta(deathMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 20) {
            death.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        ghostLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.21.Description"))));
        ghostMeta.setLore(ghostLore);
        ghostMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.21.Name"))));
        ghostMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ghost.setItemMeta(ghostMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 21) {
            ghost.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        funeralLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.22.Description"))));
        funeralMeta.setLore(funeralLore);
        funeralMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Kill_Inventory.22.Name"))));
        funeralMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        funeral.setItemMeta(funeralMeta);
        if(plugin.data.getKillFlag(p.getUniqueId()) == 22) {
            funeral.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        killInv.setItem(10, rabbit);
        killInv.setItem(12, bat);
        killInv.setItem(14, cow);
        killInv.setItem(16, pumpkin);
        killInv.setItem(20, rain);
        killInv.setItem(22, glass);
        killInv.setItem(24, tornado);
        killInv.setItem(28, guardian);
        killInv.setItem(30, death);
        killInv.setItem(32, ghost);
        killInv.setItem(34, funeral);

        ////////////////////////////////////////
        killInv.setItem(0, empty);
        killInv.setItem(1, empty);
        killInv.setItem(2, empty);
        killInv.setItem(3, empty);
        killInv.setItem(4, empty);
        killInv.setItem(5, empty);
        killInv.setItem(6, empty);
        killInv.setItem(7, empty);
        killInv.setItem(8, empty);
        killInv.setItem(9, empty);
        killInv.setItem(17, empty);
        killInv.setItem(18, empty);
        killInv.setItem(26,empty);
        killInv.setItem(27, empty);
        killInv.setItem(35, empty);
        killInv.setItem(36, empty);
        killInv.setItem(44, empty);
        killInv.setItem(45, empty);
        killInv.setItem(46, empty);
        killInv.setItem(47, empty);
        killInv.setItem(51, empty);
        killInv.setItem(52, empty);
        killInv.setItem(53, empty);
        killInv.setItem(50, empty);
        //////////////////////////////////

        killInv.setItem(48, barrier);
        killInv.setItem(49, skull);

        KillInv_1.put(p, killInv);
    }
    public void DeathSoundInv(Player p) {
        Inventory soundInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.Sound_Inventory_Name"))));
        ArrayList<String> blazeLore = new ArrayList<>();
        ArrayList<String> portalLore = new ArrayList<>();
        ArrayList<String> dragonLore = new ArrayList<>();
        ArrayList<String> dolphinLore = new ArrayList<>();
        ArrayList<String> donkeyLore = new ArrayList<>();
        ArrayList<String> guardianLore = new ArrayList<>();
        ArrayList<String> ghastLore = new ArrayList<>();
        ArrayList<String> vexLore = new ArrayList<>();
        ArrayList<String> ravagerLore = new ArrayList<>();
        ArrayList<String> TNTLore = new ArrayList<>();
        ArrayList<String> explodeLore = new ArrayList<>();

        ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
        ItemMeta blazeMeta = blaze.getItemMeta();
        ItemStack portal = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        ItemMeta portalMeta = portal.getItemMeta();
        ItemStack dragon = new ItemStack(Material.DRAGON_EGG);
        ItemMeta dragonMeta = dragon.getItemMeta();
        ItemStack dolphin = new ItemStack(Material.DOLPHIN_SPAWN_EGG);
        ItemMeta dolphinMeta = dolphin.getItemMeta();
        ItemStack donkey = new ItemStack(Material.DONKEY_SPAWN_EGG);
        ItemMeta donkeyMeta = donkey.getItemMeta();
        ItemStack guardian = new ItemStack(Material.GUARDIAN_SPAWN_EGG);
        ItemMeta guardianMeta = guardian.getItemMeta();
        ItemStack ghast = new ItemStack(Material.GHAST_SPAWN_EGG);
        ItemMeta ghastMeta = ghast.getItemMeta();
        ItemStack vex = new ItemStack(Material.VEX_SPAWN_EGG);
        ItemMeta vexMeta = vex.getItemMeta();
        ItemStack ravager = new ItemStack(Material.RAVAGER_SPAWN_EGG);
        ItemMeta ravagerMeta = ravager.getItemMeta();
        ItemStack TNT = new ItemStack(Material.TNT);
        ItemMeta TNTMeta = TNT.getItemMeta();
        ItemStack explode = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta explodeMeta = explode.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack defaultSound = new ItemStack(Material.OAK_SIGN);
        ItemMeta defaultSoundMeta = defaultSound.getItemMeta();
        ItemStack map = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta = map.getItemMeta();

        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.Next_Page"))));
        map.setItemMeta(mapMeta);
        defaultSoundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.Default"))));
        defaultSoundMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        defaultSound.setItemMeta(defaultSoundMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 0) {
            defaultSound.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        blazeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.1.Description"))));
        blazeMeta.setLore(blazeLore);
        blazeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.1.Name"))));
        blazeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        blaze.setItemMeta(blazeMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 1) {
            blaze.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        portalLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.2.Description"))));
        portalMeta.setLore(portalLore);
        portalMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.2.Name"))));
        portalMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        portal.setItemMeta(portalMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 2) {
            portal.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        blazeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.3.Description"))));
        dragonMeta.setLore(dragonLore);
        dragonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.3.Name"))));
        dragonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        dragon.setItemMeta(dragonMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 3) {
            dragon.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        dolphinLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.4.Description"))));
        dolphinMeta.setLore(dolphinLore);
        dolphinMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.4.Name"))));
        dolphinMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        dolphin.setItemMeta(dolphinMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 4) {
            dolphin.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        donkeyLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.5.Description"))));
        donkeyMeta.setLore(donkeyLore);
        donkeyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.5.Name"))));
        donkeyMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        donkey.setItemMeta(donkeyMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 5) {
            donkey.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        guardianLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.6.Description"))));
        guardianMeta.setLore(guardianLore);
        guardianMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.6.Name"))));
        guardianMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        guardian.setItemMeta(guardianMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 6) {
            guardian.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        ghastLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.7.Description"))));
        ghastMeta.setLore(ghastLore);
        ghastMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.7.Name"))));
        ghastMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ghast.setItemMeta(ghastMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 7) {
            ghast.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        vexLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.8.Description"))));
        vexMeta.setLore(vexLore);
        vexMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.8.Name"))));
        vexMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        vex.setItemMeta(vexMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 8) {
            vex.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        ravagerLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.9.Description"))));
        ravagerMeta.setLore(ravagerLore);
        ravagerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.9.Name"))));
        ravagerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ravager.setItemMeta(ravagerMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 9) {
            ravager.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        TNTLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.10.Description"))));
        TNTMeta.setLore(TNTLore);
        TNTMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.10.Name"))));
        TNTMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        TNT.setItemMeta(TNTMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 10) {
            TNT.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        explodeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.11.Description"))));
        explodeMeta.setLore(explodeLore);
        explodeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Sound_Inventory.11.Name"))));
        explodeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        explode.setItemMeta(explodeMeta);
        if(plugin.data.getSoundFlag(p.getUniqueId()) == 11) {
            explode.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        soundInv.setItem(10, blaze);
        soundInv.setItem(12, portal);
        soundInv.setItem(14, dragon);
        soundInv.setItem(16, dolphin);
        soundInv.setItem(20, donkey);
        soundInv.setItem(22, guardian);
        soundInv.setItem(24, ghast);
        soundInv.setItem(28, vex);
        soundInv.setItem(30, ravager);
        soundInv.setItem(32, TNT);
        soundInv.setItem(34, explode);

        ////////////////////////////////////////
        soundInv.setItem(0, empty);
        soundInv.setItem(1, empty);
        soundInv.setItem(2, empty);
        soundInv.setItem(3, empty);
        soundInv.setItem(4, empty);
        soundInv.setItem(5, empty);
        soundInv.setItem(6, empty);
        soundInv.setItem(7, empty);
        soundInv.setItem(8, empty);
        soundInv.setItem(9, empty);
        soundInv.setItem(17, empty);
        soundInv.setItem(18, empty);
        soundInv.setItem(26,empty);
        soundInv.setItem(27, empty);
        soundInv.setItem(35, empty);
        soundInv.setItem(36, empty);
        soundInv.setItem(44, empty);
        soundInv.setItem(45, empty);
        soundInv.setItem(46, empty);
        soundInv.setItem(47, empty);
        soundInv.setItem(51, empty);
        soundInv.setItem(52, empty);
        soundInv.setItem(53, empty);
        //////////////////////////////////

        soundInv.setItem(48, barrier);
        soundInv.setItem(49, defaultSound);
        soundInv.setItem(50, map);

        DeathSoundInv.put(p, soundInv);


    }
    public void ChatColorInv(Player p){
        Inventory signInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.GG_ChatColor_Inventory_Name"))));
        ArrayList<String> goldLore = new ArrayList<>();
        ArrayList<String> blueLore = new ArrayList<>();
        ArrayList<String> yellowLore = new ArrayList<>();
        ArrayList<String> greenLore = new ArrayList<>();
        ArrayList<String> dark_purpleLore = new ArrayList<>();
        ArrayList<String> light_purpleLore = new ArrayList<>();
        ArrayList<String> dark_blueLore = new ArrayList<>();
        ArrayList<String> redLore = new ArrayList<>();
        ArrayList<String> dark_greenLore = new ArrayList<>();
        ArrayList<String> aquaLore = new ArrayList<>();
        ArrayList<String> blackLore = new ArrayList<>();

        ItemStack gold = new ItemStack(Material.ORANGE_DYE);
        ItemMeta goldMeta = gold.getItemMeta();
        ItemStack blue = new ItemStack(Material.BLUE_DYE);
        ItemMeta blueMeta = blue.getItemMeta();
        ItemStack yellow = new ItemStack(Material.YELLOW_DYE);
        ItemMeta yellowMeta = yellow.getItemMeta();
        ItemStack green = new ItemStack(Material.LIME_DYE);
        ItemMeta greenMeta = green.getItemMeta();
        ItemStack dark_purple = new ItemStack(Material.PURPLE_DYE);
        ItemMeta dark_purpleMeta = dark_purple.getItemMeta();
        ItemStack light_purple = new ItemStack(Material.PINK_DYE);
        ItemMeta light_purpleMeta = light_purple.getItemMeta();
        ItemStack dark_blue = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta dark_blueMeta = dark_blue.getItemMeta();
        ItemStack red = new ItemStack(Material.RED_DYE);
        ItemMeta redMeta = red.getItemMeta();
        ItemStack dark_green = new ItemStack(Material.GREEN_DYE);
        ItemMeta dark_greenMeta = dark_green.getItemMeta();
        ItemStack aqua = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemMeta aquaMeta = aqua.getItemMeta();
        ItemStack black = new ItemStack(Material.BLACK_DYE);
        ItemMeta blackMeta = black.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);


        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack sign = new ItemStack(Material.OAK_SIGN);
        ItemMeta signMeta = sign.getItemMeta();

        signMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.Default"))));
        signMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sign.setItemMeta(signMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 0) {
            sign.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);


        goldLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.1.Description"))));
        goldMeta.setLore(goldLore);
        goldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.1.Name"))));
        goldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gold.setItemMeta(goldMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 1) {
            gold.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        blueLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.2.Description"))));
        blueMeta.setLore(blueLore);
        blueMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.2.Name"))));
        blueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        blue.setItemMeta(blueMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 2) {
            blue.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        yellowLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.3.Description"))));
        yellowMeta.setLore(yellowLore);
        yellowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.3.Name"))));
        yellowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        yellow.setItemMeta(yellowMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 3) {
            yellow.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        greenLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.4.Description"))));
        greenMeta.setLore(greenLore);
        greenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.4.Name"))));
        greenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        green.setItemMeta(greenMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 4) {
            green.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        dark_purpleLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.5.Description"))));
        dark_purpleMeta.setLore(dark_purpleLore);
        dark_purpleMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.5.Name"))));
        dark_purpleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        dark_purple.setItemMeta(dark_purpleMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 5) {
            dark_purple.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        light_purpleLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.6.Description"))));
        light_purpleMeta.setLore(light_purpleLore);
        light_purpleMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.6.Name"))));
        light_purpleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        light_purple.setItemMeta(light_purpleMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 6) {
            light_purple.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        dark_blueLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.7.Description"))));
        dark_blueMeta.setLore(dark_blueLore);
        dark_blueMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.7.Name"))));
        dark_blueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        dark_blue.setItemMeta(dark_blueMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 7) {
            dark_blue.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        redLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.8.Description"))));
        redMeta.setLore(redLore);
        redMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.8.Name"))));
        redMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        red.setItemMeta(redMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 8) {
            red.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        dark_greenLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.9.Description"))));
        dark_greenMeta.setLore(dark_greenLore);
        dark_greenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.9.Name"))));
        dark_greenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        dark_green.setItemMeta(dark_greenMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 9) {
            dark_green.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        aquaLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.10.Description"))));
        aquaMeta.setLore(aquaLore);
        aquaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.10.Name"))));
        aquaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        aqua.setItemMeta(aquaMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 10) {
            aqua.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        blackLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.11.Description"))));
        blackMeta.setLore(blackLore);
        blackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("GG_ChatColor_Inventory.11.Name"))));
        blackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        black.setItemMeta(blackMeta);
        if(plugin.data.getSignFlag(p.getUniqueId()) == 11) {
            black.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        signInv.setItem(10, gold);
        signInv.setItem(12, blue);
        signInv.setItem(14, yellow);
        signInv.setItem(16, green);
        signInv.setItem(20, dark_purple);
        signInv.setItem(22, light_purple);
        signInv.setItem(24, dark_blue);
        signInv.setItem(28, red);
        signInv.setItem(30, dark_green);
        signInv.setItem(32, aqua);
        signInv.setItem(34, black);

        ////////////////////////////////////////
        signInv.setItem(0, empty);
        signInv.setItem(1, empty);
        signInv.setItem(2, empty);
        signInv.setItem(3, empty);
        signInv.setItem(4, empty);
        signInv.setItem(5, empty);
        signInv.setItem(6, empty);
        signInv.setItem(7, empty);
        signInv.setItem(8, empty);
        signInv.setItem(9, empty);
        signInv.setItem(17, empty);
        signInv.setItem(18, empty);
        signInv.setItem(26,empty);
        signInv.setItem(27, empty);
        signInv.setItem(35, empty);
        signInv.setItem(36, empty);
        signInv.setItem(44, empty);
        signInv.setItem(45, empty);
        signInv.setItem(46, empty);
        signInv.setItem(47, empty);
        signInv.setItem(51, empty);
        signInv.setItem(52, empty);
        signInv.setItem(53, empty);
        signInv.setItem(50, empty);
        //////////////////////////////////

        signInv.setItem(48, barrier);
        signInv.setItem(49, sign);

        ChatColorInv.put(p, signInv);
    }
    public void MessageInv_1(Player p) {
        Inventory messageInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Death_Message_Inventory_Name"))));
        ArrayList<String> list_1lore = new ArrayList<>();
        ArrayList<String> list_2lore = new ArrayList<>();
        ArrayList<String> list_3lore = new ArrayList<>();
        ArrayList<String> list_4lore = new ArrayList<>();
        ArrayList<String> list_5lore = new ArrayList<>();
        ArrayList<String> list_6lore = new ArrayList<>();
        ArrayList<String> list_7lore = new ArrayList<>();
        ArrayList<String> list_8lore = new ArrayList<>();
        ArrayList<String> list_9lore = new ArrayList<>();
        ArrayList<String> list_10lore = new ArrayList<>();
        ArrayList<String> list_11lore = new ArrayList<>();
        ArrayList<String> list_12lore = new ArrayList<>();
        ArrayList<String> list_13lore = new ArrayList<>();
        ArrayList<String> list_14lore = new ArrayList<>();
        ArrayList<String> list_15lore = new ArrayList<>();
        ArrayList<String> list_16lore = new ArrayList<>();
        ArrayList<String> list_17lore = new ArrayList<>();
        ArrayList<String> list_18lore = new ArrayList<>();
        ArrayList<String> list_19lore = new ArrayList<>();
        ArrayList<String> list_20lore = new ArrayList<>();
        ArrayList<String> list_21lore = new ArrayList<>();
        ArrayList<String> list_22lore = new ArrayList<>();
        ArrayList<String> list_23lore = new ArrayList<>();
        ArrayList<String> list_24lore = new ArrayList<>();
        ArrayList<String> list_25lore = new ArrayList<>();
        ArrayList<String> list_26lore = new ArrayList<>();
        ArrayList<String> list_27lore = new ArrayList<>();
        ArrayList<String> list_28lore = new ArrayList<>();


        ItemStack map = new ItemStack(Material.OAK_SIGN);
        ItemMeta mapMeta = map.getItemMeta();
        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack map_2 = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta_2 = map_2.getItemMeta();
        ItemStack list_1 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_1 = list_1.getItemMeta();
        ItemStack list_2 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_2 = list_1.getItemMeta();
        ItemStack list_3 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_3 = list_1.getItemMeta();
        ItemStack list_4 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_4 = list_1.getItemMeta();
        ItemStack list_5 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_5 = list_1.getItemMeta();
        ItemStack list_6 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_6 = list_1.getItemMeta();
        ItemStack list_7 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_7 = list_1.getItemMeta();
        ItemStack list_8 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_8 = list_1.getItemMeta();
        ItemStack list_9 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_9 = list_1.getItemMeta();
        ItemStack list_10 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_10 = list_1.getItemMeta();
        ItemStack list_11 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_11 = list_1.getItemMeta();
        ItemStack list_12 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_12 = list_1.getItemMeta();
        ItemStack list_13 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_13 = list_1.getItemMeta();
        ItemStack list_14 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_14 = list_1.getItemMeta();
        ItemStack list_15 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_15 = list_1.getItemMeta();
        ItemStack list_16 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_16 = list_1.getItemMeta();
        ItemStack list_17 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_17 = list_1.getItemMeta();
        ItemStack list_18 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_18= list_1.getItemMeta();
        ItemStack list_19 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_19 = list_1.getItemMeta();
        ItemStack list_20 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_20 = list_1.getItemMeta();
        ItemStack list_21 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_21 = list_1.getItemMeta();
        ItemStack list_22 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_22 = list_1.getItemMeta();
        ItemStack list_23 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_23 = list_1.getItemMeta();
        ItemStack list_24 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_24 = list_1.getItemMeta();
        ItemStack list_25 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_25 = list_1.getItemMeta();
        ItemStack list_26 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_26 = list_1.getItemMeta();
        ItemStack list_27 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_27 = list_1.getItemMeta();
        ItemStack list_28 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_28 = list_1.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);


        mapMeta_2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Next_Page"))));
        map_2.setItemMeta(mapMeta_2);
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);
        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Default"))));
        mapMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        map.setItemMeta(mapMeta);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 0) {
            map.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_1lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.1.Description"))));
        listMeta_1.setLore(list_1lore);
        listMeta_1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.1.Name"))));
        listMeta_1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_1.setItemMeta(listMeta_1);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 1){
            list_1.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_2lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.2.Description"))));
        listMeta_2.setLore(list_2lore);
        listMeta_2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.2.Name"))));
        listMeta_2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_2.setItemMeta(listMeta_2);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 2){
            list_2.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_2lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.3.Description"))));
        listMeta_3.setLore(list_3lore);
        listMeta_3.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.3.Name"))));
        listMeta_3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_3.setItemMeta(listMeta_3);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 3){
            list_3.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_4lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.4.Description"))));
        listMeta_4.setLore(list_4lore);
        listMeta_4.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.4.Name"))));
        listMeta_4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_4.setItemMeta(listMeta_4);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 4){
            list_4.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_5lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.5.Description"))));
        listMeta_5.setLore(list_5lore);
        listMeta_5.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.5.Name"))));
        listMeta_5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_5.setItemMeta(listMeta_5);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 5){
            list_5.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_6lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.6.Description"))));
        listMeta_6.setLore(list_6lore);
        listMeta_6.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.6.Name"))));
        listMeta_6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_6.setItemMeta(listMeta_6);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 6){
            list_6.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_7lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.7.Description"))));
        listMeta_7.setLore(list_7lore);
        listMeta_7.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.7.Name"))));
        listMeta_7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_7.setItemMeta(listMeta_7);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 7){
            list_7.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_8lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.8.Description"))));
        listMeta_8.setLore(list_8lore);
        listMeta_8.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.8.Name"))));
        listMeta_8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_8.setItemMeta(listMeta_8);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 8){
            list_8.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_9lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.9.Description"))));
        listMeta_9.setLore(list_9lore);
        listMeta_9.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.9.Name"))));
        listMeta_9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_9.setItemMeta(listMeta_9);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 9){
            list_9.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_10lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.10.Description"))));
        listMeta_10.setLore(list_10lore);
        listMeta_10.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.10.Name"))));
        listMeta_10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_10.setItemMeta(listMeta_10);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 10){
            list_10.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_11lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.11.Description"))));
        listMeta_11.setLore(list_11lore);
        listMeta_11.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.11.Name"))));
        listMeta_11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_11.setItemMeta(listMeta_11);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 11){
            list_11.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_12lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.12.Description"))));
        listMeta_12.setLore(list_12lore);
        listMeta_12.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.12.Name"))));
        listMeta_12.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_12.setItemMeta(listMeta_12);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 12){
            list_12.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_13lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.13.Description"))));
        listMeta_13.setLore(list_13lore);
        listMeta_13.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.13.Name"))));
        listMeta_13.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_13.setItemMeta(listMeta_13);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 13){
            list_13.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_14lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.14.Description"))));
        listMeta_14.setLore(list_14lore);
        listMeta_14.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.14.Name"))));
        listMeta_14.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_14.setItemMeta(listMeta_14);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 14){
            list_14.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_15lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.15.Description"))));
        listMeta_15.setLore(list_15lore);
        listMeta_15.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.15.Name"))));
        listMeta_15.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_15.setItemMeta(listMeta_15);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 15){
            list_15.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_16lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.16.Description"))));
        listMeta_16.setLore(list_16lore);
        listMeta_16.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.16.Name"))));
        listMeta_16.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_16.setItemMeta(listMeta_16);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 16){
            list_16.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_17lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.17.Description"))));
        listMeta_17.setLore(list_17lore);
        listMeta_17.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.17.Name"))));
        listMeta_17.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_17.setItemMeta(listMeta_17);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 17){
            list_17.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_18lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.18.Description"))));
        listMeta_18.setLore(list_18lore);
        listMeta_18.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.18.Name"))));
        listMeta_18.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_18.setItemMeta(listMeta_18);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 18){
            list_18.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_19lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.19.Description"))));
        listMeta_19.setLore(list_19lore);
        listMeta_19.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.19.Name"))));
        listMeta_19.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_19.setItemMeta(listMeta_19);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 19){
            list_19.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_20lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.20.Description"))));
        listMeta_20.setLore(list_20lore);
        listMeta_20.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.20.Name"))));
        listMeta_20.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_20.setItemMeta(listMeta_20);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 20){
            list_20.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_21lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.21.Description"))));
        listMeta_21.setLore(list_21lore);
        listMeta_2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.21.Name"))));
        listMeta_21.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_21.setItemMeta(listMeta_21);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 21){
            list_21.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_22lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.22.Description"))));
        listMeta_22.setLore(list_22lore);
        listMeta_22.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.22.Name"))));
        listMeta_22.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_22.setItemMeta(listMeta_22);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 22){
            list_22.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_23lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.23.Description"))));
        listMeta_23.setLore(list_23lore);
        listMeta_23.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.23.Name"))));
        listMeta_23.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_23.setItemMeta(listMeta_23);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 23){
            list_23.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_24lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.24.Description"))));
        listMeta_24.setLore(list_24lore);
        listMeta_24.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.24.Name"))));
        listMeta_24.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_24.setItemMeta(listMeta_24);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 24){
            list_24.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_25lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.25.Description"))));
        listMeta_25.setLore(list_25lore);
        listMeta_25.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.25.Name"))));
        listMeta_25.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_25.setItemMeta(listMeta_25);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 25){
            list_25.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_26lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.26.Description"))));
        listMeta_26.setLore(list_26lore);
        listMeta_26.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.26.Name"))));
        listMeta_26.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_26.setItemMeta(listMeta_26);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 26){
            list_26.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_27lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.27.Description"))));
        listMeta_27.setLore(list_27lore);
        listMeta_27.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.27.Name"))));
        listMeta_27.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_27.setItemMeta(listMeta_27);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 27){
            list_27.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_28lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.28.Description"))));
        listMeta_28.setLore(list_28lore);
        listMeta_28.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.28.Name"))));
        listMeta_28.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_28.setItemMeta(listMeta_28);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 28){
            list_28.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }



        messageInv.setItem(10, list_1);
        messageInv.setItem(11, list_2);
        messageInv.setItem(12, list_3);
        messageInv.setItem(13, list_4);
        messageInv.setItem(14, list_5);
        messageInv.setItem(15, list_6);
        messageInv.setItem(16, list_7);
        messageInv.setItem(19, list_8);
        messageInv.setItem(20, list_9);
        messageInv.setItem(21, list_10);
        messageInv.setItem(22, list_11);
        messageInv.setItem(23, list_12);
        messageInv.setItem(24, list_13);
        messageInv.setItem(25, list_14);
        messageInv.setItem(28, list_15);
        messageInv.setItem(29, list_16);
        messageInv.setItem(30, list_17);
        messageInv.setItem(31, list_18);
        messageInv.setItem(32, list_19);
        messageInv.setItem(33, list_20);
        messageInv.setItem(34, list_21);
        messageInv.setItem(37, list_22);
        messageInv.setItem(38, list_23);
        messageInv.setItem(39, list_24);
        messageInv.setItem(40, list_25);
        messageInv.setItem(41, list_26);
        messageInv.setItem(42, list_27);
        messageInv.setItem(43, list_28);

        ////////////////////////////////////////
        messageInv.setItem(0, empty);
        messageInv.setItem(1, empty);
        messageInv.setItem(2, empty);
        messageInv.setItem(3, empty);
        messageInv.setItem(4, empty);
        messageInv.setItem(5, empty);
        messageInv.setItem(6, empty);
        messageInv.setItem(7, empty);
        messageInv.setItem(8, empty);
        messageInv.setItem(9, empty);
        messageInv.setItem(17, empty);
        messageInv.setItem(18, empty);
        messageInv.setItem(26,empty);
        messageInv.setItem(27, empty);
        messageInv.setItem(35, empty);
        messageInv.setItem(36, empty);
        messageInv.setItem(44, empty);
        messageInv.setItem(45, empty);
        messageInv.setItem(46, empty);
        messageInv.setItem(47, empty);
        messageInv.setItem(51, empty);
        messageInv.setItem(52, empty);
        messageInv.setItem(53, empty);
        //////////////////////////////////


        messageInv.setItem(48, barrier);
        messageInv.setItem(49, map);
        messageInv.setItem(50, map_2);

        MessageInv_1.put(p, messageInv);
    }
    public void MessageInv_2(Player p) {
        Inventory messageInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Death_Message_Inventory_Name"))));
        ArrayList<String> list_1lore = new ArrayList<>();
        ArrayList<String> list_2lore = new ArrayList<>();
        ArrayList<String> list_3lore = new ArrayList<>();
        ArrayList<String> list_4lore = new ArrayList<>();
        ArrayList<String> list_5lore = new ArrayList<>();
        ArrayList<String> list_6lore = new ArrayList<>();
        ArrayList<String> list_7lore = new ArrayList<>();
        ArrayList<String> list_8lore = new ArrayList<>();
        ArrayList<String> list_9lore = new ArrayList<>();
        ArrayList<String> list_10lore = new ArrayList<>();
        ArrayList<String> list_11lore = new ArrayList<>();
        ArrayList<String> list_12lore = new ArrayList<>();
        ArrayList<String> list_13lore = new ArrayList<>();
        ArrayList<String> list_14lore = new ArrayList<>();
        ArrayList<String> list_15lore = new ArrayList<>();
        ArrayList<String> list_16lore = new ArrayList<>();
        ArrayList<String> list_17lore = new ArrayList<>();
        ArrayList<String> list_18lore = new ArrayList<>();
        ArrayList<String> list_19lore = new ArrayList<>();
        ArrayList<String> list_20lore = new ArrayList<>();
        ArrayList<String> list_21lore = new ArrayList<>();
        ArrayList<String> list_22lore = new ArrayList<>();
        ArrayList<String> list_23lore = new ArrayList<>();
        ArrayList<String> list_24lore = new ArrayList<>();
        ArrayList<String> list_25lore = new ArrayList<>();
        ArrayList<String> list_26lore = new ArrayList<>();
        ArrayList<String> list_27lore = new ArrayList<>();
        ArrayList<String> list_28lore = new ArrayList<>();



        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack map = new ItemStack(Material.OAK_SIGN);
        ItemMeta mapMeta = map.getItemMeta();
        ItemStack list_1 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_1 = list_1.getItemMeta();
        ItemStack list_2 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_2 = list_1.getItemMeta();
        ItemStack list_3 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_3 = list_1.getItemMeta();
        ItemStack list_4 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_4 = list_1.getItemMeta();
        ItemStack list_5 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_5 = list_1.getItemMeta();
        ItemStack list_6 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_6 = list_1.getItemMeta();
        ItemStack list_7 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_7 = list_1.getItemMeta();
        ItemStack list_8 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_8 = list_1.getItemMeta();
        ItemStack list_9 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_9 = list_1.getItemMeta();
        ItemStack list_10 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_10 = list_1.getItemMeta();
        ItemStack list_11 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_11 = list_1.getItemMeta();
        ItemStack list_12 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_12 = list_1.getItemMeta();
        ItemStack list_13 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_13 = list_1.getItemMeta();
        ItemStack list_14 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_14 = list_1.getItemMeta();
        ItemStack list_15 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_15 = list_1.getItemMeta();
        ItemStack list_16 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_16 = list_1.getItemMeta();
        ItemStack list_17 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_17 = list_1.getItemMeta();
        ItemStack list_18 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_18= list_1.getItemMeta();
        ItemStack list_19 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_19 = list_1.getItemMeta();
        ItemStack list_20 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_20 = list_1.getItemMeta();
        ItemStack list_21 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_21 = list_1.getItemMeta();
        ItemStack list_22 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_22 = list_1.getItemMeta();
        ItemStack list_23 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_23 = list_1.getItemMeta();
        ItemStack list_24 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_24 = list_1.getItemMeta();
        ItemStack list_25 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_25 = list_1.getItemMeta();
        ItemStack list_26 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_26 = list_1.getItemMeta();
        ItemStack list_27 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_27 = list_1.getItemMeta();
        ItemStack list_28 = new ItemStack(Material.PAPER);
        ItemMeta listMeta_28 = list_1.getItemMeta();

        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);
        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.Default"))));
        mapMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        map.setItemMeta(mapMeta);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 0) {
            map.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }


        list_1lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.29.Description"))));
        listMeta_1.setLore(list_1lore);
        listMeta_1.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.29.Name"))));
        listMeta_1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_1.setItemMeta(listMeta_1);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 29){
            list_1.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_2lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.30.Description"))));
        listMeta_2.setLore(list_2lore);
        listMeta_2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.30.Name"))));
        listMeta_2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_2.setItemMeta(listMeta_2);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 30){
            list_2.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_3lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.31.Description"))));
        listMeta_3.setLore(list_3lore);
        listMeta_3.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.31.Name"))));
        listMeta_3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_3.setItemMeta(listMeta_3);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 31){
            list_3.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_4lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.32.Description"))));
        listMeta_4.setLore(list_4lore);
        listMeta_4.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.32.Name"))));
        listMeta_4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_4.setItemMeta(listMeta_4);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 32){
            list_4.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_5lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.33.Description"))));
        listMeta_5.setLore(list_5lore);
        listMeta_5.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.33.Name"))));
        listMeta_5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_5.setItemMeta(listMeta_5);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 33){
            list_5.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_6lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.34.Description"))));
        listMeta_6.setLore(list_6lore);
        listMeta_6.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.34.Name"))));
        listMeta_6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_6.setItemMeta(listMeta_6);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 34){
            list_6.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_7lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.35.Description"))));
        listMeta_7.setLore(list_7lore);
        listMeta_7.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.35.Name"))));
        listMeta_7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_7.setItemMeta(listMeta_7);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 35){
            list_7.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_8lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.36.Description"))));
        listMeta_8.setLore(list_8lore);
        listMeta_8.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.36.Name"))));
        listMeta_8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_8.setItemMeta(listMeta_8);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 36){
            list_8.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_9lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.37.Description"))));
        listMeta_9.setLore(list_9lore);
        listMeta_9.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.37.Name"))));
        listMeta_9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_9.setItemMeta(listMeta_9);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 37){
            list_9.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_10lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.38.Description"))));
        listMeta_10.setLore(list_10lore);
        listMeta_10.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.38.Name"))));
        listMeta_10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_10.setItemMeta(listMeta_10);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 38){
            list_10.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_11lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.39.Description"))));
        listMeta_11.setLore(list_11lore);
        listMeta_11.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.39.Name"))));
        listMeta_11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_11.setItemMeta(listMeta_11);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 39){
            list_11.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_12lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.40.Description"))));
        listMeta_12.setLore(list_12lore);
        listMeta_12.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.40.Name"))));
        listMeta_12.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_12.setItemMeta(listMeta_12);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 40){
            list_12.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_13lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.41.Description"))));
        listMeta_13.setLore(list_13lore);
        listMeta_13.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.41.Name"))));
        listMeta_13.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_13.setItemMeta(listMeta_13);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 41){
            list_13.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_14lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.42.Description"))));
        listMeta_14.setLore(list_14lore);
        listMeta_14.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.42.Name"))));
        listMeta_14.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_14.setItemMeta(listMeta_14);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 42){
            list_14.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_15lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.43.Description"))));
        listMeta_15.setLore(list_15lore);
        listMeta_15.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.43.Name"))));
        listMeta_15.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_15.setItemMeta(listMeta_15);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 43){
            list_15.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_16lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.44.Description"))));
        listMeta_16.setLore(list_16lore);
        listMeta_16.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.44.Name"))));
        listMeta_16.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_16.setItemMeta(listMeta_16);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 44){
            list_16.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_17lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.45.Description"))));
        listMeta_17.setLore(list_17lore);
        listMeta_17.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.45.Name"))));
        listMeta_17.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_17.setItemMeta(listMeta_17);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 45){
            list_17.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_18lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.46.Description"))));
        listMeta_18.setLore(list_18lore);
        listMeta_18.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.46.Name"))));
        listMeta_18.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_18.setItemMeta(listMeta_18);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 46){
            list_18.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_19lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.47.Description"))));
        listMeta_19.setLore(list_19lore);
        listMeta_19.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.47.Name"))));
        listMeta_19.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_19.setItemMeta(listMeta_19);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 47){
            list_19.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_20lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.48.Description"))));
        listMeta_20.setLore(list_20lore);
        listMeta_20.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.48.Name"))));
        listMeta_20.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_20.setItemMeta(listMeta_20);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 48){
            list_20.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_21lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.49.Description"))));
        listMeta_21.setLore(list_21lore);
        listMeta_2.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.49Name"))));
        listMeta_21.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_21.setItemMeta(listMeta_21);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 49){
            list_21.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_22lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.50.Description"))));
        listMeta_22.setLore(list_22lore);
        listMeta_22.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.50.Name"))));
        listMeta_22.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_22.setItemMeta(listMeta_22);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 50){
            list_22.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_23lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.51.Description"))));
        listMeta_23.setLore(list_23lore);
        listMeta_23.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.51.Name"))));
        listMeta_23.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_23.setItemMeta(listMeta_23);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 51){
            list_23.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_24lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.52.Description"))));
        listMeta_24.setLore(list_24lore);
        listMeta_24.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.52.Name"))));
        listMeta_24.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_24.setItemMeta(listMeta_24);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 52){
            list_24.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_25lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.53.Description"))));
        listMeta_25.setLore(list_25lore);
        listMeta_25.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.53.Name"))));
        listMeta_25.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_25.setItemMeta(listMeta_25);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 53){
            list_25.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_26lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.54.Description"))));
        listMeta_26.setLore(list_26lore);
        listMeta_26.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.54.Name"))));
        listMeta_26.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_26.setItemMeta(listMeta_26);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 54){
            list_26.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_27lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.55.Description"))));
        listMeta_27.setLore(list_27lore);
        listMeta_27.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.55.Name"))));
        listMeta_27.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_27.setItemMeta(listMeta_27);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 55){
            list_27.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        list_28lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.56.Description"))));
        listMeta_28.setLore(list_28lore);
        listMeta_28.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Death_Message_Inventory.56.Name"))));
        listMeta_28.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        list_28.setItemMeta(listMeta_28);
        if(plugin.data.getMessageFlag(p.getUniqueId()) == 56){
            list_28.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        messageInv.setItem(10, list_1);
        messageInv.setItem(11, list_2);
        messageInv.setItem(12, list_3);
        messageInv.setItem(13, list_4);
        messageInv.setItem(14, list_5);
        messageInv.setItem(15, list_6);
        messageInv.setItem(16, list_7);
        messageInv.setItem(19, list_8);
        messageInv.setItem(20, list_9);
        messageInv.setItem(21, list_10);
        messageInv.setItem(22, list_11);
        messageInv.setItem(23, list_12);
        messageInv.setItem(24, list_13);
        messageInv.setItem(25, list_14);
        messageInv.setItem(28, list_15);
        messageInv.setItem(29, list_16);
        messageInv.setItem(30, list_17);
        messageInv.setItem(31, list_18);
        messageInv.setItem(32, list_19);
        messageInv.setItem(33, list_20);
        messageInv.setItem(34, list_21);
        messageInv.setItem(37, list_22);
        messageInv.setItem(38, list_23);
        messageInv.setItem(39, list_24);
        messageInv.setItem(40, list_25);
        messageInv.setItem(41, list_26);
        messageInv.setItem(42, list_27);
        messageInv.setItem(43, list_28);

        ////////////////////////////////////////
        messageInv.setItem(0, empty);
        messageInv.setItem(1, empty);
        messageInv.setItem(2, empty);
        messageInv.setItem(3, empty);
        messageInv.setItem(4, empty);
        messageInv.setItem(5, empty);
        messageInv.setItem(6, empty);
        messageInv.setItem(7, empty);
        messageInv.setItem(8, empty);
        messageInv.setItem(9, empty);
        messageInv.setItem(17, empty);
        messageInv.setItem(18, empty);
        messageInv.setItem(26,empty);
        messageInv.setItem(27, empty);
        messageInv.setItem(35, empty);
        messageInv.setItem(36, empty);
        messageInv.setItem(44, empty);
        messageInv.setItem(45, empty);
        messageInv.setItem(46, empty);
        messageInv.setItem(47, empty);
        messageInv.setItem(51, empty);
        messageInv.setItem(52, empty);
        messageInv.setItem(53, empty);
        messageInv.setItem(50, empty);
        //////////////////////////////////


        messageInv.setItem(48, barrier);
        messageInv.setItem(49, map);

        MessageInv_2.put(p, messageInv);
    }
    public void BedInv(Player p) {
        Inventory bedInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.Bed_Break_Inventory_Name"))));
        ArrayList<String> lightningLore = new ArrayList<>();
        ArrayList<String> squidLore = new ArrayList<>();
        ArrayList<String> fireWorkLore = new ArrayList<>();
        ArrayList<String> guardianLore = new ArrayList<>();
        ArrayList<String> ghostLore = new ArrayList<>();
        ArrayList<String> tombLore = new ArrayList<>();
        ArrayList<String> smokeLore = new ArrayList<>();
        ArrayList<String> bloodLore = new ArrayList<>();
        ArrayList<String> witherLore = new ArrayList<>();
        ArrayList<String> negriLore = new ArrayList<>();
        ArrayList<String> anvilLore = new ArrayList<>();

        ItemStack lightning = new ItemStack(Material.GLASS);
        ItemMeta lightningMeta = lightning.getItemMeta();
        ItemStack squid = new ItemStack(Material.SQUID_SPAWN_EGG);
        ItemMeta squidMeta = squid.getItemMeta();
        ItemStack fireWork = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta fireWorkMeta = fireWork.getItemMeta();
        ItemStack guardian = new ItemStack(Material.GUARDIAN_SPAWN_EGG);
        ItemMeta guardianMeta = guardian.getItemMeta();
        ItemStack ghost = new ItemStack(Material.PAINTING);
        ItemMeta ghostMeta = ghost.getItemMeta();
        ItemStack tomb = new ItemStack(Material.DARK_OAK_SIGN);
        ItemMeta tombMeta = tomb.getItemMeta();
        ItemStack smoke = new ItemStack(Material.CAMPFIRE);
        ItemMeta smokeMeta = smoke.getItemMeta();
        ItemStack blood = new ItemStack(Material.REDSTONE);
        ItemMeta bloodMeta = blood.getItemMeta();
        ItemStack wither = new ItemStack(Material.WITHER_ROSE);
        ItemMeta witherMeta = wither.getItemMeta();
        ItemStack negri = new ItemStack(Material.BLACK_CONCRETE);
        ItemMeta negriMeta = negri.getItemMeta();
        ItemStack anvil = new ItemStack(Material.ANVIL);
        ItemMeta anvilMeta = anvil.getItemMeta();


        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);


        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack bed = new ItemStack(Material.OAK_SIGN);
        ItemMeta bedMeta = bed.getItemMeta();
        ItemStack map = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta = map.getItemMeta();

        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.Next_Page"))));
        map.setItemMeta(mapMeta);
        bedMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.Default"))));
        bedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bed.setItemMeta(bedMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 0) {
            bed.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);

        lightningLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.1.Description"))));
        lightningMeta.setLore(lightningLore);
        lightningMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.1.Name"))));
        lightningMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        lightning.setItemMeta(lightningMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 1){
            lightning.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        squidLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.2.Description"))));
        squidMeta.setLore(squidLore);
        squidMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.2.Name"))));
        squidMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        squid.setItemMeta(squidMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 2){
            squid.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        fireWorkLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.3.Description"))));
        fireWorkMeta.setLore(fireWorkLore);
        fireWorkMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.3.Name"))));
        fireWorkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        fireWork.setItemMeta(fireWorkMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 3){
            fireWork.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        guardianLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.4.Description"))));
        guardianMeta.setLore(guardianLore);
        guardianMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.4.Name"))));
        guardianMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        guardian.setItemMeta(guardianMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 4){
            guardian.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        ghostLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.5.Description"))));
        ghostMeta.setLore(ghostLore);
        ghostMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.5.Name"))));
        ghostMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ghost.setItemMeta(ghostMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 5){
            ghost.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        tombLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.6.Description"))));
        tombMeta.setLore(tombLore);
        tombMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.6.Name"))));
        tombMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        tomb.setItemMeta(tombMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 6){
            tomb.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        smokeLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.7.Description"))));
        smokeMeta.setLore(smokeLore);
        smokeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.7.Name"))));
        smokeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        smoke.setItemMeta(smokeMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 7){
            smoke.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        bloodLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.8.Description"))));
        bloodMeta.setLore(bloodLore);
        bloodMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.8.Name"))));
        bloodMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        blood.setItemMeta(bloodMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 8){
            blood.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        witherLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.9.Description"))));
        witherMeta.setLore(witherLore);
        witherMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.9.Name"))));
        witherMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wither.setItemMeta(witherMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 9){
            wither.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        negriLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.10.Description"))));
        negriMeta.setLore(negriLore);
        negriMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.10.Name"))));
        negriMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        negri.setItemMeta(negriMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 10){
            negri.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        anvilLore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.11.Description"))));
        anvilMeta.setLore(anvilLore);
        anvilMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Bed_Break_Inventory.11.Name"))));
        anvilMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        anvil.setItemMeta(anvilMeta);
        if(plugin.data.getBedFlag(p.getUniqueId()) == 11){
            anvil.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        bedInv.setItem(10, lightning);
        bedInv.setItem(12, squid);
        bedInv.setItem(14, fireWork);
        bedInv.setItem(16, guardian);
        bedInv.setItem(20, ghost);
        bedInv.setItem(22, tomb);
        bedInv.setItem(24, smoke);
        bedInv.setItem(28, blood);
        bedInv.setItem(30, wither);
        bedInv.setItem(32, negri);
        bedInv.setItem(34, anvil);
        ////////////////////////////////////////
        bedInv.setItem(0, empty);
        bedInv.setItem(1, empty);
        bedInv.setItem(2, empty);
        bedInv.setItem(3, empty);
        bedInv.setItem(4, empty);
        bedInv.setItem(5, empty);
        bedInv.setItem(6, empty);
        bedInv.setItem(7, empty);
        bedInv.setItem(8, empty);
        bedInv.setItem(9, empty);
        bedInv.setItem(17, empty);
        bedInv.setItem(18, empty);
        bedInv.setItem(26,empty);
        bedInv.setItem(27, empty);
        bedInv.setItem(35, empty);
        bedInv.setItem(36, empty);
        bedInv.setItem(44, empty);
        bedInv.setItem(45, empty);
        bedInv.setItem(46, empty);
        bedInv.setItem(47, empty);
        bedInv.setItem(51, empty);
        bedInv.setItem(52, empty);
        bedInv.setItem(53, empty);
        //////////////////////////////////

        bedInv.setItem(48, barrier);
        bedInv.setItem(49, bed);
        bedInv.setItem(50, map);

        BedInv.put(p, bedInv);

    }
    public void FrameInv(Player p){
        Inventory frameInv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.Frame_Inventory_Name"))));
        ArrayList<String> frame_1Lore = new ArrayList<>();
        ArrayList<String> frame_2Lore = new ArrayList<>();
        ArrayList<String> frame_3Lore = new ArrayList<>();
        ArrayList<String> frame_4Lore = new ArrayList<>();
        ArrayList<String> frame_5Lore = new ArrayList<>();
        ArrayList<String> frame_6Lore = new ArrayList<>();
        ArrayList<String> frame_7Lore = new ArrayList<>();
        ArrayList<String> frame_8Lore = new ArrayList<>();
        ArrayList<String> frame_9Lore = new ArrayList<>();
        ArrayList<String> frame_10Lore = new ArrayList<>();
        ArrayList<String> frame_11Lore = new ArrayList<>();

        ItemStack frame_1 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_1Meta = frame_1.getItemMeta();
        ItemStack frame_2 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_2Meta = frame_2.getItemMeta();
        ItemStack frame_3 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_3Meta = frame_3.getItemMeta();
        ItemStack frame_4 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_4Meta = frame_4.getItemMeta();
        ItemStack frame_5 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_5Meta = frame_5.getItemMeta();
        ItemStack frame_6 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_6Meta = frame_6.getItemMeta();
        ItemStack frame_7 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_7Meta = frame_7.getItemMeta();
        ItemStack frame_8 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_8Meta = frame_8.getItemMeta();
        ItemStack frame_9 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_9Meta = frame_9.getItemMeta();
        ItemStack frame_10 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_10Meta = frame_10.getItemMeta();
        ItemStack frame_11 = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frame_11Meta = frame_11.getItemMeta();


        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();
        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();
        ItemStack defaultFrame = new ItemStack(Material.OAK_SIGN);
        ItemMeta defaultFrameMeta = defaultFrame.getItemMeta();
        ItemStack map = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTNmYzUyMjY0ZDhhZDllNjU0ZjQxNWJlZjAxYTIzOTQ3ZWRiY2NjY2Y2NDkzNzMyODliZWE0ZDE0OTU0MWY3MCJ9fX0=");
        ItemMeta mapMeta = map.getItemMeta();

        mapMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.Next_Page"))));
        map.setItemMeta(mapMeta);
        defaultFrameMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.Default"))));
        defaultFrameMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        defaultFrame.setItemMeta(defaultFrameMeta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 0) {
            defaultFrame.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.Back"))));
        barrier.setItemMeta(barrierMeta);


        frame_1Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.1.Description"))));
        frame_1Meta.setLore(frame_1Lore);
        frame_1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.1.Name"))));
        frame_1Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_1.setItemMeta(frame_1Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 1){
            frame_1.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_2Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.2.Description"))));
        frame_2Meta.setLore(frame_2Lore);
        frame_2Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.2.Name"))));
        frame_2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_2.setItemMeta(frame_2Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 2){
            frame_2.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_3Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.3.Description"))));
        frame_3Meta.setLore(frame_3Lore);
        frame_3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.3.Name"))));
        frame_3Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_3.setItemMeta(frame_3Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 3){
            frame_3.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_4Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.4.Description"))));
        frame_4Meta.setLore(frame_4Lore);
        frame_4Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.4.Name"))));
        frame_4Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_4.setItemMeta(frame_4Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 4){
            frame_4.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_5Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.5.Description"))));
        frame_5Meta.setLore(frame_5Lore);
        frame_5Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.5.Name"))));
        frame_5Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_5.setItemMeta(frame_5Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 5){
            frame_5.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_6Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.6.Description"))));
        frame_6Meta.setLore(frame_6Lore);
        frame_6Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.6.Name"))));
        frame_6Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_6.setItemMeta(frame_6Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 6){
            frame_6.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_7Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.7.Description"))));
        frame_7Meta.setLore(frame_7Lore);
        frame_7Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.7.Name"))));
        frame_7Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_7.setItemMeta(frame_7Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 7){
            frame_7.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_8Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.8.Description"))));
        frame_8Meta.setLore(frame_8Lore);
        frame_8Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.8.Name"))));
        frame_8Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_8.setItemMeta(frame_8Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 8){
            frame_8.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_9Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.9.Description"))));
        frame_9Meta.setLore(frame_9Lore);
        frame_9Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.9.Name"))));
        frame_9Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_9.setItemMeta(frame_9Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 9){
            frame_9.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_10Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.10.Description"))));
        frame_10Meta.setLore(frame_10Lore);
        frame_10Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.10.Name"))));
        frame_10Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_10.setItemMeta(frame_10Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 10){
            frame_10.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frame_11Lore.add(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.11.Description"))));
        frame_11Meta.setLore(frame_11Lore);
        frame_11Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Frame_Inventory.11.Name"))));
        frame_11Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        frame_11.setItemMeta(frame_11Meta);
        if(plugin.data.getFrameFlag(p.getUniqueId()) == 11){
            frame_11.addUnsafeEnchantment(Enchantment.LUCK, 1);
        }

        frameInv.setItem(10, frame_1);
        frameInv.setItem(12, frame_2);
        frameInv.setItem(14, frame_3);
        frameInv.setItem(16, frame_4);
        frameInv.setItem(20, frame_5);
        frameInv.setItem(22, frame_6);
        frameInv.setItem(24, frame_7);
        frameInv.setItem(28, frame_8);
        frameInv.setItem(30, frame_9);
        frameInv.setItem(32, frame_10);
        frameInv.setItem(34, frame_11);
        ////////////////////////////////////////
        frameInv.setItem(0, empty);
        frameInv.setItem(1, empty);
        frameInv.setItem(2, empty);
        frameInv.setItem(3, empty);
        frameInv.setItem(4, empty);
        frameInv.setItem(5, empty);
        frameInv.setItem(6, empty);
        frameInv.setItem(7, empty);
        frameInv.setItem(8, empty);
        frameInv.setItem(9, empty);
        frameInv.setItem(17, empty);
        frameInv.setItem(18, empty);
        frameInv.setItem(26,empty);
        frameInv.setItem(27, empty);
        frameInv.setItem(35, empty);
        frameInv.setItem(36, empty);
        frameInv.setItem(44, empty);
        frameInv.setItem(45, empty);
        frameInv.setItem(46, empty);
        frameInv.setItem(47, empty);
        frameInv.setItem(51, empty);
        frameInv.setItem(52, empty);
        frameInv.setItem(53, empty);
        //////////////////////////////////

        frameInv.setItem(48, barrier);
        frameInv.setItem(49, defaultFrame);
        frameInv.setItem(50, map);

        FrameInv.put(p, frameInv);
    }
}