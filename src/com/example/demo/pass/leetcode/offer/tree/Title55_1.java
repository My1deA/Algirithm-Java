package com.example.demo.pass.leetcode.offer.tree;

/*  面试题55 - I. 二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3
 */
class Solution55_1 {
    public int maxDepth(TreeNode root) {
        //if (root == null) return 0;
        return computeDeep(root);
    }

    public int computeDeep2(TreeNode node){
        if(node==null)return 0;
        return Math.max(computeDeep2(node.left),computeDeep2(node.right))+1;
    }


    public int computeDeep(TreeNode node){
        if(node== null) return 0;
        int left=1,right=1;
        if(node.left !=null){
            left=computeDeep(node.left)+1;
        }
        if(node.right !=null){
            right=computeDeep(node.right)+1;
        }
        return left > right ? left : right;

    }
}

public class Title55_1 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(15);
        TreeNode node5=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        Solution55_1 solution55_1=new Solution55_1();
        System.out.println(solution55_1.maxDepth(node1));
    }
}