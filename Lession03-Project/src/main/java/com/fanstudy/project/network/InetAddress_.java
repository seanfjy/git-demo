package com.fanstudy.project.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);
        InetAddress host2 = InetAddress.getByName("seanfjy");
        System.out.println("host2 = " + host2);
        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println("host3 = " + host3);
        String host3Name = host3.getHostName();
        System.out.println("hostName = " + host3Name);
        String host3Address = host3.getHostAddress();
        System.out.println("host3Address = " + host3Address);

    }
}
