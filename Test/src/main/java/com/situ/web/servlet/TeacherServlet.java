package com.situ.web.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher")
public class TeacherServlet extends BaseServlet{
    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {

        }
    }*/

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("TeacherServlet.findAll");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("TeacherServlet.add");
    }
}
