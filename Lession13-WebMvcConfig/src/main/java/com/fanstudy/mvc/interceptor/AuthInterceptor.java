package com.fanstudy.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    private static final String COMMON_USER = "zhangsan";

    // 判断登录的用户, 能否执行相应的动作
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        System.out.println("====AuthInterceptor====");

        String loginUser = request.getParameter("loginUser");

        String requestURI = request.getRequestURI();

        // 判断当前用户的操作
        if ((COMMON_USER.equals(loginUser)) && (requestURI.startsWith("/article/add")
            || requestURI.startsWith("/article/edit") || requestURI.startsWith("/article/remove"))) {
            return false;

        }
        return true;
    }
}
