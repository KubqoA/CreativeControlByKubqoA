package io.github.kubqoa.creativecontrolbykubqoa;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.kubqoa.creativecontrolbykubqoa.database.DatabaseInterface;
import io.github.kubqoa.creativecontrolbykubqoa.exceptions.InvalidConfigurationException;

import java.sql.Connection;
import java.sql.SQLException;

public class Database
{
    private Config config;
    public DatabaseInterface database;
    public HikariConfig hikariConfig;
    public HikariDataSource hikariDataSource;

    public Database(Config config) {
        this.config = config;
    }

    public void initializeDatabasePool() {
        try {
            this.hikariConfig = this.getHikariConfig();
            this.hikariDataSource = new HikariDataSource(this.hikariConfig);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public String getTableName(String table) {
        return this.config.getString("db.prefix") + table;
    }

    public Connection getConnection() {
        try {
            return this.hikariDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeDatabasePool() {
        if (this.hikariDataSource != null && !this.hikariDataSource.isClosed()) this.hikariDataSource.close();
    }

    private HikariConfig getHikariConfig() throws InvalidConfigurationException, IllegalAccessException, InstantiationException {
        try {
            Class<?> aClass = Class.forName("io.github.kubqoa.creativecontrolbykubqoa.database."+this.config.getString("db.type"));
            this.database = (DatabaseInterface) aClass.newInstance();
            return this.database.getHikariConfig(this.config);
        } catch (ClassNotFoundException exception) {
            throw new InvalidConfigurationException("db.type");
        }
    }
}
