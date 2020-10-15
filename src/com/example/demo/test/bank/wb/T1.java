package com.example.demo.test.bank.wb;

import java.util.Scanner;

public class T1 {

    public static void sort(int[] a,int left,int right){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }

    public static void quickSort(int[] a,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        int t=a[left];
        while(i<j){
            while(i<j && t<=a[j]){
                j--;
            }
            while(i<j && t>=a[i]){
                i++;
            }
            swap(a,i,j);
        }
        a[left]=a[i];
        a[i]=t;
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }

    public static void swap(int[] num,int i,int j){
        int t=num[i];
        num[i]=num[j];
        num[j]=t;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=scanner.nextInt();
        }
        sort(num,0,num.length-1);

        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }

    }
}
