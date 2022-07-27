package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ajax2")
public class Ajax2Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax2Servlet.service");
        String name=req.getParameter("name");
        System.out.println(name);
        Map<String,Object> map=new HashMap<>();
        if(name.equalsIgnoreCase("tom")){
            map.put("exist",true);
            map.put("msg","用户名已存在，换一个");
        }  else {
            map.put("exist",false);
            map.put("msg","该用户名可以使用");
        }
        resp.setContentType("text/html; charset=UTF-8");
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(resp.getWriter(),map);
    }
}
