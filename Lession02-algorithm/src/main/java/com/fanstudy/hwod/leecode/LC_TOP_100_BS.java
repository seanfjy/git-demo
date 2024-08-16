package com.fanstudy.hwod.leecode;

/**
 * 二分查找
 */
public class LC_TOP_100_BS {

    /**
     * 35. 搜索插入位置
     */
    class LC_35 {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

    /**
     * 74. 搜索二维矩阵
     */
    class LC_74 {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 初始化起始点为右上角
            int row = 0;
            int col = matrix[0].length - 1;
            while (row < matrix.length && col >= 0) {

                if (matrix[row][col] < target) {
                    row++;
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    return true;
                }
            }
            return false;

        }
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     */
    class LC_34 {
        public int[] searchRange(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (end + start) / 2;
                if (target > nums[mid]) {
                    start = mid + 1;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = end = mid;
                    while (start > 0) {
                        if (nums[start - 1] != target) {
                            break;
                        }
                        start--;
                    }
                    while (end < nums.length - 1) {
                        if (nums[end + 1] != target) {
                            break;
                        }
                        end++;
                    }
                    return new int[] {start, end};

                }
            }
            return new int[] {-1, -1};
        }
    }

    /**
     * 33. 搜索旋转排序数组
     */
    class LC_33 {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] <= nums[mid]) {
                    if (target > nums[mid] || target < nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (target > nums[right] || target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return -1;

        }
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     */
    class LC_153 {
        public int findMin(int[] nums) {

            int min = nums[0];
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[l] <= nums[mid]) {
                    // 左边有序
                    min = Math.min(min, nums[l]);
                    // 右边可能有最小值
                    l = mid + 1;
                } else {
                    // 右边有序
                    min = Math.min(min, nums[mid]);
                    // 左边可能有最小值
                    r = mid - 1;
                }

            }
            return min;
        }
    }

    /**
     * 4. 寻找两个正序数组的中位数
     */
    class TC_4 {

        // 暴力
        public double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int i = 0, j = 0, k = 0;
            int[] merge = new int[n1 + n2];
            while (i < n1 && j < n2) {
                if (nums1[i] <= nums2[j]) {
                    merge[k++] = nums1[i++];
                } else {
                    merge[k++] = nums2[j++];
                }
            }
            while (i < n1) {
                merge[k++] = nums1[i++];
            }
            while (j < n2) {
                merge[k++] = nums2[j++];
            }

            return (merge[(n1 + n2) / 2] + merge[(n1 + n2 - 1) / 2]) / 2.0;

        }

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int iMin = 0, iMax = m;
            while (iMin <= iMax) {

                int i = (iMin + iMax) >> 1;
                int j = (m + n + 1) / 2 - i;
                if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                    iMin = i + 1;
                } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                    iMax = i - 1;
                } else {
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }
                    int minRight = 0;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }

            }
            return 0.0;

        }
    }
}
