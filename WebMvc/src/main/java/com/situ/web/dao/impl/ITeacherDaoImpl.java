package com.situ.web.dao.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.pojo.Teacher;
import com.situ.web.util.JDBCUtil;
import com.situ.web.util.PageInfo;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class ITeacherDaoImpl implements ITeacherDao {
    @Override
    public List<Teacher> selectPage(Integer offset, Integer pageSize) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Teacher> list = new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,age,address from teacher limit ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                Teacher teacher = new Teacher(id, name, age, address);
                list.add(teacher);
            }
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int selectCount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select count(*) from teacher";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
                System.out.println(count);
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
        Connection connection = null;
        PreparedStatement statement = null;
        int count=0;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "delete from teacher where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            System.out.println(statement);
             count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
        return count;
    }

    @Override
    public void add(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into teacher(name,age,address) values (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getName());
            statement.setInt(2, teacher.getAge());
            statement.setString(3, teacher.getAddress());
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }

    @Override
    public Teacher selectById(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Teacher teacher=null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,age,address from teacher where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
               teacher = new Teacher(id, name, age, address);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        return teacher;
    }

    @Override
    public void update(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "update  teacher set name=?,age=?,address=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getName());
            statement.setInt(2, teacher.getAge());
            statement.setString(3, teacher.getAddress());
            statement.setInt(4,teacher.getId());
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }


}
