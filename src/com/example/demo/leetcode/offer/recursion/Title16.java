package com.example.demo.leetcode.offer.recursion;

/* 面试题16. 数值的整数次方
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
示例 1:
输入: 2.00000, 10
输出: 1024.00000

示例 2:
输入: 2.10000, 3
输出: 9.26100

示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Title16 {
    public static void main(String[] args) {
        Solution16 solution16=new Solution16();
        System.out.println(solution16.myPow2(2,-2));
    }
}

class Solution16 {
    public double myPow(double x, int n) {
        if(x==0)return 0;
        long b=n;
        double ans=1;
        if(b<0){
            b=-b;
            x=1/x;
        }
        while(b>0){
            if((b&1)==1){
                ans*=x;
            }
            x*=x;
            b>>=1;
        }
        return ans;
    }

    public double myPow2(double x, int n) {
        double sum=1;
        if(n>0){
            for(int i=0;i<n;i++){
                sum*=x;
            }
        }else if (n < 0){
            for(int i=0;i<Math.abs(n);i++){
                sum*=1/x;
            }
        }else {
            return 1;
        }
        return sum;
    }
}