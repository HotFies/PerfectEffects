package org.aneras.mc.perfecteffects.MySQL;

import org.aneras.mc.perfecteffects.PerfectEffects;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Data {

    private PerfectEffects plugin;
    public Data(PerfectEffects plugin){
        this.plugin = plugin;
    }

    public void createTable(){
        PreparedStatement preparedStatement;
        try {
            preparedStatement = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS playersInfo "
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),MessageFlag INT(100),BedFlag INT(100),SignFlag INT(100),SoundFlag INT(100),FrameFlag INT(100),KillFlag INT(100),ArrowFlag INT(100),WalkFlag INT(100),BedBreakCount INT NOT NULL,KillCount INT NOT NULL, PRIMARY KEY (NAME))");
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createPlayer(Player player){
        try {
            UUID uuid = player.getUniqueId();
            if(!exists(uuid)){
                PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("INSERT IGNORE INTO playersInfo" + " (NAME,UUID) VALUES (?,?)");
                ps.setString(1, player.getName());
                ps.setString(2, uuid.toString());
                ps.executeUpdate();
                return;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean exists(UUID uuid){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT * FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            if(results.next()){
                return true;
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public void changeBedBreakCount(UUID uuid, int BedBreakCount){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET BedBreakCount=? WHERE UUID=?");
            preparedStatement.setInt(1, BedBreakCount);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeKillCount(UUID uuid, int KillCount){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET KillCount=? WHERE UUID=?");
            preparedStatement.setInt(1, KillCount);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeMessageFlag(UUID uuid, int MessageFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET MessageFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, MessageFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeBedFlag(UUID uuid, int BedFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET BedFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, BedFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeSignFlag(UUID uuid, int SignFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET SignFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, SignFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeSoundFlag(UUID uuid, int SoundFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET SoundFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, SoundFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeFrameFlag(UUID uuid, int FrameFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET FrameFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, FrameFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeKillFlag(UUID uuid, int KillFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET KillFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, KillFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeArrowFlag(UUID uuid, int ArrowFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET ArrowFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, ArrowFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeWalkFlag(UUID uuid, int WalkFlag){
        try {
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("UPDATE playersInfo SET WalkFlag=? WHERE UUID=?");
            preparedStatement.setInt(1, WalkFlag);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getBedBreakCount(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT BedBreakCount FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int BedBreakCount;
            if(results.next()){
                BedBreakCount = results.getInt("BedBreakCount");
                return BedBreakCount;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getKillCount(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT KillCount FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int KillCount;
            if(results.next()){
                KillCount = results.getInt("KillCount");
                return KillCount;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getMessageFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT MessageFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int MessageFlag;
            if(results.next()){
                MessageFlag = results.getInt("MessageFlag");
                return MessageFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getWalkFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT WalkFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int WalkFlag;
            if(results.next()){
                WalkFlag = results.getInt("WalkFlag");
                return WalkFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getBedFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT BedFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int BedFlag;
            if(results.next()){
                BedFlag = results.getInt("BedFlag");
                return BedFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getSignFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT SignFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int SignFlag;
            if(results.next()){
                SignFlag = results.getInt("SignFlag");
                return SignFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getSoundFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT SoundFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int SoundFlag;
            if(results.next()){
                SoundFlag = results.getInt("SoundFlag");
                return SoundFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getFrameFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT FrameFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int FrameFlag;
            if(results.next()){
                FrameFlag = results.getInt("FrameFlag");
                return FrameFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getKillFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT KillFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int KillFlag;
            if(results.next()){
                KillFlag = results.getInt("KillFlag");
                return KillFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int getArrowFlag(UUID uuid){
        try{
            PreparedStatement preparedStatement = plugin.SQL.getConnection().prepareStatement("SELECT ArrowFlag FROM playersInfo WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet results = preparedStatement.executeQuery();
            int ArrowFlag;
            if(results.next()){
                ArrowFlag = results.getInt("ArrowFlag");
                return ArrowFlag;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}