package com.example.services;

import com.example.entities.Driver;
import com.example.entities.Repair;
import com.example.entities.Ride;
import com.example.repositories.DriverRepository;
import com.example.repositories.RepairRepository;
import com.example.repositories.RideRepository;

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
@Path("/api/ride")
public class RideService {

    @Inject
    RideRepository rideRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Ride find(@PathParam("id") long id){
        return rideRepository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ride> findAll(){
        return rideRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createRepair(Ride ride, @Context UriInfo uriInfo){

        rideRepository.persist(ride);
        URI uri =
                uriInfo.getAbsolutePathBuilder().path(Long.toString(ride.id)).build();
        return Response.created(uri).entity(ride).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteRepair(@PathParam("id") long id){
        rideRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateRide(Ride r){
        rideRepository.update(r);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
