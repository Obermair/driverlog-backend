package com.example.services;

import com.example.entities.Driver;
import com.example.entities.Repair;
import com.example.repositories.DriverRepository;
import com.example.repositories.RepairRepository;

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
@Path("/api/repair")
public class RepairService {

    @Inject
    RepairRepository repairRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Repair find(@PathParam("id") long id){
        return repairRepository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Repair> findAll(){
        return repairRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createRepair(Repair repair, @Context UriInfo uriInfo){

        repairRepository.persist(repair);
        URI uri =
                uriInfo.getAbsolutePathBuilder().path(Long.toString(repair.id)).build();
        return Response.created(uri).entity(repair).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteRepair(@PathParam("id") long id){
        repairRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateRepair(Repair r){
        repairRepository.update(r);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
