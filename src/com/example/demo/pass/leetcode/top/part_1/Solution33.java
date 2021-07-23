package com.example.demo.pass.leetcode.top.part_1;


// 33 搜索旋转排序数组
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是O(logn) 级别。

输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4

输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1

输入: nums = [5,6,0,1,2,3,4],
*/


public class Solution33 {

    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)return mid;

            //当mid < left的时候
            if(nums[mid]<nums[left]){
                // mid > target || mid right < target
                if(nums[mid] > target || nums[mid] < target && nums[right] < target ){
                    right=mid;
                // mid < target
                }else if(nums[mid] < target && nums[right] >= target){
                    left=mid;
                }
            }
            // mid > left
            else if(nums[mid]>nums[left]){
                // mid < target || mid left > target
                if(nums[mid]<target || nums[mid] > target && nums[left] > target ){
                    left=mid;
                // mid > target
                }else if(nums[mid] > target && nums[left] <= target){
                    right=mid;
                }
            }else if(nums[mid]==nums[left]){
                left=mid+1;
            }
            //System.out.println(left+" "+right);
        }

        return -1;
    }

    public static void main(String[] args) {

        int [] nums={5,6,0,1,2,3,4};
        System.out.println(search(nums,5));

    }
}
