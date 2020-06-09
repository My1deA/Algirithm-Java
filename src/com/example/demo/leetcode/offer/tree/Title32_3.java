package com.example.demo.leetcode.offer.tree;

import java.util.*;

/*  面试题32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class Title32_3 {
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
        Solution32_3 solution32_3=new Solution32_3();
        System.out.println(solution32_3.levelOrder(node1));

    }
}

class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        ArrayList<List<Integer>> ans=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> t;
        int deep=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            deep++;
            int n=queue.size();
            t=new ArrayList<>();
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
            if(deep%2==0){
                Collections.reverse(t);
            }
            ans.add(t);
        }
        return ans;
    }
}