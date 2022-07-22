package com.situ.web.servlet;

import com.situ.web.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        http://localhost:8080/JavaWeb/deleteStudent?id=2
        String id=req.getParameter("id");

        Connection connection=null;
        PreparedStatement statement=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="delete from student where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,Integer.parseInt(id));
            System.out.println(statement);
            int count=statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
//        重定向
        resp.sendRedirect("/JavaWeb/student");

    }
}
