package io.github.kubqoa.creativecontrolbykubqoa.database;

import io.github.kubqoa.creativecontrolbykubqoa.CreativeControlByKubqoA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Query {
    private ResultSet resultSet;

    abstract public String query();
    abstract public Object[] parameters();

    /**
     * Run the query specified in query method with parameters from parameter method
     */
    public void run() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CreativeControlByKubqoA.database.getConnection();
            preparedStatement = connection.prepareStatement(query());
            int i = 1;
            for (Object parameter : parameters()) {
                preparedStatement.setObject(i, parameter);
                i++;
            }
            this.resultSet = preparedStatement.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            CreativeControlByKubqoA.database.close(connection,preparedStatement,null);
        }
    }

    public ResultSet getResultSet() {
        return this.resultSet;
    }

    public int getNumberOfResults() {
        try {
            this.getResultSet().last();
            return this.getResultSet().getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Checks whether there the resultSet contains any results
     *
     * @return boolean
     */
    public boolean hasResults() {
        try {
            return this.resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
