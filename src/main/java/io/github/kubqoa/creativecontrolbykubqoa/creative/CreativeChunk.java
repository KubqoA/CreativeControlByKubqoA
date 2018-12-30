package io.github.kubqoa.creativecontrolbykubqoa.creative;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import org.bukkit.Chunk;

import java.util.Base64;

public class CreativeChunk {
    private Chunk chunk;

    public CreativeChunk(Chunk chunk) {
        this.chunk = chunk;
        this.loadChunkFromDatabase();
    }

    public static String getUniqueId(Chunk chunk) {
        String coordinates = "x" + chunk.getX() + "z" + chunk.getZ();
        return new String(Base64.getEncoder().encode(coordinates.getBytes()));
    }

    public static CreativeChunk getLoadedChunk(Chunk chunk) {
        return CreativeControlByKubqoA.chunks.get(getUniqueId(chunk));
    }

    public String getUniqueId() {
        return getUniqueId(this.chunk);
    }

    private void loadChunkFromDatabase() {

    }

    private void saveChunkToDatabase() {

    }

    public void unload() {
        this.saveChunkToDatabase();
        CreativeControlByKubqoA.chunks.remove(this.getUniqueId());
    }
}
