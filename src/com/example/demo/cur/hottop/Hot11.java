package com.example.demo.cur.hottop;

import java.awt.geom.Area;

public class Hot11 {

    public static int maxArea(int[] height) {
        int n=height.length-1;//桶长
        int max=0;
        int left=0;//左下标
        int right=n;//右下标
        while(left<right){
            //求出两边最小高度
            int minHeight=Math.min(height[left],height[right]);
            //求出能放入水的容量
            int area=n*minHeight;
            if(area>max){
                max=area;
            }

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            //底面积减少
            n--;
        }
        return max;
    }


    public static void main(String[] args) {
        int [] a={1,2,1};
        System.out.println(maxArea(a));
    }
}
