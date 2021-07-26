package com.example.demo.cur.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        int [] temp=new int[a.length];
        printAns(a);
        mergeSort(a,0,a.length-1,temp);
        printAns(a);
    }


    public static void mergeSort(int [] a,int start,int end,int [] temp){
        if(start>=end)return;
        int mid=(start+end)/2;
        mergeSort(a,start,mid,temp);
        mergeSort(a,mid+1,end,temp);
        merge(a,start,mid,end,temp);
    }

    public static void merge(int[] a,int start,int mid,int end,int[] temp){
        int index=0;
        int left=start;
        int right=mid+1;
        while(left<=mid && right<=end){
            if(a[left]<=a[right]){
                temp[index++]=a[left++];
            }else{
                temp[index++]=a[right++];
            }
        }

        while(left<=mid){
            temp[index++]=a[left++];
        }
        while(right<=end){
            temp[index++]=a[right++];
        }

        index=0;
        for(int i=start;i<=end;i++){
            a[i]=temp[index++];
        }

    }

    public static void  printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
