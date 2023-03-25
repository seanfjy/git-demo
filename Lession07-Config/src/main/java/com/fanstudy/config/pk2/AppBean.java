package com.fanstudy.config.pk2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ConfigurationProperties 表示使用Bean对象读取配置项
 *  prefix:表示配置文件中多个key的公共开始部分
 *      app.name;app表示前缀
 *
 */
//@Component
    //创建普通bean,非spring代理
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "myapp")
public class AppBean {

    //key名称与属性名相同 调用属性的setXXX方法给属性赋值
    //非static
    private String name;

    private String owner;

    private Integer port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", port=" + port +
                '}';
    }
}
