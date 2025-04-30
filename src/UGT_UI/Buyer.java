package UGT_UI;

//import UGT_Data.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer extends JFrame implements ActionListener {


    JButton buttonfollowing;
    JButton buttondiscover;
    JButton buttonsettings;
    JButton buttonlike;

    JButton buttonsearch; // just added these buttons
    JButton buttoncart; //just added these buttons

    CardLayout cards;
    JPanel maincard;

    public Buyer(String username,String password, String first_name,String last_name,String name_on_card,String card_number,String card_month_exp,String card_year_exp,String card_cvv,String address, String email) { //start ......................................................................

        JFrame frame = new JFrame(); //by defeautl frames use borderlayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setTitle("UnderGroundThreads");





         cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
        maincard = new JPanel();
        maincard.setLayout(cards);

        maincard.add(Search(),"cardsearch");
        maincard.add(Cart(), "cardcart");
        maincard.add(Cardfollowing(),"cardfollowing");
        maincard.add(Carddiscover(),"carddiscover");
        maincard.add(Cardlike(),"cardlike");
        maincard.add(Cardsettings(username, password,first_name,last_name,name_on_card,card_number,card_month_exp,card_year_exp,card_cvv,address,email), "cardsettings");


        frame.add(maincard);
        //add(maincard);  --->could also use this




        JPanel buttonpanel_header = new JPanel(); //flowlayout
        //buttonpanel_header.setBackground(Color.black);
        buttonpanel_header.setPreferredSize(new Dimension(50,50));
        buttonpanel_header.setLayout(new GridLayout(1,3));


        buttonsearch = new JButton();
        buttonsearch.setText("search");
        buttonsearch.setPreferredSize(new Dimension(10,10));
        buttonsearch.setFocusable(false);
        buttonsearch.addActionListener(this);

        buttoncart = new JButton();
        buttoncart.setText("cart");
        buttoncart.setPreferredSize(new Dimension(10,10));
        buttoncart.setFocusable(false);
        buttoncart.addActionListener(this);

        JLabel minibannertext = new JLabel();
        minibannertext.setForeground(Color.WHITE);
        minibannertext.setText("UndergroundThreads");

        JPanel minibanner = new JPanel();
        minibanner.add(minibannertext);
        minibanner.setBackground(Color.DARK_GRAY);

        buttonpanel_header.add(minibanner);
        buttonpanel_header.add(buttonsearch);
        buttonpanel_header.add(buttoncart);

        frame.add(buttonpanel_header, BorderLayout.NORTH);

        //by deafualt panels use flowlayout
        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.yellow); //yellow will be hidden by the buttons
        buttonpanel.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns
        buttonpanel.setPreferredSize(new Dimension(50,50)); //SINCE USING BORRDERLAYOUY 100X100 DOES NOT DO ANYTINGN


        //manipanel *use flowlayout buttons will just flow...


        //JButton
        buttonfollowing = new JButton();
        buttonfollowing.setText("following");
        buttonfollowing.setFocusable(false);
        buttonfollowing.addActionListener(this);

        buttondiscover = new JButton();
        buttondiscover.setText("discover");
        buttondiscover.setFocusable(false);
        buttondiscover.addActionListener(this);

        buttonlike = new JButton();
        buttonlike.setText("liked");
        buttonlike.setFocusable(false);
        buttonlike.addActionListener(this);

        buttonsettings = new JButton();
        buttonsettings.setText("settings");
        buttonsettings.setFocusable(false);
        buttonsettings.addActionListener(this);

        buttonpanel.add(buttonfollowing);
        buttonpanel.add(buttondiscover);
        buttonpanel.add(buttonlike);
        buttonpanel.add(buttonsettings);
        frame.add(buttonpanel,BorderLayout.SOUTH);


        frame.setVisible(true);
    }






    //ACTION EVENTS

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonfollowing){
            print_following_grid();
            cards.show(maincard, "cardfollowing");
        }else if(e.getSource() == buttondiscover){
            print_discover_grid();
            cards.show(maincard, "carddiscover");
        }else if(e.getSource() == buttonlike){
            print_liked_grid();
            cards.show(maincard, "cardlike");

        }else if(e.getSource() == buttonsettings){
            cards.show(maincard,"cardsettings");
        }else if(e.getSource() == buttonsearch){

            cards.show(maincard, "cardsearch");
        }else if(e.getSource() == buttoncart ){
            JPanel aaa = cart_item();
            JPanel bbb = cart_item();
            JPanel ccc = cart_item();
            JPanel ddd = cart_item();
            JPanel eee = cart_item();
            JPanel fff = cart_item();
            JPanel ggg = cart_item();
            add_to_cart(ggg);
            add_to_cart(fff);
            add_to_cart(ddd);
            add_to_cart(eee);
            add_to_cart(ccc);
            add_to_cart(bbb);
            add_to_cart(aaa);
            print_cart_grid();
            cards.show(maincard, "cardcart");
        }

    }



