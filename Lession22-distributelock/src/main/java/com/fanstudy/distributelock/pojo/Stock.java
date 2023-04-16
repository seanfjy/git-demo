package com.fanstudy.distributelock.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("db_stock")
@Data
public class Stock {
    private Long id;
    private String productCode;
    private String wareHouse;
    private Integer count;
}
