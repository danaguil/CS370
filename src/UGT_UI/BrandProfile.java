package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class BrandProfile extends JFrame implements ActionListener {

    JButton buttonprofile;
    JButton buttonpost;
    JButton buttonsettings;

    CardLayout cards;
    JPanel maincard;


    BrandProfile(){
        JFrame frame = new JFrame(); //by default frames use borderlayout
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //size of frame
        frame.setSize(500, 800);
        //frame will not be resizable
        frame.setResizable(false);
        //title of frame
        frame.setTitle("UnderGroundThreads");

        cards = new CardLayout();
        //will hold all the cards
        maincard = new JPanel();
        //setting maincard's layout...using cards to be able to switch cards
        maincard.setLayout(cards);

        //adding to maincard ----> JPanel method (card), String is the name of that panel to later use to switch
        maincard.add(Card_profile(),"profile");
        maincard.add(Card_post(), "post");
        maincard.add(Card_settings(), "settings");

        //adding the maincard to the frame
        frame.add(maincard);

        //JPanel to hold all the buttons
        JPanel buttonpanel = new JPanel();

        buttonpanel.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns
        buttonpanel.setPreferredSize(new Dimension(50,50)); //SINCE USING BORRDERLAYOUY 100X100 DOES NOT DO ANYTHING

        //this is where the buttons come in

        //creates button
        buttonprofile = new JButton();
        //Adding text to button
        buttonprofile.setText("profile");
        //so you won't see this rectangle when button clicked
        buttonprofile.setFocusable(false);
        //so that the button can have an action
        buttonprofile.addActionListener(this);

        //creates button
        buttonpost = new JButton();
        buttonpost.setText("post");
        buttonpost.setFocusable(false);
        buttonpost.addActionListener(this);

        //creates  button
        buttonsettings = new JButton();
        buttonsettings.setText("settings");
        buttonsettings.setFocusable(false);
        buttonsettings.addActionListener(this);

        //adding buttons to buttonpanel
        buttonpanel.add(buttonprofile);
        buttonpanel.add(buttonpost);
        buttonpanel.add(buttonsettings);

        //Adding buttonpanel to frame
        frame.add(buttonpanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }

//--------------------------------------------------------------------Cardprofile

    private String Brandname;
    private String Instagram;
    private String Tiktok;
    private String aboutbrandtext;

    //Getters
    void setBrandname(String Brandname){
        this.Brandname = Brandname;
    }

    void setInstagram(String Instagram){
        this.Instagram = Instagram;
    }

    void setTiktok(String Tiktok){
        this.Tiktok = Tiktok;
    }

    void setAboutbrandtext(String Aboutbrandtext){
        this.aboutbrandtext = Aboutbrandtext;
    }




    //arraylist to hold all buttons
    ArrayList<JButton> all_myposts = new ArrayList<>();
    //will hold all that all_post
    JPanel post_grid;



    //----------------------------------------------------------------------------------------------------Cardprofile
    private JPanel Card_profile(){
        //creates JPanel
        JPanel cardprofile = new JPanel();
        //size of JPanel
        cardprofile.setSize(500,800);
        //layout
        cardprofile.setLayout(new BorderLayout());
        //background color
        cardprofile.setBackground(Color.red);




        //------------------------------------------------will be the top part of the profile
        //creates JPanel
        JPanel profile_info = new JPanel();
        //background color
        //profile_info.setBackground(Color.green);
        //layout
        profile_info.setLayout(new BorderLayout());
        //size of this panel
        profile_info.setPreferredSize(new Dimension(500, 200));


        //adding to cardprofile and placing it
        cardprofile.add(profile_info, BorderLayout.NORTH);

        //-----------------------------------------------------inside of the profile_info
        //-----------------------------------------------------this is the brands logo
        //creates JPanel
        JPanel profile_logo = new JPanel();
        //background color
        profile_logo.setBackground(Color.orange);
        //size
        profile_logo.setPreferredSize(new Dimension(200,200));

        //add a jlabel to add a photo onto profile_logo


        //ADDING TO PROFILE INFO
        profile_info.add(profile_logo, BorderLayout.WEST);





        //--------------------------------------panel_for_3panels
        //----------------this is what will hold the Brand name, social medias, and About brand
        //create JPanel
        JPanel panel_for_3panels = new JPanel();
        //background color
        panel_for_3panels.setBackground(Color.BLACK);
        //size
        panel_for_3panels.setPreferredSize(new Dimension(300, 200));
        //layout GridLayout... so that the panels added later on will be stacked on top of each other
        panel_for_3panels.setLayout(new GridLayout(3,1));
        //ADDING PANEL_FOR_3PANELS TO PROFILE INFO
        profile_info.add(panel_for_3panels);




        //-----------------------------------------------------------------inside of panel_for_3panels
        //-------------------------------------brandname_panel
        //creating JPanel
        JPanel brandname_panel = new JPanel();
        //size
        brandname_panel.setSize(new Dimension(300, 50));
        //background color
        //brandname_panel.setBackground(Color.BLACK);


        //creating JLabel... brandname_ will be the text for the JLabel
        JLabel brandname_text = new JLabel("RANDOM BRAND");
        //color for text
        brandname_text.setForeground(Color.BLACK);
        //ADDING BRANDNAME_TEXT TO BRANDNAME
        brandname_panel.add(brandname_text);

        //------------------------------------socialmedia_panel
        //creating JPanel
        JPanel socialmedia_panel = new JPanel();
        //size
        socialmedia_panel.setSize(new Dimension(300, 50));
        //background color
        //socialmedia_panel.setBackground(Color.black);


        JTextField socialmedia_text = new JTextField("socialmedia_panel: RANDOMBRAND_123" );
        //JTextField will not be editable
        socialmedia_text.setEditable(false);
        //background color
        // socialmedia_text.setBackground(Color.black);
        //text color for JTextField
        socialmedia_text.setForeground(Color.black);
        //get rid of Border
        socialmedia_text.setBorder(null);
        //ADDING SOCIALMEDIA_TEXT
        socialmedia_panel.add(socialmedia_text);


        //----------------------------------about brand
        //creating JPanel
        JPanel aboutbrand = new JPanel();
        //Layout
        aboutbrand.setLayout(new BorderLayout());
        //creating JTextArea
        JTextArea aboutme_text = new JTextArea("about brand... this is a brand ");
        //JTextArea will not be editable
        aboutme_text.setEditable(false);
        //Text will stay within the TextArea
        aboutme_text.setLineWrap(true);
        //background color
        //aboutme_text.setBackground(Color.BLACK);
        //text color
        aboutme_text.setForeground(Color.BLACK);


        //ADDING ABOUTME_TEXT TO ABOUTBRAND
        aboutbrand.add(aboutme_text);
        //background color
        aboutbrand.setBackground(Color.BLUE);



        //ADDING 3 JPANELS TO PANEL_FOR_3PANELS
        //BRANDNAME
        //SOCIALMEDIA
        //ABOUTBRAND
        panel_for_3panels.add(brandname_panel);
        panel_for_3panels.add(socialmedia_panel);
        panel_for_3panels.add(aboutbrand);


        //-------------------------------------------------------post grid
        //JPanel to hold all the post made by brand
        //creating JPanel
        post_grid = new JPanel();
        //Layout 0 = rows (dynamic) 3 = cols
        post_grid.setLayout(new GridLayout(0,3));

        //creating JScrollPane ---> jsp
        //making post_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(post_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //ADDING JSP TO CARDPROFILE
        cardprofile.add(jsp);

        return cardprofile;
    }





    //---------------------------------------------------print_grid for post (buttons)
    private void print_grid(){
        //clears all buttons from post_grid
        post_grid.removeAll();
        //if all_posts has a post
        if( all_myposts != null && !all_myposts.isEmpty()) {
            for (int i = 0; i < all_myposts.size(); i++) {
                //creating JButton
                JButton post = all_myposts.get(i);
                //size
                post.setPreferredSize(new Dimension(100,100));
                //adding JButton (post) to post_grid
                post_grid.add(post);
            }

        }else{
            System.out.println("Sorry this brand has no post");
        }

        //relays componenets
        post_grid.revalidate();
        //visual refresh
        post_grid.repaint();


    }





//--------------------------------------------------------------------------------------------------------card_post

    private JComboBox clothing_box;
    private JComboBox clothing_color_box;
    private JComboBox clothing_size_box;
    private JComboBox clothing_price_box;
    //JButton
    private JButton share_button;
    private JButton select_photo_button;

    //Getters
    public String getPost_clothing_item(){
        //TOP BOTTOM SHOES
        return (String) clothing_box.getSelectedItem();
    }

    public String getPost_clothing_color(){
        //COLORS
        return (String) clothing_color_box.getSelectedItem();
    }

    public String getPost_clothing_size(){
        //SIZE
        return (String) clothing_size_box.getSelectedItem();
    }

    public String getPost_clothing_price(){
        //PRICE
        return (String)clothing_price_box.getSelectedItem();
    }



    public String getPost_photo(){
        //return path for image
        return path.getAbsolutePath();
    }




    //------------------------------------------------------------------------------------Card_post
    private JPanel Card_post(){
        //creating JPanel
        JPanel cardpost = new JPanel();
        //size
        cardpost.setSize(500, 800);
        //layout  GridLayout
        cardpost.setLayout(new GridLayout(6,1));





        //creating button
        select_photo_button = new JButton();
        //adding action listener
        select_photo_button.addActionListener(this);
        //creating JLabel
        JLabel label_select_photo = new JLabel("select photo");
        //ADDING LABEL_SELECT_PHOTO TO SELECT_PHOTO_BUTTON
        select_photo_button.add(label_select_photo);
        //ADDING SELECT_PHOTO_BUTTON
        cardpost.add(select_photo_button);
        //upload button done


        //TOP BOTTOM SHOES ---> CAN ONLY SELECT ONE
        //clothing option array for JComboBox
        String[] clothing = {"select a clothing item","Top", "Bottom", "Shoes"};
        //using array to create clothing_box
        clothing_box = new JComboBox(clothing);
        //adding action listener
        clothing_box.addActionListener(this);
        //allows user to type in a clothing piece
        // clothing_box.setEditable(true);

        //ADDING CLOTHING_BOX TO CARDPOST
        cardpost.add(clothing_box);

        //clothing color array for JComboBox
        String[] clothing_color = {"select a color","Red", "Orange", "Yellow","Green", "Blue","Purple", "Pink", "Brown", "Gray", "Black", "White"};
        //using array to create clothing_color_box
        clothing_color_box = new JComboBox(clothing_color);
        //adding an action linstener
        clothing_color_box.addActionListener(this);
        //allows user to type in a color
        clothing_color_box.setEditable(true);

        //ADDING CLOTHING_COLOR_BOX TO CARDPOST
        cardpost.add(clothing_color_box);

        //clothing_size array for JComboBox
        String[] clothing_size = {"Select a size","XS", "S", "M", "L", "XL", "XXL", "XXXL"};
        //using array to create clothing_size_box
        clothing_size_box = new JComboBox(clothing_size);
        //adding action listener
        clothing_size_box.addActionListener(this);
        //allows user to type in a size
        clothing_size_box.setEditable(true);

        //ADDING CLOTHING_SIZE_BOX TO CARDPOST
        cardpost.add(clothing_size_box);



        //clothing_price array for JComboBox
        String[] clothing_price = {"Select a price or add a price","5.00", "10.00", "15.00", "20.00", "25.00", "30.00", "35.00"};
        //using array to create clothing_price_box
        clothing_price_box = new JComboBox(clothing_price);
        //adding action listener
        clothing_price_box.addActionListener(this);
        //allows user to type in a price
        clothing_price_box.setEditable(true);

        //ADDING CLOTHING-PRICE_BOX
        cardpost.add(clothing_price_box);



        // share_button.....
        //once this button is press ----> it will call on CREATE POST ..... and CREATE POST will call ADD TO PROFILE and ADD TO FOLLOWERS (SOME LIKE THAT)

        //creating button
        share_button = new JButton();
        //adding action listener
        share_button.addActionListener(this);
        //label for the button "share"
        JLabel share_button_label = new JLabel("share");
        //adding label to button
        share_button.add(share_button_label);

        //ADDING BUTTON TO PANEL
        cardpost.add(share_button);
        return cardpost;
    }








    //-------------------------------------------------------------------------------post_maker

    private JButton post_maker(String clothing_item, String color, String size, String price, String brandname,String post_photo){
        //creating button
        JButton post = new JButton();
        //adding the image to the button
        ImageIcon path = new ImageIcon(getPost_photo());
        JLabel img = new JLabel(path);
        post.add(img);
        //allows users to click on post(button).. once user clicks on post additional information pops up (the actual post)
        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //will create the pop up for the button(post) when the button is clicked
                JOptionPane.showMessageDialog(null,make_a_post(clothing_item,color,size,price,brandname,post_photo)," ",JOptionPane.PLAIN_MESSAGE);

            }
        });


        return post;
    }













    //----------------------------------------------------------------------------------make_a_post


    //this will create the actual post (once the button (post) is clicked this pops up)
    private JPanel make_a_post(String clothing_item, String color, String size, String price, String brandname, String post_photo){

        //creating a panel
        JPanel makeapost = new JPanel();
        //makeapost.setBackground(Color.orange);
        //size of the post
        makeapost.setPreferredSize(new Dimension(250,400) );
        makeapost.setLayout(new BoxLayout(makeapost,BoxLayout.Y_AXIS));
        //
        JPanel brandname_banner = new JPanel();
        //brandname_banner.setPreferredSize(new Dimension(250,50));
        brandname_banner.setLayout(new GridLayout(1,1));

        JButton brandname_button = new JButton(brandname);
        //so you wont see a rectangle
        brandname_button.setFocusable(false);
        //adding the button to the panel
        brandname_banner.add(brandname_button);




        //getting photo
        ImageIcon photo = new ImageIcon(post_photo);
        //resizing photo to fit on photo panel
        Image scaledImage = photo.getImage().getScaledInstance(250,200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);




        //creating photo label with scaled photo (scaledIcon)
        JLabel photo_label = new JLabel(scaledIcon);

        //creating jpanel for the photo
        JPanel clothing_photo_panel = new JPanel();
        //size of panel
        clothing_photo_panel.setPreferredSize(new Dimension(250,200));
        //clothing_photo_panel.setBackground(Color.green);
        //addint the photo_label to clothing_photo_panel
        clothing_photo_panel.add(photo_label);


        //to hold buttons
        //holds: like, AddCart, Follow
        JPanel button_panel = new JPanel();
        //so buttons sit nice, no gaps
        button_panel.setLayout(new GridLayout(1,3));
        //BUTTONS
        JButton like_button = new JButton("like");
        //gets rid of rectangle
        like_button.setFocusable(false);
        //like_button.setEnabled(false);
        JButton add_to_cart_button = new JButton("AddCart");
        //gets rid of rectangle
        add_to_cart_button.setFocusable(false);
        //add_to_cart_button.setEnabled(false);
        JButton follow_button = new JButton("Follow");
        //gets rid of rectangle
        follow_button.setFocusable(false);
        //follow_button.setEnabled(false);

        //adding to button panel
        button_panel.add(like_button);
        button_panel.add(add_to_cart_button);
        button_panel.add(follow_button);

        //panel to hold description
        JPanel description_panel = new JPanel(); //will hold all the clothing item info
        //description_panel.setBackground(Color.BLUE);
        description_panel.setLayout(new BorderLayout());
        //size of panel
        description_panel.setPreferredSize(new Dimension(250,100));
        //creating JTextArea will hold the actual text
        JTextArea description = new JTextArea("Clothing: " + clothing_item + "\n Color: " + color + "\nPrice: " + price + "\nSize: "+ size, 4,20);
        description.setEditable(false);

        //adding description to description_panel
        description_panel.add(description);


        //holds the edit_post_button
        JPanel edit_post_panel = new JPanel();
        //makes the button take up all the space
        edit_post_panel.setLayout(new GridLayout(1,1));
        //edit_post_panel.setBackground(Color.MAGENTA);
        //creating button
        JButton edit_post_button = new JButton("edit post");



        //adding action
        edit_post_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "wanna make changes","edit post",JOptionPane.PLAIN_MESSAGE);

            }
        });


        //adding edit button to edit_button_panel
        edit_post_panel.add(edit_post_button);


        //adding all objects to makaapost panel
        makeapost.add(brandname_banner);
        makeapost.add(clothing_photo_panel);
        makeapost.add(button_panel);
        makeapost.add(description_panel);
        makeapost.add(edit_post_panel);

        return makeapost;
    }



    //-----------------------------------------------------------------add_to_profile
    //adds a post (button) to all_myposts
    private void add_to_profile(JButton post){
        //adding post to all_post (list array)
        all_myposts.add(post);
    }







    //-----------------------------------------------------------------------------------------------Card_settings

    //Card_settings uses cardlayout, holds: order(), account_settings(), report_a_bug(), logout()

    private JPanel Card_settings(){
        //creating panel to hold everything
        JPanel card_settings = new JPanel();
        card_settings.setBackground(Color.cyan);
        card_settings.setPreferredSize(new Dimension(300,800));
        card_settings.setLayout(new BorderLayout());

        //cardlayout
        CardLayout cards = new CardLayout();
        //creating JPanel maincard to hold all the cards, so that we can call specific card within action listener
        JPanel maincard = new JPanel(cards);

        //adding maincard to card_settings
        card_settings.add(maincard);

        //adding cards sto maincard
        maincard.add(orders(),"orders");
        maincard.add(account_settings(), "accountsettings");
        maincard.add(report_a_bug(), "report");
        maincard.add(logout(), "logout");
        //creating buttonpanel to hold buttons
        JPanel buttonpanel = new JPanel();
        //buttonpanel.setBackground(Color.orange);




        //buttons: order_button, account_settings_button, report_a_bug_button, logout_button
        JButton order_button = new JButton("orders");
        order_button.addActionListener(this);
        JButton account_settings_button = new JButton("account settings");
        account_settings_button.addActionListener(this);
        JButton report_a_bug_button = new JButton("report a bug");
        report_a_bug_button.addActionListener(this);
        JButton logout_button = new JButton("log out");
        logout_button.addActionListener(this);

        //adding all buttons
        buttonpanel.add(order_button);
        buttonpanel.add(account_settings_button);
        buttonpanel.add(report_a_bug_button);
        buttonpanel.add(logout_button);


        //ACTION LISTENERS

        order_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                print_order_grid();
                cards.show(maincard, "orders");
            }
        });

        account_settings_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "accountsettings");
            }
        });

        report_a_bug_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "report");
            }
        });

        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "logout");
            }
        });




        //adding button panel to card_settings
        card_settings.add(buttonpanel, BorderLayout.NORTH);
        return card_settings;
    }


