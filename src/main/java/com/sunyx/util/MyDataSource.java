package com.sunyx.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by liuli on 2018/12/27.
 */
@Component
public class MyDataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

    public String getDriver() {
        return driver;
    }
    @Value("#{jdbcProperties.driver}")
    public void setDriver(String driver) {
        try {
            this.driver = driver;
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }
    @Value("#{jdbcProperties.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }
    @Value("#{jdbcProperties.jdbc_username}")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    @Value("#{jdbcProperties.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
