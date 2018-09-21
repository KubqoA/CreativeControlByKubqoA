package io.github.kubqoa.creativecontrolbykubqoa.database;

import com.zaxxer.hikari.HikariConfig;
import io.github.kubqoa.creativecontrolbykubqoa.Config;

abstract public class WIP_MariaDB implements DatabaseInterface {
    public HikariConfig getHikariConfig(Config config) {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setPoolName("CreativeControlMariaDBPool");
        hikariConfig.setDriverClassName("org.mariadb.jdbc.MariaDbDataSource");
        hikariConfig.setJdbcUrl("jdbc:mysql://" + config.getString("db.host") + ":" + config.getString("db.port") + "/" + config.getString("db.database"));
        hikariConfig.setUsername(config.getString("db.username"));
        hikariConfig.setPassword(config.getString("db.password"));
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return hikariConfig;
    }
}
