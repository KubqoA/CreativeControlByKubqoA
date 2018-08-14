package io.github.kubqoa.creativecontrolbykubqoa;

import org.bukkit.plugin.java.JavaPlugin;

public class CreativeControlByKubqoA extends JavaPlugin {
    public static Config config;
    public static Database database;
    public static JavaPlugin javaPlugin;

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
        this.getLogger().info("Table blocks exists: " + database.database.tableExists("blocks"));
    }

    @Override
    public void onDisable() {
        database.closeDatabasePool();
    }
}
