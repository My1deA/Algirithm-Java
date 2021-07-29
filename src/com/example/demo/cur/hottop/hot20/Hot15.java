package com.example.demo.cur.hottop.hot20;

import java.util.ArrayList;
import java.util.List;

public class Hot15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        // 双指针滑动 i：左指针 k：中间  j：右指针
        quickSort(nums,0,nums.length-1);

        for(int i=0;i<nums.length-2;i++){
            // 获取最先的 nums[i]
            if( i > 0  && nums[i]==nums[i-1] ){
                continue;
            }
            // 右下标
            int j=nums.length-1;
            // 中间
            int k=i+1;
            while(k<j){
                int t=nums[i]+nums[j]+nums[k];
                if(t==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(nums[j]);
                    ans.add(list);
                    while(k<j && nums[k]==nums[++k]);
                    while(k<j && nums[j]==nums[--j]);
                }else if(t<0){
                    while(k<j && nums[k]==nums[++k]);
                }else if(t>0){
                    while(k<j && nums[j]==nums[--j]);
                }
            }
        }
        return ans;
    }

    public static void quickSort(int [] a,int left,int right){
        if(left>=right) return;
        int t=a[left];
        int i=left;
        int j=right;
        while (i<j){
            //找出最小移到左边
            while(i<j && a[j]>=t) j--;
            //找出最大的移到右边
            while(i<j && a[i]<=t) i++;
            swap(a,i,j);
        }
        // i 交换后已经是比较小 所以放到原本的left位置
        a[left]=a[i];
        a[i]=t;

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }



    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list=threeSum(nums);

        for(int i=0;i<list.size();i++){
            List<Integer> integerList=list.get(i);
            for(int j=0;j< integerList.size();j++){
                System.out.print(integerList.get(j)+" ");
            }
            System.out.println();
        }
    }

}


















