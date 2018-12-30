package io.github.kubqoa.creativecontrolbykubqoa.database.sqlite;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import io.github.kubqoa.creativecontrolbykubqoa.database.Update;
import org.bukkit.block.Block;

public class BlockStoreUpdate extends Update {
    private Block block;

    public BlockStoreUpdate(Block block) {
        this.block = block;
    }

    public String update() {
        return "INSERT INTO " +
                CreativeControlByKubqoA.database.getTableName("blocks") +
                "(chunk, x, y, z, world) " +
                "VALUES (?, ?, ?, ?, ?);";
    }

    public Object[] parameters() {
        return new Object[]{
                CreativeChunk.getUniqueId(this.block.getChunk()),
                this.block.getX(),
                this.block.getY(),
                this.block.getZ(),
                this.block.getWorld().getUID()
        };
    }
}
