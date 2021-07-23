package com.example.demo.pass.leetcode.offer.more;


/* 剑指 Offer 57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]。
 */

import java.util.Arrays;

class Solution57_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        int left=0,right=nums.length-1,t;
        while(left<right){
            t=nums[left]+nums[right];
            if(t>target){
                right--;
            }else if(t<target){
                left++;
            }else{
                ans[0]=nums[left];
                ans[1]=nums[right];
                break;
            }
        }

        return ans;
    }
}

public class Title57_1 {
    public static void main(String[] args) {
        int[] nums = {1};
        Solution57_1 solution57=new Solution57_1();
        System.out.println(Arrays.toString(solution57.twoSum(nums,1)));
    }
}
