package com.example.demo.leetcode.top.part_1;

import java.lang.reflect.Array;
import java.util.*;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        Map<String,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String t=String.valueOf(ch);
            if(!map.containsKey(t)){
                map.put(t,new ArrayList<String>());
            }
            map.get(t).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        char[] ch={'a','b','c'};
        System.out.println(String.valueOf(ch));
    }
}
