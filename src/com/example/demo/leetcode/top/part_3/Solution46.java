package com.example.demo.leetcode.top.part_3;

import java.util.ArrayList;
import java.util.List;

//46. 全排列
/*给定一个 没有重复 数字的序列，返回其所有可能的全排列。

        输入: [1,2,3]
        输出:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]*/

public class Solution46 {

    private static List<List<Integer>> ans=new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    public static void dfs(int[] nums,int k){
        if(k==nums.length-1){
            List<Integer> t=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i]+" ");
                t.add(nums[i]);
            }
            System.out.println();
            ans.add(t);
        }else{
            for(int i=k;i<nums.length;i++){
                swap(nums,k,i);
                dfs(nums,k+1);
                swap(nums,k,i);
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static void main(String[] args) {
        int [] nums={1};
        permute(nums);
    }


}






























