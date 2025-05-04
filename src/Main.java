import UGT_Controllers.IDGenerator;
import UGT_Controllers.LoginController;
import UGT_Data.Brand;
import UGT_Data.Customer;
import UGT_Data.Item;
import UGT_UI.*;
import javax.swing.*;
import UGT_Controllers.LoginController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main extends JFrame {
    public static void main(String[] args) throws FileNotFoundException{



        // TODO: add item name to lowercase and add to hashmap
        LoginController.initialize();
        new Login();
        new Buyer_Pages();
       // new Buyer_HomePage();
    }
}
