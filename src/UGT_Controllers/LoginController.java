package UGT_Controllers;

// import auth.ResetCode;
import UGT_UI.Login;
import UGT_Data.User;
import UGT_UI.UGT_UI_SERVICE.LoginService;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
    This entire UserService will provide the entire login functionality.
    Here are the function it'll include:
        - populateHashMap(); When we start a new GUI (after creating multiple accounts), function will add to the
            hashmap using the userInfoFile.txt
            - getUserClass(): helper function, will trim the txt file to get the correct information
        - loggingIn(): User will able to input their username and password, and if correct, will continue with the program
        - createAccount(): Users new to the program can create their own account u
        - forgotAccount(): When users forgot either their username/password, they can use their email to continue
            the process creating a new password
 */
public class LoginController {
    static HashMap<String, User> usernameMap = new HashMap<>(); // init the hashmap
    // static Map<String, ResetCode> resetCodeMap = new HashMap<>(); // will add both email and their oneTimeCode when user forgot their password
    static String directoryPath = "src/UGT_Data/";
    static String fileName = "userInfoFile.txt";

    // Create a File object with the specified path
    static File userFile = new File(directoryPath + fileName);

    // Function will populate the hashmap from information from userInfoFile.txt
    public static void populateHashMap() throws FileNotFoundException {

        // If the file doesn't exist, create it with some default users
        if (!userFile.exists()) {
            System.out.println("userInfoFile.txt not found. Creating default file...");
            try {
                PrintWriter writer = new PrintWriter(userFile);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error creating default userInfoFile.txt");
                return;
            }
        }
        // Continue with reading and populating the map
        Scanner inFile = new Scanner(userFile);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            String[] parts = line.split("\\|");

            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }

            String username = parts[0].substring(10).trim(); // Assumes "Username: " is exactly 10 characters
            User newUser = getUserClass(parts, username);
            usernameMap.put(username, newUser);
        }

        inFile.close();

        System.out.println("Users in map:");
        for (String key : usernameMap.keySet()) {
            System.out.println("-> -" + key + "-");
        }
    }

    public static User getUserClass(String[] parts, String username) {
        String email = parts[1].substring(7).trim();      // Remove "Email: " (7 chars)
        String password = parts[2].substring(10).trim();  // Remove "Password: " (10 chars)

        return new User(email, username, password);
    }

    public static void loggingIn() throws IOException{
        String username = LoginService.getLoginusername();

        // String email = ui.LoginGUI.getca_email();

        String password = LoginService.getLoginpassword();


        User user = usernameMap.get(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + username);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static void createAccount() throws IOException {
        // Create account logic
        String newUsername = LoginService.getca_username();

        // String email = ui.LoginGUI.getca_email();

        String newPassword = LoginService.getca_password();


        String email = "temp@gmail.com";
        // Check if username already exists, if it contains that specific key, then it exist
        if (usernameMap.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose another username.");
        } else {
            // Create a new user and add to HashMap
            User newUser = new User(email, newUsername, newPassword);
            usernameMap.put(newUsername, newUser);

            FileWriter fw = new FileWriter(directoryPath + fileName, true);
            PrintWriter out = new PrintWriter(fw);

            out.println("Username: " + newUser.getUsername() + " | Email: " + newUser.getEmail() +
                    " | Password: " + newUser.getPassword());
            out.close();
            System.out.println("Account created successfully! You can now login with your username.");
        }
    }

    // Function will help user retrieve information for their account to re-login
    // O(n), not as efficient. solution create a hashmap just for emails, or maybe just an arraylist
    // just for emails
    // if the email is invalid, don't mention it, prevents attackers from guessing accounts
    public static void forgotAccount(){
        String emailKey = "testemail@gmail.com"; // replace test string with var in loginGUI getter

        // Traverses through the hashmap
        for(Map.Entry<String, User> entry : usernameMap.entrySet()){
            // gets all the keys
            String key = entry.getKey();
            // gets the class info of the key in order to get the email
            User user = usernameMap.get(key);

            // compares the emailKey and also the emails of all the users
            if(emailKey.equals(user.getEmail())){
                // test case: pass
                Random rand = new Random();
                LocalDateTime creationTime = LocalDateTime.now();
                // storing the time when the code was created, should be 10 min max
                int oneTimeCode = rand.nextInt((99999 - 10000) + 1) + 10000;

               // resetCodeMap.put(emailKey, new ResetCode(oneTimeCode)); // adding info to hashmap

                System.out.println("Here's your one time key: " + oneTimeCode + "Variable created at: " + creationTime);
            }
        }
    }
/*
    // add the following function will GUI and test them out
    public boolean isResetCodeValid(String email, int userInputCode) {
        ResetCode stored = resetCodeMap.get(email); // get the email key

        long currentTime = System.currentTimeMillis(); // getting exact time when calling this line of code
        long elapsedTime = currentTime - stored.getTimestamps(); // subtracting from the stored timestamps

        long tenMinutesInMillis = 10 * 60 * 1000;

        // if more than 10 minutes (600,000 ms) have passed, it's expired
        // Only allows the rest if it's within that window and the code matches
        if (elapsedTime <= tenMinutesInMillis && stored.getCode() == userInputCode) {
            resetCodeMap.remove(email); // one-time use
            return true;
        } else {
            return false;
        }
    }

    // Periodically removing codes that are expired from memory to avoid any clutter and extra memory
    public void cleanupExpiredResetCodes() {
        long now = System.currentTimeMillis();
        resetCodeMap.entrySet().removeIf(entry -> now - entry.getValue().getTimestamps() > 10 * 60 * 1000);
    }
*/

}
