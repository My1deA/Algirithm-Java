package com.example.demo.leetcode.top.part_2;

import java.util.ArrayList;
import java.util.List;

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
