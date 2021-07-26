package com.example.demo.cur.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        selectSort(a);
        printAns(a);
    }

    public static void selectSort(int [] a){
        for(int i=0;i<a.length;i++){
            int index=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index=j;
                }
            }
            swap(a,i,index);

        }
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
