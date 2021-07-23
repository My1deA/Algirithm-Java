package com.example.demo.pass.algorithm.greedy;


//17964 水桶打水 （贪心）
/*问题描述
        　有n个人排队到r个水龙头去打水，他们装满水桶的时间t1、t2………..tn为整数且各不相等，应如何安排他们的打水顺序才能使他们总共花费的时间最少？

输入格式
          第一行n，r (n<=500,r<=75)
        　第二行为n个人打水所用的时间Ti (Ti<=100)；
输出格式
        最少的花费时间
样例输入
        3 2         4 2
        1 2 3       2 6 4 5
样例输出
        7           23（所有人的花费时间总和）
        */

import java.util.Arrays;

public class T_17964 {

    public static int getTime(int[] a,int[] b){
        //排序 小在前
        sort(a);
        System.out.println(Arrays.toString(a));
        int sum=0;

        for(int i=0;i<a.length;i++){
            //求出每个水喉 最小等待时间
            int min=b[0];
            int index=0;
            for(int j=0;j<b.length;j++){
                if(min>b[j]){
                    min=b[j];
                    index=j;
                }
            }
            b[index]+=a[i];
            sum+=b[index];

        }

        return sum;
    }

    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j< a.length-1;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n=4,m=2;
        int[] a={2,6,4,5};
        int[] b=new int[m];
        System.out.println(getTime(a,b));


    }
}
