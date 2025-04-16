package UGT_Data;

/*
    User class, will be containing
        - email, username, and password. All which the user can change if needed
    We have the function getEmail, getUsername etc.. in order to check for valid credentials when logining in

    We could've used a record java class, only one line of code for maximum efficiency, BUT
     we won't be able to change user information when needed.
 */
public class User {
    // User values
    private String email;
    private String username;
    private String password;

    // Initializing when creating a new user
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getter functions
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter functions to update user information
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
