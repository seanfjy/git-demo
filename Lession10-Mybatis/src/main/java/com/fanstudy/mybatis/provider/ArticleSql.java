package com.fanstudy.mybatis.provider;

public class ArticleSql {

    public static String selectObject(){
        return """
                select id,user_id,title,summary,read_count,crate_time,update_time from article
            where id = #{id}
                """;
    }
}
