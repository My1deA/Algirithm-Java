package com.example.demo.pass.test.sz;

public class T4 {
    static {
        System.out.println("main static 1");
    }

    public static void main(String[] args) {
        System.out.println("main start");
        A a=new A();
        System.out.println(A.n);
        System.out.println(a.n);
    }
    static {
        System.out.println("main static 2");
    }
}

class A{
    {
        System.out.println("A {}");
    }

    public static int n=100;
    static {
        System.out.println("A static {}");
        n=30;
    }

    public A(){
        System.out.println("A constructor");
    }
}
