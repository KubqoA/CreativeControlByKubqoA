package io.github.kubqoa.creativecontrolbykubqoa.creative;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class CreativeBlock {
    private Block block;

    public CreativeBlock(Block block) {
        this.block = block;
    }

    public static CreativeChunk getCreativeChunk(Block block) {
        return CreativeChunk.getLoadedChunk(block.getChunk());
    }

    private CreativeChunk getCreativeChunk() {
        return getCreativeChunk(this.block);
    }

    public boolean isCreative() {
        return this.getCreativeChunk().hasBlock(this.block);
    }

    public void insert() {
        this.getCreativeChunk().insertBlock(this.block);
    }

    public void update() {

    }

    public void remove() {
        this.getCreativeChunk().removeBlock(this.block);
    }

    public void physicalRemove() {
        this.block.setType(Material.AIR);
    }
}
