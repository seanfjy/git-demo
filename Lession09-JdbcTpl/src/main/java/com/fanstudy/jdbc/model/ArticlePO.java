package com.fanstudy.jdbc.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticlePO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime crateTime;
    private LocalDateTime updateTime;

}
