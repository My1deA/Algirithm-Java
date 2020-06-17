package com.example.demo.leetcode.offer.tree;

/*  面试题28. 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
   1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 */
class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;

        return isEqual(root.left,root.right);
    }

    public boolean isEqual(TreeNode left,TreeNode right){
        if(left == null && right == null){//left right 同时为空
            return true;
        }else if (left !=null && right!=null){//left 和 right 不为空
            if(left.val == right.val){
                return isEqual(left.left,right.right) && isEqual(left.right,right.left);
            }else{//不相同
                return false;
            }
        }else{//一个为空 一个不为空
            return false;
        }
    }
}
public class Title28 {
}