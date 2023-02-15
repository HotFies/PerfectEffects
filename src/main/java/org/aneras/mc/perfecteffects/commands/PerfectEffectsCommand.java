package org.aneras.mc.perfecteffects.commands;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class PerfectEffectsCommand implements CommandExecutor {
    private static Map<Player, Inventory> MainInvHash = new HashMap<>();
    PerfectEffects plugin;
    public PerfectEffectsCommand(PerfectEffects PerfectEffects,  Map<Player, Inventory> InvToHash){
        plugin = PerfectEffects ;
        MainInvHash = InvToHash;
    }
    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if (!(sender instanceof Player)) return false;
        Player Player_gl = (Player) sender;
        if(command.getName().equalsIgnoreCase("PfEffects")){
            if(args.length == 0) {
                if (plugin.config.getConfig().getBoolean("Lobby")) {
                    MainInvHash.remove(Player_gl);
                    plugin.createMainInv(Player_gl);
                    Player_gl.openInventory(MainInvHash.get(Player_gl));
                    return true;
                } else {
                    Player_gl.sendMessage(ChatColor.RED + plugin.config.getConfig().getString("CantChangeTrails"));
                    return false;
                }
            }
            if(args[0].equalsIgnoreCase("reload")){
                plugin.config.reloadConfig();
                Player_gl.sendMessage(ChatColor.GREEN + "Config was reloaded");
                return true;
            }else{
                Player_gl.sendMessage(ChatColor.RED + "Unrecognized command:" + args[0]);
                return false;
            }
        }
        return true;
    }
}
