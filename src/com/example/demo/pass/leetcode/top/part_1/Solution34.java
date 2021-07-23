package com.example.demo.pass.leetcode.top.part_1;

//34. 在排序数组中查找元素的第一个和最后一个位置
/*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是O(log n) 级别。如果数组中不存在目标值，返回[-1, -1]。

输入: nums = [5,7,7,8,8,10], target = 8   输出: [3,4]

输入: nums = [5,7,7,8,8,10], target = 6   输出: [-1,-1]*/

public class Solution34 {

    public static int[] searchRange(int[] nums, int target) {
        int [] ans={-1,-1};
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                int start=mid,end=mid;
                while(nums[start]==target && start>0){
                    start--;
                }
                if(nums[start]==target){
                    ans[0]=start;
                }else{
                    ans[0]=start+1;
                }


                while(nums[end]==target && end<nums.length-1){
                    end++;
                }
                if(nums[end]==target){
                    ans[1]=end;
                }else{
                    ans[1]=end-1;
                }

                break;
            }

            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        int [] ans=searchRange(nums,10);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
