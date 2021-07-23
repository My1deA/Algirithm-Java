package com.example.demo.pass.leetcode.top.part_1;

public class Solution50 {

    public static double myPow(double x, int n) {
        if(x==0)return 0;
        long b=n;
        if(b<0){
            x=1/x;
            b=-b;
        }
        double ans=1;
        while(b>0){
            if((b&1)==1) ans*=x;
            x*=x;
            b>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.1,3));
    }
}
