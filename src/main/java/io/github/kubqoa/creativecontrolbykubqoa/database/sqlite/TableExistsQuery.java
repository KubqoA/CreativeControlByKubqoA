package io.github.kubqoa.creativecontrolbykubqoa.database.sqlite;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.database.Query;
import io.github.kubqoa.creativecontrolbykubqoa.exceptions.TableExistsException;

/**
 * Query to test whether the given table exists
 *
 * @author Jakub Arbet
 */
public class TableExistsQuery extends Query {
    private String table;

    public TableExistsQuery(String table) {
        this.table = CreativeControlByKubqoA.config.getString("db.prefix") + table;
    }

    public String query() {
        return "SELECT name FROM sqlite_master WHERE type='table' AND name=?";
    }

    public Object[] parameters() {
        return new Object[]{
                table
        };
    }

    public Exception exception() {
        return new TableExistsException(this.table);
    }
}
