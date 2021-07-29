package com.example.demo.cur.hottop.hot20;

public class Hot5 {

    public static String longestPalindrome(String s) {
        int n=s.length();
        int max=0;
        String sub=null;
        boolean[][] dp=new boolean[n+1][n+1];

        // dp: 构建矩阵的右上三角记录
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                // 自己本身就是回文子串
                if(i==j){
                    dp[i][j]=true;
                // 两个字符相邻并且相同
                }else if(j==i+1 &&  s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                // i+1里面的子字符串相同
                }else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                }
                // 更新子串
                if(max<=j-i+1 && dp[i][j]){
                    max=j-i+1;
                    sub=s.substring(i,j+1);
                }
            }
        }

        return sub;
    }

    public static void main(String[] args) {
        String s="ac";
        System.out.println(longestPalindrome(s));
    }

}
