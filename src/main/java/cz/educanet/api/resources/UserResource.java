package cz.educanet.api.resources;


import cz.educanet.api.UserManager;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)

public class UserResource {

    @Inject
    private UserManager userManager;


    // Show User
    @GET
    @Path("/{username}")
    public Response showUser() {
        return Response.ok().build();
    }

}
