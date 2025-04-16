package UGT_UI.UGT_UI_SERVICE;
import UGT_Controllers.LoginController;
import UGT_UI.Login;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static UGT_UI.Login.*;


/*
    Functionality of file: Will include all the getters for the UI login page
    This will make it easier to connect both UI and LoginController file
 */
public class LoginService {

    public static void loginActionButton(){
        // Login button
        Login.loginAction.addActionListener(e -> {
            try {
                System.out.println("It works!!");
                LoginController.loggingIn();
            } catch (IOException ex) {
                //ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Login failed due to an error.");
            }
        });
    }

    public static void createAccountActionButton(){
        // Create Account button
        Login.create_account_Action.addActionListener(e -> {
            try {
                System.out.println("Create Account Button works!!");
                LoginController.createAccount();
            } catch (IOException ex) {
                //ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Create Account failed due to an error.");
            }
        });
    }

    //GETTERS, for logging in

    public static String getLoginusername(){
        // testing, can delete after
        System.out.println("USERNAME ENTERED: " + login_username.getText()); // works
        System.out.println("PASSWORD ENTERED: " + Login.login_password.getText());

        return login_username.getText();
    }

    public static String getLoginpassword(){
        return login_password.getText();
    }


    // creating an account getters
    public static String getca_username(){
        return ca_username.getText();
    }

    public static String getca_password(){
        return ca_password.getText();
    }


    public String getca_brandname(){
        return ca_brandname.getText();
    }

    public String getca_socialmedia1(){
        return ca_socialmedia1.getText();
    }

    public String getca_socialmedia2(){
        return ca_socialmedia2.getText();
    }

    public String getca_aboutbrand(){
        return ca_aboutbrand.getText();
    }


}
