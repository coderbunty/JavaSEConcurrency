package com.app2.runnables;

import com.app2.tasks.AttackTask;

import java.util.logging.Logger;

public class Worker implements Runnable {

    private static final Logger LOG = Logger.getLogger(Worker.class.getName());
    private final AttackTask task;

    public Worker (final AttackTask task) {
        this.task = task;
    }

    public void run() {
        LOG.info(Thread.currentThread().getName() + " processing " + task.toString());
        try {
            Thread.sleep(task.getTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
