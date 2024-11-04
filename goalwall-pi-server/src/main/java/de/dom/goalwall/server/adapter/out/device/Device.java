package de.dom.goalwall.server.adapter.out.device;

import org.jboss.logging.Logger;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Device {
    
    @Inject Logger logger;
    private static Runtime runtime = Runtime.getRuntime();

    public void executeScript(){
        Thread t = new Thread( ()->{
            exec("python python/led_on.py 17");
        });
        t.start();
    }


    private void exec( String cmd ){
        try{
            runtime.exec(cmd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
