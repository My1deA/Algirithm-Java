package com.example.demo.test.vip.test2;


/*给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:
        matrix = [
        [ 1,  5,  9],
        [10, 11, 13],
        [12, 13, 15]
        ],
        k = 8,

        返回 13。
        说明:
        你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。

        输入描述:
        第一行为k的值和矩阵的n的值 后续为n*n矩阵的数字，以空格分割



        输出描述:
        矩阵中第k小的元素

输入例子1:
        8 3
        1 5 9
        10 11 13
        12 13 15

输出例子1:
        13*/

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static int solution(int[][] m,int k){
        //int cur=1;


        return 0;
    }


    public static void main(String[] args) {
        int k=0,n=0;
        Scanner scanner=new Scanner(System.in);
        k=scanner.nextInt();
        n=scanner.nextInt();
        int[][] m=new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                m[i][j]=scanner.nextInt();
//            }
//        }
        int[] t=new int[n*n];
        for(int i=0;i<n*n;i++){
            t[i]=scanner.nextInt();
        }
        Arrays.sort(t);

        System.out.println(t[k-1]);

    }

}
