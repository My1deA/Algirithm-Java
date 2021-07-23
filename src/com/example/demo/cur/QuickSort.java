package com.example.demo.cur;

public class QuickSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        quickSort(a,0,a.length-1);
        printAns(a);
    }


    public static void quickSort(int[] a,int left,int right){
        if(left>=right)return;
        int t=a[left];
        int i=left;
        int j=right;

        while(i<j){
            //先找出小的
            while (a[j]>=t && j>=i){
                j--;
            }
            //找大的
            while(a[i]<=t && i<=j){
                i++;
            }
            swap(a,i,j);
        }
        a[left]=a[i];
        a[i]=t;

        quickSort(a,left,i);
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
