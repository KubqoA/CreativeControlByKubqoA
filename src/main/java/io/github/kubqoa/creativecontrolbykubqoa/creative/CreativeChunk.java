package io.github.kubqoa.creativecontrolbykubqoa.creative;

import org.bukkit.Chunk;
import org.bukkit.block.Block;

import java.util.Base64;
import java.util.List;

public class CreativeChunk {
    private Chunk chunk;
    private List<Block> creativeBlocks;

    public CreativeChunk(Chunk chunk) {
        this.chunk = chunk;
    }

    public static String getUniqueId(Chunk chunk) {
        return new CreativeChunk(chunk).getUniqueId();
    }

    public String getUniqueId() {
        String coordinates = "x" + this.chunk.getX() + "z" + this.chunk.getZ();
        return new String(Base64.getEncoder().encode(coordinates.getBytes()));
    }

    public void loadCreativeBlocks() {

    }

    public List<Block> getCreativeBlocks() {
        return this.creativeBlocks;
    }
}
