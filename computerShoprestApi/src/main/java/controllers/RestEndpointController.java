package controllers;


import model.Part;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/store")
@Stateless
public class RestEndpointController {


    @PersistenceContext
    EntityManager em;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Part part) {
        em.persist(part);
        return Response.ok().build();
    }

    @GET
    @Path("/parts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Part> getAllParts() {
        return em.createNamedQuery("part.all", Part.class).getResultList();
    }

    @GET
    @Path("/part/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPointedPart(@PathParam("id") int id) {
        Part part;
        try {
            part = em.createNamedQuery("part.id", Part.class).setParameter("partId", id).getSingleResult();
        }catch (NoResultException e){
            part = null;
        }
        return Response.ok(part).build();
    }

    @PUT
    @Path("/part/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPointedPart(@PathParam("id") int id,Part p) {
        Part part;
        try {
            part = em.createNamedQuery("part.id", Part.class).setParameter("partId", id).getSingleResult();
            part.setPrice(p.getPrice());
            part.setType(p.getType());
        }catch (NoResultException e){
            part = null;
        }

        return Response.ok(part).build();

    }

    @GET
    @Path("parts/byCategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Part> getAllPartsByName(@PathParam("category") String category){
        return em.createNamedQuery("part.ByCategory",Part.class).setParameter("category",category).getResultList();
    }

    @GET
    @Path("parts/byPrice/{min}/{max}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Part> getAllPartsByPrice(@PathParam("min") int min,@PathParam("max") int max){
        return em.createNamedQuery("part.byPrice",Part.class)
                .setParameter("minPrice",min).setParameter("maxPrice",max)
                .getResultList();
    }


}
