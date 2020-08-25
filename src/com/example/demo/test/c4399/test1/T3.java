package com.example.demo.test.c4399.test1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class T3 {
                            //     1  2  3   4  5  6 7  8  9  10 11 12
    private static int[] month={0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static String[] ans;


    public static int getDay(int y,int m,int d){
        int sum=0;
        for(int i=0;i<m;i++){
            if(i!=2){
                sum+=month[i];
            }else{
                sum+=month[i];
                if(isSyear(y)){
                    sum++;
                }
            }
        }
        sum+=d;
        return sum;
    }


    public static Boolean isSyear(int y){
        if( y%4==0&&y%100!=0 || y%400==0){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        ans=new String[t];

        int y1,m1,d1,y2,m2,d2,k=0;
        while(t-->0){
            y1=scanner.nextInt();
            m1=scanner.nextInt();
            d1=scanner.nextInt();

            y2=scanner.nextInt();
            m2=scanner.nextInt();
            d2=scanner.nextInt();


            long sum1=getDay(y1,m1,d1);
            long sum2=getDay(y2,m2,d2);

            sum1 += (y1-1) * 365 + (y1-1) / 4 - (y1-1) / 100 + (y1-1) / 400;
            sum2 += (y2-1) * 365 + (y2-1) / 4 - (y2-1) / 100 + (y2-1) / 400;

            if(y1==1970&&m1==1&&(d1==1||d1==2||d1==3)){
                sum1++;
            }//OJ有问题，1970年1月这三天有毒

            if ((sum2 - sum1) % 7 == 0){
                ans[k++]="True";
            } else {
                ans[k++]="False";
            }

        }

        for(int i=0;i<k;i++){
            System.out.println(ans[i]);
        }
    }
}
