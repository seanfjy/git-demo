package com.fanstudy.project.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 9999)) {
            System.out.println("客户端socket=" + socket.getClass());

            try (OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream()) {
                outputStream.write("客户端说:你好,服务端!".getBytes());
                socket.shutdownOutput();
                byte[] buf = new byte[1024];
                int readLen;
                while ((readLen = inputStream.read(buf)) != -1) {
                    System.out.println(new String(buf,0,readLen));
                }
            }
        }
        System.out.println("客户端退出...");

    }
}
