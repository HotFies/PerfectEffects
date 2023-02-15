package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.annotation.Nonnull;

public class ChatSendColorListener implements Listener {
    private final PerfectEffects plugin;
    public ChatSendColorListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onChatSend(@Nonnull AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if (!Names.get().getBoolean("Lobby")) {
            switch (plugin.data.getSignFlag(p.getUniqueId())){
                case 1:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.GOLD + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.GOLD + "GG");
                    }
                    break;
                }
                case 2:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.BLUE + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.BLUE + "GG");
                    }
                    break;
                }
                case 3:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.YELLOW + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.YELLOW + "GG");
                    }
                    break;
                }
                case 4:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.GREEN + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.GREEN + "GG");
                    }
                    break;
                }
                case 5:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.DARK_PURPLE + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.DARK_PURPLE + "GG");
                    }
                    break;
                }
                case 6:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.LIGHT_PURPLE + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.LIGHT_PURPLE + "GG");
                    }
                    break;
                }
                case 7:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.DARK_BLUE + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.DARK_BLUE + "GG");
                    }
                    break;
                }
                case 8:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.RED + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.RED + "GG");
                    }
                    break;
                }
                case 9:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.DARK_GREEN + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.DARK_GREEN + "GG");
                    }
                    break;
                }
                case 10:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.AQUA + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.AQUA + "GG");
                    }
                    break;
                }
                case 11:{
                    if (msg.equals("gg")) {
                        e.setMessage(ChatColor.BLACK + "gg");
                    } else if (msg.equals("GG")) {
                        e.setMessage(ChatColor.BLACK + "GG");
                    }
                    break;
                }
            }
        }
    }
}

