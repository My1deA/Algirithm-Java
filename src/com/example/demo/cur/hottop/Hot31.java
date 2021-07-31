package com.example.demo.cur.hottop;


public class Hot31 {

    // 123476541
    // 123514467
    public static void nextPermutation(int[] nums) {
        int i= nums.length-2;
        //从后往前遍历 找出 前<后的i
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=nums.length-1;
            while(j>=0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        //如果i=-1 直接排序
        bubbleSort(nums,i+1,nums.length-1);

    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    //冒泡排序 后面的元素从小到大排序 则是离原来数值较大的数
    public static void bubbleSort(int [] a,int start,int end){
        for(int i=start;i<=end;i++){
            for(int j=i+1;j<=end;j++){
                if(a[i]>a[j]){
                    swap(a,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        nextPermutation(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
