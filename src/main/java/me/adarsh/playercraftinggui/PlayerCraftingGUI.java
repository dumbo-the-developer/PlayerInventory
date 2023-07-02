package me.adarsh.playercraftinggui;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerCraftingGUI extends JavaPlugin {

    PluginManager pm = getServer().getPluginManager();

    @Override
    public void onEnable() {
        pm.registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
