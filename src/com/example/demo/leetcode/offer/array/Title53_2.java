package com.example.demo.leetcode.offer.array;

/*  面试题53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例 1:
输入: [0,1,3]
输出: 2

示例 2:
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
 
限制：1 <= 数组长度 <= 10000
 */
public class Title53_2 {
    public static void main(String[] args) {
        int[] nums={0,1,2,3,4,5,6,7,9};
        Solution53_2 solution53_2=new Solution53_2();
        System.out.println(solution53_2.missingNumber(nums));
    }
}

class Solution53_2 {
    public int missingNumber(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid] == mid) i=mid+1;
            else j=mid-1;//前面出现不符合 下标的值
        }
        return i;
    }
}