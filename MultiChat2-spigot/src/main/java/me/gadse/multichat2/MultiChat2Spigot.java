package me.gadse.multichat2;

import org.bukkit.plugin.java.JavaPlugin;

public final class MultiChat2Spigot extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!getDataFolder().exists() && !getDataFolder().mkdirs())
            getLogger().severe("Plugin data folder is inaccessible. Check your read-write settings.");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
