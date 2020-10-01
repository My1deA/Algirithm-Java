package com.example.demo.concurrent.my.pattrn;

public class HuggrySingleton {

    private HuggrySingleton(){

    }

    private static HuggrySingleton huggrySingleton=new HuggrySingleton();

    public static HuggrySingleton getInstance(){
        return huggrySingleton;
    }


}
