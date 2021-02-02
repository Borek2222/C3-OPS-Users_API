package cz.educanet.api.resources;

import cz.educanet.api.User;
import cz.educanet.api.UserManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authentication")
@Produces(MediaType.APPLICATION_JSON)

public class AuthenticationResource {

    @Inject
    private  UserManager userManager;


    // Create
    @POST
    @Path("/create")
    public Response registerUser(String id, @FormParam("username") String username, @FormParam("name") String name, @FormParam("email") String email) {
        if (userManager.createUser(id, username, name, email))
            return Response.ok("User " + username + " Created!").build();
        else
            return Response.status(406).build();
    }


    @PUT
    @Path("/edit")
    public Response editUser(@PathParam("username") String username) {
        return Response.ok().build();
    }

    // Logout
    @DELETE
    @Path("/delete")
    public Response deleteUser() {
        User user = new User("","", "", "");

        if (!userManager.delete(user))
            return Response.ok("Logged out").build();
        else
            return Response.status(406).build();
    }
}