package com.example.demo.cur.hottop.hot20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hot17 {

    private static List<String> ans=new ArrayList<>();
    private static Map<Character,String> map=new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        initMap();
        String temp="";
        dfs(digits,temp,0);
        return ans;
    }

    public static void dfs(String digits,String temp,int k){
        if(k==digits.length()){
            if(!temp.equals("")){
                ans.add(temp);
            }
        }else{
            String str=map.get(digits.charAt(k));
            for(int i=0;i<str.length();i++){
                temp+=str.charAt(i);
                dfs(digits,temp,k+1);
                temp=temp.substring(0,temp.length()-1);
            }
        }
    }

    public static void initMap(){
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }

    public static void main(String[] args) {
        String digits="";
        List<String> list=letterCombinations(digits);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }
}
