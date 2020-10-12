package com.example.demo.test.sz;

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class T1 {

    public static int getSqrt (int num) {
        // write code here
        String str=String.valueOf(Math.sqrt(num));
        Integer t=str.charAt(0)-'0';
        return t;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Integer num=scanner.nextInt();
        System.out.println(getSqrt(num));
    }
}
