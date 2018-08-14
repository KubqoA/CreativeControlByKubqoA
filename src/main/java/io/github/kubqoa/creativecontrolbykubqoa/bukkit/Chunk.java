package io.github.kubqoa.creativecontrolbykubqoa.bukkit;

import java.util.Base64;

public class Chunk {
    private org.bukkit.Chunk chunk;

    public Chunk(org.bukkit.Chunk chunk) {
        this.chunk = chunk;
    }

    public String getUniqueId() {
        String coordinates = "x" + this.chunk.getX() + "z" + this.chunk.getZ();
        return new String(Base64.getEncoder().encode(coordinates.getBytes()));
    }
}
