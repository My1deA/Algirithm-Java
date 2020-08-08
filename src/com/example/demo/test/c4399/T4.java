package com.example.demo.test.c4399;

/*段誉身具凌波微波，动无常则，若危若安，一次能走一级台阶或者两级台阶，他要爬一段30级的山路，问有多少种走法？分析如何计算，然后编程解答。
        进阶问题：当他轻功熟练度提升，一次最多可以走三级，那就结果有什么变化？后来走火入魔了，不能走一级，只能走二或三级，又有什么变化？

输入描述:
        输入一个数n（1<=n<=30），代表段誉要爬一段n级的山路。

输出描述:
        输出三个整数a,b,c（以空格相间）。其中a为段誉一次能走一级或两级台阶的走法；b为段誉一次能走一级、二级或三级台阶的走法；c为段誉一次能走二级或三级台阶的走法。

输入例子1:
        3

输出例子1:
        3 4 1*/

import java.util.Scanner;

public class T4 {

    private static int[] c1=new int[31];
    private static int[] c2=new int[31];
    private static int[] c3=new int[31];

    // 1 2
    public static int climb1(int n){
        if(n<=0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        if(c1[n]!=0)return c1[n];
        c1[n]=climb1(n-1)+climb1(n-2);
        return c1[n];
    }

    // 1 2 3
    public static int climb2(int n){
        if(n<=0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        if(n==3)return 4;
        if(c2[n]!=0)return c2[n];
        c2[n]=climb2(n-1)+climb2(n-2)+climb2(n-3);
        return c2[n];
    }


    //2 3
    public static int climb3(int n){
        if(n<=0)return 0;
        if(n==2)return 1;
        if(n==3)return 1;
        if(c3[n]!=0)return c3[n];
        c3[n]=climb3(n-2)+climb3(n-3);
        return c3[n];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(climb1(n)+" "+climb2(n)+" "+climb3(n));

    }
}
