package ru.trandefil.tm.service;

import ru.trandefil.tm.api.ConnectionService;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionServiceImpl implements ConnectionService {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        System.out.println("MySql driver registered");
        Connection connection = null;
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
        final Properties properties = new Properties();
        try {
            properties.load(inputStream);
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

}
