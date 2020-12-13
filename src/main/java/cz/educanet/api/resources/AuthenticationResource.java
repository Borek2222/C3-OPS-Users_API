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


    // Register
    @POST
    @Path("/register")
    public Response registerUser(@FormParam("username") String username, @FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password) {
        if (userManager.register(username, name, email, password))
            return Response.ok("User " + username + " Created!").build();
        else
            return Response.status(406).build();
    }

    // Login
    @POST
    @Path("/login")
    public Response loginUser(@FormParam("username") String username, @FormParam("password") String password) {
        User user = new User(username,"", "", password);

        if (userManager.login(user))
            return Response.ok("Logged in!").build();
        else
            return Response.status(406).build();
    }


    // Logout
    @DELETE
    @Path("/authentication/logout")
    public Response logout() {
        return Response.ok().build();
    }
}