package com.example.demo.pass.leetcode.top.part_1;

import com.example.demo.pass.leetcode.top.common.ListNode;


/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.

说明：
给定的 n保证是有效的。

进阶：
你能尝试使用一趟扫描实现吗？
 */

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            length++;
        }

        int i=length-n-1;
        cur=head;
        while(i-- > 0){
            cur=cur.next;
        }

        if(length-n==0){
            return head.next;
        }else {
            cur.next=cur.next.next;
            return head;
        }


    }


    //扫描一遍
    //https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


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

        Solution19 solution19=new Solution19();
        ListNode head=solution19.removeNthFromEnd(node1,4);
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }

    }
}
