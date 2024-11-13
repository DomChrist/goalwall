package de.dom.goalwall.server.application.game;

import de.dom.goalwall.server.application.game.counter.CountGame;
import de.dom.goalwall.server.application.port.out.LedPort;
import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.eventbus.Message;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameService {

    Game activeGame;

    private final LedPort ledPort;

    public GameService(LedPort ledPort) {
        this.ledPort = ledPort;
    }

    public void start( int game ){
        var g = routeById(game);
        if( g != null ) this.start( g );
    }

    public void start( Game game ){
        if( this.activeGame != null ){
            this.activeGame.stop();
            this.activeGame = null;
        }
        this.ledPort.countDownFrom(3);
        this.activeGame = game;
    }

    public void stop(){
        if( this.activeGame != null ){
            this.activeGame.stop();
            this.activeGame = null;
        }
    }

    public void hit(){
        if( this.activeGame != null ){
            this.activeGame.hit();
        }
    }

    @ConsumeEvent(value = "ButtonPressed")
    public void buttonListener(Message<String> message){
        if( this.activeGame != null ){
            this.hit();
        }
    }

    private Game routeById( int id){
        switch (id){
            case Game.GAME_COUNTER:
                return new CountGame(ledPort);
                default:
                    return null;
        }
    }

}
