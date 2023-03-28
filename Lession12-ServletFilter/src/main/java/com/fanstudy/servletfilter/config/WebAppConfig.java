package com.fanstudy.servletfilter.config;

import com.fanstudy.servletfilter.filter.LogFilter;
import jakarta.servlet.Filter;
import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fanstudy.servletfilter.servlet.LoginServlet;

@Configuration
public class WebAppConfig {


    @Bean
    public ServletRegistrationBean<Servlet> servletRegistrationBean(){
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new LoginServlet());
        registrationBean.addUrlMappings("/user/login");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

//    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;

    }
}
