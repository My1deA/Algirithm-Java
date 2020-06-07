package com.example.demo.leetcode.offer.stack;


import java.util.Stack;

/*  面试题30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
调用 min、push 及 pop 的时间复杂度都是 O(1)

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.min();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.min();   --> 返回 -2.

    各函数的调用总次数不超过 20000 次
    ["MinStack","push","push","push","top","pop","min","pop","min","pop","push","top","min","push","top","min","pop","min"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

 */
public class Title30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

class MinStack {

    private Integer minValue;
    private Stack<Integer> stack;
    private Stack<Integer> minStack;//防止stack pop后丢失最小值 需要建立一个minStack/数组 来存储 次最小值
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<Integer>();
        minStack=new Stack<Integer>();
        minValue=Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        if(minValue>=x){//证明 原始栈中有多个 min值
            minValue=x;
            minStack.push(x);
        }
    }

    public void pop() {
        Integer t=stack.pop();
        if (t.equals(minValue)){//包装类型使用 equels 比较值
            minStack.pop();
            if(minStack.isEmpty()){
                minValue=Integer.MAX_VALUE;
            }else{
                minValue=minStack.peek();
            }

        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minValue;
    }
}