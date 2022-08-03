package com.situ.web.servlet;

import com.situ.web.pojo.User;
import com.situ.web.service.IUserService;
import com.situ.web.service.impl.IUserServiceImpl;
import com.situ.web.util.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.awt.geom.AreaOp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private IUserService userService=new IUserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
//        if(method==null ||method.equals("")){
//            method="login";
//        }
        if(method==null ||method.equals("")){
            method="selectByPage";
        }

        switch (method) {
            case "login":
                login(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
            case "addUser":
                addUser(req,resp);
                break;
            case  "deleteById":
                deleteById(req,resp);
                break;
            case "selectByPage":
                selectByPage(req,resp);
                break;
            case "updateUserPage":
                updateUserPage(req,resp);
                break;
            case "updateUser":
                updateUser(req,resp);
                break;
            default:
                break;
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("UserServlet.updateUser");
        String id= req.getParameter("id");
        String name=req.getParameter("name");
        String password1=req.getParameter("password");
        System.out.println(id);
        System.out.println(name);
        System.out.println(password1);
       String password=MD5Util.MD5Encode(password1);
       User user=new User(Integer.parseInt(id),name,password);
        System.out.println(user);

       int count= userService.update(user);
        System.out.println(count);

       if(count>0){
           JSONUtil.toJSON(resp,JSONResult.ok("修改成功!"));
       } else {
           JSONUtil.toJSON(resp,JSONResult.error("修改失败!"));
       }

    }

    private void updateUserPage(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("UserServlet.updateUserPage");
        String id=req.getParameter("id");
        User user= userService.selectById(Integer.parseInt(id));

        JSONUtil.toJSON(resp,JSONResult.ok(user));

    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet.selectByPage");

        String pageNo=req.getParameter("pageNo");
        String pageSize=req.getParameter("pageSize");
        if(pageNo==null || pageNo.equals("")){
            pageNo="1";
        }
        if(pageSize==null || pageSize.equals("")){
            pageSize="5";
        }
        System.out.println(pageNo);
        System.out.println(pageSize);

        PageInfo<User> pageInfo1=userService.selectByPage(Integer.parseInt(pageNo),Integer.parseInt(pageSize));

        System.out.println(pageInfo1);
//        JSONUtil.toJSON(resp,JSONResult.ok(pageInfo));

        req.setAttribute("pageInfo",pageInfo1);
        req.getRequestDispatcher("user_pageList.jsp").forward(req,resp);



    }


    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("UserServlet.deleteById");
        String id=req.getParameter("id");
        int count= userService.deleteById(Integer.parseInt(id));
        if(count>0){
            JSONUtil.toJSON(resp,JSONResult.ok("删除成功！"));
        }else {
            JSONUtil.toJSON(resp,JSONResult.error("删除失败！"));

        }    }



    //注册
    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("UserServlet.addUser");
        String name=req.getParameter("name1");

        String password1=req.getParameter("password1");
        String password= MD5Util.MD5Encode(password1);

        User user=new User(name,password);
        System.out.println(user);
        int count= userService.add(user,name);
        System.out.println(count);
        if(count>0){

            JSONUtil.toJSON(resp,JSONResult.ok("注册成功"));
        }else {
            JSONUtil.toJSON(resp,JSONResult.error("用户名已存在,注册失败"));
        }

    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String password1 = req.getParameter("password");
        String code=req.getParameter("code");
        String password=MD5Util.MD5Encode(password1);
        // 先判断验证码是不是正确
        // 验证码错误，返回一个错误提示信息
        // 验证码正确，再验证用户名和密码是否正确
        HttpSession session = req.getSession();
//        session.setAttribute("codeInSession", sRand);
       String codeInSession= (String) session.getAttribute("codeInSession");
       if(!code.equalsIgnoreCase(codeInSession)){
           JSONUtil.toJSON(resp,JSONResult.error("验证码错误！"));
           return;
       }

       User user= userService.selectByMsg(name,password);
        System.out.println(user);
//        if (user == null) {// 用户名密码错误
//            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
//        } else {// 登录成功
//            session.setAttribute("user", user);
//            resp.sendRedirect(req.getContextPath());
//        }
        if (user == null) {
            JSONUtil.toJSON(resp, JSONResult.error("用户名或密码错误!"));
        } else {
            session.setAttribute("user", user);
            JSONUtil.toJSON(resp, JSONResult.ok("登陆成功！"));
        }

    }
}
