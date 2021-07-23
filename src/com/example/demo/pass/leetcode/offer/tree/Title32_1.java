package com.example.demo.pass.leetcode.offer.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*  面试题32 - I. 从上到下打印二叉树

例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

[3,9,20,15,7]
 */
class Solution32 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        ArrayList<Integer> ans=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();//出队列
            ans.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);//进队列
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }

        int[] returnAns=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            returnAns[i]=ans.get(i);
        }

        return returnAns;
    }
}

public class Title32_1 {
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

        Solution32 solution32=new Solution32();
        System.out.println(Arrays.toString(solution32.levelOrder(node1)));
    }
}