package com.example.demo.test.neteasy;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class T1 {
    private static int[] score=new int[10001];
    private static int[] sortArr=new int[10001];
    private static int[] query=new int[10001];
    private static HashMap<Integer,Integer> map=new HashMap<>();
    private static int n=0;//学生总数
    private static int m=0;//询问总数


    public static void getRank(){
        sort();
        double t=0;
        double ans;
        for(int i=0;i<m;i++){
            t=map.get(score[query[i]-1]);
            ans=100*(n-t)/n;
            DecimalFormat df = new DecimalFormat("#0.000000");
            String str = df.format(ans);
            System.out.println(str);
        }
    }



    public static void sort(){

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(sortArr[j]<sortArr[j+1]){
                    swap(j,j+1);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!map.containsKey(sortArr[i])){
                map.put(sortArr[i],i+1);
            }
        }
        //System.out.println();
    }

    public static void swap(int i,int j){
        int t=sortArr[i];
        sortArr[i]=sortArr[j];
        sortArr[j]=t;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        for(int i=0;i<n;i++){
            score[i]=scanner.nextInt();
            sortArr[i]=score[i];
        }
        m=scanner.nextInt();
        for(int i=0;i<m;i++){
            query[i]=scanner.nextInt();
        }
        getRank();

    }
}
