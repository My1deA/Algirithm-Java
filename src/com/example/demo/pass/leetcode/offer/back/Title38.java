package com.example.demo.pass.leetcode.offer.back;

import java.util.ArrayList;
import java.util.HashSet;
/* 面试题38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。

示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

 */

class Solution38 {
    private ArrayList<String> list= new ArrayList<>();
    private String[] strings;

    public String[] permutation(String s) {
        char[] chars=s.toCharArray();
        recursion(chars,0);
        strings=new String[list.size()];
        for(int i=0;i<list.size();i++){
            strings[i]=list.get(i);
        }
        return strings;
    }

    public void recursion(char[] chars,int k){
        if(k==chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            HashSet<Character> set = new HashSet<>();
            for(int i=k;i<chars.length;i++){
                if(set.contains(chars[i]))continue;
                set.add(chars[i]);
                swap(chars,k,i);
                recursion(chars,k+1);
                swap(chars,k,i);
            }
        }
    }

    public void swap(char[] chars,int i,int j){
        char t=chars[i];
        chars[i]=chars[j];
        chars[j]=t;
    }
}

public class Title38 {
    public static void main(String[] args) {
        String s="aab";
        Solution38 solution38=new Solution38();
        String[] strings=solution38.permutation(s);
        for(int i=0;i<strings.length;i++){
            System.out.print(strings[i]+" ");
        }
    }
}
