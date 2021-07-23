package com.example.demo.pass.test.kedaxunfei;

import java.util.Scanner;

//选择排序
public class T2 {

    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            int index=i;
            int max=a[index];
            for(int j=i+1;j<a.length;j++){
                if(max>a[j]){
                    max=a[j];
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

    public static void printAns(int[] a){
        for (int i=0;i<a.length;i++){
            if(i!=a.length-1){
                System.out.print(a[i]+",");
            }else{
                System.out.print(a[i]);
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String str=scanner.next();
        String[] strings=str.split(",");
        int[] a=new int[strings.length];
        for(int i=0;i<strings.length;i++){
            a[i]=Integer.valueOf(strings[i]);
        }

        sort(a);
        printAns(a);
    }
}
