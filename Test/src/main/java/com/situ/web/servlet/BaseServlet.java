package com.situ.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    //  /Test/student?method=findAll
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 乱码
        // 登录验证


        // /localhost:8080/Test/student?method=findAll
        // /localhost:8080/Test/student?method=add

        //req.setCharacterEncoding("utf-8");
        //1.获得请求的mehtod方法的名字
        String methodName = req.getParameter("method");
        //2.获得当前被访问对象的字节码对象
        //StudentServlet.class TeacherServlet.class
        Class clazz = this.getClass();
        //3.获得当前字节码对象中指定的方法
        if (methodName != null && !methodName.equals("")) {
            try {
                Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                method.setAccessible(true);
                //4.obj.findAll(); 调用想要调用的方法
                method.invoke(this, req, resp);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

}
