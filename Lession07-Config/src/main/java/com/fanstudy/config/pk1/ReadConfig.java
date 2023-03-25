package com.fanstudy.config.pk1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ReadConfig {
    //注入环境对象
    @Autowired
    private Environment environment;

    public void print(){
        //获取某个key的值
        String name = environment.getProperty("app.name");

        //判断key是否存在
        if (environment.containsProperty("app.owner1")){
            System.out.println("app.owner 是存在的");
        }

        //读取key的值,转为期望的类型,提供默认值

        Integer port = environment.getProperty("app.port2", Integer.class, 8888);

        String format = String.format("读取的key值. name=%s,port=%d", name, port);
        System.out.println(format);


    }
}
