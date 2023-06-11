package com.fanstudy.distributelock.zk;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKTest {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        try (ZooKeeper zooKeeper = new ZooKeeper("192.168.19.130:2181", 30000, event -> {
            Watcher.Event.KeeperState state = event.getState();
            if (Watcher.Event.KeeperState.SyncConnected.equals(state)&& Watcher.Event.EventType.None.equals(event.getType())) {

            System.out.println("获取链接了:"+event);
            countDownLatch.countDown();
            } else if (Watcher.Event.KeeperState.Closed.equals(state)) {

                System.out.println("关闭连接:"+event);
            }else {
                System.out.println("节点时间.....");
            }
        })) {

            countDownLatch.await();
            System.out.println("一顿操作");
            //节点新增:永久 临时 永久序列 临时序列
            zooKeeper.create("/fan/test1","hello zookeeper".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            zooKeeper.create("/fan/test2","hello zookeeper".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//            zooKeeper.create("/fan/test3","hello zookeeper".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
//            zooKeeper.create("/fan/test4","hello zookeeper".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            Stat exists = zooKeeper.exists("/fan", true);
            if (exists != null){
                System.out.println("当前节点存在");
            }else {
                System.out.println("当前节点不存在");
            }

            // 获取内容
            byte[] data = zooKeeper.getData("/fan", true, exists);
            System.out.println("当前节点的内容:"+new String(data));

            //获取子节点
            List<String> children = zooKeeper.getChildren("/fan", true);
            System.out.println(children);

            //更新 版本号必须和当前节点版本号一致,才可更新,或指定-1,不关心版本号
            zooKeeper.setData("/fan","aaawa".getBytes(),-1);

            zooKeeper.delete("/fan/test1",-1);

            System.in.read();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
