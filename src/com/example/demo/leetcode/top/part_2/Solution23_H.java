package com.example.demo.leetcode.top.part_2;

/*
给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。

        示例 1：
        输入：lists = [[1,4,5],[1,3,4],[2,6]]
        输出：[1,1,2,3,4,4,5,6]
        解释：链表数组如下：
        [
        1->4->5,
        1->3->4,
        2->6
        ]
        将它们合并到一个有序链表中得到。
        1->1->2->3->4->4->5->6

        示例 2：
        输入：lists = []
        输出：[]

        示例 3：
        输入：lists = [[]]
        输出：[]

        提示：
        k == lists.length
        0 <= k <= 10^4
        0 <= lists[i].length <= 500
        -10^4 <= lists[i][j] <= 10^4
        lists[i] 按 升序 排列
        lists[i].length 的总和不超过 10^4*/

import com.example.demo.leetcode.top.common.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution23_H {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null)return null;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode listNode=lists[i];
            while(listNode!=null){
                ans.add(listNode.val);
                listNode=listNode.next;
            }
        }
        if(ans.size()>0) {
            int[] a = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                a[i] = ans.get(i);
            }
            mergeSort(a, 0, a.length - 1);

            ListNode head = new ListNode(0);
            ListNode cur = new ListNode(a[0]);
            head.next = cur;

            for (int i = 1; i < a.length; i++) {
                ListNode node = new ListNode(a[i]);
                cur.next = node;
                cur = cur.next;
            }
            return head.next;
        }
        return null;
    }

    public static void mergeSort(int[] a,int left,int right){
        if(left>=right)return;
        int mid=(left+right)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);

    }

    public static void merge(int[] a,int left,int mid,int right){
        int [] t=new int[a.length];
        for(int k=left,i=left,j=mid+1; k<=right;k++){
            if(i>mid){
                t[k]=a[j++];
            }else if(j>right){
                t[k]=a[i++];
            }else if(a[i]<=a[j]){
                t[k]=a[i++];
            }else{
                t[k]=a[j++];
            }
        }

        for(int i=left;i<=right;i++){
            a[i]=t[i];
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes=new ListNode[3];
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(4);
        ListNode n3=new ListNode(5);
        n1.next=n2;
        n2.next=n3;

        ListNode n4=new ListNode(1);
        ListNode n5=new ListNode(3);
        ListNode n6=new ListNode(4);
        n4.next=n5;
        n5.next=n6;

        ListNode n7=new ListNode(2);
        ListNode n8=new ListNode(6);
        n7.next=n8;

        listNodes[0]=n1;listNodes[1]=n4;listNodes[2]=n7;
        ListNode listNode=mergeKLists(listNodes);
        while(listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }

    }
    
}
