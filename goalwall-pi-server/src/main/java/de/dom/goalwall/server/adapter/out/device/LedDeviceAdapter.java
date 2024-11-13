package de.dom.goalwall.server.adapter.out.device;

import com.diozero.api.function.Action;
import com.diozero.devices.LED;
import de.dom.goalwall.server.application.port.out.LedPort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LedDeviceAdapter implements LedPort {

    private static Map<Integer, LED> leds = new HashMap<>();

    private static final LED topLeft = new LED(27,true);
    private static final LED topCenter = new LED(23,true);
    private static final LED topRight = new LED(24,true);
    private static final LED center = new LED(17,true);
    private static final LED bottomLeft = new LED(22,true);
    private static final LED bottomCenter = new LED(4,true);
    private static final LED bottomRight = new LED(25,true);

    private List<LED> all(){
        return Arrays.asList( topLeft,topCenter,topRight,center,bottomLeft,bottomCenter,bottomRight);
    }

    @Override
    public void allOn() {
        all().forEach( led -> {led.on();});
    }

    @Override
    public void allOff() {
        all().forEach( led -> {led.off();});
    }

    @Override
    public void drawO() {
        allOff();
        top();
        bottom();
    }

    @Override
    public void drawNumber(int n) {
        allOff();
        switch (n){
            case 1:
                draw1();
                break;
            case 2:
                draw2();
                break;
            case 3:
                draw3();
                break;
            case 4:
                draw4();
                break;
            case 5:
                draw5();
                break;
            case 6:
                draw6();
                break;
            case 7:
                draw7();
                break;
            case 8:
                draw8();
                break;
            case 9:
                draw9();
                break;
            case 0:
                draw0();
                break;

            default:
                int mod = n % 10;
                drawNumber(mod);
                break;
        }
    }

    @Override
    public void countDownFrom(int i) {
        int sleep = 1000;
        for( int c = i; c >= 0; c--){
            drawNumber(c);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
            }
        }
    }

    private void top(){
        topLeft.on();
        topCenter.on();
        topRight.on();
    }

    private void bottom(){
        bottomLeft.on();
        bottomCenter.on();
        bottomRight.on();
    }

    private void draw0(){
        allOff();
        top();
        bottom();
    }

    private void draw1(){
        allOff();
        topRight.on();
        bottomRight.on();
    }

    private void draw2(){
        allOff();
        topCenter.on();
        topRight.on();
        center.on();
        bottomLeft.on();
        bottomCenter.on();
    }

    private void draw3(){
        allOff();
        topCenter.on();
        center.on();
        bottomCenter.on();
        topRight.on();
        bottomRight.on();
    }

    private void draw4(){
        allOff();
        topLeft.on();
        center.on();
        topRight.on();
        bottomRight.on();
    }

    private void draw5(){
        allOff();
        topLeft.on();
        topCenter.on();
        center.on();
        bottomRight.on();
        bottomCenter.on();
    }

    private void draw6(){
        allOff();
        topLeft.on();
        topCenter.on();
        center.on();
        bottom();
    }

    private void draw7(){
        allOff();
        topCenter.on();
        topRight.on();
        bottomRight.on();
    }

    private void draw8(){
        allOn();
    }

    private void draw9(){
        allOff();
        top();
        center.on();
        bottomRight.on();
        bottomCenter.on();
    }

    public void init( final float duration, final float cooldown, final boolean async, int rounds ){
        new Thread(
                ()->{
                    long sleep = 1500L;
                    for( int i = 0; i < rounds; i++){
                        topCenter.blink(duration ,cooldown,1,async);
                        topRight.blink(duration ,cooldown,1,async);
                        center.blink(duration ,cooldown,1,async);
                        bottomLeft.blink(duration ,cooldown,1,async);
                        bottomCenter.blink(duration ,cooldown,1,async);
                        bottomRight.blink(duration ,cooldown,1,async);
                        center.blink(duration ,cooldown,1,async);
                        topLeft.blink(duration ,cooldown,1,async);
                    }

                }
        ).start();


    }

}
