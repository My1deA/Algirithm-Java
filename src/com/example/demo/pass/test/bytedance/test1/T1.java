package com.example.demo.pass.test.bytedance.test1;

import java.util.Scanner;

public class T1 {
    private static int[] v={1,4,16,64};
    private static int n=4;
    private static int m=1025;
    private static int[][] d=new int[4][1025];

    public static int dp(int N){

        //初始化 第一种
        for(int j=1;j<m;j++){
            if(j>v[0]){
                d[0][j]=j-v[0];
            }
        }
        //print();

        // 从第二种货币开始
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                d[i][j]=d[i-1][j];
                for(int k=0;k<=j/v[i];k++){
                    d[i][j]=Math.min(d[i][j],d[i-1][j-k*v[i]]+k);
                }
            }
        }

        return d[n-1][N];
    }


    public static void print(){
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                System.out.print(d[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        System.out.println(dp(1024-N));
    }


}
