package de.dom.goalwall.server.adapter.in.webapi;

import org.jboss.logging.Logger;

import de.dom.goalwall.server.adapter.out.device.Device;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("button")
public class ButtonPressedWebApi {
    
    @Inject
    Logger logger;

    @Inject
    Device device;

    @POST()
    @Path("pressed")
    public String pressed(){
        logger.info("/button");

        device.executeScript();

        return "";
    }


}
