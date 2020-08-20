package com.example.demo.leetcode.top.part_1;

import com.example.demo.leetcode.top.common.ListNode;

import java.util.Stack;

/*
给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

public class Solution2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        //进位
        int carry=0;
        while(l1!=null || l2 !=null || carry !=0){
            int num1=l1!=null ? l1.val : 0;
            int num2=l2!=null ? l2.val : 0;
            int sum=num1+num2+carry;

            carry=sum/10;

            ListNode node=new ListNode(sum%10);
            cur.next=node;
            cur=cur.next;

            if(l1!=null)l1=l1.next;
            if (l2!=null)l2=l2.next;

        }

        return head.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack=new Stack<>();

        int num=0;
        while(l1 !=null){
            stack.push(l1.val);
            l1=l1.next;
        }
        while(!stack.isEmpty()){
            num=num*10+stack.pop();
        }

        int num2=0;
        while(l2 !=null){
            stack.push(l2.val);
            l2=l2.next;
        }
        while(!stack.isEmpty()){
            num2=num2*10+stack.pop();

        }

        int ans=num+num2;
        ListNode head=new ListNode(ans%10);
        ListNode cur=head;
        ans=ans/10;
        while(ans!=0){
            ListNode node=new ListNode(ans%10);
            cur.next=node;
            cur=node;
            ans=ans/10;
        }

        return head;

    }

}
