package com.example.demo.leetcode.top.part_1;

import java.util.Arrays;

//解题思路： 排序+双指针
public class Solution1 {

    public static void main(String[] args) {
        //int[] nums = {2, 7, 11, 15};
        int[] nums = {3,3};
        Solution1 solution1=new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(nums,6)));
    }

    public int[] twoSum(int[] nums, int target) {

        int[] a=Arrays.copyOf(nums,nums.length);

        heapSort(a);
        //System.out.println(Arrays.toString(nums));

        //双指针
        int left=0;
        int right=nums.length-1;
        int[] ans=new int[2];

        while(left<right){
            if(a[left]+a[right] >target){
                right--;
            }else if(a[left]+a[right] < target){
                left++;
            }else{
                ans[0]=a[left];
                ans[1]=a[right];
                break;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(ans[0]==nums[i]){
                ans[0]=i;
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(ans[1]==nums[i] && ans[0]!=i){
                ans[1]=i;
                break;
            }
        }

        heapSort(ans);


        return ans;
    }




    public int[] heapSort(int[] a){
        for(int i=a.length/2-1;i>=0;i--){
            heapAdjust(a,i,a.length);
        }

        for(int i=0;i<a.length;i++){
            swap(a,0,a.length-i-1);
            heapAdjust(a,0,a.length-i-1);
        }
        return a;
    }


    public void heapAdjust(int[] a,int i,int n){
        int t=a[i];
        int index=i;
        for(int k=2*i+1;k<n;k=2*k+1){
            if(k+1<n && a[k]<a[k+1]){
                k++;
            }
            if(t<a[k]){
                a[index]=a[k];
                index=k;
            }else{
                break;
            }
        }
        a[index]=t;
    }

    public void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

}
