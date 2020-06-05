package com.example.demo.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        quickSort(a,0,a.length-1);
        printAns(a);
    }
    //以一个数的基准来检索数据大小 先改变后面标志位 再改变前面标志位
    // warings:  while(a[j]>=t && i<j) j-- | while(a[i]<=t && i<j) i++
    public static void quickSort(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int i=left;
        int j=right;
        int t=a[left];
        while(i<j){
            //找出比基准小的数
            while(a[j]>=t && i<j){
                j--;
            }
            //找出比基准大的数
            while(a[i]<=t && i<j){
                i++;
            }
            swap(a,i,j);
        }
        a[left]=a[i];
        a[i]=t;

        printAns(a);
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
