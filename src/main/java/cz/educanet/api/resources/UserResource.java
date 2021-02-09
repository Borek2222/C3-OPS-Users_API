package cz.educanet.api.resources;


import cz.educanet.api.User;
import cz.educanet.api.UserManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)

public class UserResource {

    @Inject
    private UserManager userManager;


    // Show list
    @GET
    @Path("users")
    public Response getAll() {
        return Response.ok(userManager.getUsers()).build();
    }


    // Show User
    @GET
    @Path("/{id}")
    public Response showUser(User user) {

        if (userManager.getUser(user))
            return Response.ok("ID" + user.getId() + "Username:  " + user.getUsername() + "\nName: " + user.getName() + "\nEmail: " + user.getEmail()).build();

        return Response.status(406).build();
    }
}


