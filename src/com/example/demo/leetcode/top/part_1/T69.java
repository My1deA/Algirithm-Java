package com.example.demo.leetcode.top.part_1;

public class T69 {
    public static int mySqrt(int x) {
        long left=0;
        long right=x/2+1;
        while(left<right){
            long mid=(left+right+1)/2;
            long sqrt=mid*mid;
            if(sqrt>x){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
