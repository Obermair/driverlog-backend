package com.example.services;

import com.example.entities.Driver;
import com.example.entities.Fuel;
import com.example.repositories.DriverRepository;
import com.example.repositories.FuelRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@ApplicationScoped
@Path("/api/fuel")
public class FuelService {

    @Inject
    FuelRepository fuelRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Fuel find(@PathParam("id") long id){
        return fuelRepository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fuel> findAll(){
        return fuelRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createFuel(Fuel fuel, @Context UriInfo uriInfo){

        fuelRepository.persist(fuel);
        URI uri =
                uriInfo.getAbsolutePathBuilder().path(Long.toString(fuel.id)).build();
        return Response.created(uri).entity(fuel).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteFuel(@PathParam("id") long id){
        fuelRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateFuel(Fuel f){
        fuelRepository.update(f);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