//ALL CARDS USED WITHIN THE CONSTRUCTOR



//Card following things
    private final ArrayList<JPanel> all_following_post = new ArrayList<>();
    JPanel following_grid;




    private void print_following_grid(){
        //clears all buttons from post_grid
        following_grid.removeAll();
        //if all_posts has a post
        if( all_following_post != null && !all_following_post.isEmpty()) {



            for (int i = 0; i < all_following_post.size(); i++) {
                //creating JButton
                JPanel order = all_following_post.get(i);
                //size
                order.setPreferredSize(new Dimension(500,200));
                //adding JButton (post) to post_grid
                following_grid.add(order);
            }

        }else{
            System.out.println("Sorry no orders");
        }

        //relays componenets
        following_grid.revalidate();
        //visual refresh
        following_grid.repaint();
    }














    //one of the main pages
    private JPanel Cardfollowing(){
        //creating cardfollowing_panel to hold everything
        JPanel cardfollowing_panel = new JPanel(new BorderLayout());
        //size
        cardfollowing_panel.setPreferredSize(new Dimension(500,800));
        //color
        //cardfollowing_panel.setBackground(Color.RED);


        //this panel will hold the orders
        following_grid = new JPanel();
        //layout, all orders will be stacked
        following_grid.setLayout(new GridLayout(0,3));
        //craeing JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(following_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to cardfollowing_panel
        cardfollowing_panel.add(jsp);

        return cardfollowing_panel;
    }



//card discover things
    private final ArrayList<JPanel> all_discover_post = new ArrayList<>();
    JPanel discover_grid;



    private void print_discover_grid(){
        //clears all buttons from post_grid
        discover_grid.removeAll();
        //if all_posts has a post
        if( all_discover_post != null && !all_discover_post.isEmpty()) {



            for (int i = 0; i < all_discover_post.size(); i++) {
                //creating JButton
                JPanel order = all_discover_post.get(i);
                //size
                order.setPreferredSize(new Dimension(500,200));
                //adding JButton (post) to post_grid
                discover_grid.add(order);
            }

        }else{
            System.out.println("Sorry no orders");
        }

        //relays componenets
        discover_grid.revalidate();
        //visual refresh
        discover_grid.repaint();
    }




    //one of the main pages
    private JPanel Carddiscover(){
        //creating carddiscover_panel to hold everything
        JPanel carddiscover_panel = new JPanel(new BorderLayout());
        //size
        carddiscover_panel.setPreferredSize(new Dimension(500,800));
        //color
        //carddiscover_panel.setBackground(Color.RED);


        //this panel will hold the orders
        discover_grid = new JPanel();
        //layout, all orders will be stacked
        discover_grid.setLayout(new GridLayout(0,3));
        //craeing JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(discover_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to carddiscover_panel
        carddiscover_panel.add(jsp);

        return carddiscover_panel;
    }

