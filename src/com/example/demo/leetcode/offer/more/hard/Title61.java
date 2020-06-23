package com.example.demo.leetcode.offer.more.hard;


/* 剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

输入: [1,2,3,4,5]
输出: True

限制：数组长度为 5  数组的数取值为 [0, 13] .
 */

import java.util.Arrays;

class Solution61 {


    public boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


    public boolean isStraight(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        //System.out.println(Arrays.toString(nums));
        int count = 0;
        int t = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }else{
                if(i>0 && (nums[i]-nums[i-1])> 1 && nums[i-1]!=0 ){
                    //System.out.println(nums[i]);
                    count=count-(nums[i]-nums[i-1])+1;
                }else if(i>0 && nums[i] == nums[i-1] && nums[i-1]!=0){
                    return false;
                }
            }
            if(count<0)return false;
        }
        return true;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int t = nums[left];
        while (i < j) {
            while(i < j && nums[j] >= t) {
                j--;
            }
            while (i < j && nums[i] <= t) {
                i++;
            }
            swap(nums, i, j);
        }
        nums[left] = nums[i];
        nums[i] = t;

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}

public class Title61 {
    public static void main(String[] args) {
        int[] nums = {0,0,2,2,5};
        Solution61 solution61 = new Solution61();
        System.out.println(solution61.isStraight(nums));
    }
}
