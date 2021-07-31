package com.example.demo.cur.hottop;

import java.util.ArrayList;
import java.util.List;

public class Hot22 {


    private  static List<String> list=new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        dfs(0,0,n,"");
        return list;
    }

    public static void dfs(int left,int right,int n,String str){
        //已经有 n个（ 和 n个）
        if(left==n && right==n){
            list.add(str);
            return;
        }

        // 左括号还有剩余
        if(left<n){
            dfs(left+1,right,n,str+"(");
        }
        //如果可以添加右括号
        if(left>right){
            dfs(left,right+1,n,str+")");
        }
        return;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }

}























