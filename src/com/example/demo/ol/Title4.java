package com.example.demo.ol;

import java.util.Scanner;

//字符串操作
public class Title4 {


    public static String getNum(String str){
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getNum(str));
    }

}
