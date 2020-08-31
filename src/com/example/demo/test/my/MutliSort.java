package com.example.demo.test.my;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

//多线程排序
public class MutliSort extends RecursiveAction {
    private int[] a;
    private int start;
    private int end;
    private int threadHold=2;

    public MutliSort(int[] a,int start,int end){
        this.a=a;
        this.start=start;
        this.end=end;
    }

    @Override
    protected void compute() {
        if((end-start)<=threadHold){
            mergeSort(a,start,end);
        }else{
            int mid = (start + end)/2;
            MutliSort leftTask=new MutliSort(a,start,mid);
            MutliSort rightTask=new MutliSort(a,mid+1,end);

            leftTask.fork();
            rightTask.fork();

            leftTask.join();
            rightTask.join();

            merge(a,start,mid,end);

        }
    }

    private static void mergeSort(int[] a,int left,int right){
        if(left>=right)return;
        int mid = (left+right)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    private static void merge(int[] a,int left,int mid,int right){
        int[] t=new int[a.length];
        int i=left;
        int j=mid+1;
        for(int k=left;k<=right;k++){
            if(i>mid){
                t[k]=a[j++];
            }else if(j>right){
                t[k]=a[i++];
            }else if(a[i]<=a[j]){
                t[k]=a[i++];
            }else{
                t[k]=a[j++];
            }
        }
        for(int k=left;k<=right;k++){
            a[k]=t[k];
        }
    }


    public static void main(String[] args) {
        int a[]={5,7,4,6,9,1,3,2,8,0};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MutliSort task=new MutliSort(a,0,a.length-1);
        forkJoinPool.execute(task);//执行任务
        try {
            forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);//阻塞当前线程直到pool中的任务都完成了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //mergeSort(a,0,a.length-1);


        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }


    }


}
