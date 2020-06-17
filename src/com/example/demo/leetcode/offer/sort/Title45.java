package com.example.demo.leetcode.offer.sort;

/*面试题45. 把数组排成最小的数
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

输入: [10,2]
输出: "102"

输入: [3,30,34,5,9]
输出: "3033459"

输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
class Solution {
    public String minNumber(int[] nums) {
        String [] strings=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strings[i]=String.valueOf(nums[i]);
        }
        sort(strings,0,nums.length-1);
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<nums.length;i++){
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }

    public void sort(String [] strings,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        String t=strings[left];
        while(j>i){
            //后面+标准 >= 标准+后面 则继续寻找较小值
            while(j>i && (strings[j]+t).compareTo(t+strings[j])>=0 ){
                j--;
            }
            //前面+标准 <= 标准+前面 则继续寻找较大值
            while(j>i && (strings[i]+t).compareTo(t+strings[i])<=0){
                i++;
            }
            swap(strings,i,j);
        }
        strings[left]=strings[i];
        strings[i]=t;

        sort(strings,left,i-1);
        sort(strings,i+1,right);
    }

    public void swap(String [] strings,int i,int j){
        String t=strings[i];
        strings[i]=strings[j];
        strings[j]=t;
    }

    public void traverse(int[] nums,int k){
        if(k>=nums.length-1){
            for(int i=0;i<nums.length;i++){
                System.out.print(nums[i]);
            }
            System.out.println();
        }else{
            for(int i=k;i<nums.length;i++){
                swap(nums,k,i);
                traverse(nums,k+1);
                swap(nums,k,i);
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}


public class Title45 {
    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};
        Solution solution=new Solution();
        //solution.traverse(nums,0);
        System.out.println(solution.minNumber(nums));
    }
}