package io.github.kubqoa.creativecontrolbykubqoa.database;

import com.zaxxer.hikari.HikariConfig;
import io.github.kubqoa.creativecontrolbykubqoa.Config;
import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.BlockStoreUpdate;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.BlockTableCreateUpdate;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.GetChunksCreativeBlocksQuery;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

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

    public void createBlocksTable() {
        try {
            new BlockTableCreateUpdate().run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void blockStore(Block block) {
        new BukkitRunnable() {
            public void run() {
                try {
                    new BlockStoreUpdate(block).run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(CreativeControlByKubqoA.javaPlugin);
    }

    public boolean blockCheck(Block block) {
        return false;
    }

    public void blockRemove(Block block) {

    }

    @Override
    public List<Block> getChunksCreativeBlocks(CreativeChunk chunk) {
        try {
            GetChunksCreativeBlocksQuery query = new GetChunksCreativeBlocksQuery(chunk);
            query.run();
            //TODO: implement method
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
