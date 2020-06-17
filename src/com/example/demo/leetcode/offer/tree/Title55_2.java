package com.example.demo.leetcode.offer.tree;

import java.util.Random;

/*  面试题55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

 

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false
 */


class Solution55_2 {
    public boolean isBalanced(TreeNode root) {
       return myBalanced(root);
    }

    public boolean myBalanced(TreeNode node) {
        if(node == null) return true;//叶子结点
        if(Math.abs(getDeep(node.left)-getDeep(node.right))>=2){//子子树如果高度>=2 肯定不平衡
            return false;
        }
        return myBalanced(node.left) && myBalanced(node.right);

    }

    public int getDeep(TreeNode node){
        if(node==null)return 0;
        int left=1,right=1;
        left=left+getDeep(node.left);
        right=right+getDeep(node.right);
        return left>right?left:right;
    }
}

public class Title55_2 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(2);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(3);
        TreeNode node6=new TreeNode(4);
        TreeNode node7=new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node6;
        node4.right=node7;
        Solution55_2 solution55_2=new Solution55_2();
        System.out.println(solution55_2.isBalanced(node1));
    }
}