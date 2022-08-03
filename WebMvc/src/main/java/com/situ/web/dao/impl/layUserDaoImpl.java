package com.situ.web.dao.impl;


import com.situ.web.dao.layUserDao;
import com.situ.web.pojo.User;
import com.situ.web.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class layUserDaoImpl implements layUserDao {
    @Override
    public List<User> selectPage(Integer offset, Integer limit) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> list = new ArrayList<>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select id,name,password,age,address,gender from user limit ?,?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,offset);
            statement.setInt(2,limit);
            System.out.println(statement);
            resultSet= statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                User user = new User(id, name, password, age,address, gender);
                list.add(user);
            }
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        return list;
    }

    @Override
    public int selectTotalCount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select count(*) from user";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }

        return count;
    }

    @Override
    public int deleteById(Integer id) {
        Connection connection=null;
        PreparedStatement statement=null;
        int count=0;
        try {
            connection=JDBCUtil.getConnection ();
            String sql="delete from user where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            System.out.println(statement);
            count=statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        return count;
    }

    @Override
    public int add(User user, String name) {
        Connection connection=null;
        PreparedStatement statement=null;
        int count= 0;
        try {
            connection= JDBCUtil.getConnection();
            String sql="insert into  user(name, password,age,address,gender) VALUES (?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getAge());
            statement.setString(4,user.getAddress());
            statement.setString(5,user.getGender());
            System.out.println(statement);
            count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        return count;
    }

    @Override
    public User selectByName(String name) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,password from user where name=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                int id1=resultSet.getInt(1);
                String name1=resultSet.getString(2);
                String password=resultSet.getString(3);
                user=new User(id1,name1,password);
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User selectById(Integer id) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,password,age,address,gender from user where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
               user = new User(id1, name, password, age,address, gender);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUser(User user) {
        Connection connection=null;
        PreparedStatement statement=null;
        int count=0;
        try {
            connection=JDBCUtil.getConnection();
            String sql="update user set name=?,password=?,age=?,address=?,gender=? where id=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getAge());
            statement.setString(4,user.getAddress());
            statement.setString(5,user.getGender());
            statement.setInt(6,user.getId());
            System.out.println(statement);
            count=statement.executeUpdate();
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        return count;
    }


}
