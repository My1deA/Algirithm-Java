package com.example.demo.pass.leetcode.top.part_1;

import java.util.Arrays;

public class T56 {

    public static int[][] merge(int[][] intervals) {
        int [][] res=new int[intervals.length][2];

        Arrays.sort(intervals,(o1,o2)-> o1[0]-o2[0]);
        int i=-1;
        for(int[] interval: intervals){
            if(i==-1 || res[i][1] < interval[0]){
                res[++i]=interval;
            }else {
                res[i][1]=Math.max(res[i][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,i+1);
    }

    public static void printAns(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans=merge(intervals);
        printAns(ans);
    }


    public int[][] merge2(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
