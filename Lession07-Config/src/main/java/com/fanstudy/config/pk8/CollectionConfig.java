package com.fanstudy.config.pk8;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class CollectionConfig {
    private List<MyServer> servers;

    private Map<String, User> users;

    private String[] names;
}
