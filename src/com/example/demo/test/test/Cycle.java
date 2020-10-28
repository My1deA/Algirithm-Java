package com.example.demo.test.test;

import com.example.demo.leetcode.top.common.ListNode;

public class Cycle {
    public boolean hasCycle(ListNode head){
        ListNode p=head;
        ListNode q=head;
        while(p!=null && p.next!=null){
            p=p.next.next;
            q=q.next;
            if(q==p){
                return true;
            }
        }
        return false;
    }
}
