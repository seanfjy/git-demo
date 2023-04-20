package com.fanstudy.distributelock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Lession22DistributelockApplicationTests {


    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        String lock = redisTemplate.opsForValue().get("lock");
        System.out.println(lock);

    }

}
