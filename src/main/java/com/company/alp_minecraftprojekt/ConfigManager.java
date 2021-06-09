package com.company.alp_minecraftprojekt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.*;
import java.util.Set;

public class ConfigManager {
    // Accessible config values:
    static String[] Item;
    static String[] Effect;
    static int[] Duration;

    static String[] KeyName;
    static Set<String> KeySet;

    static FileConfiguration config;
    // Debug bullshit:
    static File log = new File("plugins/ALP_Minecraft_Projekt/config_set_values.txt");;
    static FileWriter Writer;
    static BufferedWriter BWriter;

    public static void loadConfiguration(FileConfiguration configuration) {
        config = configuration;
        Bukkit.getLogger().info("LOADING CONFIG!");
        int size = config.getKeys(false).size();

        wipeLookUp(size);

        // Position in array:
        int position = 0;

        // Debug bullshit:
        try {
            // Wipe file:
            log.delete();
            Thread.sleep(1500);
            log.createNewFile();
            // Create writer:
            Writer = new FileWriter(log);
            BWriter = new BufferedWriter(Writer);
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
        // End of <Debug bullshit>
        loadConfigToMemory(position);
    }

    private static void wipeLookUp(int size) {
        // This is the most retarded way but (i guess) easiest to do:
        KeyName = new String[size];
        // Get key names:
        KeySet = config.getKeys(false);
        // Add keys to KeyName array:
        KeySet.toArray(KeyName);
        // Item:
        Item = null;
        Item = new String[size];
        // Effect:
        Effect = null;
        Effect = new String[size];
        // Duration:
        Duration = null;
        Duration = new int[size];
    }

    private static void loadConfigToMemory(int position) {
        // Write config output bs:
        for(String Block : KeyName) {
            Item[position] = Block;
            Effect[position] = config.getString(Block + ".effect");
            Duration[position] = config.getInt(Block + ".duration");
            writeToConfigLog(position, Block);
            // Write changes to console:
            if(Effect[position] != null) {
                Bukkit.getLogger().info(position + " > " + Block + " > " + Effect[position] + " > " + Duration[position]);
            }
            position++;
        }
        // Close writing stream
        try {
            BWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void writeToConfigLog(int position, String Block) {
        // Debug bullshit:
        try {
            BWriter.write(position + " > " + Block + " > " + Effect[position] + " > " + Duration[position]);
            BWriter.newLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        // End of <Debug bullshit>
    }
}