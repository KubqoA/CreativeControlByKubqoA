package io.github.kubqoa.creativecontrolbykubqoa.exceptions;

public class TableExistsException extends Exception {
    public TableExistsException(String table) {
        super("Failed to check whether table " + table + " exists.");
    }
}
