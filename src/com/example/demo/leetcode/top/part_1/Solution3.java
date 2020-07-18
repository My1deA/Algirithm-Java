package com.example.demo.leetcode.top.part_1;

import java.util.HashMap;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int ans=0,pre=0;
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                //得到上一个相同char的位置 防止出现abba 为3的问题
                pre=Math.max(pre,map.get(chars[i]));
            }
            //更新map
            map.put(chars[i],i+1);
            ans=Math.max(ans,map.get(chars[i])-pre);

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3=new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("abba"));
    }
}
