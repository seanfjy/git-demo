package com.fanstudy.mvc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @PostMapping("/add")
    public String addArticle(){
        return "发布新文章";
    }

    @PostMapping("/edit")
    public String editArticle(){
        return "修改文章";
    }

    @DeleteMapping("/remove")
    public String removeArticle(){
        return "删除文章";
    }

    @GetMapping("/query")
    public String queryArticle(){
        return "查询文章";
    }
}
