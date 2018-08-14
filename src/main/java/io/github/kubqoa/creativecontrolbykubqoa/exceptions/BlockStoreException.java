package io.github.kubqoa.creativecontrolbykubqoa.exceptions;

public class BlockStoreException extends Exception {
    public BlockStoreException() {
        super("Failed to store new block record to database");
    }
}
