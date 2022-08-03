package com.situ.web.servlet;

import com.situ.web.pojo.User;
import com.situ.web.service.impl.layUserServiceImpl;
import com.situ.web.service.layUserService;
import com.situ.web.util.JSONResult;
import com.situ.web.util.JSONUtil;
import com.situ.web.util.LayUITableJSONResult;
import com.situ.web.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/layUser")
public class layUserServlet extends HttpServlet {
    private layUserService userService = new layUserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "deleteAll":
                deleteAll(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "getUserUpdatePage":
                getUserUpdatePage(req, resp);
                break;

            case "updateUser":
                updateUser(req, resp);
                break;
            case "selectById":
                selectById(req, resp);
                break;
            default:
                break;

        }
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("layUserServlet.selectById");
        String id=req.getParameter("id");
        User user= userService.selectById(Integer.parseInt(id));
        JSONUtil.toJSON(resp,JSONResult.ok(user));
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("layUserServlet.updateUser");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String password1 = req.getParameter("password");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String password = MD5Util.MD5Encode(password1);

        User user = new User(Integer.parseInt(id), name, password, Integer.parseInt(age), address, gender);
        int count = userService.updateUser(user);
        if (count > 0) {
            JSONUtil.toJSON(resp, JSONResult.ok("修改成功"));
        } else {
            JSONUtil.toJSON(resp, JSONResult.error("修改失败"));

        }


    }

    private void getUserUpdatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("layUserServlet.getUserUpdatePage");
        String id = req.getParameter("id");
        User user = userService.selectById(Integer.parseInt(id));

        req.setAttribute("user", user);
        req.getRequestDispatcher("user_update.jsp").forward(req, resp);


    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("layUserServlet.add");
        String name = req.getParameter("name");
        String password1 = req.getParameter("password");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String gender = req.getParameter("gender");
        String password = MD5Util.MD5Encode(password1);
        User user = new User(name, password, Integer.parseInt(age), address, gender);
        int count = userService.add(user, name);
        if (count > 0) {
            JSONUtil.toJSON(resp, JSONResult.ok("添加成功"));
        } else {
            JSONUtil.toJSON(resp, JSONResult.error("用户名已存在！"));

        }

    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("layUserServlet.deleteAll");
        String[] ids = req.getParameterValues("ids[]");
        System.out.println(Arrays.toString(ids));
        int sum = userService.deleteAll(ids);
        if (sum > 0) {
            JSONUtil.toJSON(resp, JSONResult.ok("删除成功"));
        } else {
            JSONUtil.toJSON(resp, JSONResult.error("删除失败！"));
        }
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("layUserServlet.deleteById");
        String id = req.getParameter("id");
        int count = userService.deleteById(Integer.parseInt(id));
        if (count > 0) {
            JSONUtil.toJSON(resp, JSONResult.ok("删除成功"));
        } else {
            JSONUtil.toJSON(resp, JSONResult.error("删除失败！"));

        }
    }

    // /layUser?method=selectByPage&page=1&limit=10
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("layUserServlet.selectByPage");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        LayUITableJSONResult layUITableJSONResult = userService.selectByPage(Integer.parseInt(page), Integer.parseInt(limit));
        JSONUtil.toJSON(resp, layUITableJSONResult);
    }


}
