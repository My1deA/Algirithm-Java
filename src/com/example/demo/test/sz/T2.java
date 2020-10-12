package com.example.demo.test.sz;

import java.util.Scanner;

public class T2 {

    public static int minDistance (String a, String b) {
        // write code here
        //需要删除的
        int count=Math.abs(a.length()-b.length());

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] strs=str.trim().split(",");
        strs[0]=strs[0].substring(1,strs[0].length()-1);
        strs[1]=strs[1].substring(1,strs[1].length()-1);
        System.out.println(minDistance(strs[0],strs[1]));
    }
}
