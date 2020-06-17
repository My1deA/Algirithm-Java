package com.example.demo.leetcode.offer.link;

/*  面试题22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
 */
class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k == 0)return null;
        int n=0;
        ListNode next=head;
        while(next!=null){
            next=next.next;
            n++;
        }
        n=n-k;
        next=head;
        while(n--!= 0){
            next=next.next;
        }
        return next;
    }
}

public class Title22 {
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
        Solution22 solution22=new Solution22();
        ListNode cur = solution22.getKthFromEnd(node1,2);
        while(cur !=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
