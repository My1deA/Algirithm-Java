package com.example.demo.concurrent.mutli.test2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier {

    private volatile static CyclicBarrier cyclicBarrier=new CyclicBarrier(5);

    static class MyThread implements Runnable{

        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName()+" 倒数中...");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"做了A事");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"做了B事");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"做了C事");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Thread thread=new Thread(new MyThread());
            thread.start();
        }
        //System.out.println("结束了...");
    }
}
