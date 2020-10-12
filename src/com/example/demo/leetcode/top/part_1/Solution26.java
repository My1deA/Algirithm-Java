package com.example.demo.leetcode.top.part_1;

import java.util.concurrent.ConcurrentHashMap;

public class Solution26 {
    public int AnsremoveDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = i + 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }
        return i + 1;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1,n=nums.length-1;
        int count = 1;
        if(nums.length==0 || nums.length==1){
            return nums.length;
        }

        while (true) {
            while(nums[i]==nums[j] && j<n){
                j++;
            }
            if(j-i==1 && (nums[i]!=nums[j])) {
                count++;
            }else if(j-i>1 &&  (nums[i]!=nums[j])){
                for(int k=0;k<=n-j;k++){
                    nums[k+i+1]=nums[k+j];
                }
                count++;
                n=n-(j-i)+1;
            }

            i++;
            j=i+1;
            //for(int k=0;k<=n;k++){
                //System.out.print(nums[k]+" ");
            //}
            //System.out.println();

            if(i==n){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

    }
}
