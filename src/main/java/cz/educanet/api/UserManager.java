package cz.educanet.api;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;

public class UserManager {

    ArrayList<User> userList = new ArrayList<>();

    // @POST
    public boolean register(@QueryParam("username") String username, String name, @QueryParam("email") String email, String password) {
        User user = new User(username, name, email, password);

        return false;
    }

    public boolean usernameDuplicate(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(user.getUserName()))
                return true;
            else
                return false;

        }
        return false;
    }

    // @POST
    public boolean login() {
        return false;
    }

    // @GET
    public boolean getUser() {
        return false;
    }

    // @DELETE
    public boolean logout() {
        return true;
    }
}
