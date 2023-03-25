package com.fanstudy.pk;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 核心注解功能
 * 
 * @SpringBootConfiguration:包含@Configuration注解的功能
 * @Configuration: 配置类,结合@bean能够将对象注入到spring的ioc容器中
 * @EnableAutoConfiguration : 开启自动配置
 * @ComponentScan: 组件扫描器
 *      扫描@Controller,@Service @Repository @Component 创建好对象注入到容器中
 *      启动类作为扫描包的根节点
 */
@SpringBootApplication
public class Lession06PackageApplication {
    @Bean
    public Date myDate(){
        return new Date(0,11,12);

    }
    public static void main(String[] args) {
        //run方法返回的是一个容器对象
        ApplicationContext run = SpringApplication.run(Lession06PackageApplication.class, args);

        //可以从容器获取对象
        Date bean = run.getBean(Date.class);
    }

}
