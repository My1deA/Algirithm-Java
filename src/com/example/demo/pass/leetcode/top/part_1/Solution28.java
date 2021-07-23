package com.example.demo.pass.leetcode.top.part_1;


//实现 strStr()
/*实现strStr()函数。
给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1

输入: haystack = "hello", needle = "ll" 输出: 2

输入: haystack = "aaaaa", needle = "bba" 输出: -1*/


public class Solution28 {

    public static int strStr(String haystack, String needle) {
        if(haystack.equals("") && needle.equals(""))return 0;

        for(int i=0;i<haystack.length();i++){
            if(i+needle.length()<=haystack.length() && haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a", needle = "a";
        System.out.println(strStr(haystack,needle));
    }
}
