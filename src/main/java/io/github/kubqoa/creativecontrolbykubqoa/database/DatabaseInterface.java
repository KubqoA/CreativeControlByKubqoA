package io.github.kubqoa.creativecontrolbykubqoa.database;

import com.zaxxer.hikari.HikariConfig;
import io.github.kubqoa.creativecontrolbykubqoa.Config;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import org.bukkit.Location;

import java.util.List;

public interface DatabaseInterface {
    /**
     * Get HikariConfig for the given database type
     *
     * @param config
     * @return HikariConfig object to initialize the HikariDataSource
     */
    HikariConfig getHikariConfig(Config config);

    /**
     * Creates a new block table in the given database type
     * Table structure:
     * id       - int
     * chunk    - text(28)
     * x        - real
     * y        - real
     * z        - real
     * world    - text(uuid)
     */
    void createBlocksTable();


    /**
     * Get creative blocks for the given CreativeChunk
     *
     * @param chunk the chunk for which to get all the creative blocks
     * @return list of all creative blocks in the given chunk
     */
    List<Location> loadChunk(CreativeChunk chunk);

    /**
     * Save creative blocks for the given CreativeChunk
     *
     * @param chunk the chunk for which to save the changes
     * @return
     */
    void saveChunk(CreativeChunk chunk);
}
