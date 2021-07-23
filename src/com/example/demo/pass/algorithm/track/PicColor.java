package com.example.demo.pass.algorithm.track;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
【输入样例】
5 8 4
1 2
1 3
1 4
2 3
2 4
2 5
3 4
4 5

【输出样例】
48
 */

public class PicColor {
    public static Set<String> set = new HashSet<String>();
    public static int n,k,m,a,b,count=0;
    public static int [] [] num;
    public static int []  color;
    public static boolean [] bool;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        num = new int [n+1][n+1];
        color = new int [n+1];
        bool = new boolean [m+1];
        for (int i = 0; i < k; i++) {
            a=sc.nextInt();
            b=sc.nextInt();
            num[a][b]=num[b][a]=1;
        }
        f(1,"");
        System.out.println(count);

    }
    public static void f(int ren,String s){
        if(ren==n+1){
            set.add(s);
            count++;
            return;
        }
        for (int i = 1; i <=m; i++) {
            //	if(!bool[i]){
            int boo = 0;
            for (int j = 1; j <=n; j++) {
                if(num[ren][j]==1 && i==color[j] ){
                    boo=1;
                    break;
                }
            }
            if(boo==0){

                bool[i]=true;
                color[ren]=i;
                f(ren+1,s+i);
                color[ren]=0;
                bool[i]=false;
            }
            //	}
        }

    }

}


