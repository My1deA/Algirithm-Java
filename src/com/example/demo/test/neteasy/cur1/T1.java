package com.example.demo.test.neteasy.cur1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {


    public static int[][] build(int n){
        int [][] a=new int[n+1][n+1];
        int left=0,right=n-1,top=0,bottom=n-1;
        int direction=1;
        int val=1;
        while (true){
            if(direction%2==1){
                //右
                for(int i=left;i<=right;i++){
                    a[top][i]=val++;
                }
                top++;
                if(top>bottom)break;

                //下
                for(int i=top;i<=bottom;i++){
                    a[i][right]=val++;
                }
                right--;
                if(left>right)break;

                //左
                for(int i=right;i>=left;i--){
                    a[bottom][i]=val++;
                }
                bottom--;
                if(top>bottom)break;

                //上
                for(int i=bottom;i>=top;i--){
                    a[i][left]=val++;
                }
                left++;
                if(left>right)break;

            }else{
                //下
                for(int i=top;i<=bottom;i++){
                    a[i][left]=val++;
                }
                left++;
                if(left>right)break;

                //右
                for(int i=left;i<=right;i++){
                    a[bottom][i]=val++;
                }
                bottom--;
                if(top>bottom)break;

                //上
                for(int i=bottom;i>=top;i--){
                    a[i][right]=val++;
                }
                right--;
                if(left>right)break;

                //左
                for(int i=right;i>=left;i--){
                    a[top][i]=val++;
                }
                top++;
                if(top>bottom)break;
            }
            direction++;
        }

        return a;
    }

    public static void printAns(int[][] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1;j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Integer c=scanner.nextInt();
        List<Integer> list;
        while(c>0){
            c--;
            list=new ArrayList<>();
            Integer N=scanner.nextInt();
            Integer M=scanner.nextInt();
            int[][] a=build(N);
            //printAns(a);

            for(int i=0;i<M;i++){
                Integer I=scanner.nextInt();
                Integer J=scanner.nextInt();
                list.add(a[I][J]);
            }
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }

        }
    }
}






























