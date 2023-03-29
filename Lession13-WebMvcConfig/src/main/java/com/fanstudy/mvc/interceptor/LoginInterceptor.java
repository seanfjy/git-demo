package com.fanstudy.mvc.interceptor;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    private List<String> permitUser;

    public LoginInterceptor() {
        this.permitUser = Arrays.asList("zhangsan","lisi","admin");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("========LoginInterceptor========");
        String loginUser = request.getParameter("loginUser");
        if (StringUtils.hasText(loginUser) && permitUser.contains(loginUser)){
            return true;
        }
        return false;
    }
}
