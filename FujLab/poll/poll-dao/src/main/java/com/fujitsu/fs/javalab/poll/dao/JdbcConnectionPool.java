package com.fujitsu.fs.javalab.poll.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectionPool {

    private static JdbcConnectionPool instance;

    private HikariDataSource ds;

    private JdbcConnectionPool() {
        HikariConfig config = new HikariConfig();

        Properties jdbcProps = new Properties();
        try {
            jdbcProps.load(getClass().getResourceAsStream("/jdbc.properties"));
        } catch (IOException e) {

        }
        config.setJdbcUrl(jdbcProps.getProperty("jdbc.url"));
        config.setUsername(jdbcProps.getProperty("jdbc.username"));
        config.setPassword(jdbcProps.getProperty("jdbc.password"));
        config.setIdleTimeout(Long.parseLong(jdbcProps.getProperty("jdbc.pool.idleTimeout")));
        config.setMaxLifetime(Long.parseLong(jdbcProps.getProperty("jdbc.pool.maxLifetime")));
        config.setMaximumPoolSize(Integer.parseInt(jdbcProps.getProperty("jdbc.pool.maximumPoolSize")));

        ds = new HikariDataSource(config);
    }

    synchronized public static JdbcConnectionPool getInstance() {
        if (instance == null) {
                if (instance == null) {
                    instance = new JdbcConnectionPool();
                }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
