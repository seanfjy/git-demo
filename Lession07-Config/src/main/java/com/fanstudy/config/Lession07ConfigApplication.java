package com.fanstudy.config;

import com.fanstudy.config.pk9.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ImportResource;

//再配置类加入注解@ImportResource
@ImportResource(locations = {"classpath:/applicationContext.xml"})


//@EnableConfigurationProperties({NestAppbean.class})
@ConfigurationPropertiesScan(basePackages = {"com.fanstudy.config.pk6","com.fanstudy.config.pk8"})
@SpringBootApplication
public class Lession07ConfigApplication {

    public static void main(String[] args) {
        var app = SpringApplication.run(Lession07ConfigApplication.class, args);
        Person bean = app.getBean(Person.class);
        System.out.println(bean);


    }

}
