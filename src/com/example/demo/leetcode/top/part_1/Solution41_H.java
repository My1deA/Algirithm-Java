package com.example.demo.leetcode.top.part_1;

// 41. 缺失的第一个正数
/*给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

        输入: [1,2,0]         输出: 3

        输入: [3,4,-1,1]      输出: 2

        输入: [7,8,9,11,12]   输出: 1*/
public class Solution41_H {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {

    }
}
