package com.example.demo.pass.sort;

//插入排序
public class InsertionSort {

    public static void main(String[] args) {
        int[] a=new int [] {5,8,2,4,9,3,1,0,6,7};
        printAns(a);
        insertionSort(a);
        printAns(a);
    }
    //取出当前元素与之前元素比较 如果前面元素大于目前，前面元素就后移 直到插入成功
    //warings : for(int j=i-1;j>=0;j--)  需要index t来记录下标以及a[i] index不可以省略 因为if else里无法赋值a[j]=t 因为a[j]始终比t大
    public static void insertionSort(int [] a){
        for(int i=0;i<a.length;i++){
            int t=a[i];
            int index=i;
            for(int j=i-1;j>=0;j--){
                if(a[j]>t){
                    a[j+1]=a[j];
                    index=j;
                }
            }
            a[index]=t;
        }
    }

    public static void printAns(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
