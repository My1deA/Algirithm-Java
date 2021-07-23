package com.example.demo.pass.test.xgd;

import java.util.Scanner;

public class T1 {

    public static String getAns(String string){
        StringBuffer stringBuffer=new StringBuffer();
        //stringBuffer.append(string.charAt(0));
        //stringBuffer.append(string.charAt(string.length()-1));
        int i=0,j=string.length()-1;

        while (i <= j) {
            char ch1=string.charAt(i);
            char ch2=string.charAt(j);
            if(ch1<ch2){
                stringBuffer.append(ch1);
                i++;
            }else{
                stringBuffer.append(ch2);
                j--;
            }

        }

        return stringBuffer.toString();

    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getAns(str));

    }


}
