package com.example.demo.cur.hottop;

import com.example.demo.cur.hottop.share.ListNode;

public class Hot23 {


    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0, lists.length-1);
    }

    public ListNode merge(ListNode[] listNodes,int left,int right){
        // 超出范围
        if(left > right)return null;
        // 返回自己
        if(left==right) return listNodes[left];
        // 中点
        int mid=(left+right)/2;
        // 二分求出
        ListNode leftNode=merge(listNodes,left,mid);
        ListNode rightNode=merge(listNodes,mid+1,right);
        ListNode mergeNode=mergeListNode(leftNode,rightNode);
        return mergeNode;
    }

    public ListNode mergeListNode(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if (l2==null) return l1;

        ListNode head=null;
        ListNode pre=null;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                if(head==null){
                    head=l1;
                    pre=l1;
                }else{
                    pre.next=l1;
                    pre=pre.next;
                }
                l1=l1.next;
            }else{
                if(head==null){
                    head=l2;
                    pre=l2;
                }else{
                    pre.next=l2;
                    pre=pre.next;
                }
                l2=l2.next;
            }
        }

        if(l1==null) pre.next=l2;
        else if(l2==null) pre.next=l1;

        return head;
    }


}

/* 暴力解法 O（n*n*logn）
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }
*/

