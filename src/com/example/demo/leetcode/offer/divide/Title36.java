package com.example.demo.leetcode.offer.divide;

/* 面试题36. 二叉搜索树与双向链表
 */
public class Title36 {
    public static void main(String[] args) {
    }
}

class Solution36 {

    Node pre,head;

    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        //遍历
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

    public void dfs(Node node){
        if(node==null)return;
        dfs(node.left);
        //初始化head
        if(head==null){
            head=node;
            pre=node;
        }else{
            pre.right=node;
            node.left=pre;
            pre=node;
        }

        dfs(node.right);
    }

}