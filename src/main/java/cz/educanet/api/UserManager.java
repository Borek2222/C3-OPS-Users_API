package cz.educanet.api;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;

public class UserManager {

    ArrayList<User> userList = new ArrayList<>();

    // @POST
    public boolean register(String username, String name, String email, String password) {
        User user = new User(username, name, email, password);

        if(userDuplicate(user))
            return false;

        else {
            userList.add(user);
            this.userList.add(user);
            return true;
        }
    }

    // checks for user duplicates
    public boolean userDuplicate(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(user.getUserName()))
                return true;
            else
                return false;

        }
        return false;
    }


    // @POST
    public boolean login(@QueryParam("username") String username, String name, @QueryParam("email") String email, String password) {
        User user = new User(username, name, email, password);

        if (userList.contains(user))
            return true;
        else
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
