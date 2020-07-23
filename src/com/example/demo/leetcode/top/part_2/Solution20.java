package com.example.demo.leetcode.top.part_2;

import java.util.Stack;

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