//Card like things
    private final ArrayList<JPanel> all_my_liked_post = new ArrayList<>();
    JPanel liked_grid;



    private void print_liked_grid(){
        //clears all buttons from post_grid
        liked_grid.removeAll();
        //if all_posts has a post
        if( all_my_liked_post != null && !all_my_liked_post.isEmpty()) {



            for (int i = 0; i < all_my_liked_post.size(); i++) {
                //creating JButton
                JPanel order = all_my_liked_post.get(i);
                //size
                order.setPreferredSize(new Dimension(500,200));
                //adding JButton (post) to post_grid
                liked_grid.add(order);
            }

        }else{
            System.out.println("Sorry no orders");
        }

        //relays componenets
        liked_grid.revalidate();
        //visual refresh
        liked_grid.repaint();
    }



    //one of the mainpages
    private JPanel Cardlike(){
        //creating cardlike_panel to hold everything
        JPanel cardlike_panel = new JPanel(new BorderLayout());
        //size
        cardlike_panel.setPreferredSize(new Dimension(500,800));
        //color
        //cardlike_panel.setBackground(Color.RED);


        //this panel will hold the orders
        liked_grid = new JPanel();
        //layout, all orders will be stacked
        liked_grid.setLayout(new GridLayout(0,3));
        //craeing JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(liked_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to cardlike_panel
        cardlike_panel.add(jsp);

        return cardlike_panel;
    }



