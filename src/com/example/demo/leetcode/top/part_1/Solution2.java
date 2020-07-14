package com.example.demo.leetcode.top.part_1;

import com.example.demo.leetcode.top.common.ListNode;

import java.util.Stack;

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
