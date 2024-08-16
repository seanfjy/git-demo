package com.fanstudy.hwod.truthques.CD100;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 堆内存申请
 * 区间查找
 */
public class N_42 {
    static int malloc_size;
    static ArrayList<int[]> used = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        malloc_size = sc.nextInt();

        while (sc.hasNextInt()) {
            int start = sc.nextInt();
            int count = sc.nextInt();
            int end = start + count - 1;

            used.add(new int[]{start, end});
        }

        System.out.println(solution());
    }

    public static int solution() {
        // 申请内存大小非法
        if (malloc_size <= 0 || malloc_size > 100) {
            return -1;
        }

        // 总空间, 对应位置元素值标记为0表示未被分配，标记为1表示已分配
        int[] memory = new int[100];

        // 已分配的内存情况
        for (int[] range : used) {
            int start = range[0];
            int end = range[1];

            // 起始分配位置非法
            if (start < 0 || start >= 100) {
                return -1;
            }

            // 截止分配位置非法
            if (end < 0 || end >= 100) {
                return -1;
            }

            for (int i = start; i <= end; i++) {
                if (memory[i] != 0) {
                    // 存在内存占用重叠，则非法
                    return -1;
                } else {
                    // 标记已分配的内存
                    memory[i] = 1;
                }
            }
        }

        return getAns(memory);
    }

    private static int getAns(int[] memory) {
        // 记录最佳申请起始位置
        int ans = -1;
        // 记录最接近的申请内存的空闲内存块的大小
        int min_size = Integer.MAX_VALUE;

        int l = 0;
        while (l < 100) {
            // 找到空闲内存左边界 l（包含）
            while (l < 100 && memory[l] != 0) {
                l++;
            }

            // 2024.04.04 补充此逻辑，否则下面用例会有问题
            /*
             * 1
             * 0 100
             */
            if (l >= 100) {
                break;
            }

            // 找到空闲内存右边界 r（不包含）
            int r = l + 1;
            while (r < 100 && memory[r] == 0) {
                r++;
            }

            // 空闲内存大小
            int free_size = r - l;

            // 空闲内存 >= 申请内存 && 更接近申请内存大小
            if (free_size >= malloc_size && free_size < min_size) {
                min_size = free_size;
                ans = l;
            }

            // 找下一个空闲内存
            l = r + 1;
        }
        return ans;
    }
}