package UGT_UI;

import UGT_Controllers.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import UGT_Data.ResetCode;



public class Login extends JFrame implements ActionListener {
    //buttons
    //will be used to switch from window to window
    JButton buttonlogin;
    JButton buttoncreateaccount;
    JButton buttonforgot;
    //will be used to be able to add actions
    //ref
    CardLayout cards;
    //hold all the cards
    JPanel maincard;


    //constructor
    public Login() {
        //creating JFrame
        JFrame frame = new JFrame(); //by default frames use borderlayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows window to close
        frame.setSize(500, 800); //size of window
        frame.setTitle("UnderGroundThreads"); //title of window
        frame.setResizable(false);
        // cards is cardlayout
        cards = new CardLayout();
        //will be used to hold all the cards
        maincard = new JPanel();
        maincard.setLayout(cards);

        //adding card to maincard
        //adding Cardlogin method-----> will be called cardlogin
        maincard.add(Cardlogin(),"cardlogin");
        //adding Cardcreateaccount method-----> will be called cardcreateaccountr
        maincard.add(Cardcreateaccount(),"cardcreateaccountr");
        //adding Cardforgot method-----> will be called cardforgot
        maincard.add(Cardforgot(),"cardforgot");

        //adding maincard to frame (maincard will hold all the cards (windows) needed)
        frame.add(maincard);




        //by default panels use flowlayout
        //creating buttonpanel
        JPanel buttonpanel = new JPanel();
        //adding new setLayout for buttonpanel
        buttonpanel.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns



        //JButton
        //creating buttonlogin
        buttonlogin = new JButton();
        //text on top of button
        buttonlogin.setText("Login");
        //get rid of rectangle
        buttonlogin.setFocusable(false);
        //allows for action
        buttonlogin.addActionListener(this);

        //creating buttoncreateaccount
        buttoncreateaccount = new JButton();
        //text on top of button
        buttoncreateaccount.setText("create account");
        //get rid of rectangle
        buttoncreateaccount.setFocusable(false);
        //allows for action
        buttoncreateaccount.addActionListener(this);


        //creating buttonforgot
        buttonforgot = new JButton();
        //text on top of button
        buttonforgot.setText("forgot password?");
        //get rid of rectangle
        buttonforgot.setFocusable(false);
        //allows for action
        buttonforgot.addActionListener(this);

        //adding buttonlogin, buttoncreateaccount, and buttonforgot to buttonpanel
        buttonpanel.add(buttonlogin);
        buttonpanel.add(buttoncreateaccount);
        buttonpanel.add(buttonforgot);
        //adding buttonpanel to frame
        frame.add(buttonpanel,BorderLayout.NORTH);

        //able to see frame
        frame.setVisible(true);
    }


    //for login button, create account button, forgot button (main buttons)
    @Override
    public void actionPerformed(ActionEvent e) {
        //if button gets pressed
        if(e.getSource() == buttonlogin){
            //show this card from maincard--->cardlogin
            cards.show(maincard, "cardlogin");
        }else if(e.getSource() == buttoncreateaccount){
            //show this card from maincard---->cardcreateaccount
            cards.show(maincard, "cardcreateaccountr");
        }else if(e.getSource() == buttonforgot){
            //show this card from maincard----->cardforgot
            cards.show(maincard, "cardforgot");
        }

    }







//******************************************************************************************** Cardlogin


    private static JTextField login_username;
    private static JTextField login_password;




