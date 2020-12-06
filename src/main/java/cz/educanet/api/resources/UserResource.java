package cz.educanet.api.resources;

import cz.educanet.api.UserManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("authentication")
@Produces(MediaType.APPLICATION_JSON)

public class UserResource {

    private  UserManager userManager = new UserManager();

    // Register
    @POST
    @Path("/authentication/register")
    public Response registerUser(@FormParam("username") String username, String name, @FormParam("email") String email, String password) {
        if (userManager.register(username, name, email, password))
            return Response.ok("User Created").build();
        else
            return Response.status(406).build();
    }

    // login
    @POST
    @Path("/authentication/login")
    public Response loginUser() {
        return Response.ok().build();
    }

    // Show User
    @GET
    @Path("/{username}")
    public Response showUser() {
        return Response.ok().build();
    }


    // Logout
    @DELETE
    @Path("{username}/authentication/logout")
    public Response logout() {
        return Response.ok().build();
    }
}