//Card settings things
    JTextField usernmae_j;
    JTextField password_j;
    JTextField first_name_j;
    JTextField last_name_j;
    JTextField cardinfo_j;
    JTextField card_number_j;
    JTextField card_month_exp_j;
    JTextField card_year_exp_j;
    JTextField card_cvv_j;
    JTextField address_j;
    JTextField email_j;
    //within Cardsettings
    private JPanel account_settings(String username,String password, String first_name,String last_name,String name_on_card,String card_number,String card_month_exp,String card_year_exp,String card_cvv,String address, String email ){
        JPanel account_settings = new JPanel();
        //account_settings.setBackground(Color.red);
        account_settings.setLayout(new BoxLayout(account_settings, BoxLayout.Y_AXIS));
        //banner to help out user
        JPanel banner = new JPanel();
        JLabel text_for_banner = new JLabel("fill in any new changes then press save :)");
        banner.add(text_for_banner);
        account_settings.add(banner);

        JPanel change_username_panel = new JPanel();
       // change_username_panel.setBackground(Color.MAGENTA);
        change_username_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel username_label = new JLabel("username:");
        usernmae_j = new JTextField(username,20);
        change_username_panel.add(username_label);
        change_username_panel.add(usernmae_j);
        //adding to account_settings
        account_settings.add(change_username_panel);


        JPanel change_password_panel = new JPanel();
        JLabel password_label = new JLabel("password:");
        password_j = new JTextField(password,20);
        change_password_panel.add(password_label);
        change_password_panel.add(password_j);
        //adding to account_settings
        account_settings.add(change_password_panel);

        JPanel change_first_and_last_name_panel = new JPanel();
        change_first_and_last_name_panel.setLayout(new BoxLayout(change_first_and_last_name_panel, BoxLayout.Y_AXIS));

        JPanel first_name_panel = new JPanel();
        JLabel first_name_label = new JLabel("1st name:");
        first_name_j = new JTextField(first_name,20);
        first_name_panel.add(first_name_label);
        first_name_panel.add(first_name_j);
        change_first_and_last_name_panel.add(first_name_panel);
        //lastname
        JPanel last_name_panel = new JPanel();
        JLabel last_name_label = new JLabel("last name:");
        last_name_j = new JTextField(last_name,20);
        last_name_panel.add(last_name_label);
        last_name_panel.add(last_name_j);
        change_first_and_last_name_panel.add(last_name_panel);
        //adding both 1stname and lastname to change_first_and_last_name_panel
        account_settings.add(change_first_and_last_name_panel);

        JPanel change_name_on_ecard_panel = new JPanel();
        JLabel cardinfo_label = new JLabel("name on card:");
        cardinfo_j = new JTextField(name_on_card,20);
        change_name_on_ecard_panel.add(cardinfo_label);
        change_name_on_ecard_panel.add(cardinfo_j);
        //adding to account_settings
        account_settings.add(change_name_on_ecard_panel);



        JPanel change_card_number_panel = new JPanel();
        JLabel card_number_label = new JLabel("card number:");
        card_number_j = new JTextField(card_number,20);
        change_card_number_panel.add(card_number_label);
        change_card_number_panel.add(card_number_j);
        //adding to account_settings
        account_settings.add(change_card_number_panel);





        JPanel change_card_month_exp_panel = new JPanel();
        JLabel card_month_exp_label = new JLabel("month exp:");
        //might change this to drop down
        card_month_exp_j = new JTextField(card_month_exp,20);
        change_card_month_exp_panel.add(card_month_exp_label);
        change_card_month_exp_panel.add(card_month_exp_j);
        //adding to account_settings
        account_settings.add(change_card_month_exp_panel);





        JPanel change_card_year_exp_panel = new JPanel();
        JLabel card_year_exp_label = new JLabel("name on card:");
        card_year_exp_j = new JTextField(card_year_exp,20);
        change_card_year_exp_panel.add(card_year_exp_label);
        change_card_year_exp_panel.add(card_year_exp_j);
        //adding to account_settings
        account_settings.add(change_card_year_exp_panel);



        JPanel change_card_cvv_panel = new JPanel();
        JLabel card_cvv_label = new JLabel("name on card:");
        card_cvv_j = new JTextField(card_cvv,20);
        change_card_cvv_panel.add(card_cvv_label);
        change_card_cvv_panel.add(card_cvv_j);
        //adding to account_settings
        account_settings.add(change_card_cvv_panel);



        JPanel change_address_panel = new JPanel();
        JLabel addresss_label = new JLabel("address:");
        address_j = new JTextField(address,20);
        change_address_panel.add(addresss_label);
        change_address_panel.add(address_j);
        //adding to account_settings
        account_settings.add(change_address_panel);

        JPanel change_email_panel = new JPanel();
        JLabel email_label = new JLabel("email:");
        email_j = new JTextField(email,20);
        change_email_panel.add(email_label);
        change_email_panel.add(email_j);
        //adding to account_settings
        account_settings.add(change_email_panel);

        JPanel button_panel = new JPanel();
        JButton save_changes_button = new JButton("save changes");
        button_panel.add(save_changes_button);
        //adding to account_settings
        account_settings.add(button_panel);




        //ACTION LISTENER
        save_changes_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                System.out.println("your changes have been saved :)");


            }
        });


        return account_settings;
    }





    //within Cardsettings
    private JPanel report_a_bug(){
        //creating panel
        JPanel report_a_bug_panel = new JPanel();
        //size
        report_a_bug_panel.setSize(500,200);
        //color
        //report_a_bug_panel.setBackground(Color.green);
        //layout
        report_a_bug_panel.setLayout(new BoxLayout(report_a_bug_panel, BoxLayout.Y_AXIS));
        //creating bug_report_panel to hold all objects: label, textarea
        JPanel bug_report_panel = new JPanel();
        JLabel bug_report_label = new JLabel("Report a bug:");
        JTextArea Bug_report_text_area = new JTextArea(4,40);
        Bug_report_text_area.setText("Tells us about the bug you found :(");
        bug_report_panel.add(bug_report_label);
        bug_report_panel.add(Bug_report_text_area);
        //adding bug_report_panel to report_a_bug_panel
        report_a_bug_panel.add(bug_report_panel);

        //creating button_panel to hold button
        JPanel button_panel = new JPanel();
        //creating button submit_report
        JButton submit_report = new JButton("submit");

        //ACTION LISTENER
        submit_report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you submitted your bug report!!!!!");
            }
        });

        //adding submit_report to button_panel
        button_panel.add(submit_report);
        //adding button_panel to report_a_bug_panel
        report_a_bug_panel.add(button_panel);





        //creating feedback_panel to hold all feedback objects
        JPanel feedback_panel = new JPanel();
        JLabel feedback_label = new JLabel("Provide Feedback:");
        JTextArea feedback_text_area = new JTextArea(4,40);
        feedback_text_area.setText("Tells us what you think about UnderGroundThreads :)");
        feedback_panel.add(feedback_label);
        feedback_panel.add(feedback_text_area);
        //adding feedback_panel to report_a_bug_panel
        report_a_bug_panel.add(feedback_panel);



        //creating button_panel to hold button
        JPanel feedback_button_panel = new JPanel();
        //creating button
        JButton save_feedback = new JButton("submit");




        //ACTION LISTENER
        save_feedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you submitted your Feedback!!!");
            }
        });

        //adding save_feedback to feedback_button_panel
        feedback_button_panel.add(save_feedback);
        //adding feedback_button_panel to report_a_bug_panel
        report_a_bug_panel.add(feedback_button_panel);

        return report_a_bug_panel;
    }



    //within Cardsettings
    private JPanel logout(){
        //creating logout_panel to hold everything
        JPanel logout_panel = new JPanel();
        //creating button
        JButton logout_button = new JButton("logout_button");
        logout_button.addActionListener(this);
        //ACTION LISTENER
        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you been logged out :(");
            }
        });

        //adding button (logout_button) to logout_panel
        logout_panel.add(logout_button);

        return logout_panel;
    }






    //(one of the main pages)
    //Cardsettings holds: account_settings(), report_a_bug(), and logout()
    //uses cardlayout and a buttons to move throughout the pages
    private JPanel Cardsettings(String username,String password, String first_name,String last_name,String name_on_card,String card_number,String card_month_exp,String card_year_exp,String card_cvv, String address, String email ){
        JPanel cardsettings = new JPanel();
        cardsettings.setBackground(Color.red);
        cardsettings.setPreferredSize(new Dimension(300,800));
        cardsettings.setLayout(new BorderLayout());


        //cardlayout
        CardLayout cards = new CardLayout();
        //creating JPanel maincard to hold all the cards, so that we can call specific card within action listener
        JPanel maincard = new JPanel(cards);

        //adding maincard to card_settings
        cardsettings.add(maincard);
        maincard.add(account_settings(username, password, first_name, last_name, name_on_card, card_number,card_month_exp, card_year_exp, card_cvv, address,email),"account_settings");
        maincard.add(report_a_bug(),"report_a_bug");
        maincard.add(logout(),"logout");

        //creating buttonpanel to hold buttons
        JPanel buttonpanel = new JPanel();
        //buttonpanel.setBackground(Color.orange);

        //buttons: accoutn_settings_button, report_a_bug_button, logout_button
        JButton account_settings_button = new JButton("accountsettings");
        JButton report_a_bug_button =  new JButton("reportabug");
        JButton logout_button = new JButton("Logout");



        account_settings_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "account_settings");
            }
        });




        report_a_bug_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "report_a_bug");
            }
        });



        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "logout");
            }
        });







        buttonpanel.add(account_settings_button);
        buttonpanel.add(report_a_bug_button);
        buttonpanel.add(logout_button);





    cardsettings.add(buttonpanel, BorderLayout.NORTH);

        return cardsettings;
    }











