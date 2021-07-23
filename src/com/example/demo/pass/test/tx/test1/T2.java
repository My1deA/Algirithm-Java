package com.example.demo.pass.test.tx.test1;

import java.util.Scanner;

public class T2 {

    public static int[] Street(int[] w,int n){
        int[] v=new int[n];
        for(int i=0;i<n;i++){
            v[i]=1;//初始化为1 能看见自己
        }

        for(int i=0;i<n;i++){
            //左边
            int j=i-1;
            if(j>=0){
                int maxl=w[j--];
                v[i]++;
                while(j>=0){
                    if(maxl<w[j]){
                        maxl=w[j];
                        v[i]++;
                    }
                    j--;
                }
            }

            //System.out.print(v[i]+" ");
            //右边
            j=i+1;
            if(j<n){
                int maxl=w[j++];
                v[i]++;
                while(j<n){
                    if(maxl<w[j]){
                        maxl=w[j];
                        v[i]++;
                    }
                    j++;
                }
            }
            //System.out.println(v[i]);
        }
        return v;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int[] w=new int[n];
        for(int i=0;i<n;i++){
            w[i]=scanner.nextInt();
        }

        int[] v=Street(w,n);
        for(int i=0;i<n;i++){
            System.out.print(v[i]+" ");
        }

    }
}
