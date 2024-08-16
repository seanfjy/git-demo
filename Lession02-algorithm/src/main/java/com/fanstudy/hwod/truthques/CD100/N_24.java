package com.fanstudy.hwod.truthques.CD100;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 剩余银饰的重量
 * 优先队列
 */
public class N_24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            pq.offer(in.nextInt());
        }
        while (pq.size() >= 3) {
            int z = pq.poll();
            int y = pq.poll();
            int x = pq.poll();

            int leave = Math.abs((z - y) - (y - x));
            if (leave != 0) {
                pq.offer(leave);

            }
        }
        if (pq.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(pq.peek());
        }

    }
}
