package com.example.demo.pass.leetcode.offer.stack;


import java.util.LinkedList;


/*  面试题59 - II. 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5


*/
class MaxQueue {
    /*
    具体方法是使用一个双端队列 dequedeque，在每次入队时，如果 dequedeque 队尾元素小于即将入队的元素 valuevalue，
    则将小于 valuevalue 的元素全部出队后，再将 valuevalue 入队；否则直接入队
     */
    private LinkedList<Integer> queue;
    private LinkedList<Integer> maxQueue;

    public MaxQueue() {
        queue=new LinkedList<>();
        maxQueue=new LinkedList<>();
    }

    public int max_value() {
        if(maxQueue.isEmpty()){
            return -1;
        }else{
            return maxQueue.peek();//返回最大值
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!maxQueue.isEmpty() && value > maxQueue.getLast()){
            maxQueue.removeLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }else{
            Integer t=queue.pop();
            if (t.equals(maxQueue.peek())){
                maxQueue.pop();
            }
            return t;
        }
    }
}

public class Title59_2 {
    public static void main(String[] args) {
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(3);
        maxQueue.push_back(2);
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
