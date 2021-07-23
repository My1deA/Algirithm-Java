package com.example.demo.pass.concurrent.mutli.test2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor {

    static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"....");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new MyThread());
        }
        executorService.shutdown();


    }
}
