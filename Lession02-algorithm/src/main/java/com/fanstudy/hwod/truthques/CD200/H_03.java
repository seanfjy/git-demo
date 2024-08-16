package com.fanstudy.hwod.truthques.CD200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 电脑病毒感染 图论/单源最短路径(dijkstra)
 */
public class H_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        // 邻接表
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();

        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int u = in.nextInt(); // 出发点
            int v = in.nextInt(); // 目标点
            int w = in.nextInt(); // 耗时
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});

        }
        int src = in.nextInt();// 源点

        // 记录节点i是否找到最短路径
        boolean[] visited = new boolean[n + 1];
        // 记录源点到节点i的最短路径
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 到自身耗时为0
        dist[src] = 0;

        // 记录[节点编号,节点到原点耗时]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {src, dist[src]});
        // bfs
        while (!pq.isEmpty()) {

            int u = pq.poll()[0];
            if (visited[u])
                continue;

            visited[u] = true;

            if (graph.containsKey(u)) {
                for (int[] next : graph.get(u)) {
                    int v = next[0], w = next[1];
                    int newDist = dist[u] + w;
                    if (dist[v] > newDist) {
                        dist[v] = newDist;
                        pq.add(new int[] {v, dist[v]});
                    }
                }
            }

        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);

        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }
}
