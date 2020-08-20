package com.example.demo.leetcode.top.part_1;


/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例1:
输入: 123
输出: 321

示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
 */
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
