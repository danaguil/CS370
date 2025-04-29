import UGT_UI.*;
import javax.swing.*;
import UGT_Controllers.LoginController;
import java.io.FileNotFoundException;

public abstract class Main extends JFrame {




    public static void main(String[] args) throws FileNotFoundException{


        // BuyerFooter footer = new BuyerFooter();


       // Buyer_CartPage C = new Buyer_CartPage();
        //Buyer_SearchPage S = new Buyer_SearchPage();
        //Buyer_LikedPage L = new Buyer_LikedPage();
        //Buyer_HomePage H = new Buyer_HomePage();
        //Buyer_DiscoverPage D = new Buyer_DiscoverPage();
        // Buyer_settings b = new Buyer_settings();

         ProfilePage profile = new ProfilePage();









        /*
        try {
            LoginController.populateHashMap();
            new Login();

        } catch (FileNotFoundException e) {
            System.out.println("Error: userInfoFile.txt not found!");
            throw new FileNotFoundException();
        }

        */
    }




}