//******************************************************************************************************************************** Pages within settings


    //----------------------------------------------------------------------------------account_settings


    private JPanel account_settings(){
        //creating account_settings_panel to hold everything
        JPanel account_settings_panel = new JPanel();
        //size
        account_settings_panel.setSize(500,800);
        //color
        //account_settings_panel.setBackground(Color.YELLOW);
        //layout
        account_settings_panel.setLayout(new BoxLayout(account_settings_panel, BoxLayout.Y_AXIS));
        //banner to help out user
        JPanel banner = new JPanel();
        JLabel text_for_banner = new JLabel("fill in any new changes then press save :)");
        banner.add(text_for_banner);
        //adding banner to account_settings_panel
        account_settings_panel.add(banner);

        //creating panel to hold all username objects
        JPanel update_username_panel = new JPanel();
        JLabel username_label = new JLabel("New Username:");
        JTextField new_username = new JTextField( 20);
        update_username_panel.add(username_label);
        update_username_panel.add(new_username);
        //adding update_username_panel to account_settings_panel
        account_settings_panel.add(update_username_panel);

        //creating panel to hold all password objects
        JPanel update_password_panel = new JPanel();
        JLabel password_label = new JLabel("New password:");
        JTextField new_password_TextArea = new JTextField( 20);
        update_password_panel.add(password_label);
        update_password_panel.add(new_password_TextArea);
        //adding update_password_panel to account_settings_panel
        account_settings_panel.add(update_password_panel);

        //creating update_brandname_panel to hold all brandname objects
        JPanel update_brandname_panel = new JPanel();
        JLabel brandname_label = new JLabel("New Brandname:");
        JTextField new_brandname_TextArea = new JTextField( 20);
        update_brandname_panel.add(brandname_label);
        update_brandname_panel.add(new_brandname_TextArea);
        //adding update_brandname_panel to account_settings_panel
        account_settings_panel.add(update_brandname_panel);

        //creating update_logo_panel to hold logo button
        JPanel update_logo_panel = new JPanel();
        JLabel logo_label = new JLabel("New Logo:");
        JButton update_logo_button = new JButton("upload");
        update_logo_button.addActionListener(this);




        //ACTION LISTENER
        update_logo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                photo_selection();


            }
        });



        update_logo_panel.add(logo_label);
        update_logo_panel.add(update_logo_button);
        //adding update_logo_panel to account_settings_panel
        account_settings_panel.add(update_logo_panel);

        //creating update_about_brand_panel to hold all aboutbrand objects
        JPanel update_about_brand_panel = new JPanel();
        JLabel about_brand_label = new JLabel("New AboutBrand:");
        JTextArea update_about_brand_TextArea = new JTextArea(3,20);
        update_about_brand_TextArea.setLineWrap(true);
        update_about_brand_panel.add(about_brand_label);
        update_about_brand_panel.add(update_about_brand_TextArea);
        //adding update_about_brand_panel to account_settings_panel
        account_settings_panel.add(update_about_brand_panel);
        //creating update_socialmedia_panel to hold, update_instagram_panel and update_tiktok_panel
        JPanel update_socialmedia_panel = new JPanel();
        //creating update_instagram_panel to hold all instagram objects
        JPanel update_instagram_panel = new JPanel();
        JLabel instagram_label = new JLabel("New Instagram:");
        JTextField update_Instagram_TextArea = new JTextField("new Instagram",20);
        update_instagram_panel.add(instagram_label);
        update_instagram_panel.add(update_Instagram_TextArea);
        //creating update_tiktok_panel to hold all tiktok objects
        JPanel update_tiktok_panel = new JPanel();
        JLabel tiktok_label = new JLabel("New Tiktok:");
        JTextField update_Tiktok_Field = new JTextField("new Tiktok",20);
        update_tiktok_panel.add(tiktok_label);
        update_tiktok_panel.add(update_Tiktok_Field);
        //adding update_instagram_panel and update_tiktok_panel to update_socialmedia_panel
        update_socialmedia_panel.add(update_instagram_panel);
        update_socialmedia_panel.add(update_tiktok_panel);
        //adding update_socialmedia_panel to  account_settings_panel
        account_settings_panel.add(update_socialmedia_panel);


        //creaing  update_email_panel to hold all email objects
        JPanel update_email_panel = new JPanel();
        JLabel email_label = new JLabel("New email:");
        JTextField update_email_TextArea = new JTextField("new email",10);
        update_email_panel.add(email_label);
        update_email_panel.add(update_email_TextArea);
        //adding  update_email_panel to account_settings_panel
        account_settings_panel.add(update_email_panel);
        //creating panel to hold button
        JPanel button_panel = new JPanel();
        //creating button
        JButton save_new_changes = new JButton("save changes");
        save_new_changes.addActionListener(this);





        //ACTION LISTENER
        save_new_changes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you saved changes");
            }
        });

        //adding save_new_changes to button_panel
        button_panel.add(save_new_changes);
        //adding button_panel to account_settings_panel
        account_settings_panel.add(button_panel);
        return account_settings_panel;
    }





    //---------------------------------------------------------------------------------- report_a_bug


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





        //creaing feedback_panel to hold all feedback objects
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




    //---------------------------------------------------------------------------------- orders

    //arraylist to hold all buttons
    private ArrayList<JPanel> all_myorders = new ArrayList<>();
    //will hold all that all_post contains
    JPanel order_grid;

    private void print_order_grid(){
        //clears all buttons from post_grid
        order_grid.removeAll();
        //if all_posts has a post
        if( all_myorders != null && !all_myorders.isEmpty()) {
            for (int i = 0; i < all_myorders.size(); i++) {
                //creating JButton
                JPanel order = all_myorders.get(i);
                //size
                order.setPreferredSize(new Dimension(500,200));
                //adding JButton (post) to post_grid
                order_grid.add(order);
            }

        }else{
            System.out.println("Sorry no orders");
        }

        //relays componenets
        order_grid.revalidate();
        //visual refresh
        order_grid.repaint();
    }

    private JPanel orders(){
        //creating orders_panel to hold everything
        JPanel orders_panel = new JPanel(new BorderLayout());
        //size
        orders_panel.setPreferredSize(new Dimension(500,800));
        //color
        //orders_panel.setBackground(Color.RED);


        //this panel will hold the orders
        order_grid = new JPanel();
        //layout, all orders will be stacked
        order_grid.setLayout(new GridLayout(0,1));
        //craeing JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(order_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to orders_panel
        orders_panel.add(jsp);

        return orders_panel;
    }





    //----------------------------------------------------------------------------------logout


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

