package com.example.demo.leetcode.top.part_1;

public class Solution53 {

    public static int maxSubArray2(int[] nums) {
        if(nums.length==1)return nums[0];
        int max=nums[0];
        int b=0;
        for(int i=0;i<nums.length;i++){
            if(b>0){
                b+=nums[i];
            }else{
                b=nums[i];
            }

            if(b>max){
                max=b;
            }
        }
        return max;
    }


    public static int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int b=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && b==0){
                b=nums[i];
            }else if(nums[i]+b<0){
                b=0;
            }else{
                b=b+nums[i];
            }

            if(b>max){
                max=b;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums={-2,-1,-3};
        System.out.println(maxSubArray2(nums));
    }

}
