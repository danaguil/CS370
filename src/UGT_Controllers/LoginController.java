package UGT_Controllers;

import UGT_Data.ResetCode;
import UGT_Data.User;
import UGT_Services.UserService;
import UGT_UI.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static UGT_Services.UserService.Validator.verifySingleInfo;

// Will I need a duplicate username and email and password info for customer and brand???

/**
 * Controller for the Login page.
 */
public class LoginController {

    /**
     * Initializes the Login page.
     */
    public static void initialize() {
        // Calling populateUserMap() function in a try block
        try {
            populateProgram.populateMap();
        } catch (FileNotFoundException e) {
            // Outputs error if not found
            System.out.println("Error loading user data: " + e.getMessage());
        }
        // displays all users
        showAllUsers();
    }

    /**
     * Logs in a user with the given username and password.
     */
    public static void loginUser() {
        // Gets information from GUI
        String username = Login.getLoginusername();
        String password = Login.getLoginpassword();

        // Using username (key), we'll get the user class information
        User user = populateProgram.userMap.get(username);
        // As long, it's a valid user, and it matches, it will move the user to the home page
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
        } else { // If not, such a user is found
            System.out.println("Invalid username or password.");
        }
    }

    /**
     * Registers a new user with the given information.
     * @param status The status of the user. Can be either "buyer" or "brand".
     * @throws IOException If an error occurs while writing to the userInfoFile.txt file.
     */
    public static void registerUser(String status) throws IOException {
        // User input fields
        String username, email, password;

        // Brand-specific fields
        String brandName = "";
        String logoFileLocation = "";
        String aboutBrand = "";
        String instagramHandle = "";
        String tiktokHandle = "";

        String id = IDGenerator.generateID();

        // Step 1: Gather user input
        if (status.equalsIgnoreCase("brand")) {
            username = Login.get_ca_brand_username();
            email = Login.get_ca_brand_email();
            password = Login.get_ca_brand_password();
            brandName = Login.get_ca_brand_brandname();
            logoFileLocation = Login.getPost_photo();
            aboutBrand = Login.get_ca_brand_aboutbrand();
            instagramHandle = Login.get_ca_brand_Instagram();
            tiktokHandle = Login.get_ca_brand_Tiktok();
        } else if (status.equalsIgnoreCase("buyer")) {
            username = Login.get_ca_buyer_username();
            email = Login.get_ca_buyer_email();
            password = Login.get_ca_buyer_password();
        } else {
            System.out.println("Invalid status provided.");
            return;
        }

        // Step 2: Verify core user fields
        boolean validUserInfo = UserService.Validator.verifySingleInfo(username, "username") &&
                UserService.Validator.verifySingleInfo(email, "email") &&
                UserService.Validator.verifySingleInfo(password, "password");

        if (!validUserInfo) {
            System.out.println("User information is invalid. Fix errors above.");
            return;
        }

        // Step 3: Brand-specific field verification (skip logo, it's a file path)
        if (status.equalsIgnoreCase("brand")) {
            boolean validBrandInfo = UserService.Validator.verifySingleInfo(brandName, "brand name") &&
                    UserService.Validator.verifySingleInfo(aboutBrand, "about brand") &&
                    UserService.Validator.verifySingleInfo(instagramHandle, "instagram handle") &&
                    UserService.Validator.verifySingleInfo(tiktokHandle, "tiktok handle");

            if (!validBrandInfo) {
                System.out.println("Brand information is invalid. Fix errors above.");
                return;
            }

            if (logoFileLocation == null || logoFileLocation.trim().isEmpty()) {
                System.out.println("Logo file is missing.");
                return;
            }
        }

        // Step 4: If all valid, create the user
        UserService.createUser(username, email, password,
                brandName, aboutBrand, logoFileLocation,
                instagramHandle, tiktokHandle, status, id);
    }



    /**
     * Recovers the password for a user with the given email.
     * @throws FileNotFoundException If the userInfoFile.txt file cannot be found.
     */
    public static void recoverAccount() throws FileNotFoundException {
        // Get information from GUI
        String emailKey = Login.get_recoverInformation_email();
        // Boolean will help if such an email is found
        boolean found = false;

        /* Loop through the entire HashMap, can't user username (key) because it's a security risk,
                Therefore, we are using an email to verify the user
         */
        for (User user : populateProgram.userMap.values()) {
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

    /**
     * Updates the password of a user with the given email and OTP code.
     * @throws FileNotFoundException If the userInfoFile.txt file cannot be found.
     */
    public static void updatePasswordViaOTP() throws FileNotFoundException {
        // Get information from GUI
        String emailKey = Login.get_OTCL_email();
        String newPassword = Login.get_OTCL_password();

        verifySingleInfo(newPassword, "password");

        // Finally, update password if code is valid
        UserService.updatePassword(emailKey, newPassword);
    }

    /**
     * Updates the password of a user with the given email and new password.
     */
    public static void showAllUsers() {
        UserService.displayAllUsers();
    }

    /**
     * Saves the brand logo to the Media folder.
     * @param selectedFile The file to be saved. Must be a valid file path. Must be a valid image file.
     * @return true if the file was saved successfully, false otherwise.
     */
    public static boolean saveBrandLogo(File selectedFile) {
        // Checking if a file is selected
        if (selectedFile == null) {
            System.out.println("No file selected.");
            return false;
        }

        try {
            // Destination path
            String mediaDirectory = "src/UGT_Data/Media/";
            File destFile = new File(mediaDirectory + selectedFile.getName());

            // Copy file content
            Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Logo saved successfully: " + destFile.getPath());
        } catch (IOException e) {
            System.out.println("Failed to save logo: " + e.getMessage());
        }

        return true;
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

