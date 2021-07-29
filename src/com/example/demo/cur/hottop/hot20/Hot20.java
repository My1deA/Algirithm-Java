package com.example.demo.cur.hottop.hot20;

import java.util.Stack;

public class Hot20 {



    public static boolean isValid(String s) {
        if(s.length()%2==1)return false;
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);

            if(ch==')' || ch == '}' || ch == ']' ){
                // 栈不为空则获取栈顶元素
                Character t='a';
                if(!stack.empty()){
                     t=stack.peek();
                }
                if( (t=='(' && ch ==')') || (t=='{' && ch =='}' ) || (t=='[' &&  ch ==']')) {
                    // 匹配成功移出栈
                    stack.pop();
                    // 跳过流程 直接下一个
                    continue;
                }
            }
            // 除非成功匹配外 所有元素都要进行进栈操作
            stack.push(ch);
        }

        if(stack.empty())return true;

        return false;
    }

    public static void main(String[] args) {
        String s="([])";
        System.out.println(isValid(s));
    }


}
