package io.github.kubqoa.creativecontrolbykubqoa.callbacks;

import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import org.bukkit.Location;

import java.util.List;

public class AddBlocksToChunk implements Callback<List<Location>> {
    @Override
    public void execute(List<Location> response) {
        if (response == null) return;
        CreativeChunk chunk = CreativeChunk.getLoadedChunk(response.get(0).getChunk());
        chunk.addBlocks(response);
    }
}
