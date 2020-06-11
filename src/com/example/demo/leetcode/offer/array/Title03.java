package com.example.demo.leetcode.offer.array;

import java.util.HashMap;

/*  面试题03. 数组中重复的数字
找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

限制：
2 <= n <= 100000
 */
public class Title03 {
    public static void main(String[] args) {
        Solution03 solution03=new Solution03();
        int [] nums={2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution03.findRepeatNumber(nums));
    }
}

class Solution03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }else{
                map.put(nums[i],1);
            }
        }
        return 0;
    }
}