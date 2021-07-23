package com.example.demo.pass.leetcode.top.part_1;

// 42. 接雨水
/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）

输入: [0,1,0,2,1,0,1,3,2,1,2,1]       输出: 6*/
public class Solution42_H {

    public static int trap2(int[] height) {
       return 0;
    }

    public static int trap(int[] height) {
        int sum=0;
        for(int i=0;i<height.length-1;i++){
            if(height[i]>0 && i+1 < height.length-1){
                int j=i+1;
                while(height[i]>height[j] && j< height.length-1){
                    j++;
                }
                if(height[j]>=height[i]){
                    sum+=Math.min((height[i]-height[i+1]),(height[j]-height[j-1])) * (j-i-1);
                    System.out.println(i+" "+j+" "+height[i]+" "+height[i+1]+" "+height[j]+" "+(j-i-1));
                }


            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] height={4,2,3};
        System.out.println(trap(height));
    }
}
