package UGT_Data;

import java.io.File;

/*
    User class will contain
        - email, username, password, and ID. All which the user can change if needed
    We have the function getEmail, getUsername, etc... to check for valid credentials when logining in

   Both customer and brand will then inherit from this user class, each will have their own
    attributes and methods integrated to both
 */
public class User {
    // User basic information
    private String email;
    private String username;
    private String password;
    private File profilePicture = new File("src/UGT_Data/Media/defaultProfilePicture.png");
    private final String id;

    // Initializing when creating a new user
    public User(String email, String username, String password, String id) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
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

    public String getId() {return id;}

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

    public void displayInfo() {
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Password: " + getPassword());
        System.out.println("ID: " + getId());
        System.out.println("----------------------");
    }
}
