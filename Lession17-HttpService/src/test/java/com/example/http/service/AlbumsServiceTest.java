package com.example.http.service;

import com.example.http.model.Albums;
import com.example.http.record.AlbumsRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AlbumsServiceTest {

    @Autowired
    private AlbumsService albumsService;
    @Test
    void testQuery() {
        Albums albums = albumsService.getById(5);
        System.out.println(albums);
    }

    @Test
    void testReturnRecord() {
        AlbumsRecord byIdReturnRecord = null;
        try {
            byIdReturnRecord = albumsService.getByIdReturnRecord(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(byIdReturnRecord);
    }
}