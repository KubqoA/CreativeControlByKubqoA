package io.github.kubqoa.creativecontrolbykubqoa.database.sqlite;

import io.github.kubqoa.creativecontrolbykubqoa.database.Update;
import io.github.kubqoa.creativecontrolbykubqoa.exceptions.BlockStoreException;
import org.bukkit.block.Block;

public class BlockStoreUpdate extends Update {
    private Block block;

    public BlockStoreUpdate(Block block) {
        this.block = block;
    }

    public String update() {
        return "update";
    }

    public Object[] parameters() {
        return new Object[0];
    }

    public Exception exception() {
        return new BlockStoreException();
    }
}
