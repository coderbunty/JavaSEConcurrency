package com.app2.tasks;

public class LandStrikeTask extends Task {

    private static final int TIME_PER_STRIKE = 500;

    public LandStrikeTask(int numOfTanks) {
        super(numOfTanks * TIME_PER_STRIKE);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
