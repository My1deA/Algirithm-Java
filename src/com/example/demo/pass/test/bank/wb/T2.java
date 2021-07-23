package com.example.demo.pass.test.bank.wb;

import java.util.Scanner;

public class T2 {

    public static int getScore(String str){
        int i=0;
        int j=str.length();
        int sum=0;
        int tri=0;
        int end=0;
        boolean fail=false;

        while(i<j && !fail){
            if(str.charAt(i)=='P'){
                sum+=200;
                if(tri>=3){
                    sum+=50;
                }
                tri++;
            }else if(str.charAt(i)=='G'){
                sum+=100;
                tri=0;
            }else if(str.charAt(i)=='M'){
                tri=0;
                end++;
                if(end==3){
                    sum=0;
                    fail=true;
                }
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(getScore(str));
    }
}
