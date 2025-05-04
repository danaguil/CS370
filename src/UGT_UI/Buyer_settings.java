package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buyer_settings extends JPanel implements ActionListener {


    //class button
    JButton save_changes_button;

    //constructor
    public Buyer_settings () {
        this.setSize(500, 800);
        this.setLayout(new BorderLayout());
        this.add(settings_page("username", "password",  "first_name", "last_name", "name_on_card", "card_number", "card_month_exp", "card_year_exp", "card_cvv", "address","email"),BorderLayout.CENTER);
        //footer.add(settings_page( "username", "password",  "first_name", "last_name", "name_on_card", "card_number", "card_month_exp", "card_year_exp", "card_cvv", "address","email"),BorderLayout.CENTER);
        this.setVisible(true);
    }





    //settings_page variables
    private static JTextField usernmae_j;
    private static JTextField password_j;
    private static JTextField first_name_j;
    private static JTextField last_name_j;
    //private static JTextField cardinfo_j;
    //private static JTextField card_number_j;
    //private static JTextField card_month_exp_j;
    //private static JTextField card_year_exp_j;
    //private static JTextField card_cvv_j;
    private static JTextField address_j;
    private static JTextField email_j;

    //settins_page getters
    public static String get_username_TextField() {
        return usernmae_j.getText();
    }
    public static String get_password_TextField() {
        return password_j.getText();
    }
    public static String get_first_name_TextField() {
        return first_name_j.getText();
    }
    public static String get_last_name_TextField() {
        return last_name_j.getText();
    }
    public static String get_address_TextField() {
        return address_j.getText();
    }
    public static String get_email_TextField() {
        return email_j.getText();
    }





    /*
    public static String get_cardinfo_TextField() {
        return cardinfo_j.getText();
    }
    public static String get_cardnumber_TextField() {
        return card_number_j.getText();
    }
    public static String get_cardmonth_exp_TextField() {
        return card_month_exp_j.getText();
    }
    public static String get_cardyear_exp_TextField() {
        return card_year_exp_j.getText();
    }
    */



    //main page
    private JPanel settings_page(String username, String password, String first_name, String last_name, String name_on_card, String card_number, String card_month_exp, String card_year_exp, String card_cvv, String address, String email ){
        JPanel settings_page = new JPanel();
        //settings_page.setBackground(Color.red);
        settings_page.setLayout(new BoxLayout(settings_page, BoxLayout.Y_AXIS));
        //banner to help out user
        JPanel banner = new JPanel();
        JLabel text_for_banner = new JLabel("fill in any new changes then press save :)");
        banner.add(text_for_banner);
        settings_page.add(banner);

        JPanel change_username_panel = new JPanel();
        // change_username_panel.setBackground(Color.MAGENTA);
        change_username_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel username_label = new JLabel("username:");
        usernmae_j = new JTextField(20);
        change_username_panel.add(username_label);
        change_username_panel.add(usernmae_j);
        //adding to settings_page
        settings_page.add(change_username_panel);


        JPanel change_password_panel = new JPanel();
        change_password_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel password_label = new JLabel("password:");
        password_j = new JTextField(20);
        change_password_panel.add(password_label);
        change_password_panel.add(password_j);
        //adding to settings_page
        settings_page.add(change_password_panel);

        JPanel change_first_and_last_name_panel = new JPanel();
        change_first_and_last_name_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        change_first_and_last_name_panel.setLayout(new BoxLayout(change_first_and_last_name_panel, BoxLayout.Y_AXIS));

        JPanel first_name_panel = new JPanel();
        JLabel first_name_label = new JLabel("1st name:");
        first_name_j = new JTextField(20);
        first_name_panel.add(first_name_label);
        first_name_panel.add(first_name_j);
        change_first_and_last_name_panel.add(first_name_panel);
        //lastname
        JPanel last_name_panel = new JPanel();
        JLabel last_name_label = new JLabel("last name:");
        last_name_j = new JTextField(20);
        last_name_panel.add(last_name_label);
        last_name_panel.add(last_name_j);
        change_first_and_last_name_panel.add(last_name_panel);
        //adding both 1stname and lastname to change_first_and_last_name_panel
        settings_page.add(change_first_and_last_name_panel);



        /*
        JPanel change_name_on_ecard_panel = new JPanel();
        JLabel cardinfo_label = new JLabel("name on card:");
        cardinfo_j = new JTextField(name_on_card,20);
        change_name_on_ecard_panel.add(cardinfo_label);
        change_name_on_ecard_panel.add(cardinfo_j);
        //adding to settings_page
        settings_page.add(change_name_on_ecard_panel);


        JPanel change_card_number_panel = new JPanel();
        JLabel card_number_label = new JLabel("card number:");
        card_number_j = new JTextField(card_number,20);
        change_card_number_panel.add(card_number_label);
        change_card_number_panel.add(card_number_j);
        //adding to settings_page
        settings_page.add(change_card_number_panel);


        JPanel change_card_month_exp_panel = new JPanel();
        JLabel card_month_exp_label = new JLabel("month exp:");
        //might change this to drop down
        card_month_exp_j = new JTextField(card_month_exp,20);
        change_card_month_exp_panel.add(card_month_exp_label);
        change_card_month_exp_panel.add(card_month_exp_j);
        //adding to settings_page
        settings_page.add(change_card_month_exp_panel);


        JPanel change_card_year_exp_panel = new JPanel();
        JLabel card_year_exp_label = new JLabel("name on card:");
        card_year_exp_j = new JTextField(card_year_exp,20);
        change_card_year_exp_panel.add(card_year_exp_label);
        change_card_year_exp_panel.add(card_year_exp_j);
        //adding to settings_page
        settings_page.add(change_card_year_exp_panel);


        JPanel change_card_cvv_panel = new JPanel();
        JLabel card_cvv_label = new JLabel("name on card:");
        card_cvv_j = new JTextField(card_cvv,20);
        change_card_cvv_panel.add(card_cvv_label);
        change_card_cvv_panel.add(card_cvv_j);
        //adding to settings_page
        settings_page.add(change_card_cvv_panel);

         */



        JPanel change_address_panel = new JPanel();
        JLabel addresss_label = new JLabel("address:");
        address_j = new JTextField(20);
        change_address_panel.add(addresss_label);
        change_address_panel.add(address_j);
        //adding to settings_page
        settings_page.add(change_address_panel);



        JPanel change_email_panel = new JPanel();
        JLabel email_label = new JLabel("email:");
        email_j = new JTextField(20);
        change_email_panel.add(email_label);
        change_email_panel.add(email_j);
        //adding to settings_page
        settings_page.add(change_email_panel);

        JPanel button_panel = new JPanel();
        save_changes_button = new JButton("save changes");
        save_changes_button.addActionListener(this);
        button_panel.add(save_changes_button);
        //adding to settings_page
        settings_page.add(button_panel);


        return settings_page;
    }




    //actions for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {


        /*
        //Switch to Search page
        if(e.getSource() == button_search){
            System.out.println("your search button pressed");
            dispose();
            new Buyer_SearchPage();
        }
        //Switch to Cart page
        if(e.getSource() == button_cart){
            System.out.println("your cart button pressed");
            dispose();
            new Buyer_CartPage();
        }
        //Switch to Home page
        if(e.getSource() == button_Home){
            System.out.println("your home button pressed");
            dispose();
            new Buyer_HomePage();
        }
        //Switch to Discover button
        if(e.getSource() == button_discover){
            System.out.println("your discover button pressed");
            dispose();
            new Buyer_DiscoverPage();
        }
        //Switch to Like page
        if(e.getSource() == button_like){
            System.out.println("your like button pressed");
            dispose();
            new Buyer_LikedPage();

        }
        //Switch to Settings page
        if(e.getSource() == button_settings){
            System.out.println("your settings button pressed");

            dispose();
            new Buyer_settings();
        }

         */


        if(e.getSource() == save_changes_button){

            System.out.println("save changes");


        }

    }


    public void savehanges(){

    }

}

