package com.fanstudy.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fanstudy.jdbc.model.ArticlePO;

@SpringBootTest
class Lession09JdbcTplApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test01() {
        String sql = """
                select count(*) as ct from article;
                """;
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("记录行数count = "+aLong);
    }

    @Test
    void test02() {
        String sql = """
                select * from article
                where id = ?;
                """;
        ArticlePO articlePO = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ArticlePO.class), 1);
        System.out.println("文章数据:"+articlePO);

    }

    @Test
    void testUpdate() {
        String sql = "update article set title = ?  where id = ?";
        int rows = jdbcTemplate.update(sql, "GO语言基础", 2);
        System.out.println(rows);
    }
}
