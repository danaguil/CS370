// New File: UGT_Services/UserService.java
package UGT_Services;
import UGT_Controllers.populateProgram;
import UGT_Data.*;
import java.io.*;
import java.util.*;

import static UGT_Controllers.populateProgram.userMap;

/*
    Functions that help the Login process can be used for users' system information changes
 */
public class UserService {

    // Function simply checks if a username exists
    public static boolean usernameExists(String username) {
        return populateProgram.userMap.containsKey(username);
    }

    // Function simply checks if an email exists
    public static boolean emailExists(String email) {
        for (User user : userMap.values()) {
            if (user.getEmail().equalsIgnoreCase(email)) return true;
        }
        return false;
    }

    /**
        Class for validating common user fields. Will cover every condition for users' information
     */
    public static class Validator {

        /**
         * Validates a single piece of user information based on its field type.
         * Performs common validation checks and specific validation for email, username and password fields.
         *
         * @param info      The value to validate
         * @param fieldType The type of field ("email", "username", "password", etc.)
         * @return true if validation passes, false otherwise
         */
        public static boolean verifySingleInfo(String info, String fieldType) {
            if (!checkCommonRestrictions(info, fieldType)) return false;

            return switch (fieldType.toLowerCase()) {
                case "email" -> checkEmail(info);
                case "username" -> checkUsername(info);
                case "password" -> checkPassword(info);
                default -> true; // fields like brandName, aboutBrand, etc.
            };
        }

        /**
         * Checks common restrictions for user information.
         * @param info Information to validate
         * @param fieldType Type of field ("email", "username", "password", etc.)
         * @return true if validation passes, false otherwise.
         */
        private static boolean checkCommonRestrictions(String info, String fieldType) {
            if (info == null || info.trim().isEmpty() && !fieldType.equalsIgnoreCase("tiktok handle")
                    && !fieldType.equalsIgnoreCase("instagram handle")) {
                System.out.println(fieldType + " cannot be empty.");
                return false;
            }

            if (fieldType.equalsIgnoreCase("username") || fieldType.equalsIgnoreCase("email") ||
                    fieldType.equalsIgnoreCase("password") || fieldType.equalsIgnoreCase("instagram handle") ||
                    fieldType.equalsIgnoreCase("tiktok handle")) {

                if (info.contains(" ")) {
                    System.out.println(fieldType + " cannot contain spaces.");
                    return false;
                }

                if (info.contains(",")) {
                    System.out.println(fieldType + " cannot contain commas.");
                    return false;
                }
            }

            return true;
        }

        /**
         * Checks if an email is valid.
         * @param email The email to validate. Must be in the format "<EMAIL>".
         * @return true if the email is valid, false otherwise.
         */
        private static boolean checkEmail(String email) {
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Invalid email format.");
                return false;
            }
            if (UserService.emailExists(email)) {
                System.out.println("Email already exists.");
                return false;
            }
            return true;
        }

        /**
         * Checks if a username is valid.
         * @param username The username to validate. Must be at least 6 characters long. Must not contain spaces or commas.
         * @return true if the username is valid, false otherwise.
         */
        private static boolean checkUsername(String username) {
            if (UserService.usernameExists(username)) {
                System.out.println("Username already exists.");
                return false;
            }
            return true;
        }

