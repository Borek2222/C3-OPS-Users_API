package cz.educanet.api;

public class User {
   private String id, username, name, email;


    public User(String id, String username, String name, String email) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
    }

    // get ID
    public String getID() {
        return id;
    }

    // get USERNAME
    public String getUserName() {
        return username;
    }

    // get NAME
    public String getName() {
        return name;
    }

    // get EMAIL
    public String getEmail() {
        return email;
    }
}
