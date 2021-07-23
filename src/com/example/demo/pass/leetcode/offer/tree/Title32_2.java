package com.example.demo.pass.leetcode.offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        //if(root==null)return new int[0];
        ArrayList<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> t;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n=queue.size();// important
            t=new ArrayList<>();// important
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                t.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}

public class Title32_2 {
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

        Solution32_2 solution32_2=new Solution32_2();
        System.out.println(solution32_2.levelOrder(node1));
    }
}