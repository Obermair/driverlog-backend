package com.example.services;

import com.example.entities.Driver;
import com.example.entities.Ride;
import com.example.repositories.DriverRepository;

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
@Path("/api/driver")
public class DriverService {

    @Inject
    DriverRepository driverRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Driver find(@PathParam("id") long id){
        return driverRepository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("driven/{id}")
    public Object driven(@PathParam("id") long id){
        return driverRepository.drivenKilometers(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("fuelCredits/{id}")
    public Object fuelCredits(@PathParam("id") long id,  @Context UriInfo uriInfo){

        return driverRepository.fuelCredits(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("repairCredits/{id}")
    public Object repairCredits(@PathParam("id") long id){
        return driverRepository.repairCredits(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rides/{id}")
    public List<Ride> rides(@PathParam("id") long id){
        return driverRepository.lastRides(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Driver> findAll(){
        return driverRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createDriver(Driver driver, @Context UriInfo uriInfo){

        driverRepository.persist(driver);
        URI uri =
                uriInfo.getAbsolutePathBuilder().path(Long.toString(driver.id)).build();
        return Response.created(uri).entity(driver).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteDriver(@PathParam("id") long id){
        driverRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateDriver(Driver d){
        driverRepository.update(d);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
