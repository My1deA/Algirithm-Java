package com.example.demo.pass.leetcode.offer.hash;

import java.util.*;

/* 面试题50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:
s = "abaccdeff"
返回 "b"

s = "" 返回 " "
 */
class Solution50 {
    public char firstUniqChar(String s) {
        char ans = ' ';
        ArrayList<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
                list.add(s.charAt(i));
            }
        }
        //遍历map Itertor<Map.Entry<xx,xx>> it = Map.EntrySet.itertor
        // while(it.hasnext()){ Map.Entry<xx,xx> = it.next()
        for(int i=0;i<list.size();i++){
            if(map.get(list.get(i))==1){
                ans=list.get(i);
                break;
            }
        }
        return ans;
    }
}

public class Title50 {
    public static void main(String[] args) {
        String str="abaccdeff";
        Solution50 solution50=new Solution50();
        System.out.println(solution50.firstUniqChar(str));
    }
}
