package com.example.demo.leetcode.offer.stack;

import java.util.Stack;


/*用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]

        输入：
        ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
        [[],[],[5],[2],[],[]]
        输出：[null,-1,null,null,5,2]

        1 <= values <= 10000
        最多会对 appendTail、deleteHead 进行 10000 次调用
*/
public class Title09 {

    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}


class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }

    public void appendTail(int value) {
        while (!stack2.isEmpty()){
            Integer i=stack2.pop();
            stack1.push(i);
        }
        stack1.push(value);

        while (!stack1.isEmpty()){
            Integer i=stack1.pop();
            stack2.push(i);
        }
    }

    public int deleteHead() {

        if(stack2.isEmpty()){
            return -1;
        }else {
            return stack2.pop();
        }
    }
}






