        /**
         * Checks if a password is valid.
         * @param password The password to validate. Must be at least 6 characters long. Must not contain spaces or commas.
         * @return true if the password is valid, false otherwise.
         */
        private static boolean checkPassword(String password) {
            if (password.length() <= 4) {
                System.out.println("Password too short (minimum 6 characters).");
                return false;
            }
            return true;
        }
    }

    /**
     * Creates a new user with the given information and adds it to the user hashmap.
     * @param username The username to be used for the account. Must be unique.
     * @param email The email to be used for the account. Must be unique.
     * @param password The password to be used for the account. Must be at least 6 characters long.
     * @param brandName The name of the brand to be used for the account. Must be unique.
     * @param aboutBrand The description of the brand to be used for the account. Must be at least 10 characters long.
     * @param logoFileLocation The location of the brand logo file. Must be a valid file path.
     * @param instagramHandle The instagram handle of the brand. Must be unique.
     * @param tiktokHandle The TikTok handle of the brand. Must be unique.
     * @param status The status of the user. Can be either "buyer" or "brand".
     * @throws IOException If an error occurs while writing to the userInfoFile.txt file.
     */
    public static void createUser(String username, String email, String password, String brandName,
                                  String aboutBrand, String logoFileLocation, String instagramHandle,
                                  String tiktokHandle, String status, String id) throws IOException {
        // Creates a new class with new information and adding it to the user hashmap
        User newUser = new User(email, username, password, id);
        userMap.put(username, newUser);

        // Opening the userFile and writing the new information into it
        FileWriter fw = new FileWriter(populateProgram.userFile, true);
        PrintWriter out = new PrintWriter(fw);
        out.println(username + "," + email + "," + password + "," + id + "," + status);
        out.close();

        System.out.println("Account created successfully for: " + username);

        /*
            Now we need to add the user to the correct hashmap based on the status of the user and add
            the necessary information into the hashmap as well.
         */
        System.out.println("Adding " + username + " to the " + status + " hashmap...");
        if (status.equalsIgnoreCase("buyer")) {
            // Users and system will populate these variables, initializing to make it clean
            String firstName = "";
            String lastName = "";
            String address = "";


            // Creating a customer class with the new information and adding it to the customer hashmap
            Customer newCustomer = new Customer(email, username, password, firstName,
                    lastName, address, id);
            populateProgram.customerMap.put(username, newCustomer);
            newCustomer.displayInfo();

            // Writing the new information into the customerFile.txt file
            fw = new FileWriter(populateProgram.customerFile, true);
            out = new PrintWriter(fw);

            out.println(username + "," + email + "," + password + "," + firstName + "," +
                    lastName + "," + address + "," + id);

            out.close();
        } else if (status.equalsIgnoreCase("brand")) {
            // Creating a brand class with the new information and adding it to the brand hashmap
            Brand newBrand = new Brand(email, username, password, brandName, aboutBrand,
                    new File(logoFileLocation), instagramHandle, tiktokHandle, id);
            populateProgram.brandMap.put(brandName.toLowerCase(), newBrand);
            newBrand.displayInfo();

            // Writing the new information into the brandFile.txt file
            fw = new FileWriter(populateProgram.brandFile, true);
            out = new PrintWriter(fw);

            out.println(username + "," + email + "," + password +
                    "," + brandName + "," + aboutBrand + "," + logoFileLocation + "," + instagramHandle +
                    "," + tiktokHandle + "," + id);

            out.close();
        }
    }


    /**
     * Updates the password of a user with the given email key.
     * @param emailKey The email key of the user whose password is to be updated.
     * @param newPassword The new password to be set for the user.
     * @throws FileNotFoundException If the userInfoFile.txt file cannot be found.
     */
    public static void updatePassword(String emailKey, String newPassword) throws FileNotFoundException {
        Scanner inFile = new Scanner(populateProgram.userFile);
        List<String> updatedLines = new ArrayList<>();

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine().trim();
            if (line.isEmpty()) {
                updatedLines.add("");
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 3) {
                updatedLines.add(line);
                continue;
            }

            String username = parts[0].trim();
            String email = parts[1].trim();
            String oldPassword = parts[2].trim();

            if (email.equalsIgnoreCase(emailKey)) {
                if (oldPassword.equals(newPassword)) {
                    System.out.println("New password cannot be the same as the old one.");
                    return;
                }
                parts[2] = newPassword;
                System.out.println("Password updated for user: " + username);
                updateUserInMap(username, newPassword);
            }

            updatedLines.add(String.join(",", parts));
        }
        inFile.close();

        PrintWriter outFile = new PrintWriter(populateProgram.userFile);
        for (String line : updatedLines) {
            outFile.println(line);
        }
        outFile.close();
    }

    /**
     * Updates the password of a user with the given username key.
     * @param username The username key of the user whose password is to be updated.
     * @param newPassword The new password to be set for the user.
     */
    public static void updateUserInMap(String username, String newPassword) {
        User user = userMap.get(username);
        if (user != null) {
            user.setPassword(newPassword);
        }
    }

    /**
     * Updates the information of a user with the given username key.
     */
    public static void displayAllUsers() {
        boolean isEmpty = userMap.isEmpty() && populateProgram.brandMap.isEmpty() && populateProgram.customerMap.isEmpty();
        if (isEmpty) {
            System.out.println("No users in the system.");
            return;
        }

        System.out.println("===== General Users =====");
        for (User user : userMap.values()) {
            // Only display users
                user.displayInfo(); // base user info
        }

        System.out.println("===== Brands =====");
        for (Brand brand : populateProgram.brandMap.values()) {
            brand.displayInfo(); // full brand info
        }

        System.out.println("===== Customers =====");
        for (Customer customer : populateProgram.customerMap.values()) {
            customer.displayInfo(); // full customer info
        }
    }

}