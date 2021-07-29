package com.example.demo.cur.hottop.hot20;

import com.example.demo.cur.hottop.share.ListNode;

public class Hot19 {
    // 快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        ListNode q=head;

        // 前指针向后遍历 n 个位置
        for(int i=0;i<n;i++){
            q=q.next;
        }

        // q已经是null了，则表明是删除第一个元素 直接返回head.next
        if(q==null){
            return head.next;
        }


        // 直至 q 为最后一个元素
        while(q.next!=null){
            p=p.next;
            q=q.next;
        }
        // 直接指到 需要删除node 的后面的 node
        p.next=p.next.next;

        return head;
    }
}
