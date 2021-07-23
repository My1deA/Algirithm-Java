package com.example.demo.pass.test.bank.ICG;

import java.util.Scanner;
import java.util.Stack;

public class T2 {

    private Character ch;



    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 字符串编码
     * @param srcStr string字符串 ASCII码字符串，不涉及中文
     * @return string字符串
     */
    public static String encode (String srcStr) {
        // write code here
        int j=0;
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<srcStr.length();i+=7){
            String t=srcStr.substring(i,i+6);
            t="00"+t;
            System.out.println(t);
            System.out.println(changeI(t));
            j=i;

        }

        return null;
    }

    public static Integer changeI(String str){
        Integer sum=0;
        for(int i=str.length()-1;i>=0;i--){
            sum+=2*sum+str.charAt(0)-'0';
        }
        return sum;
    }


    public static String change(Long a){
        Stack<Long> stack=new Stack<>();
        while(a>0){
            stack.add(a%2);
            a=a/2;
        }
        StringBuffer stringBuffer=new StringBuffer();
        while(!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }

    //真的很想去广发 /
    /*真的很想去广发*/
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        str.substring(1,str.length()-1);
        long sum=0;
        for(int i=0;i<str.length();i++){
            sum+=str.charAt(i)-0;
        }
        String str2=change(sum);

        System.out.println(encode(str2));

    }
}
