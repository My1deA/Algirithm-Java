package com.example.demo.pass.leetcode.offer.math;

/* 面试题49. 丑数
我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

说明:  1 是丑数。n 不超过1690。
 */
public class Title49 {
    public static void main(String[] args) {
        Solution49 solution49=new Solution49();
        System.out.println(solution49.nthUglyNumber(10));
    }
}

class Solution49 {

    public int nthUglyNumber(int n) {
        // 2    3    5
        int a=0,b=0,c=0;
        int[] dp=new int[n+1];
        // 1 2 3 5都是丑数
        dp[0]=1;
        for(int i=1;i<n;i++){
            int val1=dp[a]*2;
            int val2=dp[b]*3;
            int val3=dp[c]*5;
            //求出递增序列
            dp[i]=Math.min(val1,Math.min(val2,val3));
            //相同值也需要更新 如果更新a 没有更新b 下一次dp会出现相同值
            if(dp[i] == val1){
                a++;
            }
            if(dp[i] == val2){
                b++;
            }
            if(dp[i] == val3){
                c++;
            }
        }
        return dp[n-1];
    }








    /*public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }*/
}