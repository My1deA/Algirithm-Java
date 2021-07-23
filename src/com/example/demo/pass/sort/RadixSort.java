package com.example.demo.pass.sort;

import java.util.Arrays;

//基数排序
public class RadixSort {

    public static void main(String[] args) {
        int[] a=new int [] {15,38,22,14,9,32,1,0,56,47};
        printAns(a);
        radixSort(a,10,2);// a[] 数组 size:多少个通 n:多少位
        printAns(a);
    }
    //将两两相邻相互比较 将最大的先拍在后面
    // warings: a[j]>a[j+1] for(int j=0;j<a.length-1-i;j++)
    public static void radixSort(int [] a,int size,int n){
        int[] temp=new int[a.length];
        int[] busket=new int[size];

        for(int i=0,rate=1;i<n;i++){
            //初始化为0
            Arrays.fill(busket,0);
            //复制桶
            System.arraycopy(a,0,temp,0,a.length);

            // 计算每个待排序数据的子关键字
            for(int j=0;j<a.length;j++){
                int key=(temp[j]/rate)%size;
                busket[key]++;
            }

            for(int j=1;j<size;j++){
                busket[j]+=busket[j-1];
            }

            //按子关键字排序
            for(int j=a.length-1;j>=0;j--){
                int key=(temp[j]/rate)%size;
                a[--busket[key]]=temp[j];
            }
            rate*=size;
            //printAns(a);

        }


    }

    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
