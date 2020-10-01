package com.example.demo.concurrent.mutli;

//多线程求和
public class MutliAdd {
    //公共变量
    int count=0;
    public static void main(String[] args){
        //new一个实现Runnable的类
        MutliAdd test=new MutliAdd();
        //创建5个任务
        MyRunnable myRunnable1=test.new MyRunnable();
        MyRunnable myRunnable2=test.new MyRunnable();
        MyRunnable myRunnable3=test.new MyRunnable();
        MyRunnable myRunnable4=test.new MyRunnable();
        MyRunnable myRunnable5=test.new MyRunnable();
        //创建5个线程
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
        new Thread(myRunnable4).start();
        new Thread(myRunnable5).start();
    }
    //创建一个实现Runnable的类
    class MyRunnable implements Runnable{
        public void run() {
            while(true){
                //锁住的是整个MyRunnable类
                synchronized(MyRunnable.class){
                    if(count>=1000){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+":count:"+(++count));
                    //测试时，线程更容易切换
                    Thread.yield();
                }

            }
        }

    }
}


