package com.example.demo.pass.leetcode.offer.string;


/* 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
class Solution58_1 {
    public String reverseWords(String s) {
        String[] str=s.split(" ");
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=str.length-1;i>=0;i--){
            if(str[i].equals("")){
                continue;
            }
            stringBuffer.append(str[i]+" ");

        }
        return stringBuffer.toString().trim();
    }
}

public class Title58_1 {
    public static void main(String[] args) {
        String s="I am a   student. ";
        Solution58_1 solution58_1=new Solution58_1();
        System.out.println(solution58_1.reverseWords(s));
    }
}