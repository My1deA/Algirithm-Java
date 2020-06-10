package com.example.demo.leetcode.offer.recursion;

/* 面试题10- I. 斐波那契数列
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
 
提示：
0 <= n <= 100
 */
public class Title10_1 {
    public static void main(String[] args) {
        Solution10_1 solution10_1=new Solution10_1();
        System.out.println(solution10_1.fib(5));
    }
}

class Solution10_1 {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int[] a=new int[n+1];
        a[0]=0;
        a[1]=1;
        for(int i=2;i<=n;i++){
            a[i]=(a[i-2]+a[i-1])%1000000007;
        }
        return a[n];
    }
}
