package ru.trandefil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcExample {

    public static void main(String[] args){
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return;
        }

        System.out.println("MySql driver registerd");
        Connection connection = null;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return;
        }
        if(connection != null){
            System.out.println("Yes, sir!");
        }else{
            System.out.println("LOPUH");
        }
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            System.out.println("statment == null : " + (statement == null));
            resultSet = statement.executeQuery("select * from justtest");
            System.out.println("resultset == null : " + (resultSet == null));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                System.out.println(id + "<>" + name + "<>" + desc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
