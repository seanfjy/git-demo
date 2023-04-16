package com.fanstudy.distributelock.service.impl;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanstudy.distributelock.mapper.StockMapper;
import com.fanstudy.distributelock.service.StockService;

@Service
//@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    private ReentrantLock lock = new ReentrantLock();

//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void deduct() {

//        lock.lock();
        try {

            stockMapper.updateStockCount("1001",1);

//            Stock stock = stockMapper.selectOne(new QueryWrapper<Stock>().eq("product_code", "1001"));
//            if (stock != null && stock.getCount() > 0) {
//                stock.setCount(stock.getCount() - 1);
//                stockMapper.updateById(stock);
//            }
        } finally {
//            lock.unlock();
        }

    }
}
