package com.fanstudy.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.fanstudy.mybatis.po.ArticlePO;
import com.fanstudy.mybatis.provider.ArticleSql;

//@Mapper
public interface ArticleMapper {

    @Results(id = "ComResult", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "summary", property = "summary"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "crate_time", property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
//    @Select("""
//            select id,user_id,title,summary,read_count,crate_time,update_time from article
//            where id = #{id}
//            """)
    @SelectProvider(value = ArticleSql.class,method = "selectObject")
    ArticlePO selectObjectById(Integer id);


//    @ResultMap(value = "ComResult")
    @ResultMap(value = "comNew")
    @SelectProvider(value = ArticleSql.class,method = "selectObject")
    ArticlePO selectObjectByIdNew(@Param("id") Integer id);
}
