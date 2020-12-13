package cz.educanet.api.resources;


import cz.educanet.api.User;
import cz.educanet.api.UserManager;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
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
    public Response showUser(@FormParam("username") String username, @FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password) {

        User user = new User(username, name, email, password);

        if (userManager.login(user)) {
            if (userManager.getUser(user))
                return Response.ok("Username:  " + username + "\nName: " + name + "\nEmail: " + email).build();
        }

        return Response.status(406).build();
    }
}


