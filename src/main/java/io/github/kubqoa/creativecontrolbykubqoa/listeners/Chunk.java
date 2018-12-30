package io.github.kubqoa.creativecontrolbykubqoa.listeners;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkUnloadEvent;

public class Chunk implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onChunkLoad(ChunkLoadEvent event) {
        CreativeChunk chunk = new CreativeChunk(event.getChunk());
        CreativeControlByKubqoA.chunks.put(chunk.getUniqueId(),chunk);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onChunkUnload(ChunkUnloadEvent event) {
        CreativeChunk chunk = CreativeChunk.getLoadedChunk(event.getChunk());
        chunk.unload();
    }
}
