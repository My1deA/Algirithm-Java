package com.example.demo.ol;

import java.util.Scanner;

//quicksort
public class Title2 {

    public static void quickSort(int[] a,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        int t=a[left];
        while(i<j){
            while(i<j && t <= a[j] ){
                j--;
            }
            while(i<j && t >= a[i] ){
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

    public static  void printAns(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }

        //int[] a={25,84,21,47,15,27,68,35,20};
        quickSort(a,0,a.length-1);
        //printAns(a);
    }

}
