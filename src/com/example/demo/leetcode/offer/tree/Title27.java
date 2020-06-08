package com.example.demo.leetcode.offer.tree;

/*  面试题27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class Title27{
    public static void main(String[] args) {

    }
}

class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }

    public void swap(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode t=node.left;
        node.left=node.right;
        node.right=t;

        swap(node.left);
        swap(node.right);

    }
}
