// New File: UGT_Services/UserService.java
package UGT_Services;

import UGT_Controllers.IDGenerator;
import UGT_Data.*;
import UGT_UI.Login;

import java.io.*;
import java.util.*;

/*
    Functions that help the Login process can be used for users' system information changes
 */
public class UserService {
    // Getting the correct file location
    // Create class for hashmap, file information
    private static final String directoryPath = "src/UGT_Data/accountInformation/";
    private static final String usersFileName = "userInfoFile.txt";
    private static final String brandsFileName = "brands.txt";
    private static final String customersFileName = "buyers.txt";

    private static final File userFile = new File(directoryPath + usersFileName);
    private static final File brandFile = new File(directoryPath + brandsFileName);
    private static final File customerFile = new File(directoryPath + customersFileName);

    public static final HashMap<String, User> userMap = new HashMap<>(); // User hash map
    public static final HashMap<String, Brand> brandMap = new HashMap<>(); // Brand hash map
    public static final HashMap<String, Customer> customerMap = new HashMap<>(); // Customer hash map

    /**
     * Populates the user hashmap with the information from the userInfoFile.txt file.
     * @throws FileNotFoundException If the userInfoFile.txt file cannot be found.
     */
    public static void populateMap() throws FileNotFoundException {
        verifyFileExist(userFile);

        readFileLines(userFile);
        //inFile.close(); // Closes the file as we don't need to read no longer
    }

    /**
     * Function can be reused
     * @param theFile
     * @throws FileNotFoundException
     */
    public static void verifyFileExist(File theFile) {
        // If a file doesn't exist
        if (!theFile.exists()) {
            System.out.println("userInfoFile.txt not found. Creating empty file...");
            try {
                // Creating a new file if it doesn't exist
                PrintWriter writer = new PrintWriter(theFile);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error creating userInfoFile.txt");
            }
        }
    }

    public static void readFileLines(File theFile) throws FileNotFoundException {
        Scanner inFile = new Scanner(theFile);

        while (inFile.hasNextLine()) {
            // Trims the line
            String line = inFile.nextLine().trim();
            if (line.isEmpty()) continue; // Cont if line is empty

            // Splits line into 3 sections: username, email and password
            String[] parts = line.split(",");

            if(parts.length == 3) {
                populateUserMap(parts);
            } else if(parts.length == 8) {
                populateBrandMap(parts);
            } else{
                populateCustomerMap(parts);
            }
        }
        inFile.close();
    }
    public static void populateUserMap(String[] parts){
        // Parts of the line
        String username = parts[0].trim();
        String email = parts[1].trim();
        String password = parts[2].trim();
        String id = parts[3].trim();

        // Create a user class with information from userInfoFile.txt
        User user = new User(email, username, password, id);
        // Finally, adds that class to the hashmap with the username as the key
        userMap.put(username, user);
    }

    public static void populateBrandMap(String[] parts){
        String username = parts[0].trim();
        String email = parts[1].trim();
        String password = parts[2].trim();
        String brandName = parts[3].trim();
        String logoFileLocation = parts[4].trim();
        String aboutBrand = parts[5].trim();
        String instagramHandle = parts[6].trim();
        String tiktokHandle = parts[7].trim();
        String id = parts[8].trim();

        // Create a user class with information from userInfoFile.txt
        Brand brand = new Brand(email, username, password, brandName,
                aboutBrand, new File(logoFileLocation), instagramHandle, tiktokHandle, id);
        // Finally, adds that class to the hashmap with the username as the key
        brandMap.put(brandName, brand);
    }


    // Function is still at work
    public static void populateCustomerMap(String[] parts){
        String username = parts[0].trim();
        String email = parts[1].trim();
        String password = parts[2].trim();
        String firstName = parts[3].trim();
        String lastName = parts[4].trim();
        String address = parts[5].trim();
        String likedPosts = parts[6].trim();

        /*
        ArrayList<String> likedPostList = new ArrayList<>();
        if(!likedPosts.equals("")){
            String[] likedPostsArray = likedPosts.split(",");
            for(String likedPost : likedPostsArray){
                likedPostList.add(likedPost);
            }
        }

        ArrayList<String> followedBrand = new ArrayList<>();
        String followedBrandString = parts[7].trim();
        if(!followedBrandString.equals("")){
            String[] followedBrandArray = followedBrandString.split(",");
            for(String brand : followedBrandArray){
                followedBrand.add(brand);
            }
        }

        ArrayList<Order> orderList = new ArrayList<>();
        String order_listString = parts[8].trim();
        if(!order_listString.equals("")){
            String[] orderListArray = order_listString.split(",");
            orderList.add(orderListArray)
        }

        Customer customer = new Customer(email, username, password, firstName, lastName, address, likedPostList, followedBrand, orderList, customerCart);
        customerMap.put(username, customer);
        */

    }

    // Function simply checks if a username exists
    public static boolean usernameExists(String username) {
        return userMap.containsKey(username);
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
            if (info == null || info.trim().isEmpty()) {
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
            if (password.length() < 6) {
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
        FileWriter fw = new FileWriter(userFile, true);
        PrintWriter out = new PrintWriter(fw);
        out.println(username + "," + email + "," + password + "," + id);
        out.close();

        System.out.println("Account created successfully for: " + username);

        /*
            Now we need to add the user to the correct hashmap based on the status of the user and add
            the necessary information into the hashmap as well.
         */
        if (status.equals("buyer")) {
            // Users and system will populate these variables, initializing to make it clean
            String firstName = "";
            String lastName = "";
            String address = "";

            ArrayList<String> likedPosts = new ArrayList<>();
            ArrayList<String> followedBrand = new ArrayList<>();
            ArrayList<Order> order_list = new ArrayList<>();
            ArrayList<Item> customer_cart = new ArrayList<>();

            // Creating a customer class with the new information and adding it to the customer hashmap
            Customer newCustomer = new Customer(email, username, password, firstName,
                    lastName, address, likedPosts, followedBrand, order_list, customer_cart, id);
            customerMap.put(username, newCustomer);
            newCustomer.displayInfo();

            // Writing the new information into the customerFile.txt file
            fw = new FileWriter(customerFile, true);
            out = new PrintWriter(fw);

            out.println(username + "," + email + "," + password + "," + firstName + "," +
                    lastName + "," + address + ",,,," + id);

            out.close();
        } else if (status.equals("brand")) {
            // Creating a brand class with the new information and adding it to the brand hashmap
            Brand newBrand = new Brand(email, username, password, brandName, aboutBrand,
                    new File(logoFileLocation), instagramHandle, tiktokHandle, id);
            brandMap.put(brandName, newBrand);
            newBrand.displayInfo();

            // Writing the new information into the brandFile.txt file
            fw = new FileWriter(brandFile, true);
            out = new PrintWriter(fw);

            out.println(username + "," + email + "," + password + "," + "brand" +
                    "," + brandName + "," + aboutBrand + "," + logoFileLocation + "," + instagramHandle + "," + tiktokHandle + "," + id);

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
        Scanner inFile = new Scanner(userFile);
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

        PrintWriter outFile = new PrintWriter(userFile);
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
        if (userMap.isEmpty()) {
            System.out.println("No users in the system.");
            return;
        }
        for (User user : userMap.values()) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword());
            System.out.println("ID: " + user.getId());
            System.out.println("----------------------");
        }
    }
}