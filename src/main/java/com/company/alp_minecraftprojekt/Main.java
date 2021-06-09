package com.company.alp_minecraftprojekt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {
    File config = new File(getDataFolder(), "config.yml");
    @Override
    public void onEnable() {
        // If config.yml does not exist create it:
        if(!config.exists()) {
            System.out.println("config.yml not found. Created a default config.");
            saveDefaultConfig();
        }
        // Load config values:
        ConfigManager.loadConfiguration(getConfig());
        // Register events:
        Bukkit.getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {

    }
}
