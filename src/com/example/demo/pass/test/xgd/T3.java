package com.example.demo.pass.test.xgd;

import java.util.Scanner;
import java.util.Stack;

public class T3 {

    public static Boolean getAns(String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
            if(stack.peek()==')' && stack.size()>=2){
                stack.pop();
                char ch=stack.pop();
                if(ch!='(')return false;
            }else if(stack.peek()==')' && stack.size()<2){
                return false;
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        if(getAns(str)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
