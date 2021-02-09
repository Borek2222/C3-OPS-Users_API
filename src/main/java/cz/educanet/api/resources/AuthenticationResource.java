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
    public Response registerUser(User user) {
        if (userManager.createUser(user.getId(), user.getUsername(), user.getName(), user.getEmail()))
            return Response.ok("User " + user.getUsername() + " Created!").build();
        else
            return Response.status(406).build();
    }


    @PUT
    @Path("/{id}/edit")
    public Response editUser(@PathParam("username") String username) {
        return Response.ok().build();
    }

    // Logout
    @DELETE
    @Path("/{id}/delete")
    public Response deleteUser() {
        User user = new User("","", "", "");

        if (!userManager.delete(user))
            return Response.ok("User deleted").build();
        else
            return Response.status(406).build();
    }
}