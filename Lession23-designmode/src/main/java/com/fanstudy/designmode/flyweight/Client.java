package com.fanstudy.designmode.flyweight;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        Website website = factory.getWebSiteCategory("新闻");
        website.use(new User("tom"));
        Website website2 = factory.getWebSiteCategory("博客");
        website2.use(new User("jack"));
        Website website3 = factory.getWebSiteCategory("博客");
        website3.use(new User("tom2"));

        int webSiteCount = factory.getWebSiteCount();
        System.out.println(webSiteCount);
    }
}
