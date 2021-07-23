package com.example.demo.pass.leetcode.top.part_1;



// 48. 旋转图像
/*给定一个 n×n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
给定 matrix =            原地旋转输入矩阵，使其变为:
        [                   [
        [1,2,3],                   [7,4,1],
        [4,5,6],                   [8,5,2],
        [7,8,9]                    [9,6,3]
        ],                   ]*/

public class Solution48 {
    // 方法 1 ： 最直接的想法是先转置矩阵，然后翻转每一行

    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    // 方法 2 ：
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n-2*i-1;j++){
                int t=matrix[i][i+j];
                // 左上
                matrix[i][i+j]=matrix[n-i-1-j][i];
                //左下
                matrix[n-i-1-j][i]=matrix[n-i-1][n-i-1-j];
                // 右下
                matrix[n-i-1][n-i-1-j]=matrix[i+j][n-i-1];
                // 右上
                matrix[i+j][n-i-1]=t;
                //printAns(matrix);
            }
        }
        //printAns(matrix);
    }

    public static void printAns(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        /*int [][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printAns(matrix);
        rotate(matrix);*/
        Integer i=10;
        System.out.println(i.byteValue());
    }
}






















