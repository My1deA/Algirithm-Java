package com.example.demo.concurrent.mutli.test2;

//模拟死锁
public class MyDeadLock {

    private volatile static int i=0;
    private volatile static Object x=new Object();
    private volatile static Object y=new Object();

    static class MyThread implements Runnable{

        @Override
        public void run() {
            if(i==0){
                //抢第一个叉子
                synchronized (x){
                    i++;
                    System.out.println(Thread.currentThread().getName()+" 抢到了第一个叉子... ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (y){
                        System.out.println(Thread.currentThread().getName()+" 抢到了第二个叉子... ");
                    }
                }
            }else{
                //抢第二个叉子
                synchronized (y){
                    i--;
                    System.out.println(Thread.currentThread().getName()+" 抢到了第二个叉子... ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (x){
                        System.out.println(Thread.currentThread().getName()+" 抢到了第一个叉子... ");
                    }

                }
            }

        }
    }



    public static void main(String[] args) {
        Thread thread1=new Thread(new MyThread());
        Thread thread2=new Thread(new MyThread());
        thread1.start();
        thread2.start();
    }


}
