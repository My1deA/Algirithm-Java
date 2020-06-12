package com.example.demo.leetcode.offer.link;

import java.util.HashMap;
import java.util.Map;

/* 面试题35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null

输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]。

输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

提示：
-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000
 */
public class Title35 {
}
class Solution {

    //链表操作
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // val 值 1->1'->2->2'->3->3'
        for(Node node=head,copy=null; node != null; node=node.next.next){
            copy=new Node(node.val);
            copy.next=node.next;
            node.next=copy;
        }

        //random
        for(Node node=head,copy=null; node != null; node=node.next.next){
           if(node.random!=null){
               //node.random.next 指的是随机引用的下一个(也是新生成随机引用)
               node.next.random=node.random.next;
           }
        }

        //拆分
        Node curHead=head.next;
        for(Node node=head,temp=null; node!=null&&node.next!=null;){
            //分开拆除 逐个逐个拆分
            temp=node.next;
            node.next=temp.next;
            node=temp;
        }
        /*for(Node node=head,temp=head.next; node!=null && node.next !=null;){
            node.next=temp.next;
            node=node.next;
            temp.next=node.next;
            temp=temp.next;
        }*/
        return curHead;
    }

    //hashMap
    public Node copyRandomList2(Node head) {
        Map<Node,Node> map=new HashMap<>();
        //将新结点放入map中
        for(Node cur=head;cur != null;cur=cur.next){
            map.put(cur,new Node(cur.val));
        }

        //处理random值
        for(Node cur=head;cur !=null;cur=cur.next){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
        }

        return map.get(head);
    }
}