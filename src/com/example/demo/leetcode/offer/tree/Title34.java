package com.example.demo.leetcode.offer.tree;

import com.sun.org.apache.xalan.internal.xsltc.dom.NodeSortRecord;

import java.util.ArrayList;
import java.util.List;

/*  面试题34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class Title34 {
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
        Solution34 solution34=new Solution34();
        solution34.pathSum(node1,38);
    }
}

class Solution34 {

    private ArrayList<List<Integer>> ans=new ArrayList<>();
    private ArrayList<Integer> path=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        getSum(root,0,sum);
        return ans;
    }

    public void getSum(TreeNode node, int cur,int sum){
        path.add(node.val);
        cur+=node.val;
        if(cur == sum && node.left == null && node.right == null){ //叶子结点
            ArrayList<Integer> t= new ArrayList<>(path);
            //System.out.println(cur);
            //System.out.println(t);
            ans.add(t);
        }
        if(node.left != null){//防止 + null值
            getSum(node.left,cur,sum);
        }
        if(node.right != null){
            getSum(node.right,cur,sum);
        }
        //移除最新值
        path.remove(path.size()-1);
    }
}