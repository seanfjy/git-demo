package com.fanstudy.mybatis;

import com.fanstudy.mybatis.mapper.ArticleMapper;
import com.fanstudy.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lession10MybatisApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void selectTest() {
        ArticlePO articlePO = articleMapper.selectObjectById(1);
        System.out.println(articlePO);
    }
    @Test
    void selectTestNew() {
        ArticlePO articlePO = articleMapper.selectObjectByIdNew(2);
        System.out.println(articlePO);
    }


}
