package com.fanstudy.project.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(9999); Socket socket = serverSocket.accept()) {
            System.out.println("我是服务端,正在监听9999端口,等待连接...");
            System.out.println("服务端socket=" + socket.getClass());

            try (InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream()) {
                byte[] buf = new byte[1024];
                int readLen;
                while ((readLen = inputStream.read(buf)) != -1) {
                    System.out.println(new String(buf, 0, readLen));
                }
                outputStream.write("服务端说:你好,客户端!".getBytes());
                socket.shutdownOutput();
            }

        }
        System.out.println("服务端退出....");
    }
}
