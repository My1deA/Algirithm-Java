package com.example.demo.pass.leetcode.offer.more;

/*  面试题05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."

限制： 0 <= s 的长度 <= 10000
 */
class Solution05 {
    public String replaceSpace(String s) {
        if(s.length()==0)return "";
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                stringBuffer.append("%20");
            }else{
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}

public class Title05 {
    public static void main(String[] args) {
        String s="     ";
        Solution05 solution05=new Solution05();
        System.out.println(solution05.replaceSpace(s));
    }
}
