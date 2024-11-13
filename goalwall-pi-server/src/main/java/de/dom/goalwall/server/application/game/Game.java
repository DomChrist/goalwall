package de.dom.goalwall.server.application.game;

import java.util.HashMap;
import java.util.Map;

public interface Game {

    public static int GAME_COUNTER = 1_001;

    public static Map<Integer,String> games(){
        Map<Integer,String> map = new HashMap<>();
            map.put( GAME_COUNTER , "COUNTER");
        return map;
    }

    public void start();

    public void stop();

    public void hit();

    public String name();

}
