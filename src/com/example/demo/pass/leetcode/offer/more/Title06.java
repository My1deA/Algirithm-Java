package com.example.demo.pass.leetcode.offer.more;

import java.util.ArrayList;
import java.util.Collections;

/* 面试题06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
 
限制： 0 <= 链表长度 <= 10000
 */
class Solution06 {
    private ArrayList<Integer> list=new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        if(head==null)return new int[0];
        while(head != null){
            list.add(head.val);
            head=head.next;
        }
        Collections.reverse(list);
        int [] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]= list.get(i);
        }
        return ans;
    }
}
public class Title06 {
    public static void main(String[] args) {

    }
}
