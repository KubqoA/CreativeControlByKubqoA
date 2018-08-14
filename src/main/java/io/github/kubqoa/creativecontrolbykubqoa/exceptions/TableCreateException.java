package io.github.kubqoa.creativecontrolbykubqoa.exceptions;

public class TableCreateException extends Exception {
    public TableCreateException(String table) {
        super("Failed to create table " + table + " in database.");
    }
}
