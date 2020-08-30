package com.app2.tasks;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AttackTask {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
    private final int id;
    private final int timeMS;

    public AttackTask(int timeMS) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.timeMS = timeMS;
    }

    public int getId() {
        return id;
    }

    public int getTimeMS() {
        return timeMS;
    }

    @Override
    public String toString() {
        return "id = " + this.id + ", time in ms = " + this.timeMS;
    }
}
