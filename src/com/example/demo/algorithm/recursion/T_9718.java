package com.example.demo.algorithm.recursion;


// 9718 整数因子分解 数学 recursion
/*
Description
        大于1的正整数 n 都可以分解为 n = x1 * x2 * ... * xm， 每个xi为大于1的因子，即1<xi<=n 。
        例如：当n=12时，共有8种不同的分解式：
        12 = 12
        12 = 6*2
        12 = 4*3
        12 = 3*4
        12 = 3*2*2
        12 = 2*6
        12 = 2*3*2
        12 = 2*2*3
        对于给定正整数n，计算n共有多少种不同的分解式。

        输入格式
        第一行一个正整数n （1<=n<=1000000）

        输出格式
        不同的分解式数目

        输入样例                输出样例
        12                      8

        提示
        此题因子讲顺序的.第一个因子可能是2~n之间的数.比如对12而言,第一个因子可能是2,3,4,6,12.

        将第一个因子为2的分解个数,加上第一个因子为3的分解个数,...,直至加到第一个因子为12的分解个数.而第一个因子为2的分解个数又是多少呢?是6(因为12/2=6)的分解个数,递归求解!
        可用“递归”和“备忘录方法”两种方法分别求解，并测试一下效率。

        递归实现整数因子分解的计数。假设对正整数n的因子分解计数为solve(n)。
        1）当n=1时，计数加1。
        2）当n>1时，对n的每个因子i，计算solve(n/i)。
*/

public class T_9718 {

    public static int solve(int n){
        int num=0;
        if(n==1) return 1;
        //  遍历 2-n
        for(int i=2;i<=n;i++){
            //如果能整除 就递归求解
            if(n%i==0)num+=solve(n/i);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(solve(12));
    }
}