    private JPanel Cardlogin(){

        JPanel cardlogin = new JPanel();
        cardlogin.setSize(500,800);
        // cardlogin.setBackground(Color.YELLOW);
        cardlogin.setLayout(new BoxLayout(cardlogin, BoxLayout.Y_AXIS));


        //will be the panel holding username objects
        JPanel username_panel = new JPanel();
        JLabel username_label = new JLabel("Username:");
        login_username = new JTextField(10);
        username_panel.add(username_label);
        username_panel.add(login_username);
        //adding to cardlogin
        cardlogin.add(username_panel);



        //will be the panel holding password objects
        JPanel password_panel = new JPanel();
        JLabel password_label = new JLabel("password:");
        login_password = new JTextField(10);
        password_panel.add(password_label);
        password_panel.add(login_password);
        //adding to cardlogin
        cardlogin.add(password_panel);




        //will be the panel holding login objects
        JPanel login_panel = new JPanel();
        //JLabel one_time_code_label = new JLabel("One time code:");
        JButton login_button = new JButton("login");
        login_button.addActionListener(this);
        //login_panel.add(one_time_code_label);
        login_panel.add(login_button);
        //adding to cardlogin
        cardlogin.add(login_panel);


        //adding action to login button
        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("It works!!");
                LoginController.loginUser(); // calls function
            }
        });


        return cardlogin;
    }
    public static String getLoginusername(){
        return login_username.getText();
    }
    public static String getLoginpassword(){
        return login_password.getText();
    }


    //********************************************************************************************Cardcreateaccount
    //this private method only holds pages create_account_as_buyer and create_account_as_brand using cardlayout
    private JPanel Cardcreateaccount(){

        JPanel card_create_account = new JPanel();
        // card_create_account.setBackground(Color.cyan);
        card_create_account.setSize(500,800);
        card_create_account.setLayout(new BorderLayout());
        //cardlayout ---> cards
        CardLayout cards = new CardLayout();
        //creating JPanel
        JPanel maincard = new JPanel(cards);
        //maincard.setPreferredSize(new Dimension(300,500));

        card_create_account.add(maincard);

        //adding cards to maincard
        maincard.add(create_account_as_buyer(), "create_buyer_account");
        maincard.add(create_account_as_brand(),"create_brand_account");


        JPanel buttonpanel = new JPanel();
        //buttonpanel.setBackground(Color.orange);

        //buttons create_brand_account button and create_buyer_account_button
        JButton create_brand_account_button = new JButton("create brand account");
        create_brand_account_button.addActionListener(this);
        JButton create_buyer_account_button = new JButton("create buyer account");
        create_buyer_account_button.addActionListener(this);

        //adding buttons to button panel
        buttonpanel.add(create_buyer_account_button);
        buttonpanel.add(create_brand_account_button);

        //adding action to create_brand_account button
        create_brand_account_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "create_brand_account");
            }
        });

        //adding action to create_buyer_account button
        create_buyer_account_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "create_buyer_account");
            }
        });


        //adding buttonpanel to the top of card_create_account page
        card_create_account.add(buttonpanel, BorderLayout.NORTH);
        //returns JPanel
        return card_create_account;
    }


    //*************************************************************** create_account_as_brand
    private static JTextField brand_username;
    private static JTextField brand_password;
    private static JTextField brand_brandname;
    private static JTextArea brand_about_brand;
    private static JTextField brand_Instagram;
    private static JTextField brand_Tiktok;
    private static JTextField brand_email;


    //getters for create_account_as_brand
    public static String get_ca_brand_username(){
        return brand_username.getText();
    }
    public static String get_ca_brand_password(){
        return brand_password.getText();
    }
    public static String get_ca_brand_brandname(){
        return brand_brandname.getText();
    }
    public static String get_ca_brand_aboutbrand(){
        return brand_about_brand.getText();
    }
    public static String get_ca_brand_Instagram(){
        return brand_Instagram.getText();
    }
    public static String get_ca_brand_Tiktok(){
        return brand_Tiktok.getText();
    }
    public static String get_ca_brand_email(){
        return brand_email.getText();
    }




    private static File path;


    public static String getPost_photo(){
        //return path for image
        return path.getAbsolutePath();
    }


    //allows the brand to select a photo (photo must be a JPEG,PNG, OR JPG) or else message pops up
    //used within create_account_as_brand
    void photo_selection(){

        JFileChooser file_clothing_item = new JFileChooser();

        file_clothing_item.setCurrentDirectory(new File("."));

        int i = file_clothing_item.showSaveDialog(null);
        if(i == JFileChooser.APPROVE_OPTION){
            //File path global variable
            //getting the selected file path
            File selected_file = file_clothing_item.getSelectedFile();
            String name = selected_file.getName().toLowerCase();
            //if correct file (JPEG, PNG, JPG)
            if(name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".jpg") ){
                //selected file already has the file
                //set to path
                path = selected_file;
            }else{
                //show message
                JOptionPane.showMessageDialog(null, "Invalid file type. Please select a JPG or PNG image.");
            }

        }


    }





    private JPanel create_account_as_brand(){
        JPanel create_account_as_brand = new JPanel();
        create_account_as_brand.setSize(500,800);
        // create_account_as_brand.setBackground(Color.YELLOW);
        create_account_as_brand.setLayout(new BoxLayout(create_account_as_brand, BoxLayout.Y_AXIS));


        //creating banner
        JPanel banner = new JPanel();
        JLabel text_for_banner = new JLabel("fill in all textboxes and text areas please :)");
        banner.add(text_for_banner);
        //adding to create_account_as_brand
        create_account_as_brand.add(banner);


        //will hold all username objects
        JPanel username_panel = new JPanel();
        JLabel username_label = new JLabel("Username:");
        brand_username = new JTextField( 20);
        username_panel.add(username_label);
        username_panel.add(brand_username);
        //adding to create_account_as_brand
        create_account_as_brand.add(username_panel);

        //will hold all password objects
        JPanel password_panel = new JPanel();
        JLabel password_label = new JLabel("Password:");
        brand_password = new JTextField( 20);
        password_panel.add(password_label);
        password_panel.add(brand_password);
        //adding to create_account_as_brand
        create_account_as_brand.add(password_panel);

        //will hold brandname objects
        JPanel brandname_panel = new JPanel();
        JLabel brandname_label = new JLabel("Brandname:");
        brand_brandname = new JTextField( 20);
        brandname_panel.add(brandname_label);
        brandname_panel.add(brand_brandname);
        //adding to create_account_as_brand
        create_account_as_brand.add(brandname_panel);

        //will hold logo objects
        JPanel logo_panel = new JPanel();
        JLabel logo_label = new JLabel("New Logo:");
        //creating button
        JButton logo_button = new JButton("upload");
        logo_button.addActionListener(this);

        //adding action to logo button
        logo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                photo_selection();
            }
        });






        logo_panel.add(logo_label);
        logo_panel.add(logo_button);
        //adding to create_account_as_brand
        create_account_as_brand.add(logo_panel);
        //will hold about brand objects
        JPanel about_brand_panel = new JPanel();
        JLabel about_brand_label = new JLabel("AboutBrand:");
        brand_about_brand = new JTextArea(3,20);
        brand_about_brand.setLineWrap(true);
        about_brand_panel.add(about_brand_label);
        about_brand_panel.add(brand_about_brand);
        //adding to create_account_as_brand
        create_account_as_brand.add(about_brand_panel);






        //will hold all social media (Instagram and Tiktok)
        JPanel socialmedia_panel = new JPanel();
        //will hold instagram objects
        JPanel instagram_panel = new JPanel();
        JLabel instagram_label = new JLabel("Instagram:");
        brand_Instagram = new JTextField(20);
        instagram_panel.add(instagram_label);
        instagram_panel.add(brand_Instagram);
        //will hold tiktok objects
        JPanel tiktok_panel = new JPanel();
        JLabel tiktok_label = new JLabel("Tiktok:");
        brand_Tiktok = new JTextField(20);
        tiktok_panel.add(tiktok_label);
        tiktok_panel.add(brand_Tiktok);
        //adding to socialmedia panel
        socialmedia_panel.add(instagram_panel);
        socialmedia_panel.add(tiktok_panel);
        //adding to create_account_as_brand
        create_account_as_brand.add(socialmedia_panel);


        //will hold email objects
        JPanel email_panel = new JPanel();
        JLabel email_label = new JLabel("Email:");
        brand_email = new JTextField(10);
        email_panel.add(email_label);
        email_panel.add(brand_email);
        //adding to create-account_as_brand
        create_account_as_brand.add(email_panel);

        //will hold button
        JPanel button_panel = new JPanel();
        //creating button
        JButton create_account_button = new JButton("create account");
        create_account_button.addActionListener(this);



        //adding action to create_account button for brand
        create_account_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Create Account Button works!!"); // for testing
                    LoginController.registerUser("brand"); // calls function
                } catch (IOException ex) {
                    // ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Create Account failed due to an error.");
                }

                System.out.println("your account(BRAND) has been made!!! go log in ");
            }
        });

        //adding button to button panel
        button_panel.add(create_account_button);
        //adding button panel to create_account_as_brand
        create_account_as_brand.add(button_panel);
        return create_account_as_brand;
    }









    //******************************************************************create_account_buyer
    private static JTextField buyer_username;
    private static JTextField buyer_password;
    private static JTextField buyer_email;



    public static String get_ca_buyer_username(){
        return buyer_username.getText();
    }

    public static String get_ca_buyer_password(){
        return buyer_password.getText();
    }

    public static String get_ca_buyer_email(){
        return buyer_email.getText();
    }


    private JPanel create_account_as_buyer(){

        JPanel create_account_as_buyer = new JPanel();
        create_account_as_buyer.setSize(500,800);
        //create_account_as_buyer.setBackground(Color.YELLOW);
        create_account_as_buyer.setLayout(new BoxLayout(create_account_as_buyer, BoxLayout.Y_AXIS));

        //creating banner
        JPanel banner = new JPanel();
        JLabel text_for_banner = new JLabel("fill in all textboxes and TextAreas please :)");
        banner.add(text_for_banner);
        //adding banner to create_account_as_buyer
        create_account_as_buyer.add(banner);

        //will hold username objects
        JPanel username_panel = new JPanel();
        JLabel username_label = new JLabel("Username:");
        buyer_username = new JTextField( 20);
        username_panel.add(username_label);
        username_panel.add(buyer_username);
        //adding to create_account_as_buyer
        create_account_as_buyer.add(username_panel);

        //will hold buyer password objects
        JPanel buyer_password_panel = new JPanel();
        JLabel password_label = new JLabel("Password:");
        buyer_password = new JTextField( 20);
        buyer_password_panel.add(password_label);
        buyer_password_panel.add(buyer_password);
        //adding to create_account_as_buyer
        create_account_as_buyer.add(buyer_password_panel);





        //will hold email objects
        JPanel buyer_email_panel = new JPanel();
        JLabel email_label = new JLabel("Email:");
        buyer_email = new JTextField(10);
        buyer_email_panel.add(email_label);
        buyer_email_panel.add(buyer_email);
        create_account_as_buyer.add(buyer_email_panel);

        //will hold the button
        JPanel button_panel = new JPanel();
        //creating button
        JButton create_account_as_buyer_button = new JButton("create account");
        create_account_as_buyer_button.addActionListener(this);





        //adding action
        create_account_as_buyer_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Create Account Button works!!"); // for testing
                    LoginController.registerUser("buyer"); // calls function
                } catch (IOException ex) {
                    // ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Create Account failed due to an error.");
                }
                System.out.println("your account(BUYER) has been made!!! go log in ");
            }
        });






        //adding button to button panel
        button_panel.add(create_account_as_buyer_button);
        //adding a button panel to create_account_as_buyer
        create_account_as_buyer.add(button_panel);
        return create_account_as_buyer;


    }




    //************************************************************************************************************ Cardforgot
    //this private method only holds pages forgot() and one_tine_code_login using cardlayout

    //JButton get_one_time_code;

    private JPanel Cardforgot(){

        JPanel cardforgot = new JPanel();
        //cardforgot.setBackground(Color.cyan);
        cardforgot.setPreferredSize(new Dimension(500,800));
        cardforgot.setLayout(new BorderLayout());
        //cardlayout cards
        CardLayout cards = new CardLayout();
        //creating JPanel
        JPanel maincard = new JPanel(cards);
        //maincard.setPreferredSize(new Dimension(300,500));

        //adding maincard to cardforgot
        cardforgot.add(maincard);

        //adding cards to maincard
        maincard.add(forgot(), "forgot");
        maincard.add(one_time_code_login(),"one_time_code_login_button");

        //will hold buttons
        JPanel buttonpanel = new JPanel();
        //buttonpanel.setBackground(Color.orange);

        //creating button
        JButton forgot_button = new JButton("forgot button");
        forgot_button.addActionListener(this);
        //creating button
        JButton one_time_code_login_button = new JButton("one_time_code_login_button");
        one_time_code_login_button.addActionListener(this);
        //adding buttons to buttonpanel
        buttonpanel.add(forgot_button);
        buttonpanel.add(one_time_code_login_button);


        //adding action
        forgot_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "forgot");
            }
        });

        //adding action to one_time_code_login button
        one_time_code_login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "one_time_code_login_button");
            }
        });



        cardforgot.add(buttonpanel, BorderLayout.NORTH);
        //returns JPanel
        return cardforgot;


    }


    //************************************************************************************************ forgot

    private static JTextField recoverInformation_email;

    public static String get_recoverInformation_email(){
        return recoverInformation_email.getText();
    }


    private JPanel forgot(){


        JPanel forgot = new JPanel();
        forgot.setSize(500,800);
        // forgot.setBackground(Color.YELLOW);
        forgot.setLayout(new BoxLayout(forgot, BoxLayout.Y_AXIS));


        //will hold email objects
        JPanel email_panel = new JPanel();
        JLabel email_label = new JLabel("Email:");
        recoverInformation_email = new JTextField(10);
        email_panel.add(email_label);
        email_panel.add(recoverInformation_email);
        //adding to forgot
        forgot.add(email_panel);

        //will hold button
        JPanel one_time_code_panel = new JPanel();
        JButton one_time_code_button = new JButton("one time code");

        one_time_code_panel.add(one_time_code_button);
        //adding to forgot
        forgot.add(one_time_code_panel);

        //adding action to the one_time_code button
        one_time_code_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginController.recoverAccount();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                String code = String.valueOf(ResetCode.getCode());
                //pop up notification for one time code
                JOptionPane.showMessageDialog(null,code);
            }
        });


        return forgot;
    }
    //********************************************************************************************************** one_time_code_login
    // OTCL = one_time_code_login

    private static JTextField OTCL_email;
    private static JTextField OTCL_one_time_code;
    private static JTextField OTCL_new_password;

    public static String get_OTCL_email(){
        return OTCL_email.getText();
    }
    public static String get_OTCL_one_time_code(){
        return OTCL_one_time_code.getText();
    }
    public static String get_OTCL_password(){
        return OTCL_new_password.getText();
    }



    JPanel one_time_code_login(){
        JPanel create_account_as_brand = new JPanel();
        create_account_as_brand.setSize(500,800);
        //create_account_as_brand.setBackground(Color.YELLOW);
        create_account_as_brand.setLayout(new BoxLayout(create_account_as_brand, BoxLayout.Y_AXIS));


        //will hold email objects
        JPanel email_panel = new JPanel();
        JLabel email_label = new JLabel("Email:");
        OTCL_email = new JTextField(10);
        email_panel.add(email_label);
        email_panel.add(OTCL_email);
        //adding to create_account_as_brand
        create_account_as_brand.add(email_panel);

        //will hold one_time_code objects
        JPanel one_time_code_panel = new JPanel();
        JLabel one_time_code_label = new JLabel("One time code:");
        OTCL_one_time_code = new JTextField(10);
        one_time_code_panel.add(one_time_code_label);
        one_time_code_panel.add(OTCL_one_time_code);
        //adding to create_account_as_brand
        create_account_as_brand.add(one_time_code_panel);


        //will hold new password objects
        JPanel new_password_panel = new JPanel();
        JLabel new_password_label = new JLabel("New password:");
        OTCL_new_password = new JTextField(10);
        new_password_panel.add(new_password_label);
        new_password_panel.add(OTCL_new_password);
        //adding to create_account_as_brand
        create_account_as_brand.add(new_password_panel);



        //will hold login objects
        JPanel login_panel = new JPanel();
        JButton login_button = new JButton("login");
        login_panel.add(login_button);
        //adding to create_account_as_brand
        create_account_as_brand.add(login_panel);

        //adding action login button
        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("one_time_cone panel button login work!!"); // for testing

                try {
                    LoginController.updatePasswordViaOTP();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        return create_account_as_brand;
    }

}
