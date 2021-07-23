package com.example.demo.pass.sort;

public class ShellSort {


    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        shellSort(a,2);//size 每组有多少个
        printAns(a);
    }
    //希尔排序一种插入排序 InsertSort
    // warring : for(int j=i-gap;j>=0;j=j-gap)
    public static void shellSort(int [] a,int size){
        int gap=a.length/size;//一开始分5组
        while(gap>0){
            for(int i=0;i<a.length;i++){
                int index=i;
                int t=a[index];
                for(int j=i-gap;j>=0;j=j-gap){
                    if(a[j]>t){
                        a[j+gap]=a[j];
                        index=j;
                    }
                }
                a[index]=t;
            }
            gap=gap/2;
        }
    }

    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
