package com.example.demo.cur;

public class BubbleSort {

    public static void main(String[] args) {
        int [] a= new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        bubbleSort(a);
        printAns(a);

    }


    public static void bubbleSort(int [] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
            printAns(a);
        }
    }


    public static void  printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
}
