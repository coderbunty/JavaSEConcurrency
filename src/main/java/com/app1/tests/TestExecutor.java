package com.app1.tests;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestExecutor {
    public static void main(String[] args) {
        System.out.println("Java SE Concurrency");
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
