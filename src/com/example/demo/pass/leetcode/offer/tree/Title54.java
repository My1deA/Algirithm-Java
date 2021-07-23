package com.example.demo.pass.leetcode.offer.tree;

import java.util.ArrayList;

/*  面试题54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。
示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
 */
class Solution54 {
    //有一说一 这题只想遍历得到数组 然后快排
    private ArrayList<Integer> ans=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        if(root == null || k == 0) return 0;
        midTarverse(root);
        //Collections.sort(ans);
        return ans.get(ans.size()-k);
    }

    public void midTarverse(TreeNode node){
        if(node == null)return;
        midTarverse(node.left);
        //System.out.print(node.val+" ");
        ans.add(node.val);
        midTarverse(node.right);
    }
}

public class Title54 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(2);
        TreeNode node4=new TreeNode(4);
        node1.left=node2;
        node2.right=node3;
        node1.right=node4;
        Solution54 solution54=new Solution54();
        System.out.println(solution54.kthLargest(node1,1));
        //solution54.midTarverse(node1);
    }
}