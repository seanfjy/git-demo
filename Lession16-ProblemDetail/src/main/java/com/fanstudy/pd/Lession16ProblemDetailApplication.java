package com.fanstudy.pd;

import com.fanstudy.pd.config.BookContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({BookContainer.class})
@SpringBootApplication
public class Lession16ProblemDetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession16ProblemDetailApplication.class, args);
    }

}
