package com.example.demo.pass.test.kedaxunfei;

import java.util.Scanner;

public class T4 {


    public static void dfs(StringBuffer stringBuffer,int n){
        for(int i=n;i>=2;i--){
            if(n%i==0 && isPrime(i)){
                stringBuffer.append(i+"*");
                dfs(stringBuffer,n/i);
                break;
            }
        }

    }

    public static boolean isPrime(int n){
        int a= (int) Math.sqrt(n);
        for(int i=2;i<=a;i++){
            if(n%i==0){
                return false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        StringBuffer stringBuffer=new StringBuffer();
        if(isPrime(n)){
            System.out.println(n);
        }else{
            dfs(stringBuffer,n);
            System.out.println(stringBuffer.reverse().substring(1,stringBuffer.length()));
        }

    }
}
