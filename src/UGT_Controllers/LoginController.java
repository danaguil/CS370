package UGT_Controllers;

import UGT_Data.ResetCode;
import UGT_Data.User;
import UGT_Services.UserService;
import UGT_UI.Login;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    This class will handle all the logic for the login and register screens.
 */
public class LoginController {

    /*
        Function will call populateUserMap() and for testing purposes, we will display all the users
    */
    public static void initialize() {
        // Calling populateUserMap() function in a try block
        try {
            UserService.populateUserMap();
        } catch (FileNotFoundException e) {
            // Outputs error if not found
            System.out.println("Error loading user data: " + e.getMessage());
        }
        // displays all users
        showAllUsers();
    }

    /*
        The Function will log in the user with inputted credentials.
            Will go check the hashmap for the correct username and password.
            Will output an error if no such user is found
     */
    public static void loginUser() {
        // Gets information from GUI
        String username = Login.getLoginusername();
        String password = Login.getLoginpassword();

        // Using username (key), we'll get the user class information
        User user = UserService.userMap.get(username);
        // As elong, it's a valid user, and it matches, it will move the user to the home page
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
        } else { // If not, such a user is found
            System.out.println("Invalid username or password.");
        }
    }

    /*
        Function will efficiently create a new account for either a brand or a customer
            ----For now it only work for CUSTOMERS!!----
        Will go through various testing if inputted information is valid
        If so, then will add onto userInfoFile.txt and to the hashmap
     */
    public static void registerUser() throws IOException {
        // Gets information from GUI
        String username = Login.get_ca_buyer_username();
        String email = Login.get_ca_buyer_email();
        String password = Login.get_ca_buyer_password();

        // Boolean will help output a multiple error message if it's necessary.
        boolean hasError = false;

        // ALSO, might create a string list for those error messages to display to GUI

        // Checks for empty entries
        if (username == null || email == null || password == null ||
                username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            System.out.println("Please fill out all fields.");
            return; // Immediately returns error
        }

        // Checks for any spaces in entries
        if (username.contains(" ") || password.contains(" ") || email.contains(" ")) {
            System.out.println("Username, email, or password cannot contain spaces.");
            hasError = true; // Adds to the error list
        }

        // Check for any commas inputted in entries
        if (username.contains(",") || password.contains(",") || email.contains(",")) {
            System.out.println("Inputs cannot contain commas.");
            hasError = true; // Adds to the error list
        }

        // Check for valid email structure
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Invalid email format.");
            hasError = true; // Adds to the error list
        }

        // Checks if the inputted username already exists
        if (UserService.usernameExists(username)) {
            System.out.println("Username already exists. Please choose another.");
            hasError = true; // Adds to the error list
        }

        // Checks if the inputted email already exists
        if (UserService.emailExists(email)) {
            System.out.println("Email already exists. Please choose another.");
            hasError = true; // Adds to the error list
        }

        // If found NO errors and everything is perfect, we create user a new account
        if (!hasError) {
            UserService.createUser(username, email, password);
        }
    }

    /*
        Function will guide the user to create a new password if forgotten using a One Time Code, and their email
        Will test the correct inputted information
            and changes their password both in the hashmap and userInfoFile.txt
     */
    public static void recoverAccount() throws FileNotFoundException {
        // Get information from GUI
        String emailKey = Login.get_recoverInformation_email();
        // Boolean will help if such an email is found
        boolean found = false;

        /* Loop through the entire HashMap, can't user username (key) because it's a security risk,
                Therefore, we are using an email to verify the user
         */
        for (User user : UserService.userMap.values()) {
            // if an email is found
            if (user.getEmail().equalsIgnoreCase(emailKey)) {
                found = true; // Boolean is set to true
                System.out.println("Email found: " + user.getEmail()); // Test output
                int oneTimeCode = (int) (Math.random() * 90000) + 10000; // Creating OTC
                // Adding to the RestCode class in order for another function to use this code
                new ResetCode(oneTimeCode);
                System.out.println("Here is your one-time code: " + oneTimeCode); // Test Output
                // Store this in a temporary OTP map if needed

                updatePasswordViaOTP(); // Finally, update the password
                break; // Stopping the for loop immediately
            }
        }

        // If email not found send out an error message, will be displayed in the GUI
        if (!found) {
            System.out.println("Email not found. Please try again.");
        }
    }

    /*
        Function will update the password both hashmap (working) and in userInfoFile
        Will call update password function in UserService for future password changes in users' settings
     */
    public static void updatePasswordViaOTP() throws FileNotFoundException {
        // Get information from GUI
        String inputCode = Login.get_OTCL_one_time_code();
        String emailKey = Login.get_OTCL_email();
        String newPassword = Login.get_OTCL_password();

        // Checks for valid code using ResetCode getter
        if(inputCode == null || Integer.parseInt(inputCode) != ResetCode.getCode()){
            System.out.println("Invalid OTP. Please try again.");
            return; // returns if invalid
        }

        // Finally, update password if code is valid
        UserService.updatePassword(emailKey, newPassword);
    }

    // Testing Function that displays all users
    public static void showAllUsers() {
        UserService.displayAllUsers();
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

 */
/*
    // Periodically removing codes that are expired from memory to avoid any clutter and extra memory
    public void cleanupExpiredResetCodes() {
        long now = System.currentTimeMillis();
        resetCodeMap.entrySet().removeIf(entry -> now - entry.getValue().getTimestamps() > 10 * 60 * 1000);
    }
*/

