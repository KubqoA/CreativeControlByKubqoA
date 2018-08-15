package io.github.kubqoa.creativecontrolbykubqoa.database.sqlite;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.bukkit.Chunk;
import io.github.kubqoa.creativecontrolbykubqoa.database.Update;
import io.github.kubqoa.creativecontrolbykubqoa.exceptions.BlockStoreException;
import org.bukkit.block.Block;

public class BlockStoreUpdate extends Update {
    private Block block;

    public BlockStoreUpdate(Block block) {
        this.block = block;
    }

    public String update() {
        return "INSERT INTO " +
                CreativeControlByKubqoA.config.getString("db.prefix") + "blocks " +
                "(chunk, x, y, z, world) " +
                "VALUES (?, ?, ?, ?, ?);";
    }

    public Object[] parameters() {
        return new Object[]{
                new Chunk(this.block.getChunk()).getUniqueId(),
                this.block.getX(),
                this.block.getY(),
                this.block.getZ(),
                this.block.getWorld().getUID()
        };
    }

    public Exception exception() {
        return new BlockStoreException();
    }
}
