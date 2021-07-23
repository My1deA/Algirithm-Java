package com.example.demo.pass.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        selectionSort(a);
        printAns(a);
    }
    //使用index下标进行记录 求出最小的值 并和a[i]交换
    // warings: for(int j=i;j<a.length;j++)
    public static void selectionSort(int [] a){
        for(int i=0;i<a.length;i++){
            int index=i;
            for(int j=i;j<a.length;j++){
                if (a[index]>a[j]){
                    index=j;
                }
            }
            int t=a[i];
            a[i]=a[index];
            a[index]=t;
        }
    }

    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
