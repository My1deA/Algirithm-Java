package com.example.demo.leetcode.top.part_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();


        quickSort(nums,0,nums.length-1);
        //System.out.println(Arrays.toString(nums));
        for(int k=0;k<nums.length-2;k++){

            if(k>0 && nums[k]==nums[k-1])continue;

            int i=k+1;
            int j=nums.length-1;
            while(i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if(sum > 0){
                    j--;
                }else if(sum < 0){
                    i++;
                }else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ans.add(list);
                    //跳过 相同的i j
                    while(i<j && nums[i]==nums[++i]);
                    while(i<j && nums[j]==nums[--j]);
                }
            }
            //跳过相同的 i j


        }
        return ans;
    }


    public void quickSort(int[] a,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        int t=a[i];

        while(i<j){
            while(j>i && t <= a[j]){
                j--;
            }
            while(j>i && t >= a[i]){
                i++;
            }
            swap(a,i,j);
        }
        a[left]=a[i];
        a[i]=t;

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

    }

    public void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1,-1, -4};
        Solution15 solution15=new Solution15();
        List<List<Integer>> lists=solution15.threeSum(nums);
        for(int i=0;i<lists.size();i++){
            for(int j=0;j<lists.get(i).size();j++){
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
