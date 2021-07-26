package com.example.demo.cur.sort;

import java.beans.beancontext.BeanContext;

public class HeapSort {

    public static void main(String[] args) {
        int [] a= new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        heapSort(a);
        printAns(a);
    }


    public static void heapSort(int[] a){
        //调整为大顶堆
        for(int i=a.length/2-1;i>=0;i--){
            heapAdjust(a,i,a.length);
        }

        for(int i=a.length-1;i>0;i--){
            //交换
            swap(a,0,i);
            printAns(a);
            //继续调整大顶堆
            heapAdjust(a,0,i);
        }




    }


    public static void heapAdjust(int[] a,int i,int length){
        int index=i;
        int t=a[i];
        for(int j=2*index+1; j<length;j=2*j+1){
            if(j+1<length && a[j]<a[j+1]){
                j++;
            }
            if(a[j]>t){
                a[index]=a[j];
                index=j;
            }else{
                break;
            }
        }
        a[index]=t;
    }


    public static void swap(int [] a,int i,int j){
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
