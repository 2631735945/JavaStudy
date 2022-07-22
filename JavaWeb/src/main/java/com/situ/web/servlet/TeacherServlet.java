package com.situ.web.servlet;

import com.situ.web.pojo.Teacher;
import com.situ.web.util.JDBCUtil;
import com.situ.web.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        if(method==null || method.equals("")){
            method="selectByPage";
        }
        switch (method){
            case "selectTeacherAll":
                selectTeacherAll(req,resp);break;
            case "deleteById":
                deleteById(req,resp);break;
            case "addTeacher":
                addTeacher(req,resp);break;
            case "updateTeacherPage":
                updateTeacherPage(req,resp);break;
            case "updateTeacher":
                updateTeacher(req,resp);break;
            case "selectByPage":
                selectByPage(req,resp);break;
        }
    }
//http://localhost:8080/JavaWeb/teacher?method=selectByPage&pageNo=2&pageSize=5
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherServlet.selectByPage");
        String pageNo=req.getParameter("pageNo");
        String pageSize=req.getParameter("pageSize");
        if(pageNo==null|| pageNo.equals("")){
            pageNo="1";

        }
        if(pageSize==null|| pageSize.equals("")){
            pageSize="5";
        }
        int pageN=Integer.parseInt(pageNo);
        int pageS= Integer.parseInt(pageSize);
//        封装PageInfo
        PageInfo pageInfo=new PageInfo();
        pageInfo.setPageNo(pageN);
        pageInfo.setPageSize(pageS);

//         1、查询当前页的数据
        int offSet=(pageN-1)*pageS;
       List<Teacher> list= selectPage(offSet,pageS);
       pageInfo.setList(list);
//  2、查询总的数量
        int totalCount=selectCount();
        int totalPages= (int) Math.ceil((double)totalCount/pageS);

        pageInfo.setTotalPages(totalPages);
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("teacher_pageList.jsp").forward(req,resp);
    }

    private int selectCount() {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        int count=0;

        try {
            connection=JDBCUtil.getConnection();
            String sql="select count(*) from student";
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            if(resultSet.next()){
               count=resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        return count;

    }

    private List<Teacher> selectPage(int offSet, int pageS) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Teacher> list=new ArrayList<>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select id,name,age,address from teacher limit ?,?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,offSet);
            statement.setInt(2,pageS);
            System.out.println(statement);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                String address=resultSet.getString("address");
                Teacher teacher=new Teacher(id,name,age,address);
                list.add(teacher);
            }
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        return list;
    }

    private void updateTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TeacherServlet.updateTeacher");
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String address=req.getParameter("address");
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="update teacher set name=?,age=?,address=? where id=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2, Integer.parseInt(age));
            statement.setString(3,address);
            statement.setInt(4, Integer.parseInt(id));
            System.out.println(statement);
            int count=statement.executeUpdate();
            System.out.println(count);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        resp.sendRedirect(req.getContextPath()+"/teacher?method=selectByPage");
    }

    private void updateTeacherPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherServlet.updateTeacherPage");
        String id=req.getParameter("id");
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        Teacher teacher=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select id,name,age,address from teacher where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(id));
            System.out.println(statement);
            resultSet=statement.executeQuery();
          if(resultSet.next()){
              String name=resultSet.getString("name");
              int age=resultSet.getInt("age");
              String address=resultSet.getString("address");
               teacher=new Teacher(Integer.parseInt(id),name,age,address);
              System.out.println(teacher);
          }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }
        req.setAttribute("teacher",teacher);
        req.getRequestDispatcher("teacher_update.jsp").forward(req,resp);
    }

    private void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TeacherServlet.addTeacher");

        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String address=req.getParameter("address");

        Connection connection=null;
        PreparedStatement statement=null;

        try {
            connection=JDBCUtil.getConnection();
            String sql="insert into teacher(name,age,address) values (?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setInt(2, Integer.parseInt(age));
            statement.setString(3,address);
            int count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        resp.sendRedirect(req.getContextPath()+"/teacher?method=selectByPage");
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TeacherServlet.deleteById");
        String id=req.getParameter("id");
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="delete from teacher where id=?";
            statement=connection.prepareStatement(sql);
           statement.setInt(1, Integer.parseInt(id));
            System.out.println(statement);
            int count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        resp.sendRedirect(req.getContextPath()+"/teacher?method=selectByPage");
    }

    private void selectTeacherAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<Teacher> list=new ArrayList<>();
        try {
           connection= JDBCUtil.getConnection();
            String sql="select id,name,age,address from teacher";
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                String address=resultSet.getString("address");
                Teacher teacher=new Teacher(id,name,age,address);
                list.add(teacher);
            }
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }

        req.setAttribute("list",list);
        req.getRequestDispatcher("teacher_list.jsp").forward(req,resp);
    }
}
