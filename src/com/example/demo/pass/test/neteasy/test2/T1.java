package com.example.demo.pass.test.neteasy.test2;


import java.util.Scanner;

public class T1 {
    private static long[] ans=new long[6];
    private static long[] a=new long[5];

    public static int getCount(long[] a){
        int count=0;
        while(true){
            if(a[1]<=a[0]){
                break;
            }else{
                if(a[1]<= a[0]+a[2]){
                    a[0]=a[0]+a[2];
                }else{
                    a[2]=a[2]*a[3];
                }
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int index=0;
        while(n-->0){
            for(int i=0;i<4;i++){
                a[i]=scanner.nextInt();
            }
            ans[index++]=getCount(a);
        }
        for(int i=0;i<index;i++){
            System.out.println(ans[i]);
        }
    }
}
