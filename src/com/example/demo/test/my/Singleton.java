package com.example.demo.test.my;

public class Singleton {

    /*静态内部类不会随着外部类的加载而加载 ,只有静态内部类的静态成员被调用时才会进行加载 ,
    这样既保证的惰性初始化，又由JVM保证了多线程并发访问的正确性。*/
    private static class Inner{
        private static Singleton singleton=new Singleton();
    }

    public static Singleton getInstance(){
        return Inner.singleton;
    }


}
