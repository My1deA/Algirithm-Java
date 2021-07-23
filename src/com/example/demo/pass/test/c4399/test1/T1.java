package com.example.demo.pass.test.c4399.test1;

/*
一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第n次落地时，共经过多少米？第n次反弹多高？（n<=10）

输入描述:
        一行，一个整数n (1<=n<=10)。

输出描述:
        输出两个浮点数ans1,ans2。ans1为第n次落地时，共经过的距离；ans2为第n次反弹的高度。答案应与标准答案误差小于1e-5。两个数间以空格相间。

输入例子1:
        1

输出例子1:
        100.000000 50.000000

输入例子2:
        10

输出例子2:
        299.609375 0.097656*/

import java.util.Scanner;

public class T1 {
    private static double[] h=new double[11];
    private static int n=0;

    public static double getHeight(){
        double sum=0;
        for(int i=1;i<=n;i++){
            if(i==1){
                sum+=h[i-1];
            }else{
                sum+=h[i-1]*2;
            }
            h[i]=h[i-1]/2;
        }

        return sum;
    }

    public static void main(String[] args) {
        h[0]=100.0;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        System.out.print(String.format("%.6f", getHeight()));
        System.out.print(" ");
        System.out.print(String.format("%.6f", h[n]));
        /*System.out.println(getHeight());
        System.out.println(h[n]);*/

    }

}














