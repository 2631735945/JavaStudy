package com.situ.day8_0718.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    @Test
    public void test1() {
//        1、加载驱动Class.forName("");
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //        2、获得连接对象Connection
            String url = "jdbc:mysql://127.0.0.1:3306/java2207?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";        //数据库的账号
            String password = "123456";    //数据库密码
            conn = DriverManager.getConnection(url, user, password);

            //        3、写sql语句
            String sql = "select id,name,age,gender from student";
            //        4、创建Statement(一艘船)
            statement = conn.createStatement();
//        5、执行sql语句
//                (1) 更新类（更改了表里面数据）：delete/update/insert     executeUpdate()
//        返回值：int，表示你影响的行数
//                (2)查询（没有改变表里面数据）:  select                              executeQuery()
//        返回值：结果集ResultSet
            resultSet = statement.executeQuery(sql);
            List<Student> list = new ArrayList();
            while (resultSet.next()) {//如果有下一个返回true，而且指向下一个
                int sid = resultSet.getInt("id");
                String sname = resultSet.getString("name");
                int sage = resultSet.getInt("age");
                String sgender = resultSet.getString("gender");
                Student student = new Student(sid, sname, sage, sgender);
                list.add(student);
            }
            for (Student student : list) {
                System.out.println(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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

    @Test
    public void test2() {
//        1、加载驱动Class.forName("");
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //要是jar包版本8以上 Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            //        2、获得连接对象Connection
            String url = "jdbc:mysql://127.0.0.1:3306/java2207?useUnicode=true&characterEncoding=UTF-8";
            String user = "root";        //数据库的账号
            String password = "123456";    //数据库密码
            conn = DriverManager.getConnection(url, user, password);

            //        3、写sql语句
            String sql = "select id,name,age,gender from student";
            //        4、创建Statement(一艘船)
            statement = conn.createStatement();
//        5、执行sql语句
//                (1) 更新类（更改了表里面数据）：delete/update/insert     executeUpdate()
//        返回值：int，表示你影响的行数
//                (2)查询（没有改变表里面数据）:  select                              executeQuery()
//        返回值：结果集ResultSet
            resultSet = statement.executeQuery(sql);
            List<Student> list = new ArrayList();
            while (resultSet.next()) {//如果有下一个返回true，而且指向下一个
                int sid = resultSet.getInt("id");
                String sname = resultSet.getString("name");
                int sage = resultSet.getInt("age");
                String sgender = resultSet.getString("gender");
                Student student = new Student(sid, sname, sage, sgender);
                list.add(student);
            }
            for (Student student : list) {
                System.out.println(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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

    @Test
    public void testPreparedStatement() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,age,gender from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Student> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id, name, age, gender);
                list.add(student);
            }
            for (Student student : list) {
                System.out.println(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }

    }

//    插入
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into Student(name,age,gender) values (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "张三1");
            statement.setInt(2, 23);
            statement.setString(3, "男");
            System.out.println(statement);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("添加成功");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//       brand_id品牌  execute 执行
//        ClassCastException 类转换异常
    }

    @Test
    public void testDelete(){
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="delete from student where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,7);
            int count=statement.executeUpdate();
            if(count>0)
            System.out.println("删除成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }

    }

@Test
    public  void testUpdate(){
        Connection connection=null;
        PreparedStatement statement=null;
    try {
        connection= JDBCUtil.getConnection();
        String sql="update student set name=?,age=?,gender=? where id=?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,"王");
        statement.setInt(2,21);
        statement.setString(3,"女");
        statement.setInt(4,6);
        int count=statement.executeUpdate();
        if(count>0)
            System.out.println("修改成功");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }finally {
        JDBCUtil.close(connection,statement,null);
    }

}
//VirtualMachineError



}