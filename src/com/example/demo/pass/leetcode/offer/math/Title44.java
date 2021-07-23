package com.example.demo.pass.leetcode.offer.math;


/* 面试题44. 数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。

输入：n = 3
输出：3

输入：n = 11
输出：0
 
限制：0 <= n < 2^31
 */
public class Title44 {
}

class Solution44 {
    public int findNthDigit(int n) {
        int digit=1;
        long start=1;
        long count=9;
        while(n>count){
            n-=count;
            digit+=1;
            start*=10;
            count=digit*start*9;
        }
        //假设 n=15 9+5/2 因为 10 11 12 [0,5] 4,5是12位置
        long num=start+(n-1)/digit;//求出在 n 位的 num值
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}