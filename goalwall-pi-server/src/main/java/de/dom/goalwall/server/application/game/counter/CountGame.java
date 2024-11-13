package de.dom.goalwall.server.application.game.counter;

import de.dom.goalwall.server.application.game.Game;
import de.dom.goalwall.server.application.port.out.LedPort;

public class CountGame implements Game {

    private final LedPort ledPort;

    private int counter = 0;


    public CountGame(LedPort ledPort) {
        this.ledPort = ledPort;
    }

    public void number( int i ){
        this.ledPort.drawNumber( i );
    }

    @Override
    public void start() {
        this.counter = 0;
        this.ledPort.allOff();
    }

    @Override
    public void stop() {
        this.ledPort.allOff();
    }

    @Override
    public void hit() {
        this.counter++;
        this.ledPort.drawNumber( this.counter );
    }

    @Override
    public String name() {
        return "Counter";
    }

}
