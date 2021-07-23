package com.example.demo.pass.leetcode.offer.more;



/* 剑指 Offer 51. 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

输入: [7,5,6,4]
输出: 5

限制：0 <= 数组长度 <= 50000
 */
class Solution51 {

    public int reversePairs(int[] nums) {
        if(nums.length==0)return 0;
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int[] nums,int left,int right){
        if(left>=right)return 0;
        int mid=(left+right)/2;
        int count1=mergeSort(nums,left,mid);
        int coutn2=mergeSort(nums,mid+1,right);
        return count1+coutn2+merge(nums,left,mid,right);
    }

    public int merge(int[] nums,int left,int mid,int right){
        int[] t= new int[right-left+1];
        int count=0;
        for(int k=0,i=left,j=mid+1;k<t.length;k++){
            // i > mid
            if(i>mid){
                t[k]=nums[j++];
            // j > right
            }else if(j>right){
                t[k]=nums[i++];
            }else if(nums[i]<=nums[j]){
                t[k]=nums[i++];
            }else{
                t[k]=nums[j++];
                count+=(mid-i+1);
            }
        }

        for (int i=0;i<t.length;i++){
            nums[left+i]=t[i];
        }
        return count;
    }

}

public class Title51 {
    public static void main(String[] args) {
        int[] nums={};
        Solution51 solution51=new Solution51();
        System.out.println(solution51.reversePairs(nums));

    }
}
