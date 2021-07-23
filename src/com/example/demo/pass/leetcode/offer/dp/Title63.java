package com.example.demo.pass.leetcode.offer.dp;

/* 面试题63. 股票的最大利润
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
class Solution63 {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int res=0,buy=prices[0];
        for(int i=0;i<prices.length;i++){
            if(buy>prices[i]){
                buy=prices[i];
            }
            res=Math.max(res,prices[i]-buy);
        }
        return res;
    }
}

public class Title63 {
    public static void main(String[] args) {
        int[] prices={7,6,4,3,1};
        Solution63 solution63=new Solution63();
        System.out.println(solution63.maxProfit(prices));
    }
}