//search things


    private JButton convert_to_button(String brandname,JPanel profilepage){
        JButton button = new JButton(brandname);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code that will show results for search brand
                JOptionPane.showMessageDialog(null,profilepage," ", JOptionPane.PLAIN_MESSAGE);
            }
        });

        return button;
    }







    //one of the main pages
    private JPanel Search(){
        JPanel cardsearch_panel = new JPanel();
        cardsearch_panel.setLayout(new BorderLayout());
        cardsearch_panel.setBackground(Color.orange);

        JPanel search_panel = new JPanel();
        search_panel.setBackground(Color.MAGENTA);
        search_panel.setPreferredSize(new Dimension(500,40));
        JTextField searchforthisbrand = new JTextField(20);
        JButton search_button = new JButton("search");



        searchforthisbrand.getText();


        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code that will show results for search brand
                System.out.println(":)");
            }
        });



        search_panel.add(searchforthisbrand);
        search_panel.add(search_button);


        JPanel grid = new JPanel();
        grid.setBackground(Color.YELLOW);

        cardsearch_panel.add(search_panel, BorderLayout.NORTH);
        cardsearch_panel.add(grid, BorderLayout.CENTER);

        return cardsearch_panel;
    }


//cart things

    private ArrayList<JPanel> all_items_in_cart = new ArrayList<>();
    JPanel cart_grid;

    private void print_cart_grid(){
        //clears all buttons from post_grid
        cart_grid.removeAll();
        //if all_posts has a post
        if( all_items_in_cart != null && !all_items_in_cart.isEmpty()) {



            for (int i = 0; i < all_items_in_cart.size(); i++) {
                //creating JButton
                JPanel order = all_items_in_cart.get(i);
                //size
                order.setPreferredSize(new Dimension(500,200));
                //adding JButton (post) to post_grid
                cart_grid.add(order);
            }

        }else{
            System.out.println("Sorry no orders");
        }

        //relays componenets
        cart_grid.revalidate();
        //visual refresh
        cart_grid.repaint();
    }




    //one of the main pages
    private JPanel Cart(){
        //creating cardcart_panel to hold everything
      //  JPanel cardcart_panel = new JPanel(new BorderLayout());
        JPanel cardcart_panel = new JPanel();
        cardcart_panel.setLayout(new BoxLayout(cardcart_panel,BoxLayout.Y_AXIS));
        //size
        cardcart_panel.setPreferredSize(new Dimension(500,800));
        //color
        //cardcart_panel.setBackground(Color.RED);


        //this panel will hold the orders
        cart_grid = new JPanel();
        //layout, all orders will be stacked
        cart_grid.setLayout(new GridLayout(0,1));
        //craeing JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(cart_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to cardcart_panel


        cardcart_panel.add(jsp);


       JPanel total_panel = new JPanel();
       total_panel.setPreferredSize(new Dimension(500,25));

       JLabel total_label = new JLabel("Total: $69");
       total_panel.add(total_label);


       JButton buy_button = new JButton("buy");



        buy_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code that will show results for search brand
                System.out.println("thank you for buying :)");
            }
        });



        total_panel.add(buy_button);
       cardcart_panel.add(total_panel);



        return cardcart_panel;
    }

