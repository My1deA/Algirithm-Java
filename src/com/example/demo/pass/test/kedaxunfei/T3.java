package com.example.demo.pass.test.kedaxunfei;

import java.util.Scanner;

//字符串操作
public class T3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        String[] strings=str.split("_");
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<strings.length;i++){
            if(!strings[i].equals("")){
                stringBuffer.append(strings[i]+"_");
            }
        }
        System.out.println(stringBuffer.substring(0,stringBuffer.length()-1));

    }
}
