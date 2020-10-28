package com.example.demo.test.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinked {
    //通过remove frist来取走最迟未访问元素

    static Map<String,Integer> map=null;
    static Integer capacity;

    public LRUCacheLinked(int capacity){
        this.capacity=capacity;
        map=new LinkedHashMap<String,Integer>(this.capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(String key) {
        return map.get(key)!=null?map.get(key):-1;
    }

    public void put(String key, int value) {
        map.put(key,value);
    }

    public void remove(String key){
        map.remove(key);
    }


    public static void main(String[] args) {
        LRUCacheLinked lruCacheLinked=new LRUCacheLinked(5);

        map.put("A",1);
        map.put("B",1);
        map.put("C",1);
        map.put("D",1);
        map.put("E",1);
        printAns(map);
        map.put("A",2);
        printAns(map);
        map.put("Z",1);
        map.put("Y",1);
        printAns(map);

    }

     private static void printAns(Map<String,Integer> map){
         Iterator iterator=map.entrySet().iterator();
         while(iterator.hasNext()){
             Map.Entry<String,Integer> entry= (Map.Entry<String, Integer>) iterator.next();
             System.out.print(entry.getKey()+":"+entry.getValue()+" ");
         }
         System.out.println();

     }
}
