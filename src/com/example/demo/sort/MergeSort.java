package com.example.demo.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        int[] ans=new int [10];
        printAns(a);
        ans=mergeSort(a);
        printAns(ans);
    }
    //归并排序 需要多一个数组来存取结果
    // warings: for(int index=0,i=0,j=0;index<result.length;index++)  if(i>=left.length){result[index]=right[j++];}
    public static int[] mergeSort(int [] a){
        if(a.length<2)return a;
        int mid=a.length/2;
        int[] left= Arrays.copyOfRange(a,0,mid);
        int[] rigth=Arrays.copyOfRange(a,mid,a.length);
        left=mergeSort(left);
        rigth=mergeSort(rigth);
        return merge(left,rigth);
    }

    public static int[] merge(int[] left, int[] right){
        int[] result=new int [left.length+right.length];
        for(int index=0,i=0,j=0;index<result.length;index++){
            if(i>=left.length){
                result[index]=right[j++];
            }else if(j>=right.length){
                result[index]=left[i++];
            }else if(left[i]<right[j]){
                result[index]=left[i++];
            }else{
                result[index]=right[j++];
            }
        }
        return  result;
    }


    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
