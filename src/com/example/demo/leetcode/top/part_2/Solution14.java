package com.example.demo.leetcode.top.part_2;

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
