package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("getapiinfo")
public class apiinfo {
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public Response replyApiDetails() {
        System.out.println("jestem w klasie getapiinfo");
        Response response = Response.status(200).entity("API Details").build();
        return response;
        }
    }
