package com.situ.ssm.controller;

import com.situ.ssm.pojo.User;
import com.situ.ssm.service.IUserService;
import com.situ.ssm.service.impl.UserServiceImpl;
import com.situ.ssm.util.JSONResult;
import com.situ.ssm.util.LayUITableJSONResult;
import com.situ.ssm.util.MD5Util;
import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.PlainDocument;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private IUserService userService = new UserServiceImpl();

    @RequestMapping("/login")
    @ResponseBody
    public LayUITableJSONResult login(HttpServletRequest req, String name, String password, String code) {
        System.out.println("UserController.login");
        String password1 = MD5Util.MD5Encode(password);
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password1);

        HttpSession session = req.getSession();
//        session.setAttribute("codeInSession", sRand);

        String codeInSession = (String) session.getAttribute("codeInSession");
        if (!code.equalsIgnoreCase(codeInSession)) {
            return LayUITableJSONResult.error("验证码错误！");

        }

        User user = userService.login(map);
        System.out.println(user);

        if (user == null) {
            return LayUITableJSONResult.error("登陆失败，用户名或密码错误！");
        } else {
            session.setAttribute("user", user);
            return LayUITableJSONResult.ok("登陆成功");
        }

    }

    @RequestMapping("/register")
    @ResponseBody
    public LayUITableJSONResult register(User user) {
        System.out.println("UserController.register");
        System.out.println(user);
        user.setPassword(MD5Util.MD5Encode(user.getPassword()));
            int count= userService.register(user);
            if(count>0){
                return LayUITableJSONResult.ok("注册成功，请登录!");
            }     else {
                return LayUITableJSONResult.error("注册失败!");
            }
        }



}
