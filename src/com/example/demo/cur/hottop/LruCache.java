package com.example.demo.cur.hottop;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {

    private int cap;
    private Map<Integer,Integer> map=new LinkedHashMap<>();

    public LruCache(int capacity) {
        cap=capacity;
    }

    public int get(int key) {
        //更新链表
        if(map.containsKey(key)){
            int temp=map.get(key);
            map.remove(key);
            map.put(key,temp);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }else if(map.size()>=cap){
            Iterator<Map.Entry<Integer, Integer>> iterator=map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key,value);
    }

}
