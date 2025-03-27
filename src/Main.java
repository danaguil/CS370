/*
    3/27 Daniel Aguilar F.
    This code will be used to create a login page for Underground Threads, used with terminal. Still needs to be
        implemented with a GUI
 */
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // Main method to present choices
    public static void main(String[] args) {
         /*
            Creating a hashmap with user class and int (password)
            Using this method as we need to include: email, username, and password for new user credentials
            Still efficient as we can look up user with constant time O(1)
        */
        HashMap<String, UserClass> usernameMap = new HashMap<>(); // init the hashmap
        Scanner scanner = new Scanner(System.in); // for taking inputs

        // Sample data
        UserClass user1 = new UserClass("john@example.com", "john123", "password123");
        usernameMap.put(user1.getUsername(), user1);

        // Initial menu
        while (true) {
            System.out.println("WELCOME TO THE TERMINAL!!!");
            System.out.println("-- Please choose an option --");

            System.out.println("1. Login");
            System.out.println("2. Create an Account");
            System.out.println("3. Exit");

            int userChoice = scanner.nextInt(); // gets input
            scanner.nextLine();  // gets next line

            // Handle the user's choice
            userChoice(userChoice, usernameMap, scanner);

            // Option to exit
            if (userChoice == 3) {
                System.out.println("Exiting program. See you next time!!");
                break;
            }
        }
    }

    /*
        `Function that will handle the use choice. We will bring taking in the userChoice, the hashmap and scanner
            so we don't call them again and waste resources
     */
    public static void userChoice(int choice, HashMap<String, UserClass> usernameMap, Scanner scanner) {
        switch (choice) {
            case 1:
                // Login logic, we'll be getting users info
                System.out.println("Enter your username: ");
                String username = scanner.nextLine();
                System.out.println("Enter your password: ");
                String password = scanner.nextLine();

                /* Getting user input of 'username' if it exist and if the user password matches as well
                    - we match the username with the class in database and return the password in that database
                 */
                UserClass user = usernameMap.get(username);
                if (user != null && user.getPassword().equals(password)) {
                    System.out.println("Login successful! Welcome, " + username);
                } else {
                    System.out.println("Invalid username or password.");
                }
                break;

            case 2:
                // Create account logic
                System.out.println("Enter your new username: ");
                String newUsername = scanner.nextLine();

                System.out.println("Enter your email: ");
                String email = scanner.nextLine();

                System.out.println("Enter your password: ");
                String newPassword = scanner.nextLine();

                // Check if username already exists, if it contains that specific key, then it exist
                if (usernameMap.containsKey(newUsername)) {
                    System.out.println("Username already exists. Please choose another username.");
                } else {
                    // Create a new user and add to HashMap
                    UserClass newUser = new UserClass(email, newUsername, newPassword);
                    usernameMap.put(newUsername, newUser);
                    System.out.println("Account created successfully! You can now login with your username.");
                }
                break;

            case 3:
                // Exit logic (handled in main loop)
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
