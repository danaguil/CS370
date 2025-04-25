package UGT_Controllers;

// import auth.ResetCode;
import UGT_Data.Brand;
import UGT_Data.Customer;
import UGT_Data.ResetCode;
import UGT_UI.Login;
import UGT_Data.User;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.System.out;

/*
    This entire UserService will provide the entire login functionality.
    Here is the function it'll include:
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
    static HashMap<String, Brand> brandMap = new HashMap<>();
    static HashMap<String, Customer> resetCodeMap = new HashMap<>();
    // static HashMap<String, Customer> customerMap = new HashMap<>(); Not sure if we'll need this yet'

    // static Map<String, ResetCode> resetCodeMap = new HashMap<>(); // will add both email and their oneTimeCode when user forgot their password
    static String directoryPath = "src/UGT_Data/accountInformation/";
    static String fileName = "userInfoFile.txt";

    // Create a File object with the specified path
    static File userFile = new File(directoryPath + fileName);

    // Function will populate the hashmap from information from userInfoFile.txt
    public static void populateHashMap() throws FileNotFoundException {
        // If the file doesn't exist, create it as an empty file
        if (!userFile.exists()) {
            out.println("userInfoFile.txt not found. Creating empty file...");
            try {
                PrintWriter writer = new PrintWriter(userFile);
                writer.close();
            } catch (IOException e) {
                out.println("Error creating userInfoFile.txt");
                return;
            }
        }

        Scanner inFile = new Scanner(userFile);

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine().trim();
            if (line.isEmpty()) continue; // skip blank lines

            String[] parts = line.split(",");
            if (parts.length != 3) {
                out.println("Invalid line format: " + line);
                continue;
            }

            String username = parts[0].trim();
            String email = parts[1].trim();
            String password = parts[2].trim();

            User newUser = new User(email, username, password);
            usernameMap.put(username, newUser);
        }

        inFile.close();

        out.println("Users in map:");
        for (String key : usernameMap.keySet()) {
            out.println("-> " + key);
        }
    }

    public static void loggingIn() throws IOException{
        String username = Login.getLoginusername();

        // String email = ui.LoginGUI.getca_email();

        String password = Login.getLoginpassword();


        User user = usernameMap.get(username);

        if (user != null && user.getPassword().equals(password)) {
            out.println("Login successful! Welcome, " + username);
        } else {
            out.println("Invalid username or password.");
        }
    }
    /*
        Creating account functionality will be using a boolean 'status' to determine if the account
        was created for a brand or buyer user. Will then add that information to the hashmap/class

        True = brand
        False = buyer
     */
    public static void createAccount(boolean status) throws IOException {
        String username, password, email;

        // If a user is trying to create an account as a Brand Owner
        if(status) {

            username = Login.get_ca_brand_username();
            email = Login.get_ca_brand_email();
            password = Login.get_ca_brand_password();
            String brandName = Login.get_ca_brand_brandname();
            String aboutBrand = Login.get_ca_brand_aboutbrand();
            String instagramHandle = Login.get_ca_brand_Instagram();
            String tikTokHandle = Login.get_ca_brand_Tiktok();

            Brand brand = new Brand(email,username,password,brandName,aboutBrand,
                    new File("/UGT_Data/Media/defaultProfilePicture.png"), instagramHandle, tikTokHandle);
            brandMap.put(brandName, brand);
        } else { // creating an account as a Buyer
            username = Login.get_ca_buyer_username();
            email = Login.get_ca_buyer_email();
            password = Login.get_ca_buyer_password();

            //Customer customer = new Customer(email,username,password,null,null,
            //        0,null,0,0,0,null,null);
            //  customerMap.put(username, customer);
        }
        verifyInfo(username,email,password);
    }
    /*
          The Function will check if there are any duplicate usernames in the application
     */
    static void verifyInfo(String globalUsername, String globalEmail, String globalPassword) throws IOException {
        if (usernameMap.containsKey(globalUsername)) {
            out.println("Username already exists. Please choose another username.");
        } else {
            User newUser = new User(globalEmail, globalUsername, globalPassword);
            usernameMap.put(globalUsername, newUser);

            FileWriter fw = new FileWriter(directoryPath + fileName, true);
            PrintWriter out = new PrintWriter(fw);

            out.println(newUser.getUsername() + "," + newUser.getEmail() +
                    "," + newUser.getPassword());
            out.close();
            System.out.println("Account created successfully! You can now login with your username.");
        }

    }

    // Function will help user retrieve information for their account to re-login
    // O(n), not as efficient. solution create a hashmap just for emails, or maybe just an arraylist
    // just for emails
    // if the email is invalid, don't mention it, prevents attackers from guessing accounts
    public static void forgotAccount() throws FileNotFoundException {
        String emailKey = Login.get_recoverInformation_email(); // replace test string with var in loginGUI getter


        // Traverses through the hashmap
        for(Map.Entry<String, User> entry : usernameMap.entrySet()){
            // gets all the keys
            String key = entry.getKey();
            // gets the class info of the key in order to get the email
            User user = usernameMap.get(key);

            // compares the emailKey and also the emails of all the users
            if(emailKey.equals(user.getEmail())){
                System.out.println("Email found: " + user.getEmail());
                // test case: pass
                Random rand = new Random();
                LocalDateTime creationTime = LocalDateTime.now();
                // storing the time when the code was created should be 10 min max
                int oneTimeCode = rand.nextInt((99999 - 10000) + 1) + 10000;
                new ResetCode(oneTimeCode);
               // resetCodeMap.put(emailKey, new ResetCode(oneTimeCode)); // adding info to hashmap

                out.println("Here's your one time key: " + oneTimeCode + "Variable created at: " + creationTime);
// change from string to int
                break;
            }
        }
        // add a boolean "found"
        out.println("Email not found. Please try again.");
    }

    public static void changePassword(int oneTimeCode, String emailKey) throws FileNotFoundException {
        System.out.println("Email: " + emailKey);
        // checking if the inputted information matches
        if(String.valueOf(oneTimeCode).equals(Login.get_OTCL_one_time_code()) &&
                emailKey.equals(Login.get_OTCL_email())){
            // if inputted matches, then we update the new password for that user
            String newPassword = Login.get_OTCL_password();
            //User userToUpdate = new User(user.getEmail(), user.getUsername(), newPassword);
            //usernameMap.put(key, userToUpdate);
            //usernameMap.remove(emailKey);

            editUserFile(newPassword, emailKey);
        }

    }

    public static void editUserFile(String newPassword, String keyEmail) throws FileNotFoundException {
        // Checking if the files exist, outputs an error if it doesn't
        if (!userFile.exists()) {
            out.println("userInfoFile.txt not found.");
            return;
        }

        // Ready to view a file
        Scanner inFile = new Scanner(userFile);

        // Goes through the file to find a matching user with password and email
        List<String> updatedLines = new ArrayList<>();
        boolean passwordChanged = false;
        while (inFile.hasNextLine()) {

            // Entire single line in the text file
            String line = inFile.nextLine().trim();

            if (line.isEmpty()) {
                updatedLines.add(""); // keep blank lines
                continue;
            }

            // Splits the parts
            String[] parts = line.split(",");

            String email = parts[1].trim();
            String oldPassword = parts[2].trim(); // only changing the password

            if(email.equals(keyEmail)) {
                if (oldPassword.equals(newPassword)) {
                    out.println("Passwords match. Please try again.");
                    return;
                } else {
                    parts[2] = newPassword;
                    passwordChanged = true;
                    out.println("Changed password for " + parts[0] + ": Old Password ->" + oldPassword + " New Password -> " + parts[2]);
                }
            }
            updatedLines.add(String.join(",", parts));
        }

        inFile.close();

        if(!passwordChanged){
            System.out.println("Email not found or no change was needed.");
            return;
        }
        // Write updated lines back to the file
        PrintWriter outFile = new PrintWriter(userFile);
        for (String updatedLine : updatedLines) {
            outFile.println(updatedLine);
        }
        outFile.close();

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
}
