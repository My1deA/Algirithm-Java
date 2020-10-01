package com.example.demo.concurrent.mutli.test2;

import java.util.concurrent.Semaphore;

//信号量
public class MySemaphore {

    private volatile static Semaphore semaphore=new Semaphore(3);

    static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+"获取锁....");
                System.out.println(Thread.currentThread().getName()+"在运行.....");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"释放锁....");
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Thread thread=new Thread(new MyThread());
            thread.start();
        }

    }
}
