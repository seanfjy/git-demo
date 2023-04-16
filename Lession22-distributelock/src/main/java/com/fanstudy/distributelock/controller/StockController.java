package com.fanstudy.distributelock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanstudy.distributelock.service.StockService;

@RestController
public class StockController {


    @Autowired
    private StockService stockService;


    @GetMapping("/deduct")
    public void deduct(){
        stockService.deduct();

    }
}
