package io.github.kubqoa.creativecontrolbykubqoa.exceptions;

import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;

public class GetChunksCreativeBlocksException extends Exception {
    public GetChunksCreativeBlocksException(CreativeChunk chunk) {
        super("Failed to obtain creative blocks for chunk " + chunk.getUniqueId() + " from database.");
    }
}
