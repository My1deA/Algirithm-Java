package com.example.demo.leetcode.offer.array;

/*  面试题53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

限制：0 <= 数组长度 <= 50000
 */
class Solution53_1 {
    //int left=0,right=nums.length-1; while (left<=right) right=mid-1; left=mid+1;
    public int search(int[] nums, int target) {
        if(nums.length == 0)return 0;
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if(target<nums[mid]){
                right=mid-1;
            }else if (target > nums[mid]){
                left=mid+1;
            }else {
                break;
            }
        }
        if(nums[mid]==target){
            int count=0;
            for(int i=mid;i>=0;i--){
                if (nums[i]!=target){
                    break;
                }
                count++;
            }
            for(int i=mid+1;i<nums.length;i++){
                if (nums[i]!=target){
                    break;
                }
                count++;
            }
            return count;
        }
        return 0;
    }
}

public class Title53_1 {
    public static void main(String[] args) {
        int[] nums = {2,2};
        Solution53_1 solution51_1=new Solution53_1();
        System.out.println(solution51_1.search(nums,2));
    }
}
