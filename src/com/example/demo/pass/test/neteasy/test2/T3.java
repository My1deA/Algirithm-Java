package com.example.demo.pass.test.neteasy.test2;

import java.util.Scanner;

/*1
  10 5
  50590387 8028493 660013516 226575217 85137277 569716449 31075276 331696 27381455 503700401*/

public class T3 {

    private static long[] h=new long[1001];
    private static String[] str=new String[1001];

    public static String isSuccess(long [] h,int n,int k){
        int i=0;
        int magic=1;
        while(i<n-1){
            int cur=i;
            //找出可以最多跳多少步
            int index=i;
            long max=0;
            for(int j=i+1;j<=i+k && j<n;j++){
                if(h[i]>h[j]){
                    if(max<h[j]){
                        index=j;
                        max=h[j];
                    }
                }
            }
            i=index;
            if(i==cur && magic==1){
                magic=0;
                int index2=i;
                long max2=h[index2];
                for(int j=i+1;j<=i+k && j<n;j++){
                    if(max2<h[j]){
                        index2=j;
                        max2=h[j];
                    }
                }
                i=index2;
            }else if(i==cur && magic==0){
                return "NO";
            }
            //System.out.print(h[i]+" ");
        }
        return "YES";
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int index=0;
        while(t-->0){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            for(int i=0;i<n;i++){
                h[i]=scanner.nextLong();
            }
            str[index++]=(isSuccess(h,n,k));
        }
        for(int i=0;i<index;i++){
            System.out.println(str[i]);
        }
    }

}
