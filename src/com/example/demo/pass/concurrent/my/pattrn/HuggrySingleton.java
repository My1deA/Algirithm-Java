package com.example.demo.pass.concurrent.my.pattrn;

public class HuggrySingleton {

    private HuggrySingleton(){

    }

    private static HuggrySingleton huggrySingleton=new HuggrySingleton();

    public static HuggrySingleton getInstance(){
        return huggrySingleton;
    }


}
