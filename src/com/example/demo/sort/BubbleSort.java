package com.example.demo.sort;

//冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        bubbleSort(a);
        printAns(a);
    }
    //将两两相邻相互比较 将最大的先拍在后面
    // warings: a[j]>a[j+1] for(int j=0;j<a.length-1-i;j++)
    public static void bubbleSort(int [] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }

    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
