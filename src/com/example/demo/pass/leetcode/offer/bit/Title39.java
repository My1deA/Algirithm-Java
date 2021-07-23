package com.example.demo.pass.leetcode.offer.bit;

import java.util.Arrays;

/*  面试题39. 数组中出现次数超过一半的数字
数组中出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        /*for(int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int t=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
        System.out.println(Arrays.toString(nums));*/
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

public class Title39 {
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        int[] nums={3,2,3};
        System.out.println(solution.majorityElement(nums));
    }
}
