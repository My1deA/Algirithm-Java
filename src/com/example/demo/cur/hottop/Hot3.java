package com.example.demo.cur.hottop;


import java.util.HashMap;
import java.util.Map;

public class Hot3 {

    public static int lengthOfLongestSubstring(String s) {
        int length=0;//最长无重复字符串
        int left=0;//子串左界限
        Map<Character,Integer> map=new HashMap<>();
        // i 代表 子串右界限
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                //比较左界限和当前字符的下标大小 求出最大下标 实现界限左移
                // map.get(s.charAt(i))+1 是后面已经有原来的字符 所以下标直接+1跳过前面相同字符
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            //更新下标
            map.put(s.charAt(i),i);
            // i-left+1 是当前子串长度
            length=Math.max(length,i-left+1);
        }
        return length;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
