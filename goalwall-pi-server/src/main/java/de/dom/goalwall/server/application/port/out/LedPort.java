package de.dom.goalwall.server.application.port.out;

public interface LedPort {

    void allOn();

    void allOff();

    void drawO();

    void drawNumber( int n );

    void countDownFrom( int i );

}
