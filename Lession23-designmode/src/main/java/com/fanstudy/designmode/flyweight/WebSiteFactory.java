package com.fanstudy.designmode.flyweight;

import java.util.HashMap;

//网站工厂类,根据需要返回一个网站
public class WebSiteFactory {
    private HashMap<String,ConcreteWebSite> pool = new HashMap<>();

    public Website getWebSiteCategory(String type){
        if (!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }

        return pool.get(type);
    }

    public int getWebSiteCount(){
        return pool.size();
    }
}
