package com.example.demo.leetcode.top.part_1;

public class Solution7 {

    public int reverse(int x) {

        long sum=0;
        while(x!=0){
            sum=sum*10+x%10;
            x=x/10;
            if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                return 0;
            }
        }

        return (int)sum;
    }

    public static void main(String[] args) {
        Solution7 solution6=new Solution7();
        System.out.println(solution6.reverse(-321));

    }
}
