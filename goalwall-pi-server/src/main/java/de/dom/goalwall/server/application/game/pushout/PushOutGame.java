package de.dom.goalwall.server.application.game.pushout;

import de.dom.goalwall.server.application.game.pushout.model.RunningTime;
import de.dom.goalwall.server.application.port.out.LedPort;

public class PushOutGame implements Runnable {

    private LedPort leds;
    private Thread thread;
    private final int maxTime = 30 * 1000;

    public PushOutGame(LedPort leds) {
        this.leds = leds;
    }

    public void start(){
        leds.allOn();
        thread = new Thread( this );
        thread.start();
    }

    public void hit(){

    }

    public void stop(){
        thread.interrupt();
    }


    @Override
    public void run() {
        RunningTime runningTime = RunningTime.start();
        while( true ){
            leds.allOn();
        }
    }
}
