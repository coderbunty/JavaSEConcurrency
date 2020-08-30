package com.app2.tasks;

public class AirStrikeTask extends AttackTask {

    private static final int TIME_PER_STRIKE = 100;

    public AirStrikeTask(int numOfJets) {
        super(numOfJets * TIME_PER_STRIKE);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
