package cz.educanet.api;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
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
    public boolean login(User user) {
        return find(user) != null;
    }

    public User find(User user) {
        for (User value : userList) {
            if (value.getUserName().equals(user.getUserName()) && value.getPassword().equals(user.getPassword()))
                System.out.println(user.getUserName());
                return user;
        }

        System.out.println(user);

        return null;
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
