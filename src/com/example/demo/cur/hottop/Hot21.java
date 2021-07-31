package com.example.demo.cur.hottop;

import com.example.demo.cur.hottop.share.ListNode;

public class Hot21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 其中l1 为空 直接返回 l2
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        // 初始化 head 和 前序指针
        ListNode head=null;
        ListNode pre=null;

        while(l1!=null && l2 !=null){
            if(l1.val < l2.val){
                // 如果head pre没有初始化 则指向 l1或者l2头
                if(head==null){
                    head=l1;
                    pre=l1;
                }else{
                    //已经有数据就将 pre指向下一个数据并且往后滑动
                    pre.next=l1;
                    pre=pre.next;
                }
                l1=l1.next;
            }else {
                if(head==null){
                    head=l2;
                    pre=l2;
                }else{
                    //已经有数据就将 pre指向下一个数据并且往后滑动
                    pre.next=l2;
                    pre=pre.next;
                }
                l2=l2.next;
            }
        }

        if(l1!=null){
            pre.next=l1;
        }
        if(l2!=null){
            pre.next=l2;
        }

        return head;
    }
}
