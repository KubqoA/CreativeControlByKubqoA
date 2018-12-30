package io.github.kubqoa.creativecontrolbykubqoa.database.sqlite;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;
import io.github.kubqoa.creativecontrolbykubqoa.creative.CreativeChunk;
import io.github.kubqoa.creativecontrolbykubqoa.database.Query;

public class LoadChunkQuery extends Query {
    private CreativeChunk chunk;

    public LoadChunkQuery(CreativeChunk chunk) {
        this.chunk = chunk;
    }

    @Override
    public String query() {
        return "SELECT * FROM " +
                CreativeControlByKubqoA.database.getTableName("blocks") +
                " WHERE chunk=?";
    }

    @Override
    public Object[] parameters() {
        return new Object[]{
                chunk.getUniqueId()
        };
    }
}
