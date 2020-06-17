package com.example.demo.leetcode.offer.string;

/*  面试题58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
class Solution58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=n;i<s.length();i++){
            stringBuffer.append(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
}

public class Title58_2 {
    public static void main(String[] args) {
        String s="abcdefg";
        Solution58_2 solution58_2=new Solution58_2();
        System.out.println(solution58_2.reverseLeftWords(s,2));
    }
}