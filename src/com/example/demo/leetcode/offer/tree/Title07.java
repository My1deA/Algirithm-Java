package com.example.demo.leetcode.offer.tree;

/*  面试题07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
    3
   / \
  9  20
    /  \
   15   7
                    0 1 2 3 4 5 6 7
前序遍历 preorder = [G D A F E M H Z]
中序遍历 inorder = [A D E F G H M Z]
     G
   /   \
  D     M
 / \   /  \
A   F H    Z
   /
  E
 */

import java.util.concurrent.locks.ReentrantLock;

public class Title07 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        solution.buildTree(preorder,inorder);
    }
}


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createNode(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode createNode(int pl,int pr,int il,int ir,int[] preorder, int[] inorder){
        if(pl>pr){
            return null;//空结点
        }
        TreeNode node=new TreeNode(preorder[pl]);
        int index=0;
        //for(int i=il;i<=ir;i++)
        for(int i=il;i<=ir;i++){
            if(node.val==inorder[i]){
                index=i;
                break;
            }
        }
        //pl+1  pr-(ir-index)   il  index-1
        node.left=createNode(pl+1,pr-(ir-index),il,index-1,preorder,inorder);
        //pl+(index-il)+1   pr  index+1 ir
        node.right=createNode(pl+(index-il)+1,pr,index+1,ir,preorder,inorder);

        //后 中
        //bl    bl+(index-il-1) il  index-1
        //bl+(index-il) end-1   index+1 ir

        return node;
    }
}