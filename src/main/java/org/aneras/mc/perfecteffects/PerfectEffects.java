package org.aneras.mc.perfecteffects;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.aneras.mc.perfecteffects.MySQL.Data;
import org.aneras.mc.perfecteffects.MySQL.MySQL;
import org.aneras.mc.perfecteffects.commands.PerfectEffectsCommand;
import org.aneras.mc.perfecteffects.configs.Names;
import org.aneras.mc.perfecteffects.configs.PerfectEffectsConfig;
import org.aneras.mc.perfecteffects.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;

public final class PerfectEffects extends JavaPlugin {
    public MySQL SQL;
    public Data data;
    public PerfectEffectsConfig config;
    private static final Map<Player, Inventory> MainInvHash = new HashMap<>();
    @Override
    public void onEnable() {
        this.config = new PerfectEffectsConfig(this);

        Names.setup();
        Names.get().addDefault("Storage", "MySQL");
        Names.get().addDefault("host", "localhost");
        Names.get().addDefault("port", "3306");
        Names.get().addDefault("database", "trails");
        Names.get().addDefault("username", "Default");
        Names.get().addDefault("password", "Default");
        Names.get().addDefault("Lobby", true);
        Names.get().options().copyDefaults(true);
        Names.save();

        this.SQL = new MySQL();
        this.data = new Data(this);
        if(Objects.requireNonNull(Names.get().get("Storage")).equals("MySQL")) {
            try {
                SQL.Connect();
            } catch (ClassNotFoundException | SQLException e) {
                //e.printStackTrace();
                Bukkit.getLogger().info(ChatColor.RED + "Database is not connected");
            }
            if (SQL.isConnected()) {
                Bukkit.getLogger().info(ChatColor.GREEN + "Database is connected");
                data.createTable();

            }
        }

        Objects.requireNonNull(getServer().getPluginCommand("PfEffects")).setExecutor(new PerfectEffectsCommand(this, MainInvHash));
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(this, MainInvHash), this);
        Bukkit.getPluginManager().registerEvents(new WalkPlayerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ShootArrowListener(this), this);
        Bukkit.getPluginManager().registerEvents(new KillPlayerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new FrameListener(this), this);
        Bukkit.getPluginManager().registerEvents(new DeathSoundsListener(this), this);
        Bukkit.getPluginManager().registerEvents(new DeathMessagesListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatSendColorListener(this), this);
        Bukkit.getPluginManager().registerEvents(new BedBreakListener(this), this);

        Bukkit.getConsoleSender().sendMessage("[PerfectEffects] PerfectEffects was enabled");
    }

    @Override
    public void onDisable() {
        if (SQL.isConnected()) {
            Bukkit.getLogger().info(ChatColor.RED + "Database disconnected");
            SQL.Disconnect();
        }
        Bukkit.getConsoleSender().sendMessage("[PerfectEffects] PerfectEffects was disabled");
    }

    public void createMainInv(Player p){
        ArrayList<String> ArrowLore = new ArrayList<>();
        ArrayList<String> WalkLore = new ArrayList<>();
        ArrayList<String> KillLore = new ArrayList<>();
        ArrayList<String> MessageLore = new ArrayList<>();
        ArrayList<String> SoundLore = new ArrayList<>();
        ArrayList<String> BedLore = new ArrayList<>();
        ArrayList<String> signLore = new ArrayList<>();
        ArrayList<String> FrameLore = new ArrayList<>();

        Inventory inv = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Inventory_name"))));
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta arrowMeta = arrow.getItemMeta();
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        ItemStack skull = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta skullMeta = skull.getItemMeta();
        ItemStack list = new ItemStack(Material.PAPER);
        ItemMeta listMeta = list.getItemMeta();
        ItemStack sound = new ItemStack(Material.JUKEBOX);
        ItemMeta soundMeta = sound.getItemMeta();
        ItemStack bed = new ItemStack(Material.RED_BED);
        ItemMeta bedMeta = bed.getItemMeta();
        ItemStack sign = new ItemStack(Material.OAK_SIGN);
        ItemMeta signMeta = sign.getItemMeta();
        ItemStack frame = new ItemStack(Material.ITEM_FRAME);
        ItemMeta frameMeta = frame.getItemMeta();
        ItemStack empty = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta emptyMeta = empty.getItemMeta();

        ItemStack barrier = PerfectEffects.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWYxMzNlOTE5MTlkYjBhY2VmZGMyNzJkNjdmZDg3YjRiZTg4ZGM0NGE5NTg5NTg4MjQ0NzRlMjFlMDZkNTNlNiJ9fX0=");
        ItemMeta barrierMeta = barrier.getItemMeta();

        emptyMeta.setDisplayName("");
        empty.setItemMeta(emptyMeta);

        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Back"))));
        barrier.setItemMeta(barrierMeta);

        FrameLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Frame_description")))));
        frameMeta.setLore(FrameLore);
        frameMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Frame_name")))));
        frame.setItemMeta(frameMeta);

        signLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Sign_description")))));
        signMeta.setLore(signLore);
        signMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Sign_name")))));
        sign.setItemMeta(signMeta);

        ArrowLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Arrow_description")))));
        arrowMeta.setLore(ArrowLore);
        arrowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Arrow_name")))));
        arrow.setItemMeta(arrowMeta);

        WalkLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Walk_description")))));
        bootsMeta.setLore(WalkLore);
        bootsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Walk_name")))));
        boots.setItemMeta(bootsMeta);

        KillLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Kill_description")))));
        skullMeta.setLore(KillLore);
        skullMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Kill_name")))));
        skull.setItemMeta(skullMeta);

        MessageLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Message_description")))));
        listMeta.setLore(MessageLore);
        listMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Message_name")))));
        list.setItemMeta(listMeta);

        SoundLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Sound_description")))));
        soundMeta.setLore(SoundLore);
        soundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Sound_name")))));
        sound.setItemMeta(soundMeta);

        BedLore.add(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Bed_break_description")))));
        bedMeta.setLore(BedLore);
        bedMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getConfig().getString("Bed_break_name")))));
        bed.setItemMeta(bedMeta);

        inv.setItem(11, arrow);
        inv.setItem(13, boots);
        inv.setItem(15, skull);
        inv.setItem(21, sign);
        inv.setItem(23, frame);
        inv.setItem(29 ,list);
        inv.setItem(31, sound);
        inv.setItem(33, bed);
        for(int i=0; i<10; i++){
            inv.setItem(i,empty);
        }
        inv.setItem(17,empty);
        inv.setItem(18,empty);
        inv.setItem(26,empty);
        inv.setItem(27,empty);
        inv.setItem(35,empty);
        inv.setItem(36,empty);
        inv.setItem(37,empty);
        inv.setItem(38,empty);
        inv.setItem(39,empty);
        if(!config.getConfig().getBoolean("BackSet")){
            inv.setItem(40,empty);
        }
        inv.setItem(41, empty);
        inv.setItem(42, empty);
        inv.setItem(43, empty);
        inv.setItem(44, empty);

        if(config.getConfig().getBoolean("BackSet")) {
            inv.setItem(40, barrier);
        }

        MainInvHash.put(p, inv);
    }
    public static ItemStack getSkull(String value){
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", value));

        try {
            Method mtd = skullMeta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            mtd.setAccessible(true);
            mtd.invoke(skullMeta, profile);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }

        head.setItemMeta(skullMeta);
        return head;

    }
}
