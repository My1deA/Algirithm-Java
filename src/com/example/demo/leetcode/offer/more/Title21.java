package com.example.demo.leetcode.offer.more;


import java.util.Arrays;

/* 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 */
class Solution21 {
    public int[] exchange(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(i<j && nums[j]%2==0){
                j--;
            }
            if(i<j && nums[i]%2==1){
                i++;
            }
            //swap(nums,i,j);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}

public class Title21 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        Solution21 solution21=new Solution21();
        System.out.println(Arrays.toString(solution21.exchange(nums)));
    }
}
