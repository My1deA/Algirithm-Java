package com.example.demo.pass.leetcode.offer.array;

/* 面试题11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
class Solution11 {
    public int minArray(int[] numbers) {
        if(numbers.length == 0) return 0;
        int left=0,right=numbers.length-1;
        int mid=0;
        while(left<=right){
           mid=(left+right)/2;
           if(numbers[mid]>numbers[right]){
               left=mid+1;
           }else if(numbers[mid] < numbers[right]){
               right=mid;//关键
           }else{
               //去重
               right--;
           }
        }
        return numbers[mid];
    }
}

public class Title11 {
    public static void main(String[] args) {
        int [] numbers={3,1,3};
        Solution11 solution11=new Solution11();
        System.out.println(solution11.minArray(numbers));
    }
}
