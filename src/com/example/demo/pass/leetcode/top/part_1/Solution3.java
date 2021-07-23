package com.example.demo.pass.leetcode.top.part_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


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
