package com.situ.web.dao.impl;

import com.situ.web.dao.IUserDao;
import com.situ.web.pojo.User;
import com.situ.web.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
    @Override
    public int deleteById(Integer id) {
        Connection connection=null;
        PreparedStatement statement=null;
        int count= 0;
        try {
           connection= JDBCUtil.getConnection();
           String sql="delete from user where id=?";
           statement=connection.prepareStatement(sql);
           statement.setInt(1,id);
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
    public int add(User user,String name) {
        Connection connection=null;
        PreparedStatement statement=null;
        int count= 0;
        try {
            connection= JDBCUtil.getConnection();
            String sql="insert into  user(name, password) VALUES (?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
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
    public User selectById(Integer id) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        User user=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,password from user where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String password=resultSet.getString(3);
                user=new User(id1,name,password);
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
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
    public List<User> selectAll() {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> list=new ArrayList<>();
        User user=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,password from user ";
            statement=connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                int id1=resultSet.getInt(1);
                String name1=resultSet.getString(2);
                String password=resultSet.getString(3);
                user=new User(id1,name1,password);
                list.add(user);
            }
            System.out.println(list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public User selectByMsg(String name, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,password from user where name=? and password=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String password1 = resultSet.getString("password");
                user = new User(id, name1, password1);
                System.out.println(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
            return user;
    }

    @Override
    public int selectCount() {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        int count=0;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select count(*) from user ";
            statement=connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
               count=resultSet.getInt(1);
            }
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public List<User> selectPage(Integer offset, Integer pageSize) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<User> list=new ArrayList<>();
        User user=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,password from user limit ?,?";
            statement=connection.prepareStatement(sql);
            System.out.println(statement);
            statement.setInt(1,offset);
            statement.setInt(2,pageSize);

            resultSet=statement.executeQuery();
            while(resultSet.next()){
                int id1=resultSet.getInt(1);
                String name1=resultSet.getString(2);
                String password=resultSet.getString(3);
                user=new User(id1,name1,password);
                list.add(user);
            }

            System.out.println(list);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public int update(User user) {
        Connection connection=null;
        PreparedStatement statement=null;
        int count=0;
        try {
            connection=JDBCUtil.getConnection();
            String sql="update user set name=?,password=? where id=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getId());
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
