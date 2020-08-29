package com.example.demo.test.kedaxunfei;

import java.util.Scanner;

public class T1 {

    public static int maxGift(int[][] a,int m,int n){
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=a[i][j];
                }
                //如果可以回溯
                if(i>0 && j>0){
                    dp[i][j]=a[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
                }else{
                    if(i>0 && j==0){
                        dp[i][j]=a[i][j]+dp[i-1][j];
                    }else if(j>0 && i==0){
                        dp[i][j]=a[i][j]+dp[i][j-1];
                    }
                }

            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        String[] strings=str.split(",");
        int m=Integer.valueOf(strings[0]);
        int n=Integer.valueOf(strings[1]);
        int[][] a=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scanner.nextInt();
            }
        }
        System.out.println(maxGift(a,m,n));
    }
}
