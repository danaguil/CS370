package UGT_Data;

/*
    User class, will be containing
        - email, username, and password. All which the user can change if needed
    We have the function getEmail, getUsername etc.. in order to check for valid credentials when logining in

    We could've used a record java class, only one line of code for maximum efficiency, BUT
     we won't be able to change user information when needed.
 */
public abstract class User {
    // User values
    private final String email;
    private final String username;
    private final String password;  // Added password field

    // Initializing when creating a new user
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Helper functions to check for valid login information
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
