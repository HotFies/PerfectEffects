package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import javax.annotation.Nonnull;
import java.util.Objects;

public class DeathMessagesListener implements Listener {
    private final PerfectEffects plugin;
    public DeathMessagesListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void SendDeathMessage(@Nonnull PlayerDeathEvent e) {
        if (!Names.get().getBoolean("Lobby")) {
            if (e.getEntity().getKiller() != null) {
                Player player_dead = e.getEntity().getPlayer();
                Player player_killed = e.getEntity().getKiller();
                switch (plugin.data.getMessageFlag(player_killed.getUniqueId())) {
                    case 1:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.1.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 2:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.2.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 3:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.3.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 4:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.4.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 5:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.5.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 6:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.6.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 7:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.7.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 8:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.8.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 9:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.9.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 10:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.10.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 11:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.11.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 12:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.12.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 13:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.13.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 14:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.14.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 15:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.15.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 16:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.16.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 17:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.17.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 18:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.18.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 19:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.19.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 20:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.20.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 21:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.21.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 22:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.22.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 23:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.23.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 24:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.24.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 25:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.25.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 26:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.26.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 27:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.27.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 28:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.28.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 29:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.29.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 30:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.30.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 31:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.31.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 32:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.32.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 33:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.33.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 34:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.34.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 35:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.35.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 36:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.36.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 37:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.37.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 38:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.38.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 39:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.39.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 40:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.40.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 41:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.41.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 42:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.42.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 43:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.43.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 44:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.44.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 45:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.45.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 46:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.46.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 47:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.47.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 48:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.48.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 49:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.49.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 50:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.50.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 51:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.51.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 52:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.52.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 53:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.53.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 54:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.54.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 55:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.55.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;
                    case 56:
                        e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.config.getConfig().getString("Message_Inventory.56.Name")).replace("%player_dead%", Objects.requireNonNull(player_dead).getName()).replace("%player_killed%", player_killed.getName())));
                        break;

                }
            }
        }
    }
}