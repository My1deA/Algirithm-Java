package com.example.demo.mye;

public class Son extends Father{
    @Override
    public void say(String string) {
        super.say(string);
    }

    public static void main(String[] args) {
        Son son=new Son();
        son.say("123");
    }
}
