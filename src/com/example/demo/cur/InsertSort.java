package com.example.demo.cur;

public class InsertSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        insertSort(a);

    }


    public static void insertSort(int [] a){
        for(int i=0;i<a.length;i++){
            int index=i;
            int t=a[i];
            for(int j=i-1;j>=0;j--){
                if(a[j]>t){
                    a[j+1]=a[j];
                    index=j;
                }
            }
            a[index]=t;
            printAns(a);
        }


    }


    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
