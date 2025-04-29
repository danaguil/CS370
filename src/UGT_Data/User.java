package UGT_Data;

import java.io.File;

/*
    User class, will be containing
        - email, username, and password. All which the user can change if needed
    We have the function getEmail, getUsername etc... in order to check for valid credentials when logining in

   Both customer and brand will then inherit from this user class, each will have their own
    attributes and methods integrated to both
 */
public class User {
    // User basic information
    private String email;
    private String username;
    private String password;
    private File profilePicture = new File("src/UGT_Data/Media/defaultProfilePicture.png");

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


    public File getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
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

    protected void displayInfo() {

    }
}
