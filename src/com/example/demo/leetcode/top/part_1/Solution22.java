package com.example.demo.leetcode.top.part_1;


import java.util.ArrayList;
import java.util.List;

/* 22 括号生成
数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */
public class Solution22 {

    private static ArrayList<String> ans=new ArrayList<>();

    public static List<String> generateParenthesis(int n) {

        dfs("",n,n);
        return ans;
    }

    public static void dfs(String str, int left,int right){
       if(left==0 && right==0){
           ans.add(str);
           return;
       }
       //肯定是左括号先 用
       if(left>right){
           return;
       }

       if(left>0){
           dfs(str+"(",left-1,right);
       }

       if(right>0){
           dfs(str+")",left,right-1);
       }

    }



    public static void main(String[] args) {
        int n=3;
        generateParenthesis(n);
        for(int i=0;i<n;i++){
            System.out.println(ans.get(i));
        }
    }


}
