package com.example.demo.pass.test.sz;

import java.util.Scanner;

//贪心
public class T3 {

    public static int maxCoins (int[] piles) {
        // write code here
        int i=0;
        int j=piles.length-1;
        int sum=0;
        while(i<j){
            sum+=piles[j-1];
            j=j-2;
            i++;
        }
        return sum;
    }


    public static void quickSort(int[] a,int left,int right){
        if(left>=right)return;
        int i=left;
        int j=right;
        int t=a[left];
        while(i<j){
            while(i<j && a[j]>=t){
                j--;
            }
            while(i<j && a[i]<=t){
                i++;
            }
            swap(a,i,j);
        }
        a[left]=a[i];
        a[i]=t;

        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void printAns(int[] a){
        for(int i=0;i< a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    // [2,4,1,2,7,8]
    // [2,4,1] [1,1,6,7,8,10,10,11,13,14,14,14]
    // [1,3,4,5,2,7,8,9,0]
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] strs=str.substring(1,str.length()-1).split(",");
        int[] piles=new int[strs.length];
        for(int i=0;i<strs.length;i++){
            piles[i]=Integer.valueOf(strs[i]);
        }
        quickSort(piles,0,piles.length-1);
        printAns(piles);
        System.out.println(maxCoins(piles));
    }
}
