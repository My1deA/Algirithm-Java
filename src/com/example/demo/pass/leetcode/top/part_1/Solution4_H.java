package com.example.demo.pass.leetcode.top.part_1;


/*
给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。

你可以假设nums1和nums2不会同时为空。

示例 1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0

示例 2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
 */

public class Solution4_H {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length+nums2.length)%2==0){
            return (getLocation(nums1,nums2,0,0,(nums1.length+nums2.length)/2)+ getLocation(nums1,nums2,0,0,(nums1.length+nums2.length)/2+1));
        }else{
            return getLocation(nums1,nums2,0,0,(nums1.length+nums2.length)/2);
        }

    }

    public int getLocation(int[] num1,int[] num2,int begin1,int begin2,int k){

        if(begin1==num1.length){
            return num2[begin2+k-1];
        }else if(begin2==num2.length){
            return num1[begin1+k-1];
        }else if(k==1){
            return num1[begin1] < num2[begin2] ? num1[begin1] : num2[begin2];
        }else{
            int mid1,mid2;
            if(begin1 + k/2 -1 >= num1.length){
                mid1=num1.length-1;
            }else{
                mid1=begin1 + k/2-1;
            }

            if(begin2 + k/2 -1 >= num2.length){
                mid2=num2.length-1;
            }else{
                mid2=begin2 + k/2 -1;
            }

            if(num1[mid1] >= num2[mid2]){
                return getLocation(num1,num2,begin1,mid2+1,k-(mid2-begin2+1));
            }else{
                return getLocation(num1,num2,mid1+1,begin2,k-(mid1-begin1+1));
            }



        }

    }

}
