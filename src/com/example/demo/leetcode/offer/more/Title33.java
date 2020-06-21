package com.example.demo.leetcode.offer.more;



/* 剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3

输入: [1,6,3,2,5] 输出: false

输入: [1,3,2,6,5] 输出: true

提示：数组长度 <= 1000
 */

class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    public boolean recur(int[] postorder,int i,int j){
        if(i>=j)return true;
        int k=i;
        while(postorder[k]<postorder[j]){
            k++;
        }
        int left=k-1;
        while(postorder[k]>postorder[j]){
            k++;
        }
        // k==j 判断是否 是平衡二叉树
        return k==j && recur(postorder,i,left) && recur(postorder,left+1,j-1);
    }
}

public class Title33 {
    public static void main(String[] args) {
        int[] postorder={4, 8, 6, 12, 16, 14, 10};
        Solution33 solution33=new Solution33();
        System.out.println(solution33.verifyPostorder(postorder));

    }
}
