package com.example.demo.cur.hottop.hot20;

import com.example.demo.cur.hottop.share.ListNode;

public class Hot2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p=new ListNode(0);
        ListNode head=p;
        int carry=0;//进位
        int val=0;
        while(l1!=null || l2!=null || carry!=0){
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            if(carry!=0){
                val+=carry;
            }

            ListNode node=new ListNode(val%10);
            p.next=node;
            p=p.next;

            carry=val/10;
            val=0;
        }

        return head.next;
    }

}
