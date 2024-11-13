package de.dom.goalwall.server.adapter.in.webapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.diozero.devices.LED;
import de.dom.goalwall.server.adapter.out.device.LedDeviceAdapter;
import de.dom.goalwall.server.application.game.counter.CountGame;
import jakarta.ws.rs.*;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;

@Path("led")
public class LedWebApi {

    @Inject
    Logger logger;

    @Inject
    LedDeviceAdapter ledDeviceAdapter;

    @POST()
    @Path("on")
    public String on(@QueryParam("port") @DefaultValue("22") int port ){
        this.ledDeviceAdapter.allOn();
        return "OK";
    }

    @POST()
    @Path("off")
    public String off(@QueryParam("port") @DefaultValue("22") int port ){
        this.ledDeviceAdapter.allOff();
        return "OK";
    }

    @POST
    @Path("number/{nr}")
    public String number(@PathParam("nr") @DefaultValue("0") int nr){
        CountGame game = new CountGame(ledDeviceAdapter);
        game.number( nr );
        return "ok";
    }

    @POST
    @Path("init")
    public String init(
            @QueryParam("duration") @DefaultValue("1.5") float duration,
            @QueryParam("cooldown") @DefaultValue("1.5") float cooldown,
            @QueryParam("rounds") @DefaultValue("1") int rounds,
            @QueryParam("async") @DefaultValue("false") boolean async
    ){
        ledDeviceAdapter.init( duration , cooldown,async , rounds);
        return "ok";
    }

    @GET
    public String python(){

        try {
            String s = null;
            // run the Unix "ps -ef" command
                // using the Runtime exec method:
                Process p = Runtime.getRuntime().exec("python python/test.py");

                
                BufferedReader stdInput = new BufferedReader(new 
                     InputStreamReader(p.getInputStream()));
    
                BufferedReader stdError = new BufferedReader(new 
                     InputStreamReader(p.getErrorStream()));
    
                // read the output from the command
                System.out.println("Here is the standard output of the command:\n");
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
                
                // read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                }
                
            }
            catch (IOException e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
            }

        return "";
    }


    @POST
    public String execute(){
        logger.info("led");
        return "";
    }


    
}
