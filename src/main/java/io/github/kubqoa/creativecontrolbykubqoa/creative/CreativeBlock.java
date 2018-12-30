package io.github.kubqoa.creativecontrolbykubqoa.creative;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import org.bukkit.block.Block;

public class CreativeBlock {
    private Block block;

    public CreativeBlock(Block block) {
        this.block = block;
    }

    public static CreativeChunk getCreativeChunk(Block block) {
        return CreativeChunk.getLoadedChunk(block.getChunk());
    }
}
