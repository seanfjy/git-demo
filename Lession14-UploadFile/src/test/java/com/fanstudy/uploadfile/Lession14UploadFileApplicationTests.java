package com.fanstudy.uploadfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@EnableAutoConfiguration
@Slf4j
class Lession14UploadFileApplicationTests {

    @Autowired
    private DefaultFastFileStorageClient storageClient;
    @Test
    void contextLoads() {
      log.info("storageClient:{}",storageClient);

    }
    @Test
    void testUpload() throws FileNotFoundException {
        // 要上传的文件
        File file = new File("D:\\picture\\test\\pic001.jpg");
        // 上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
        StorePath storePath = storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }


}
