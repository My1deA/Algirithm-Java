package com.example.demo.test.bank.wb;

import java.util.HashMap;
import java.util.Scanner;

public class T3 {

    private static int ans=0;
    private static HashMap<Integer,Integer> map=new HashMap<>();

    public static int getAns(int[] a,int m){
        dfs(a,m,0);
        return ans;
    }

    public static void dfs(int []a ,int m,int k){
        if(k>=a.length){
            int sum=0;
            for(int i=0;i<a.length;i++){
                sum=sum*10+a[i];
            }

            if(!map.containsKey(sum)){
                //System.out.println(sum);
                map.put(sum,1);
                if(sum%m==0)ans++;
            }
        }else{
            for(int i=k;i<a.length;i++){
                swap(a,k,i);
                dfs(a,m,k+1);
                swap(a,k,i);
            }
        }
    }

    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int len=0;
        int t=n;
        while(t>0){
            t=t/10;
            len++;
        }
        t=n;
        int[] a=new int[len];
        for(int i=a.length-1;i>=0;i--){
            a[i]=t%10;
            t=t/10;
            //System.out.print(a[i]+" ");
        }
        System.out.println(getAns(a,m));

    }
}
