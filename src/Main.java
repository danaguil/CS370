import UGT_UI.*;
import javax.swing.*;
import UGT_Controllers.LoginController;
import java.io.FileNotFoundException;

public class Main extends JFrame {
    public static void main(String[] args) throws FileNotFoundException{
        // new Buyer();
        // new BrandProfile();

        try {
            LoginController.populateHashMap();
            new Login();

        } catch (FileNotFoundException e) {
            System.out.println("Error: userInfoFile.txt not found!");
            throw new FileNotFoundException();
        }


    }
}
