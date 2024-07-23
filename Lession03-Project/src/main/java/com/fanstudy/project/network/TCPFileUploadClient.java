package com.fanstudy.project.network;

import org.springframework.util.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;

public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //1.客户端连接服务端8888，得到Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //2.创建读取磁盘文件的输入流
        System.out.println("客户端开始发送图片");
        String filePath = "C:\\Users\\seanfan\\OneDrive\\图片\\已保存的图片\\1248912.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes 就是filePath 对应的字节数组
        byte[] bytes = StreamUtils.copyToByteArray(bis);
        //3.通过socket 获取到输出流, 将bytes 数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();
        socket.shutdownOutput();//设置写入数据的结束标记
        System.out.println("客户端发送图片成功");
        //4.接收从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils 的方法，直接将inputStream 读取到的内容转成字符串
        String s = StreamUtils.copyToString(inputStream, Charset.defaultCharset());
        System.out.println(s);
        //5.关闭相关的流
        inputStream.close();
        bos.close();
        bis.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
/**
 客户端开始发送图片
 客户端发送图片成功
 服务端：收到图片

 客户端退出.....
 **/