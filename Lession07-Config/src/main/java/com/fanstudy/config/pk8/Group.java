package com.fanstudy.config.pk8;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "group")
@PropertySource(value = "classpath:/conf/group-info.properties")
@Data
public class Group {
    private String name;
    private String leader;
    private Integer members;
}
