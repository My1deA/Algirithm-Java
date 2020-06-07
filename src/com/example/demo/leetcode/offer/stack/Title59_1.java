package com.example.demo.leetcode.offer.stack;


/*  面试题59 - I. 滑动窗口的最大值 (双端队列 hard)
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */

import java.util.LinkedList;

public class Title59_1 {
    public static void main(String[] args) {
        int[] nums = {};
        Solution solution = new Solution();
        // Solution2 solution2=new Solution2();
        int[] ans = solution.maxSlidingWindow(nums, 0);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    /*
    借助一个辅助队列，从头遍历数组，根据如下规则进行入队列或出队列操作：
    0. 如果队列为空，则当前数字入队列
    1. 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空，然后当前数字入队列
    2. 如果当前数字小于队列尾，则当前数字入队列
    3. 如果队列头超出滑动窗口范围，则删除队列头
    这样能始终保证队列头为当前的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        int index = 0;


        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!queue.isEmpty()){
                if (i >= (queue.peek() + k)) {
                    queue.pop();
                }
                while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            queue.offer(i);

            if(i+1>=k){
                ans[index++]=nums[queue.peek()];
            }
        }

        return ans;
    }
}


class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (index < i) {
                max = Integer.MIN_VALUE;
            }
            for (int j = i; j < i + k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}