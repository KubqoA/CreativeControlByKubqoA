package io.github.kubqoa.creativecontrolbykubqoa.database.sqlite;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.database.Update;

public class BlockTableCreateUpdate extends Update {
    @Override
    public String update() {
        return "CREATE TABLE IF NOT EXISTS " +
                CreativeControlByKubqoA.database.getTableName("blocks") +
                "(" +
                "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "`chunk` TEXT, " +
                "`x` REAL, " +
                "`y` REAL, " +
                "`z` REAL, " +
                "`world` TEXT " +
                ");";
    }

    @Override
    public Object[] parameters() {
        return new Object[0];
    }

}
