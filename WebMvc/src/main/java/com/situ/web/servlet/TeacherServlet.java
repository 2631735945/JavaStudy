package com.situ.web.servlet;

import com.situ.web.pojo.Teacher;
import com.situ.web.service.ITeacherService;
import com.situ.web.service.impl.ITeacherServiceImpl;
import com.situ.web.util.JDBCUtil;
import com.situ.web.util.JSONResult;
import com.situ.web.util.JSONUtil;
import com.situ.web.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    private ITeacherService teacherService=new ITeacherServiceImpl();

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
        PageInfo pageInfo=teacherService.selectByPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));

        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("teacher_pageList.jsp").forward(req,resp);
    }


    private void updateTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TeacherServlet.updateTeacher");
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String address=req.getParameter("address");

        Teacher teacher=new Teacher(Integer.parseInt(id),name,Integer.parseInt(age),address);
        teacherService.update(teacher);

        resp.sendRedirect(req.getContextPath()+"/teacher?method=selectByPage");
    }

    private void updateTeacherPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherServlet.updateTeacherPage");
        String id=req.getParameter("id");
        Teacher teacher=teacherService.selectById(Integer.valueOf(id));
        req.setAttribute("teacher",teacher);
        req.getRequestDispatcher("teacher_update.jsp").forward(req,resp);
    }

    private void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TeacherServlet.addTeacher");

        String name=req.getParameter("name");
        String age=req.getParameter("age");
        String address=req.getParameter("address");

        Teacher teacher=new Teacher(name,Integer.parseInt(age),address);
        teacherService.add(teacher);
        resp.sendRedirect(req.getContextPath()+"/teacher?method=selectByPage");
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("TeacherServlet.deleteById");
        int id= Integer.parseInt(req.getParameter("id"));
       int count = teacherService.deleteById(id);

        if(count>0){
            JSONUtil.toJSON(resp,JSONResult.ok("删除成功"));
        } else {
            JSONUtil.toJSON(resp,JSONResult.error("删除失败"));
        }

//        resp.sendRedirect(req.getContextPath()+"/teacher?method=selectByPage");
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
