package com.example.demo.leetcode.top.part_1;

public class T55 {

    public static boolean canJump(int[] nums) {
        int rearch=0;
        for(int i=0;i<nums.length;i++){
            if(rearch<i)return false;
            rearch=Math.max(rearch,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }

}
