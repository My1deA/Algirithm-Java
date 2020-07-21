package com.example.demo.leetcode.top.part_1;

//https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
public class Solution11 {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,res=0;
        while(i<j){
            res=height[i]<height[j]? Math.max(res,(j-i)*height[i++]) : Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution11 solution11=new Solution11();
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(solution11.maxArea(height));
    }
}
