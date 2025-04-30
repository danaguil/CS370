import UGT_Controllers.LoginController;
import UGT_UI.*;
import javax.swing.*;
import java.io.FileNotFoundException;

public class Main extends JFrame {
    public static void main(String[] args) throws FileNotFoundException{
        // new Buyer();
        // new BrandProfile();

        LoginController.initialize();
        new Login();


    }
}
