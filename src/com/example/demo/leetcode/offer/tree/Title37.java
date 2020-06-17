package com.example.demo.leetcode.offer.tree;

import java.util.LinkedList;

/*  面试题37. 序列化二叉树 hard
请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("[");
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node != null){
                stringBuffer.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                stringBuffer.append("null,");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        stringBuffer.append("]");
        return  stringBuffer.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        LinkedList<TreeNode> queue=new LinkedList<>();
        String[] str=data.substring(1,data.length()-1).split(",");
        int i=1;
        TreeNode root=new TreeNode(Integer.valueOf(str[0]));
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(!str[i].equals("null")){
                node.left=new TreeNode(Integer.valueOf(str[i]));
                queue.offer(node.left);
            }
            i++;
            if(!str[i].equals("null")){
                node.right=new TreeNode(Integer.valueOf(str[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }



    public void PrintAns(TreeNode node){
        if (node == null) return;
        System.out.print(node.val+"");
        PrintAns(node.left);
        PrintAns(node.right);
    }

    public TreeNode createTree(String[] str,int i){
        if(str[i].equals("null") || i > str.length){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(str[i]));
        node.left=createTree(str,2*i+1);
        node.right=createTree(str,2*i+2);
        return node;
    }

}

public class Title37 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        Codec codec=new Codec();
        System.out.println(codec.serialize(node1));
        codec.PrintAns(codec.deserialize(codec.serialize(node1)));
    }
}