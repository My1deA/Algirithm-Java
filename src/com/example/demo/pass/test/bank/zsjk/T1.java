package com.example.demo.pass.test.bank.zsjk;

import java.util.Scanner;

public class T1 {

    public static boolean dfs(String str,int i,int j){
        if(j-i<=1)return true;
        if(str.charAt(i)!=str.charAt(j)){
            return false;
        }
        return dfs(str,i+1,j-1);
    }


    public static void main(String[] args) {
        //String str="abcdedcba";
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(dfs(str,0,str.length()-1));
    }
}
