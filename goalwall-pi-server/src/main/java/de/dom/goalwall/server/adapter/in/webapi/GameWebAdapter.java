package de.dom.goalwall.server.adapter.in.webapi;

import de.dom.goalwall.server.application.game.Game;
import de.dom.goalwall.server.application.game.GameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;

@Path("game")
@Produces(MediaType.APPLICATION_JSON)
public class GameWebAdapter {

    @Inject
    GameService service;

    @GET
    public Response games(){
        var map = Game.games();
        return Response.ok(map).build();
    }

    @POST
    @Path("/{id}/info")
    public Response info(@PathParam("id") int id){

        return Response.ok().build();
    }

    @POST
    @Path("/{id}/start")
    public Response start(@PathParam("id") int id){
        service.start( id );
        return Response.ok().build();
    }

    @POST
    @Path("/{id}/stop")
    public Response stop(@PathParam("id") int id){
        this.service.stop();
        return Response.ok().build();
    }

    @POST
    @Path("/{id}/hit")
    public Response hit(@PathParam("id") int id){
        this.service.hit();
        return Response.ok().build();
    }

}
