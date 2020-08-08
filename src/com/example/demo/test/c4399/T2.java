package com.example.demo.test.c4399;

/*有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。

输入描述:
        一行，一个正整数n（1<=n<=1000000）。

输出描述:
        输出答案。

输入例子1:
        5

输出例子1:
        4

例子说明1:
        出局的编号依次为3,1,5,2，最后留下的是4*/

import java.util.Scanner;

public class T2 {


    public static int cricle(int n){
        int[] a=new int[n+1];
        int index=0;
        for(int i=1;i<=n;i++){
            a[i]=i+1;
        }
        a[n]=1;

        int i=1;
        while(true){
            if(a[i]==i){
                break;
            }
            int pre=i;
            for(int j=0;j<2;j++){
                pre=i;
                i=a[i];
            }
            a[pre]=a[i];
            i=a[i];
        }

        return a[i];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(cricle(n));
    }
}
