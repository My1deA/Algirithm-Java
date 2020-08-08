package com.example.demo.test.c4399;

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

            if(y1>y2 || y1==y2&&m1>m2 || y1==y2 && m1==m2 && d1>d2){
                int t1=y1;
                y1=y2;
                y2=t1;
                t1=m1;
                m1=m2;
                m2=t1;
                t1=d1;
                d1=d2;
                d2=t1;
            }


            int count=0;
            for(int i=y1;i<y2;i++){
                if(isSyear(i)){
                    count++;
                }
            }

            long sum1=getDay(y1,m1,d1);
            long sum2=getDay(y2,m2,d2)+count+(y2-y1-1)*365-sum1;
            if(isSyear(y1)&& (m1<2 || m1 ==2 && d1!=29)){
                sum2++;
            }

            //System.out.println(sum1+" "+sum2);

            if(sum1%7 == sum2%7){
                ans[k++]="True";
            }else{
                ans[k++]="False";
            }

        }

        for(int i=0;i<k;i++){
            System.out.println(ans[i]);
        }
    }
}
