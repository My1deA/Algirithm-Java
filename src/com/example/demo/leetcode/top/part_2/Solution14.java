package com.example.demo.leetcode.top.part_2;


/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串""。

示例1:

输入: ["flower","flow","flight"]
输出: "fl"

示例2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

 */

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        String ans=strs[0];

        for(int i=1;i<strs.length;i++){
            int end=0;
            while(end < ans.length() && end < strs[i].length()){
                if(ans.charAt(end) != strs[i].charAt(end)){
                    break;
                }
                end++;
            }
            ans=ans.substring(0,end);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution14 solution14=new Solution14();
        String[] strs={"flower","flow","flight"};
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
