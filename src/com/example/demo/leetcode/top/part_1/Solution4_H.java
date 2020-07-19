package com.example.demo.leetcode.top.part_1;

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
