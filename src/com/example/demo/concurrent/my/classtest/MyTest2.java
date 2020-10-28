package com.example.demo.concurrent.my.classtest;

public class MyTest2 {

    static class A{
        private static class B{
            public static void main(String[] args) {
                System.out.println("hi");
            }
        }
    }

    public static void main(String[] args) {
        double a=0.10;
        double b=0.40;
        System.out.println(a);
        System.out.println(b);
        System.out.println(b-a);
    }
}
