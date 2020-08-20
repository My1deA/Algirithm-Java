package com.example.demo.leetcode.top.part_2;

import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母

2:abc 3:def 4:ghi 5:jkl 6:mno 7:pqrs 8:tuv 9:wxyz

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class Solution17 {

    List<String> ans=new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return ans;
        String strb=new String();
        dfs(digits,strb,0);
        return ans;
    }


    public void dfs(String digits,String strb,int k){
        if(digits.length()==k){
            ans.add(strb);
        }else{
            String str=trainform(digits.charAt(k++));
            for(int i=0;i<str.length();i++){
                strb=strb+str.charAt(i);
                dfs(digits,strb,k);
                strb=strb.substring(0,strb.length()-1);
            }

        }
    }

    public String trainform(char c){
        if(c=='2'){
            return "abc";
        }else if(c=='3'){
            return "def";
        }else if(c=='4'){
            return "ghi";
        }else if(c=='5'){
            return "jkl";
        }else if(c=='6'){
            return "mno";
        }else if(c=='7'){
            return "pqrs";
        }else if(c=='8'){
            return "tuv";
        }else if(c=='9'){
            return "wxyz";
        }

        return null;
    }

    public static void main(String[] args) {
        Solution17 solution17=new Solution17();
        List<String> ans=solution17.letterCombinations("");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

}
