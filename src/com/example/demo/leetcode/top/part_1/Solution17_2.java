package com.example.demo.leetcode.top.part_1;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

//17 电话号码字母组合
public class Solution17_2 {

    private static List<String> list=new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        StringBuffer stringBuffer=new StringBuffer();
        dfs(digits,stringBuffer,0);
        return list;
    }

    public static void dfs(String digits,StringBuffer stringBuffer,int k){
        if(k>=digits.length()){
            list.add(stringBuffer.toString());
        }else{
            String str=getStr(digits.charAt(k));
            for(int i=0;i<str.length();i++){
                //StringBuffer t=stringBuffer;
                stringBuffer.append(str.charAt(i));
                dfs(digits,stringBuffer,k+1);
                stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }

    public static String getStr(char c){
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
        return "";
    }

    public static void main(String[] args) {
        String str="23";
        List<String> list=letterCombinations(str);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
