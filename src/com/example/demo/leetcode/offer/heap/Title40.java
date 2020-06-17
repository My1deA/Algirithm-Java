package com.example.demo.leetcode.offer.heap;

import java.util.Arrays;


/*
面试题40. 最小的k个数

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]

输入：arr = [0,1,2,1], k = 1
输出：[0]

[0,0,1,2,4,2,2,3,1,4]
8
 */
class Solution {
    //堆排
    public int[] getLeastNumbers(int[] arr, int k) {

        for(int i=arr.length/2-1;i>=0;i--){     //for(int i=arr.length/2-1;i>=0;i--)
            heapAdjust(arr,i,arr.length);       // heapAdjust(arr,i,arr.length);
        }

        for(int i=0;i<arr.length;i++){
            swap(arr,0,arr.length-1-i);
            heapAdjust(arr,0,arr.length-1-i);
        }
        return Arrays.copyOfRange(arr,0,k);
    }

    public void heapAdjust(int[] arr,int i,int j){
        int index=i;
        int t=arr[index];
        for(int k=2*i+1;k<j;k=k*2+1){             //for(int k=2*i+1;k<j;k=k*2+1)
            if(k+1<j && arr[k]<arr[k+1]){       //if(k+1<j && arr[k]<arr[k+1])
                k=k+1;
            }
            if(t<arr[k]){
                arr[index]=arr[k];
                index=k;
            }else{
                break;
            }
        }
        arr[index]=t;
    }

    public void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}

public class Title40 {
    public static void main(String[] args) {
        int[] arr={0,0,1,2,4,2,2,3,1,4};
        /*Solution solution=new Solution();
        int[] ans=solution.getLeastNumbers(arr,10);
        System.out.println(Arrays.toString(ans));*/

        Solution2 solution=new Solution2();
        int[] ans=solution.getLeastNumbers(arr,10);
        System.out.println(Arrays.toString(ans));
    }
}



class Solution2 {
    //快排
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,0,arr.length-1);

        return Arrays.copyOfRange(arr,0,k);
    }

    public void quickSort(int[] arr,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        int t=arr[i];
        while(j>i){
            while (j>i && arr[j] >= t){//找出比 t 小的数
                j--;
            }
            while(j>i && arr[i] <= t){//找出比 t 大的数
                i++;
            }
            swap(arr,i,j);
        }
        //此时a[i]比t小
        arr[left]=arr[i];
        arr[i]=t;

        //继续快排
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }

    public void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}

