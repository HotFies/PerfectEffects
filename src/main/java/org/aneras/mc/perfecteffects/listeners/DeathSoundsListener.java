package org.aneras.mc.perfecteffects.listeners;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.aneras.mc.perfecteffects.configs.Names;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import javax.annotation.Nonnull;

public class DeathSoundsListener implements Listener {
    private final PerfectEffects plugin;
    public DeathSoundsListener(PerfectEffects plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void DeathSoundPlayer(@Nonnull PlayerDeathEvent e) {
        if (!Names.get().getBoolean("Lobby")) {
            if (e.getEntity().getKiller() != null) {
                Player killer = e.getEntity().getPlayer();
                assert killer != null;
                World w = killer.getWorld();
                Location l = killer.getLocation();
                switch (plugin.data.getSoundFlag(killer.getUniqueId())) {
                    case 1:
                        w.playSound(l, Sound.ENTITY_BLAZE_DEATH, 50000, (float) 1);
                        break;
                    case 2:
                        w.playSound(l, Sound.BLOCK_PORTAL_TRAVEL, (float) 0.1, (float) 1000);
                        break;
                    case 3:
                        w.playSound(l, Sound.ENTITY_ENDER_DRAGON_DEATH, (float) 0.2, (float) 1000);
                        break;
                    case 4:
                        w.playSound(l, Sound.ENTITY_DOLPHIN_DEATH, 1, (float) 1000);
                        break;
                    case 5:
                        w.playSound(l, Sound.ENTITY_DONKEY_DEATH, 1, (float) 1000);
                        break;
                    case 6:
                        w.playSound(l, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1, (float) 1000);
                        break;
                    case 7:
                        w.playSound(l, Sound.ENTITY_GHAST_DEATH, 1, (float) 1);
                        break;
                    case 8:
                        w.playSound(l, Sound.ENTITY_VEX_DEATH, 1, (float) 1);
                        break;
                    case 9:
                        w.playSound(l, Sound.ENTITY_RAVAGER_DEATH, 1, (float) 1);
                        break;
                    case 10:
                        w.playSound(l, Sound.ENTITY_TNT_PRIMED, 1, (float) 1);
                        break;
                    case 11:
                        w.playSound(l, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1, (float) 1);
                        break;
                }
            }
        }
    }
}
