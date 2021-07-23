package com.example.demo.pass.algorithm.dp;



// 10303 数字三角 dp
/*
问题描述：给定一个由n行数字组成的数字三角形，如下图所示。试用动态规划算法，计算出从三角顶部至底部的一条路径，使得该路径经过的数字总和最大。

        注意每个数字只能走向下一行左边或右边的数字，而不能跳跃的走。
        7
        3   8
        8   1   0
        2   7   4   4
        4   5   2   6   5

        输入格式    第一行是数字三角的行数n，1<=n<=100。接下来n行是数字三角各行中的数字，所有数字在0~99之间。
        输出格式    输出两行，第一行是计算出的最大路径的和值，第二行是该路径上的数字。若有多条路径，靠右的路径优先（即仅仅输出靠右的路径即可，无需多条路径都输出）。

        Input:                                                                          Output:
        5                                                                               30
        7                                                                               7 8 6 4 5
        3 8
        8 1 6
        2 7 4 4
        4 5 2 4 5
        有两条路径：7-3-8-7-5和7-8-6-4-5都为30，由于后者靠右，因此仅输出后者。
*/

public class T_10303 {

    public static void tri(int[][]a , int[][] rc){
        //初始化 rc三角底
        for(int i=rc[0].length-1;i>=0;i--){
            rc[rc.length-1][i]=a[rc.length-1][i];
        }

        for(int i= rc.length-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                rc[i][j]=a[i][j]+Math.max(rc[i+1][j],rc[i+1][j+1]);
            }
        }

        int index=0;
        for(int i=0;i<rc.length;i++){
            if(rc[i][index]>rc[i][index+1]){
                System.out.print(a[i][index]+" ");
            }else{
                System.out.print(a[i][++index]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int n=5;
        int[][] a={ {7,0,0,0,0},
                    {3,8,0,0,0},
                    {8,1,6,0,0},
                    {2,7,4,4,0},
                    {4,5,2,6,5}};
        int[][] rc=new int[n][n];
        tri(a,rc);
    }
}
