package com.app2.tests;

import com.app2.runnables.Worker;
import com.app2.tasks.AirStrikeTask;
import com.app2.tasks.LandStrikeTask;
import com.app2.tasks.AttackTask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Test {

    private static final Logger LOG = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        LOG.info("Attacking now..");
        List<AttackTask> tasks = Arrays.asList(
            new AirStrikeTask(5),
            new LandStrikeTask(3),
            new LandStrikeTask(2),
            new AirStrikeTask(4),
            new AirStrikeTask(3),
            new AirStrikeTask(2),
            new LandStrikeTask(3),
            new LandStrikeTask(4),
            new AirStrikeTask(5),
            new LandStrikeTask(3)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /*for (Task task : tasks)
            executorService.submit(new Worker(task));*/
        tasks.stream()
             .map(e -> new Worker(e))
             .forEach(executorService::submit);

        executorService.shutdown();
        while(!executorService.isTerminated())
            Thread.yield();

        LOG.info("Attack completed..");
    }
}
