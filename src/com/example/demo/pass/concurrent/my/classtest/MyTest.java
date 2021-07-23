package com.example.demo.pass.concurrent.my.classtest;

public class MyTest {
    public int x;
    public int y;

    static class innerTest{

        public void myinner(){

        }
    }

    class innerTest2{

        public void myinner(){
            System.out.println(x+" "+y);
        }
    }




    public static void main(String[] args) {
        //MyTest.innerTest  test=new innerTest();
        MyTest myTest=new MyTest();
        MyTest.innerTest2 innerTest2=myTest.new innerTest2();

        //正数四舍五入 负数五舍六入
        System.out.println(Math.round(-1.6));
        //无论正负 取最大
        System.out.println(Math.ceil(-1.9));
    }
}
