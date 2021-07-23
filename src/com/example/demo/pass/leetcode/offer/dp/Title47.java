package com.example.demo.pass.leetcode.offer.dp;

/* 面试题47. 礼物的最大价值
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物
 */
class Solution47 {
    public int maxValue(int[][] grid) {
        if(grid.length==0)return 0;
        int[][] t=new int [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0){
                    t[i][j]=grid[i][j];
                }else{
                    if(i>=1 && j>=1){
                        t[i][j]=grid[i][j]+Math.max(t[i-1][j],t[i][j-1]);
                    }else {
                        if(i<1){
                            t[i][j]=grid[i][j]+t[i][j-1];
                        }else{
                            t[i][j]=grid[i][j]+t[i-1][j];
                        }
                    }
                }
            }
        }
        return t[grid.length-1][grid[0].length-1];
    }
}

public class Title47 {
    public static void main(String[] args) {
        int[][] grid={{1,2},{5,6},{1,1}};
        Solution47 solution47=new Solution47();
        System.out.println(solution47.maxValue(grid));
    }
}
