package com.situ.web.util;

import java.sql.*;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/java2207?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";        //数据库的账号
    private static final String PASSWORD = "123456";    //数据库密码

    private JDBCUtil(){}
    static {
        try {
            //1.加载驱动程序：检查启动程序是否可用,加载到JVM中
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {

        //2.创建连接对象
        return DriverManager.getConnection(URL, USER, PASSWORD);


    }

    public static void close(Connection conn, Statement statement, ResultSet resultSet) {
        //        6、关闭连接
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
        if (conn != null) {
            try {

                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
