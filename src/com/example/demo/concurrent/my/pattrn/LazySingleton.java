package com.example.demo.concurrent.my.pattrn;

public class LazySingleton {
   private LazySingleton(){

   }

   private static LazySingleton lazySingleton=null;

   public static LazySingleton getInstance(){
       if(lazySingleton==null){
           lazySingleton=new LazySingleton();
       }
       return lazySingleton;
   }

}
