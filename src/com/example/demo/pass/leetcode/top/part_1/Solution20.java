package com.example.demo.pass.leetcode.top.part_1;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true

示例 2:
输入: "()[]{}"
输出: true

示例 3:
输入: "(]"
输出: false

示例 4:
输入: "([)]"
输出: false

示例 5:
输入: "{[]}"
输出: true
。
 */

public class Solution20 {

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    Character ch=stack.pop();
                    if(ch=='(' && s.charAt(i)==')' || ch=='[' && s.charAt(i)==']' || ch=='{' && s.charAt(i)=='}'){

                    }else{
                        return false;
                    }
                }else{
                    return false;
                }

            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution20 solution20=new Solution20();
        System.out.println(solution20.isValid("([)]"));
    }

}
