package UGT_Controllers;

import UGT_Data.Customer;
import UGT_Services.UserService;

import UGT_Data.programSession;
import UGT_UI.Buyer_settings;

import java.io.FileNotFoundException;
import java.util.Map;

public class SettingsController {
    public void updateBuyerSettings() throws FileNotFoundException {

        String username = Buyer_settings.get_username_TextField(); //we have
        String password = Buyer_settings.get_password_TextField(); //we have
        String email = Buyer_settings.get_email_TextField(); //we have


        String first_name = Buyer_settings.get_first_name_TextField();
        String last_name = Buyer_settings.get_last_name_TextField();
        String address = Buyer_settings.get_address_TextField();

        Customer customer = programSession.loggedInCustomer;

        //hashmap???

        boolean updated_username = false;
        boolean updated_password = false;
        boolean updated_email = false;

        String update_alert = "User Information that was Updated: \n";



        if(UserService.usernameExists(customer.getUsername())) {
            //checking valid
           if(UserService.Validator.verifySingleInfo(username, "username")){
               //updating username
               UserService.updateUsername(customer.getId(), username);
               //checking flag
               updated_username = true;
           }
           //checking if valid
           if( UserService.Validator.verifySingleInfo(password, "password")){
                //updating password
                UserService.updatePassword(customer.getId(), password);
                //checking flag
                updated_password = true;
           }
           //checking if valid
           if(UserService.Validator.verifySingleInfo(email, "email")){
                //updating email
                UserService.updateEmail(customer.getId(), email);
                //checking flag
                updated_email = true;
           }

           if(updated_username){
               update_alert += "Username updated to: " + username + "\n";
           }
           if (updated_password){
               update_alert += "Password updated to: " + password + "\n";
           }
           if (updated_email){
               update_alert += "Email updated to: " + email + "\n";
           }









        }
    }



    public void updateBrandSettings() throws FileNotFoundException {

        String username;
        String password;
        String email;
        String brandname;










    }



}
