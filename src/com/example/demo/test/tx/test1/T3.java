package com.example.demo.test.tx.test1;

import java.util.Arrays;
import java.util.Scanner;

//逆序对 二分查找
public class T3 {


    public static int mergeSort(int[] a,int left,int right){
        if(left>=right) return 0;
        int[] b=new int[a.length];
        //注意 每次的mid
        int mid=(left+right)/2;
        int leftCount=mergeSort(a,left,mid);
        int rightCount=mergeSort(a,mid+1,right);
        int CurCount=merge(a,b,left,mid,right);

        return leftCount+rightCount+CurCount;
    }


    public static int merge(int[] a, int[] b, int left, int mid, int right) {
        int count = 0;
        int k = left;
        for (int i = left, j = mid + 1; i <= mid || j <= right; ) {
            if (i > mid) {
                b[k++] = a[j++];
            } else if (j > right) {
                b[k++] = a[i++];
            } else if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                count += mid + 1 - i;
            }
        }

        for(int i=left;i<=right;i++){
            a[i]=b[i];
        }
        return count;

    }


    public static void reverse(int[] a,int i,int j){
        for(int k=0;k<(i+j)/2;k++){
            int t=a[i+k];
            a[i+k]=a[j-k];
            a[j-k]=t;
        }
    }

    public static void main(String[] args) {
        //int[] a={7,5,6,4};
        //System.out.println(mergeSort(a,0, a.length-1));
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        n=(int)Math.pow(n,2);
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }

        int m=scanner.nextInt();
        int[] b=new int[m];
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            b[i]=scanner.nextInt();
            int[] t= Arrays.copyOf(a,a.length);
            for(int j=0;j<n;j=j=i*b[i]*2){

            }
        }




    }



}
