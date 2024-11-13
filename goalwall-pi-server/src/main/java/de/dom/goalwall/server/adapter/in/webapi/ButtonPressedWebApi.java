package de.dom.goalwall.server.adapter.in.webapi;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("button")
public class ButtonPressedWebApi {
    
    @Inject
    Logger logger;

    @POST()
    @Path("pressed")
    public String pressed(){

        return "";
    }


}
