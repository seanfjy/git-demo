package com.fanstudy.config.pk6;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
//@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "myapp")
public class NestAppbean {

    private String name;
    private String owner;
    private Integer port;

    private Security security;
}
