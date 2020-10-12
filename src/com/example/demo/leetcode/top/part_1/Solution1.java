package com.example.demo.leetcode.top.part_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//解题思路： 排序+双指针

/*给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。


        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]*/

public class Solution1 {


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }





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
