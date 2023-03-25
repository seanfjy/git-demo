package com.fanstudy.config.pk1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
public class SomeService {
    //使用@Value("${key:默认值}")

    @Value("${app.name}")
    private String name;
    @Value("${app.owner}")
    private String owner;
    @Value("${app.port:8080}")
    private Integer port;

    public void printValue(){

        StringJoiner stringJoiner = new StringJoiner(";");

        stringJoiner.add(name).add(owner).add(port.toString());
        String result = stringJoiner.toString();
        System.out.println("result = "+result);
    }
}
