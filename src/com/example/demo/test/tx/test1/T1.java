package com.example.demo.test.tx.test1;

import java.util.Scanner;
import java.util.Stack;

public class T1 {

    private static Stack<Character> stack=new Stack<>();
    private static Stack<Integer> numStack=new Stack<>();

    public static String Solution(String str){
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==']'){
                StringBuffer t=new StringBuffer();
                while(stack.peek()!='|'){
                    t.append(stack.pop());
                }
                stack.pop();//删除 |
                while(stack.peek()!='['){
                    numStack.push(stack.pop()-'0');
                }
                stack.pop(); //删除 [

                int num=0;
                while(!numStack.isEmpty()){
                    num=num*10+numStack.pop();
                }
                t=t.reverse();

                while(num-->0){
                    for(int j=0;j<t.length();j++){
                        stack.push(t.charAt(j));
                    }
                }

            }else{
                stack.push(str.charAt(i));
            }
        }

        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(Solution(str));
    }
}
