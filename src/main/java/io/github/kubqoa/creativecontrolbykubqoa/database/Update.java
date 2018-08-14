package io.github.kubqoa.creativecontrolbykubqoa.database;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class Update {
    abstract public String update();
    abstract public Object[] parameters();
    abstract public Exception exception();

    /**
     * Run the query
     *
     * @return
     */
    public int run() throws Exception {
        try {
            Connection connection = CreativeControlByKubqoA.database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(update());
            int i = 1;
            for (Object parameter : parameters()) {
                preparedStatement.setObject(i, parameter);
                i++;
            }
            return preparedStatement.executeUpdate();
        } catch (Exception exception) {
            throw exception();
        }
    };
}
