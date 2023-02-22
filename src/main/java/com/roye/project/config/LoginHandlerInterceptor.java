package com.roye.project.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后，保存用户session
        Object loginUser = request.getSession().getAttribute("loginUser");
        Object userType=request.getSession().getAttribute("userType");
        if (loginUser==null && userType==null){
            request.setAttribute("msg","无权访问，请先登录");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
