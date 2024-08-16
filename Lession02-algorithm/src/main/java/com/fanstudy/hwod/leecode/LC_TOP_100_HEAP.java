package com.fanstudy.hwod.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 堆
 */
public class LC_TOP_100_HEAP {

    /**
     * 215. 数组中的第K个最大元素
     */
    class LC_215 {
        public int findKthLargest(int[] nums, int k) {
            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }
            return quickSort(numList, k);
        }

        private int quickSort(List<Integer> numList, int k) {
            // 随机选择基数
            Random random = new Random();
            int privot = numList.get(random.nextInt(numList.size()));

            List<Integer> big = new ArrayList<>();
            List<Integer> small = new ArrayList<>();
            List<Integer> equal = new ArrayList<>();

            for (Integer num : numList) {
                if (num > privot) {
                    big.add(num);
                } else if (num < privot) {
                    small.add(num);
                } else {
                    equal.add(num);
                }
            }
            // 第K大元素在big中
            if (big.size() >= k) {
                return quickSort(big, k);
            }
            // 第K大元素在small中
            if (big.size() + equal.size() < k) {
                return quickSort(small, k - (big.size() + equal.size()));
            }
            // 第k大元素在equal中,返回privot
            return privot;
        }

    }

    /**
     * 347. 前 K 个高频元素
     */
    class LC_347 {
        public int[] topKFrequent(int[] nums, int k) {
            int[] ans = new int[k];
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int num : nums) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> heap = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                Integer key = entry.getKey();
                Integer count = entry.getValue();
                if (heap.size() == k) {
                    if (heap.peek()[1] < count) {
                        heap.poll();
                        heap.offer(new int[] {key, count});
                    }

                } else {
                    heap.offer(new int[] {key, count});
                }

            }
            for (int i = 0; i < k; i++) {
                ans[i] = heap.poll()[0];
            }

            return ans;

        }
    }

    /**
     * 295. 数据流的中位数
     */
    class MedianFinder {

        private PriorityQueue<Integer> l;
        private PriorityQueue<Integer> r;

        public MedianFinder() {
            l = new PriorityQueue<>((num1, num2) -> num2 - num1);
            r = new PriorityQueue<>((num1, num2) -> num1 - num2);
        }

        public void addNum(int num) {
            int lLen = l.size();
            int rLen = r.size();
            if (lLen == rLen) {
                if (r.isEmpty() || num <= r.peek()) {
                    l.add(num);
                } else {
                    l.add(r.poll());
                    r.add(num);
                }
            } else {
                if (l.peek() <= num) {
                    r.add(num);
                } else {
                    r.add(l.poll());
                    l.add(num);
                }
            }
        }

        public double findMedian() {
            int lLen = l.size();
            int rLen = r.size();
            if (lLen == rLen) {
                return (l.peek() + r.peek()) / 2.0;
            } else {
                return l.peek();
            }

        }
    }

}
