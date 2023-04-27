package com.fanstudy.distributelock.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import com.fanstudy.distributelock.mapper.StockMapper;
import com.fanstudy.distributelock.service.StockService;

import lombok.RequiredArgsConstructor;

@Service
// @Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    // @Autowired
    private final StockMapper stockMapper;

    // private ReentrantLock lock = new ReentrantLock();

    // @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void deduct() {

        String uuid = UUID.randomUUID().toString();

        // 加锁 setnx
        while (Boolean.FALSE.equals(redisTemplate.opsForValue().setIfAbsent("lock", uuid, 30, TimeUnit.SECONDS))) {
            //重试;循环
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            // 1. 查询库存信息
            String stock = redisTemplate.opsForValue().get("stock");
            // 2. 判断库存是否充足
            if (stock != null && stock.length() != 0) {
                Integer st = Integer.valueOf(stock);
                if (st > 0) {
                    // 3.减库存
                    redisTemplate.opsForValue().set("stock", String.valueOf(--st));
                }
            }
        } finally {
            //防误删

            //使用lua脚本
            String script = """
                    if redis.call('get',KEYS[1]) == ARGV[1] then
                        return redis.call('del',KEYS[1]);
                    else
                        return 0;
                    end                 
                    """;

            Boolean lock = redisTemplate.execute(new DefaultRedisScript<>(script, Boolean.class), List.of("lock"), uuid);
//            if (StringUtils.equals(redisTemplate.opsForValue().get("lock"),uuid)){
//                redisTemplate.delete("lock");
//            }
        }

    }

    public void deduct1() {
        // lock.lock();
        try {

            stockMapper.updateStockCount("1001", 1);

            // Stock stock = stockMapper.selectOne(new QueryWrapper<Stock>().eq("product_code", "1001"));
            // if (stock != null && stock.getCount() > 0) {
            // stock.setCount(stock.getCount() - 1);
            // stockMapper.updateById(stock);
            // }
        } finally {
            // lock.unlock();
        }

    }
}
