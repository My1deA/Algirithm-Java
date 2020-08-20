package com.example.demo.leetcode.offer.array;


import com.example.demo.leetcode.offer.Mark;

import java.util.Arrays;

/*  面试题29. 顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new int[0];
        int[] ans=new int[matrix.length*matrix[0].length];
        int left=0,right=matrix[0].length-1,top=0,botom=matrix.length-1;
        int index=0;
        while (true){
            //右
            for(int i=left;i<=right;i++) ans[index++]=matrix[top][i];
            if(++top > botom) break;
            //下
            for(int i=top;i<=botom;i++) ans[index++]=matrix[i][right];
            if(--right < left) break;
            //左
            for(int i=right;i>=left;i--) ans[index++]=matrix[botom][i];
            if(--botom < top) break;
            //上
            for(int i=botom;i>=top;i--) ans[index++]=matrix[i][left];
            if(++left > right)break;
        }

        return ans;
    }
}

public class Title29 {
    public static void main(String[] args) {
        int[] [] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution29 solution29=new Solution29();
        System.out.println(Arrays.toString(solution29.spiralOrder(matrix)));
    }
}