package com.example.demo.leetcode.offer.more;

import java.util.Arrays;

/* 剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
 */
class Solution66 {
    public int[] constructArr(int[] a) {
        int[] b=new int[a.length];
        //从左向右相乘
        for(int i=0,product=1;i<a.length;product*=a[i],i++){
            b[i]=product;
        }
        //从右向左相乘
        for(int i=a.length-1,product=1;i>=0;product*=a[i],i--){
            b[i]*=product;
        }
        return b;
    }
}

public class Title66 {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        Solution66 solution66=new Solution66();
        System.out.println(Arrays.toString(solution66.constructArr(a)));
    }
}
