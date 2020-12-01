package cz.educanet.api;

public class User {
   private String username, name, email, password;

    public User(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
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


    // get PASSWORD
    public String getPassword() {
        return password;
    }
}
