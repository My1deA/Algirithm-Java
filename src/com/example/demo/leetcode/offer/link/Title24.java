package com.example.demo.leetcode.offer.link;

import java.util.LinkedList;

/* 面试题24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 
限制：0 <= 节点个数 <= 5000
 */
class Solution24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode tail=null;
        ListNode pre=head;
        ListNode next=head.next;
        while(next != null){
            pre.next=tail;
            tail=pre;
            pre=next;
            next=next.next;
        }
        pre.next=tail;
        tail=pre;
        return tail;
    }
}

public class Title24 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        Solution24 solution24=new Solution24();
        ListNode cur = solution24.reverseList(node1);
        while(cur !=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}