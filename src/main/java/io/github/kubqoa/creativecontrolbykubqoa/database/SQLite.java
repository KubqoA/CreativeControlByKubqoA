package io.github.kubqoa.creativecontrolbykubqoa.database;

import com.zaxxer.hikari.HikariConfig;
import io.github.kubqoa.creativecontrolbykubqoa.Config;
import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.BlockStoreUpdate;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.TableExistsQuery;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * An SQLite database implementation
 */
public class SQLite implements DatabaseInterface {
    public HikariConfig getHikariConfig(Config config) {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setPoolName("CreativeControlSQLitePool");
        hikariConfig.setDriverClassName("org.sqlite.JDBC");
        hikariConfig.setJdbcUrl("jdbc:sqlite:plugins/CreativeControlByKubqoA/creativecontrol.db");
        hikariConfig.setMaxLifetime(60000);
        hikariConfig.setIdleTimeout(45000);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionTestQuery("SELECT 1");

        return hikariConfig;
    }

    public boolean tableExists(String table) {
        TableExistsQuery tableExistsQuery = new TableExistsQuery(table);
        try {
            tableExistsQuery.run();
            return tableExistsQuery.hasResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createBlocksTable() {

    }

    public void blockStore(Block block) {
        Bukkit.getScheduler().runTaskAsynchronously(CreativeControlByKubqoA.javaPlugin, new BukkitRunnable() {
            public void run() {
                new BlockStoreUpdate(block);
            }
        });
    }

    public boolean blockCheck(Block block) {
        return false;
    }

    public void blockRemove(Block block) {

    }
}
