package com.fanstudy.config;

import com.fanstudy.config.pk1.MultiConfigService;
import com.fanstudy.config.pk1.MultiEnvService;
import com.fanstudy.config.pk1.ReadConfig;
import com.fanstudy.config.pk1.SomeService;
import com.fanstudy.config.pk2.AppBean;
import com.fanstudy.config.pk6.NestAppbean;
import com.fanstudy.config.pk7.ApplicationConfig;
import com.fanstudy.config.pk8.CollectionConfig;
import com.fanstudy.config.pk8.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession07ConfigApplicationTests {

    @Autowired
    private SomeService someService;

    @Autowired
    private ReadConfig readConfig;


    @Autowired
    private MultiConfigService multiConfigService;


    @Autowired
    private MultiEnvService multiEnvService;
    @Test
    void test01() {

    someService.printValue();
    }

    @Test
    void test02() {
        readConfig.print();
    }

    @Test
    void test03() {
        multiConfigService.print();
    }

    @Test
    void test04() {
        multiEnvService.print();
    }


    @Autowired
    private AppBean appBean;
    @Test
    void test05() {
        System.out.println(appBean);
        System.out.println("appBean.getClass() :"+appBean.getClass());
    }

    @Autowired
    private NestAppbean nestAppbean;
    @Test
    void test06() {
        System.out.println(nestAppbean);
    }


    @Autowired
    private ApplicationConfig applicationConfig;
    @Test
    void test07() {
        System.out.println(applicationConfig.crateSecurity());
    }

    @Autowired
    private CollectionConfig config;
    @Test
    void test08() {
        System.out.println(config);
    }

    @Autowired
    private Group group;
    @Test
    void test09() {
        System.out.println(group);
    }
}
