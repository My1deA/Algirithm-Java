package com.example.demo.pass.concurrent.mutli.test2;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {

    private volatile static CountDownLatch countDownLatch=new CountDownLatch(5);
    private volatile static CountDownLatch start=new CountDownLatch(1);

    static class MyThread implements Runnable{
        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 倒数中...");
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("倒数开始...");;
        for(int i=0;i<5;i++){
            Thread thread=new Thread(new MyThread());
            thread.start();
        }
        start.countDown();
        countDownLatch.await();
        System.out.println("倒数结束...");

    }
}
