package com.example.demo.leetcode.offer.divide;

import javax.print.attribute.standard.NumberUp;

/* 面试题42. 连续子数组的最大和
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 
提示：
1 <= arr.length <= 10^5
-100 <= arr[i] <= 100

 */
public class Title42 {
    public static void main(String[] args) {
        int[] arr={-3,4,-1,0};
        Solution42 solution42=new Solution42();
        System.out.println(solution42.maxSubArray(arr));
    }
}

class Solution42 {

    public int maxSubArray(int[] nums) {
        int[] a=new int[nums.length+1];
        a[0]=nums[0];
        int max=a[0];
        for(int i=1;i<nums.length;i++){
            if(a[i-1]+nums[i] > nums[i]){
                a[i]=a[i-1]+nums[i];
            }else{
                a[i]=nums[i];
            }
            //System.out.print(a[i]+" ");
            if(max<a[i]){
                max=a[i];
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int t=0,max=0;
        int[] a=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(t==0 && nums[i]>0){
                t+=nums[i];
            }else if((t+nums[i]) <= 0){
                t=0;
            }else{
                t+=nums[i];
            }
            //System.out.print(t+" ");
            if(max<t){
                max=t;
            }
        }
        return max;
    }
}