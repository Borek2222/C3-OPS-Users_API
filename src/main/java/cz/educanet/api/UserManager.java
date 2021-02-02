package cz.educanet.api;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class UserManager {

    ArrayList<User> userList = new ArrayList<>();

    // @GET
    public ArrayList<User> getUsers() {
        return this.userList;
    }

    // @POST
    public boolean createUser(String id, String username, String name, String email) {
        User user = new User(id, username, name, email);

        if(searchDuplicate(user))
            return false;

        else {
            userList.add(user);
            this.userList.add(user);
            return true;
        }
    }

    // checks for user duplicates
    public boolean searchDuplicate(User user) {
        for (User value : userList) {
            return value.getUserName().equals(user.getUserName());
        }
        return false;
    }


    // @GET
    public boolean getUser(User user) {
        return find(user) != null;
    }

    public User find(User user) {
        for (User value : userList) {
            if (value.getID().equals(user.getID()))
                System.out.println(user.getID());
            return user;
        }

        System.out.println(user);

        return null;
    }

    /*
    public int getUserByID(User user) {
        if(find(user) == user)
            String id = user.getID();
            int id = Integer.parseInt(id);
            return user.getID();
        else
            return null;
    }

    // @POST
    public boolean editUser(User user, String username) {
        if(find(user) == user) {
            userList.get(getUserByID(user)).username="";
            return true;
        }
        else
            return false;
    }*/


    // @DELETE
    public boolean delete(User user) {
        return find(user) == null;
    }
}
