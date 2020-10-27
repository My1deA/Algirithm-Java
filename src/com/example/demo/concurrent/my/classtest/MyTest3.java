package com.example.demo.concurrent.my.classtest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyTest3 {
    //通过remove frist来取走最迟未访问元素
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> map=new LinkedHashMap<String,Integer>(5,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return this.size()>5;
            }
        };

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

     private static void printAns(LinkedHashMap<String,Integer> map){
         Iterator iterator=map.entrySet().iterator();
         while(iterator.hasNext()){
             Map.Entry<String,Integer> entry= (Map.Entry<String, Integer>) iterator.next();
             System.out.print(entry.getKey()+":"+entry.getValue()+" ");
         }
         System.out.println();


     }
}
