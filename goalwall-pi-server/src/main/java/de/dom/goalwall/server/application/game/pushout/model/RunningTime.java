package de.dom.goalwall.server.application.game.pushout.model;

public class RunningTime {

    private final long start;

    public RunningTime(long start) {
        this.start = start;
    }

    public long millsSinceStart() {
        return System.currentTimeMillis() - start;
    }

    public long secondsSinceStart() {
        return millsSinceStart() / 1000;
    }

    public boolean lastNSeconds( int nSeconds, int timeInSeconds ){
        long last = timeInSeconds - secondsSinceStart();
        return last <= nSeconds;
    }

    public static RunningTime start(){
        return new RunningTime(System.currentTimeMillis());
    }

}
