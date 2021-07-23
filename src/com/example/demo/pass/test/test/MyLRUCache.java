package com.example.demo.pass.test.test;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {

    private  int capacity=0;
    private  Map<Integer,Node> map=new HashMap<>();
    private  Node head;
    private  Node tail;

    public MyLRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }

    static class Node{
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    public int get(int key) {

        if(map.containsKey(key)){
            Node node=map.get(key);
            movetoTail(node,false);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //包含key
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            map.put(key,node);
            movetoTail(node,false);
        }else{
            //不包含key
            Node node=new Node(key,value);
            map.put(key,node);
            movetoTail(node,true);

            if(map.size()>capacity){
                delete(head.next.key);
            }

        }
    }

    public void delete(int key){
        Node node=map.get(key);
        node.pre.next=node.next;
        node.next.pre=node.pre;
        map.remove(key);
    }

    //是否新增
    public void movetoTail(Node node,Boolean insert){
        //更新数据
        if(!insert){
            node.next.pre=node.pre;
            node.pre.next=node.next;
        }
        //放在队尾 先修改pre后修改next
        tail.pre.next=node;
        node.pre=tail.pre;
        node.next=tail;
        tail.pre=node;
    }

    public static void main(String[] args) {
        MyLRUCache cache=new MyLRUCache(1);

        cache.put(2,1);
        System.out.println(cache.get(2));


    }


}
