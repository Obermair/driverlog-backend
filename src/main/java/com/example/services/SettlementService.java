package com.example.services;

import com.example.entities.Fuel;
import com.example.entities.Settlement;
import com.example.repositories.FuelRepository;
import com.example.repositories.RepairRepository;
import com.example.repositories.RideRepository;
import com.example.repositories.SettlementRepository;

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
@Path("/api/settlement")
public class SettlementService {

    @Inject
    SettlementRepository settlementRepository;

    @Inject
    RideRepository rideRepository;

    @Inject
    RepairRepository repairRepository;

    @Inject
    FuelRepository fuelRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Settlement find(@PathParam("id") long id){
        return settlementRepository.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Settlement> findAll(){
        return settlementRepository.listAll();
    }

    @GET
    @Path("lastRecord")
    @Produces(MediaType.APPLICATION_JSON)
    public Object getLastSettlement(){
        return settlementRepository.getLastSettlement();
    }

    @DELETE
    @Path("deleteSettlementData")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSettlementData(){
        rideRepository.deleteAll();
        fuelRepository.deleteAll();
        repairRepository.deleteAll();

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createSettlement(Settlement settlement, @Context UriInfo uriInfo){

        settlementRepository.persist(settlement);
        URI uri =
                uriInfo.getAbsolutePathBuilder().path(Long.toString(settlement.id)).build();
        return Response.created(uri).entity(settlement).build();
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteSettlement(@PathParam("id") long id){
        settlementRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateSettlement(Settlement s){
        settlementRepository.update(s);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
