package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {
    //buttons
    //will be used to switch from window to window
    JButton buttonlogin;
    JButton buttoncreateaccount;
    JButton buttonforgot;
    //will be used to be able to add actions
    CardLayout cards;
    JPanel maincard;


    //constructor
    public Login() {
        //creating JFrame
        JFrame frame = new JFrame(); //by default frames use borderlayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows window to close
        frame.setSize(500, 500); //size of window
        frame.setTitle("UnderGroundThreads"); //title of window
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
        buttonforgot.setText("forgot username/password?");
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
        }else if(e.getSource() == upload){
            JFileChooser fileChooser = new JFileChooser();

             fileChooser.showOpenDialog(null);

        }else if(e.getSource() == create_account){
            //code
        }else if(e.getSource() == get_password){
            //code
        }else if(e.getSource() == login){
            //code
        }

    }







//CARD LOGIN


    //
    JTextField login_username;
    JTextField login_password;
    //
    JButton login;

    private JPanel Cardlogin(){
        //creating JPanel
        JPanel cardlogin = new JPanel();
        //cardlogin.setLayout(new GridLayout(3,1));
        cardlogin.setBackground(Color.BLUE);




        JPanel panel_for_login = new JPanel();
        panel_for_login.setBackground(Color.MAGENTA);
        panel_for_login.setPreferredSize(new Dimension(150,150));
        panel_for_login.setLayout(new GridLayout(3,1));


        cardlogin.add(panel_for_login);


        //username
        //creating login_username JTextField
        login_username = new JTextField();
        // text that will be in JTextField
        login_username.setText("Username");
        //size of JTextField
        login_username.setPreferredSize(new Dimension(100,30));
        //adding login_username (JTextField) to cardlogin (Panel)
        //cardlogin.add(login_username);

        panel_for_login.add(login_username);

        //password
        //creating login_password JTextField
        login_password = new JTextField();
        // text that will be in JTextField
        login_password.setText("password");
        //size of JTextField
        login_password.setPreferredSize(new Dimension(100,30));
        //adding login_password to cardlogin Panel
        //cardlogin.add(login_password);

        panel_for_login.add(login_password);

        //button
        //creating login
        login = new JButton("Login");
        //adding login (button) to cardlogin (Panel)
        //cardlogin.add(login);

        panel_for_login.add(login);


        //returns cardlogin (JPanel)
        return cardlogin;
    }

//GETTERS

    public String getLoginusername(){
        return login_username.getText();
    }
    public String getLoginpassword(){
        return login_password.getText();
    }


//CARD CREATE ACCOUNT


    //ca = create account
    JTextField ca_username;
    JTextField ca_password;
    JTextField ca_brandname;
    JTextField ca_socialmedia1;
    JTextField ca_socialmedia2;
    JTextArea ca_aboutbrand;
    //JButton
    //create_account
    JButton create_account;

    JButton upload;
    private JPanel Cardcreateaccount(){
        JPanel cardcreateaccount = new JPanel();
        //carddiscover.setLayout(new GridLayout(3,3));
       // cardcreateaccount.setLayout(new GridLayout(8,1));
        cardcreateaccount.setBackground(Color.green);

/// ///////////////////////////////////////////////////////////////////////////////////////////////////////***
        JPanel panel_for_accountinfo = new JPanel();
        panel_for_accountinfo.setBackground(Color.MAGENTA);
        panel_for_accountinfo.setPreferredSize(new Dimension(400,400));
        panel_for_accountinfo.setLayout(new GridLayout(8,1));
        cardcreateaccount.add(panel_for_accountinfo);

        //create a panel to hold this
        ca_username = new JTextField();
        ca_username.setText("Username");
        ca_username.setPreferredSize(new Dimension(100,30));

        //cardcreateaccount.add(ca_username);//***********************************************1
        panel_for_accountinfo.add(ca_username);


        //password
        ca_password = new JTextField();
        ca_password.setText("password");
        ca_password.setPreferredSize(new Dimension(100,30));

        //cardcreateaccount.add(ca_password);//**********************************************2
        panel_for_accountinfo.add(ca_password);


        ca_brandname = new JTextField();
        ca_brandname.setText("brandname");
        ca_brandname.setPreferredSize(new Dimension(100,30));

        //cardcreateaccount.add(ca_brandname);//*******************************************3
        panel_for_accountinfo.add(ca_brandname);

        ca_socialmedia1 = new JTextField();
        ca_socialmedia1.setText("social media");
        ca_socialmedia1.setPreferredSize(new Dimension(100,30));

       // cardcreateaccount.add(ca_socialmedia1);//***************************************4
        panel_for_accountinfo.add(ca_socialmedia1);

        ca_socialmedia2 = new JTextField();
        ca_socialmedia2.setText("social media");
        ca_socialmedia2.setPreferredSize(new Dimension(100,30));

        //cardcreateaccount.add(ca_socialmedia2);//****************************************5
        panel_for_accountinfo.add(ca_socialmedia2);
        //creating a JTextArea ----> about brand
        ca_aboutbrand = new JTextArea();
        ca_aboutbrand.setText("About brand");
        ca_aboutbrand.setPreferredSize(new Dimension(200,200));
        //adding JTextArea to JPanel
        //cardcreateaccount.add(ca_aboutbrand); //****************************************6
        panel_for_accountinfo.add(ca_aboutbrand);
        //creating upload button  ---> upload brand logo
       upload = new JButton("upload brand logo");
        upload.addActionListener(this);
        //adding upload button to JPanel
        //cardcreateaccount.add(upload); //**********************************************7
        panel_for_accountinfo.add(upload);



        // create account button --->create account
        create_account = new JButton("create account");
        //adding button to JPanel
        //cardcreateaccount.add(create_account); //*********************************************8
        panel_for_accountinfo.add(create_account);



        //returns JPanel
        return cardcreateaccount;
    }


//getters

    public String getca_username(){
        return ca_username.getText();
    }
    public String getca_password(){
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


//CARD FORGOT

    JButton get_password;
    private JPanel Cardforgot(){
        //JPanel
        JPanel cardforgot = new JPanel();
        cardforgot.setBackground(Color.black);



        JPanel panel_for_forgot = new JPanel();
        panel_for_forgot.setBackground(Color.MAGENTA);
        panel_for_forgot.setPreferredSize(new Dimension(250,250));
        panel_for_forgot.setLayout(new GridLayout(2,1));

        cardforgot.add(panel_for_forgot);



        //JTextField
        login_username = new JTextField();
        //text inside JTextField
        login_username.setText("Username");
        login_username.setPreferredSize(new Dimension(100,30));
        //adding JTextField to JPanel
        //cardforgot.add(login_username);

        panel_for_forgot.add(login_username);

        //creating login button
        get_password = new JButton("Get Password");
        //adding login button to JPanel
        //cardforgot.add(get_password);
        panel_for_forgot.add(get_password);

        //returns JPanel
        return cardforgot;
    }

}
