package com.example.demo.test.vip.test2;

/*输入一个字符串，输出该字符串中相邻字符的所有组合。
        举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。（注意：输出的组合需要去重）（40分）

        输入描述:
        一个字符串

        输出描述:
        一行，每个组合以空格分隔，相同长度的组合需要以字典序排序，且去重。

        输入例子1:
        bac

        输出例子1:
        a b c ac ba bac*/


import java.util.*;

public class T1 {

    public static void getAns(String str){
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=1;i<=str.length();i++){
            TreeSet<String> sortSets=new TreeSet<>();
            for(int j=0;j+i<=str.length();j++){
                sortSets.add(str.substring(j,j+i));
            }
            for(String s:sortSets){
                stringBuffer.append(s).append(" ");
            }

        }
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        getAns(str);

    }
}
