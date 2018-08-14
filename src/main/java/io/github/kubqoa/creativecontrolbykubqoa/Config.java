package io.github.kubqoa.creativecontrolbykubqoa;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
    private static FileConfiguration config;
    private JavaPlugin plugin;

    Config(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void create() {
        plugin.saveDefaultConfig();
    }

    public void load() {
        config = plugin.getConfig();
    }

    public String getString(String path) {
        return config.getString(path);
    }
}
