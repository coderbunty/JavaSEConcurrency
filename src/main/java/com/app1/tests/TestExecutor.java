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
        
        /**
        ExecutorService execService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futResultsList = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; i++) {
          futResultsList.add(execService.submit(new GenerateRandom()));
        }

        // System.out.println(futResultsList.get(0).get()); // this future get() is a blocking operation

        // do some other work
        Thread.sleep(1000);

        // print out all the future results
        futResultsList.stream()
            .forEach(e -> {
              try {
                System.out.println(e.get());
              } catch (InterruptedException | ExecutionException exc) {
                exc.printStackTrace();
              }
            });

        // clean up
        execService.shutdown();
        **/
    }
}
