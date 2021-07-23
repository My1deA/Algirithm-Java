package com.example.demo.pass.leetcode.offer.link;

/*  面试题18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

示例 2:
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 
说明： 题目保证链表中节点的值互不相同
 */
class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre=head;
        ListNode next=head.next;
        while(next != null){
            if(next.val == val){
                pre.next=next.next;
                next=next.next;
            }
            //不等于null 就下一个
            if(next !=null){
                pre=next;
                next=next.next;
            }
        }
       /* while(next != null && next.val != val){
            pre=next;
            next=next.next;
        }
        //防止输入 非链表数值
        if(next !=null){
            pre.next=next.next;
        }*/

        return head;
    }
}

public class Title18 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        Solution18 solution18=new Solution18();
        ListNode cur=solution18.deleteNode(node1,4);
        while(cur !=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}