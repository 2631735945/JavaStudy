package com.situ.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AjaxServlet.doGet");
        String name=req.getParameter("name");
        System.out.println(name);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("{\"name\":\"张三12\",\"age\":13}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AjaxServlet.doPost");
        String name=req.getParameter("name");
        System.out.println(name);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("{\"name\":\"张三40\",\"age\":13}");
    }
}
