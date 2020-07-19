package com.example.demo.leetcode.top.part_1;

//https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
//      b   a   b   a   b
//  b   1       1       1   5
//  a       1       1       3
//  b           1       1   3
//  a               1       1
//  b                   1   1

public class Solution5 {
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        //开始
        int begin=0;
        int length=1;

        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }

        char[] chars=s.toCharArray();
        for(int j=1;j<chars.length;j++){
            for(int i=j-1; i>=0; i--){
                if(chars[i] == chars[j]){
                    if(j-i < 3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }

                }else{
                    dp[i][j]=false;
                }

                if( j-i+1 > length && dp[i][j]){
                    begin=i;
                    length=j-i+1;
                }
            }

        }


        return s.substring(begin,begin+length);
    }

    public static void main(String[] args) {
        Solution5 solution5=new Solution5();
        System.out.println(solution5.longestPalindrome("babab"));
    }
}
