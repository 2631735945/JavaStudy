package com.situ.day8_0718.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil1 {

    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;
    private static String DB_DRIVER;

    private JDBCUtil1() {}

    // DBUtils
    // 静态代码块，类加载时候只执行一次
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\Java220702_xm\\JavaStudy\\JavaSE\\src\\com\\situ\\day8_0718\\jdbc\\db.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            DB_URL = properties.getProperty("url");
            DB_USER = properties.getProperty("user");
            DB_PASSWORD = properties.getProperty("password");
            DB_DRIVER = properties.getProperty("driver");

            Class.forName(DB_DRIVER);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

