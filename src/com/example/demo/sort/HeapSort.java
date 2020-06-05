package com.example.demo.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] a=new int [] {9,7,8,3,4,5,6};
        printAns(a);
        heapSort(a);
        printAns(a);
    }
    //堆排序 类似插入排序、希尔排序 需要先调整大堆 然后将最大的放到a[last]
    public static void heapSort(int [] a){
        //a.length/2-1 都是非叶子结点
        for(int i=a.length/2-1;i>=0;i--){
            adjustHeap(a,i,a.length);
        }

        for(int i=a.length-1;i>0;i--){
            //将最大换到后面
            swap(a,0,i);
            //因为
            adjustHeap(a,0,i);
        }
    }

    //调整大顶堆
    public static void adjustHeap(int [] a,int i,int length){
        int index=i;
        int t=a[index];
        //查询子节点
        for(int j=2*index+1;j<length;j=2*j+1){
            if(a[j]<a[j+1] && j+1<length){//如果右结点比左结点要大 就选右节点
                j++;
            }
            if(a[j]>t){//子节点比父节点大 将父节点赋值给子节点 并交换下标
                a[index]=a[j];
                index=j;
            }else{//部分大顶堆
                break;
            }
        }
        a[index]=t;
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
