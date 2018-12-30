package io.github.kubqoa.creativecontrolbykubqoa.creative;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.callbacks.AddBlocksToChunk;
import io.github.kubqoa.creativecontrolbykubqoa.callbacks.Callback;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Base64;
import java.util.List;

public class CreativeChunk {
    private Chunk chunk;
    private List<Location> blocks;
    private List<Location> inserted;
    private List<Location> removed;

    public CreativeChunk(Chunk chunk) {
        this.chunk = chunk;

        this.loadChunkFromDatabase(this, new AddBlocksToChunk());
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

    public void addBlocks(List<Location> blocks) {
        this.blocks.addAll(blocks);
    }

    private void loadChunkFromDatabase(CreativeChunk chunk, Callback<List<Location>> callback) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    List<Location> blocks = CreativeControlByKubqoA.database.database.loadChunk(chunk);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            callback.execute(blocks);
                        }
                    }.runTask(CreativeControlByKubqoA.javaPlugin);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(CreativeControlByKubqoA.javaPlugin);
    }

    public boolean hasBlock(Block block) {
        return this.blocks.contains(block.getLocation());
    }

    public void insertBlock(Block block) {
        this.inserted.add(block.getLocation());
        this.blocks.add(block.getLocation());
    }

    public void removeBlock(Block block) {
        this.removed.add(block.getLocation());
        this.blocks.remove(block.getLocation());
    }

    private void saveChunkToDatabase() {

    }

    public void unload() {
        this.saveChunkToDatabase();
        CreativeControlByKubqoA.chunks.remove(this.getUniqueId());
    }
}
