package io.github.kubqoa.creativecontrolbykubqoa.database;

import com.zaxxer.hikari.HikariConfig;
import io.github.kubqoa.creativecontrolbykubqoa.Config;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import org.bukkit.block.Block;

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
     * Stores a new creative block record in database
     *
     * @param block the block to be stored in database
     */
    void blockStore(Block block);

    /**
     * Checks whether the given block is in database
     *
     * @param block the block to be checked
     * @return boolean
     */
    boolean blockCheck(Block block);

    /**
     * Removes the block from database
     *
     * @param block the block to be removed from database
     */
    void blockRemove(Block block);

    /**
     * Get creative blocks for the given CreativeChunk
     *
     * @param chunk the chunk for which to get all the creative blocks
     * @return list of all creative blocks in the given chunk
     */
    List<Block> getChunksCreativeBlocks(CreativeChunk chunk);
}