//********************************************************************************************************************** end of pages within setttings



//-----------------------------------------------------------------------------------------------------valid_inputs



    //checking to see if the user selected a valid item from the boxes
    private void valid_inputs(){
        //if boxes are not the default (select clothing....) option then valid
        boolean valid_photo = path != null;
        boolean valid_clothing_item = clothing_box.getSelectedIndex() != 0;
        boolean valid_clothing_color = clothing_color_box.getSelectedIndex() != 0;
        boolean valid_clothing_size = clothing_size_box.getSelectedIndex() != 0;
        boolean valid_clothing_price = clothing_price_box.getSelectedIndex() != 0;

        if(valid_clothing_item && valid_clothing_color && valid_clothing_size && valid_clothing_price && valid_photo){
            //allow for button to be pressed
            share_button.setEnabled(true);
        }else{
            //button can not be pressed
            share_button.setEnabled(false);
        }
    }


    //---------------------------------------------------------------------------------- reset_clothing_boxes_select_photo

    void reset_clothing_boxes_select_photo(){
        //setting to default option "select clothing..."
        clothing_box.setSelectedIndex(0);
        clothing_color_box.setSelectedIndex(0);
        clothing_size_box.setSelectedIndex(0);
        clothing_price_box.setSelectedIndex(0);
        //setting path to null
        path = null;
    }



    //----------------------------------------------------------------------------------photo_selection

    private File path;
    void photo_selection(){
        //creating JFilechooser
        JFileChooser file_clothing_item = new JFileChooser();
        //set the directory
        file_clothing_item.setCurrentDirectory(new File("."));
        //select a file to save
        //returns an integer (response)
        int i = file_clothing_item.showSaveDialog(null);
        //checking response
        //if success
        if(i == JFileChooser.APPROVE_OPTION){
            //getting the selected file
            File selected_file = file_clothing_item.getSelectedFile();
            //making selected_file lowercase
            String name = selected_file.getName().toLowerCase();
            //file type must be JPEG, ONG, OR JPG else notification pops up
            if(name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".jpg") ){
                //selected file already has the file
                path = selected_file;
            }else{
                JOptionPane.showMessageDialog(null, "Invalid file type. Please select a JPG or PNG image.");
            }

        }


    }





    //----------------------------------------------------------------------------------ACTION PERFORMED

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonprofile){ //-------------PROFILE BUTTON
            //show newest grid of brands post
            print_grid();
            cards.show(maincard, "profile");

        }else if(e.getSource() == buttonpost){ //------------POST BUTTON
            cards.show(maincard, "post");
            valid_inputs();

        }else if(e.getSource() == buttonsettings){ //--------SETTINGS BUTTON
            cards.show(maincard, "settings");

        }else if(e.getSource() == select_photo_button){ //---SELECT_PHOTO_BUTTON
            photo_selection();
            valid_inputs();

        }else if(e.getSource() == clothing_box){
            valid_inputs();
        }else if(e.getSource() == clothing_color_box){
            valid_inputs();
        }else if(e.getSource() == clothing_size_box){
            valid_inputs();
        }else if(e.getSource() == clothing_price_box){
            valid_inputs();
        }else if(e.getSource() == select_photo_button || e.getSource() == clothing_box || e.getSource() == clothing_color_box || e.getSource() == clothing_size_box || e.getSource() == clothing_price_box || e.getSource() == select_photo_button){
            valid_inputs();
        }
        else if(e.getSource() == share_button){ //-----------SHARE_BUTTON

            //creates new post
            JButton newpost = post_maker(getPost_clothing_item(),
                    getPost_clothing_color(),
                    getPost_clothing_size(),
                    getPost_clothing_price(),
                    "randombrandname",getPost_photo());
            //add to profile
            add_to_profile(newpost);
            //reset all boxes (JCombo boxes and select photo path)
            reset_clothing_boxes_select_photo();


        }


    }



}