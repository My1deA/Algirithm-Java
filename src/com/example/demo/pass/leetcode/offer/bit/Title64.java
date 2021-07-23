package com.example.demo.pass.leetcode.offer.bit;


/* 剑指 Offer 64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 */


class Solution64 {
    public int sumNums(int n) {
        boolean flag= n>1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

public class Title64 {
    public static void main(String[] args) {
        Solution64 solution64=new Solution64();
        System.out.println(solution64.sumNums(3));
    }
}
