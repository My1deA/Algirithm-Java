package com.example.demo.leetcode.offer.recursion;


/*  面试题10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
示例 1：
输入：n = 2
输出：2

示例 2：
输入：n = 7
输出：21
提示：0 <= n <= 100
 */
public class Title10_2 {
    public static void main(String[] args) {
        Solution10_2 solution10_2=new Solution10_2();
        System.out.println(solution10_2.numWays(48));
    }
}

class Solution10_2 {

    public int numWays(int n) {
        int[] ans=new int[n+1];
        return climb(0,n,ans);
    }

    public int climb(int i,int n,int[] ans){
        if(i>n)return 0;
        if(i==n)return 1;
        if(ans[i]>0)return ans[i];
        ans[i]=climb(i+1,n,ans)%1000000007+climb(i+2,n,ans)%1000000007;
        return ans[i]%1000000007;
    }
}