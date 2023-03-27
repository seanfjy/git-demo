package com.fanstudy.quickweb.controller;

import com.fanstudy.quickweb.vo.ArticleVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {


    /**
     * @Validated 表示要验证bean
     * @param articleVO
     * @return
     */
    // 发布新文章
    @PostMapping("article/add")
    public Map<String, Object> addArticle(@Validated(ArticleVO.AddGroup.class) @RequestBody ArticleVO articleVO, BindingResult bindingResult) {

        // 返回结果数组
        Map<String, Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            // for (FieldError fieldError : fieldErrors) {
            // map.put(fieldError.getField(),fieldError.getDefaultMessage());
            // }

            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError fieldError = fieldErrors.get(i);
                map.put(i + "-" + fieldError.getField(), fieldError.getDefaultMessage());
            }

        }
        return map;
    }
    // 编辑文章
    @PostMapping("article/edit")
    public Map<String, Object> editArticle(@Validated(ArticleVO.EditGroup.class) @RequestBody ArticleVO articleVO, BindingResult bindingResult) {

        // 返回结果数组
        Map<String, Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            // for (FieldError fieldError : fieldErrors) {
            // map.put(fieldError.getField(),fieldError.getDefaultMessage());
            // }

            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError fieldError = fieldErrors.get(i);
                map.put(i + "-" + fieldError.getField(), fieldError.getDefaultMessage());
            }

        }
        return map;
    }

}