//String photo,String clothing_item, String color, String size, String price

    //String photooo
    public JPanel cart_item(){
        JPanel item_block = new JPanel();
        item_block.setLayout(new BorderLayout());
        //item_block.setLayout();
        item_block.setBackground(Color.MAGENTA);
        item_block.setPreferredSize(new Dimension(500,200));
        //JLabel TEXT = new JLabel("SLKFLKDFJ");
        //item_block.add(TEXT);



/*
        //getting photo
        ImageIcon photo = new ImageIcon(photooo);
        //resizing photo to fit on photo panel
        Image scaledImage = photo.getImage().getScaledInstance(250,200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
*/

/*
        //creating photo label with scaled photo (scaledIcon)
        JLabel photo_label = new JLabel(scaledIcon);

        //creating jpanel for the photo
        JPanel clothing_photo_panel = new JPanel();
        //size of panel
        clothing_photo_panel.setPreferredSize(new Dimension(250,200));
        //adding photo_label
        clothing_photo_panel.add(photo_label);
        //to the left side

     */

     JPanel clothing_photo_panel = new JPanel();
     clothing_photo_panel.setPreferredSize(new Dimension(250,200));
     clothing_photo_panel.setBackground(Color.MAGENTA);

        item_block.add(clothing_photo_panel,BorderLayout.WEST);


        JPanel right_panel = new JPanel();
        right_panel.setPreferredSize(new Dimension(250,200));
        right_panel.setLayout(new BoxLayout(right_panel,BoxLayout.Y_AXIS));

        //panels that will go inside of right panel


        JPanel remove_button_panel = new JPanel();
        remove_button_panel.setBackground(Color.green);
        remove_button_panel.setLayout(new GridLayout(1,1));
        remove_button_panel.setPreferredSize(new Dimension(250,30));
        JButton remove_button = new JButton("remove");


        remove_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code that will show results for search brand
                System.out.println("brandItems.txt has been removed");
            }
        });



        //remove_button.setPreferredSize(new Dimension(250,50));
        remove_button_panel.add(remove_button);
        right_panel.add(remove_button_panel);




        //panel to hold description
        JPanel description_panel = new JPanel(); //will hold all the clothing brandItems.txt info
        //description_panel.setBackground(Color.BLUE);
        description_panel.setLayout(new BorderLayout());
        //size of panel
        description_panel.setPreferredSize(new Dimension(250,100));
        //creating JTextArea will hold the actual text
        JTextArea description = new JTextArea("Clothing: " +  "\n Color: "  + "\nPrice: "  + "\nSize: ", 4,20);
        description.setEditable(false);
        description_panel.add(description);

        right_panel.add(description_panel);
        //adding right_panel to the right of item_block
        item_block.add(right_panel, BorderLayout.EAST);


        return item_block;
    }

    private void add_to_cart(JPanel cart_item){
        all_items_in_cart.add(cart_item);
    }



}
