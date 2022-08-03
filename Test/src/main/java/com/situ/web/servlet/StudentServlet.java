package com.situ.web.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends BaseServlet{
    // /localhost:8080/Test/student?method=findAll
    // /localhost:8080/Test/student?method=add


   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {

        }
    }*/

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("StudentServlet.findAll");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("StudentServlet.add");
    }
}
