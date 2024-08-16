package com.fanstudy.hwod.truthques.CD100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 分配土地
 * 几何问题 - 坐标最大,最小 相差
 */
public class N_06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<Integer, Area> areaMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (num > 0) {
                    Area area = areaMap.getOrDefault(num, new Area());
                    area.minY = Math.min(area.minY, j);
                    area.maxY = Math.max(area.maxY, j);
                    area.minX = Math.min(area.minX, i);
                    area.maxX = Math.max(area.maxX, i);
                    areaMap.put(num, area);
                }
            }
        }
        int ans = 0;
        for (Integer key : areaMap.keySet()) {
            Area area = areaMap.get(key);
            ans = Math.max(ans, area.getArea());
        }

        System.out.println(ans);

    }

    static class Area {
        private int minX = Integer.MAX_VALUE;
        private int maxX = Integer.MIN_VALUE;

        private int minY = Integer.MAX_VALUE;

        private int maxY = Integer.MIN_VALUE;

        private int getArea() {
            return (maxX - minX + 1) * (maxY - minY + 1);
        }
    }
}
