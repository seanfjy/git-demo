package com.example.http.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

import com.example.http.model.Albums;
import com.example.http.record.AlbumsRecord;

@HttpExchange(url = "https://jsonplaceholder.typicode.com")
public interface AlbumsService {

    //查询专辑
    @HttpExchange(method = "GET",url ="/albums/{id}")
    Albums getById(@PathVariable Integer id);

    //Java Record
    @HttpExchange(method = "GET",url="/albums/{id}",contentType = MediaType.APPLICATION_JSON_VALUE)
    AlbumsRecord getByIdReturnRecord(@PathVariable Integer id);
}
