package io.github.kubqoa.creativecontrolbykubqoa;

import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import io.github.kubqoa.creativecontrolbykubqoa.listeners.BlockInsert;
import io.github.kubqoa.creativecontrolbykubqoa.listeners.BlockRemove;
import io.github.kubqoa.creativecontrolbykubqoa.listeners.Chunk;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class CreativeControlByKubqoA extends JavaPlugin {
    public static Config config;
    public static Database database;
    public static JavaPlugin javaPlugin;
    public static HashMap<String, CreativeChunk> chunks = new HashMap<>();

    public CreativeControlByKubqoA() {
        javaPlugin = this;
        config = new Config(this);
        database = new Database(config);
    }

    @Override
    public void onEnable() {
        config.create();
        config.load();
        database.initializeDatabasePool();
        database.database.createBlocksTable();
        this.registerListeners(getServer().getPluginManager());
    }

    @Override
    public void onDisable() {
        database.closeDatabasePool();
    }

    private void registerListeners(PluginManager pluginManager) {
        pluginManager.registerEvents(new Chunk(), this);
        pluginManager.registerEvents(new BlockInsert(), this);
        pluginManager.registerEvents(new BlockRemove(), this);
    }
}
