// New File: UGT_Services/UserService.java
package UGT_Services;

import UGT_Data.*;

import java.io.*;
import java.util.*;

/*
    Functions that help the Login process can be used for users' system information changes
 */
public class UserService {
    // Getting the correct file location
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

    /*
        When the program boots up, the function will populate the entire database using userInfoFile.txt
     */
    public static void populateUserMap() throws FileNotFoundException {
        // If a file doesn't exist
        if (!userFile.exists()) {
            System.out.println("userInfoFile.txt not found. Creating empty file...");
            try {
                // Creating a new file if it doesn't exist
                PrintWriter writer = new PrintWriter(userFile);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error creating userInfoFile.txt");
                return;
            }
        }

        // When we have the file read, we start the process of adding users into the hashmap from the file
        Scanner inFile = new Scanner(userFile);
        // Proceeds till the end
        while (inFile.hasNextLine()) {
            // Trims the line
            String line = inFile.nextLine().trim();
            if (line.isEmpty()) continue; // Cont if line is empty

            // Splits line into 3 sections: username, email and password
            String[] parts = line.split(",");

            // Testing output, if input in more than 3 parts
            if (parts.length != 3) {
                System.out.println("Invalid line format: " + line);
                continue;
            }

            // Parts of the line
            String username = parts[0].trim();
            String email = parts[1].trim();
            String password = parts[2].trim();

            // Create a user class with information from userInfoFile.txt
            User user = new User(email, username, password);
            // Finally, adds that class to the hashmap with the username as the key
            userMap.put(username, user);
        }
        inFile.close(); // Closes the file as we don't need to read no longer
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

    //
    public static boolean verifySingleInfo(String info, String fieldType) {
        boolean checkError;
        if (info == null || info.trim().isEmpty()) {
            System.out.println(fieldType + " cannot be empty.");
            return false;
        }

        // Only certain fields should block spaces/commas
        if (fieldType.equalsIgnoreCase("username") || fieldType.equalsIgnoreCase("email") ||
                fieldType.equalsIgnoreCase("password") || fieldType.equalsIgnoreCase("instagram handle")
                || fieldType.equalsIgnoreCase("tiktok handle")) {
            if (info.contains(" ")) {
                System.out.println(fieldType + " cannot contain spaces.");
                return false;
            }

            if (info.contains(",")) {
                System.out.println(fieldType + " cannot contain commas.");
                return false;
            }
        }

        if (fieldType.equalsIgnoreCase("email")) {
            if (!info.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Invalid email format.");
                return false;
            }
            if (emailExists(info)) {
                System.out.println("Email already exists.");
                return false;
            }
        }

        if (fieldType.equalsIgnoreCase("username")) {
            if (usernameExists(info)) {
                System.out.println("Username already exists.");
                return false;
            }
        }

        if (fieldType.equalsIgnoreCase("password")) {
            if (info.length() < 6) {
                System.out.println("Password too short (minimum 6 characters).");
                return false;
            }
        }

        return true;
    }








    

    /*
        The Function will add the user information (after validating the info) into the userInfoFile.txt file
     */
    public static void createUser(String username, String email, String password, String brandName,
                                  String aboutBrand, String logoFileLocation, String instagramHandle,
                                  String tiktokHandle, String status) throws IOException {
        // Creates a new class with new information and adding it to the user hashmap
        User newUser = new User(email, username, password);
        userMap.put(username, newUser);

        // Opening the userFile and writing the new information into it
        FileWriter fw = new FileWriter(userFile, true);
        PrintWriter out = new PrintWriter(fw);
        out.println(username + "," + email + "," + password);
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
                    lastName, address, likedPosts, followedBrand, order_list, customer_cart);
            customerMap.put(username, newCustomer);
            newCustomer.displayInfo();

            // Writing the new information into the customerFile.txt file
            fw = new FileWriter(customerFile, true);
            out = new PrintWriter(fw);

            out.println(username + "," + email + "," + password + "," + firstName + "," +
                    lastName + "," + address + ",,,," );

            out.close();
        } else if (status.equals("brand")) {
            // Creating a brand class with the new information and adding it to the brand hashmap
            Brand newBrand = new Brand(email, username, password, brandName, aboutBrand,
                    new File(logoFileLocation), instagramHandle, tiktokHandle);
            brandMap.put(brandName, newBrand);
            newBrand.displayInfo();

            // Writing the new information into the brandFile.txt file
            fw = new FileWriter(brandFile, true);
            out = new PrintWriter(fw);

            out.println(username + "," + email + "," + password + "," + "brand" +
                    "," + brandName + "," + aboutBrand + "," + logoFileLocation + "," + instagramHandle + "," + tiktokHandle);

            out.close();
        }


    }





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

    public static void updateUserInMap(String username, String newPassword) {
        User user = userMap.get(username);
        if (user != null) {
            user.setPassword(newPassword);
        }
    }

    public static void displayAllUsers() {
        if (userMap.isEmpty()) {
            System.out.println("No users in the system.");
            return;
        }
        for (User user : userMap.values()) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Password: " + user.getPassword());
            System.out.println("----------------------");
        }
    }
}