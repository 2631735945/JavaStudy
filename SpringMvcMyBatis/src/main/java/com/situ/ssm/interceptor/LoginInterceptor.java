package com.situ.ssm.interceptor;


import com.situ.ssm.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author admin
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor.preHandle");
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        if(servletPath.endsWith(".js")
                || servletPath.endsWith(".css")
                || servletPath.endsWith(".png")
                || servletPath.endsWith(".jpg")
                || servletPath.equals("/login.jsp")
                || servletPath.equals("/verifyCode")
                || servletPath.equals("/user")){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        System.out.println(user);

        if (user == null ) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor.afterCompletion");
    }
}
