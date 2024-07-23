package com.fanstudy.project.network;




import org.springframework.util.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1. 服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端监听8888端口....");
        //2. 等待连接
        Socket socket = serverSocket.accept();
        //3. 读取客户端发送的数据,通过Socket 得到输入流
        System.out.println("服务端开始接收图片");
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.copyToByteArray(bis);
        //4. 将得到bytes 数组，写入到指定的路径，就得到一个文件了
        String destFilePath = "D:\\myNotes\\ideaProjectWorkSpace\\git-demo\\Lession03-Project\\src\\a.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.flush();
        System.out.println("服务端接收图片成功");
        //5.向客户端回复"收到图片"通过socket 获取到输出流(字符)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("服务端：收到图片");
        bw.flush();//把内容刷新到数据通道
        socket.shutdownOutput();//设置写入结束标记
        //6.关闭其他资源
        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出.....");
    }
}
/**
 服务端监听8888端口....
 服务端开始接收图片
 服务端接收图片成功
 服务端退出.....
 **/
