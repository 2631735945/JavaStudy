package com.situ.web.dao.impl;

import com.situ.web.dao.IStudentDao;
import com.situ.web.pojo.Student;
import com.situ.web.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IStudentDaoImpl implements IStudentDao {
    @Override
    public List<Student> selectAll() {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        List<Student> list=new ArrayList<>();
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,age,gender from student ";
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age =resultSet.getInt("age");
                String gender=resultSet.getString("gender");
                Student student=new Student(id,name,age,gender);
                list.add(student);

            }
            for (Student student : list) {
                System.out.println(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection= JDBCUtil.getConnection();
            String sql="delete from student where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            System.out.println(statement);
            int count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
    }

    @Override
    public void add(Student student) {
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection= JDBCUtil.getConnection();
            String sql="insert into  student(name,age,gender) VALUES (?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setString(3,student.getGender());
            System.out.println(statement);
            int count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
    }

    @Override
    public Student selectById(Integer id) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;

        Student student=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,age,gender from student where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            System.out.println(statement);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
                int id1=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                String gender=resultSet.getString("gender");
                student=new Student(id1,name,age,gender);
            }
            System.out.println(student);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        return student;
    }

    @Override
    public void update(Student student) {
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="update student set name=?,age=?,gender=? where id=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setInt(2,student.getAge());
            statement.setString(3,student.getGender());
            statement.setInt(4,student.getId());
            System.out.println(statement);
            int count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
    }
}
