package io.github.kubqoa.creativecontrolbykubqoa.database;

import com.zaxxer.hikari.HikariConfig;
import io.github.kubqoa.creativecontrolbykubqoa.Config;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.BlockTableCreateUpdate;
import io.github.kubqoa.creativecontrolbykubqoa.database.sqlite.LoadChunkQuery;
import org.bukkit.Location;
import org.bukkit.block.Block;

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

    @Override
    public List<Location> loadChunk(CreativeChunk chunk) {
        Query query = new LoadChunkQuery(chunk);
        query.run();
        return null;
    }

    @Override
    public void saveChunk(CreativeChunk chunk) {

    }
}
