package com.fanstudy.mvc.settings;

import com.fanstudy.mvc.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fanstudy.mvc.formatter.DeviceFormatter;
import com.fanstudy.mvc.interceptor.AuthInterceptor;

/**
 * springMVC配置类
 */
@Configuration
public class MvcSettings implements WebMvcConfigurer {
    // 页面跳转控制器,从请求直达视图页面 无需controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 配置页面控制 addViewController("请求url") ,指定视图setViewName()
        registry.addViewController("/welcome").setViewName("index");
    }

    // 转换器
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 权限拦截器
        registry.addInterceptor(new AuthInterceptor()).order(2).addPathPatterns("/article/**")
            .excludePathPatterns("/article/query");

        // 登录拦截器
        registry.addInterceptor(new LoginInterceptor()).order(1).addPathPatterns("/**").excludePathPatterns("/article/query");

    }
}
